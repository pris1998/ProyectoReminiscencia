package com.example.proyectofct2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofct2.utils.ListaPacientesActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Pattern;
/**
¡
 Actividad que permite al usuario iniciar sesión en la aplicación.
 */
public class LoginActivity extends AppCompatActivity {

    public static FirebaseAuth auth = FirebaseAuth.getInstance();

    private TextInputEditText txtEmailUser;
    private TextInputEditText txtPasswordUser;
    TextView txtOlvidarPassword;

    Button btnInicioSesion;
    Button btnRegistro;

    //Firebase
    public static FirebaseUser user ;
    String email = "";
    String password = "";
    FirebaseFirestore mFirestore;

    //Google SignIn
    public SignInButton signInButton;
    public GoogleSignInClient signInClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Inicializacion de las variables
        txtEmailUser =  findViewById(R.id.txtEmailUser);
        btnInicioSesion = (Button) findViewById(R.id.btnEntrar);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        txtPasswordUser = findViewById(R.id.txtPasswordUser);

        txtOlvidarPassword = findViewById(R.id.txtOlvidarPassword);

        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Te reedirige a la pagina del Registro para registrar el usuario
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class );
                startActivity(intent);
            }
        });

        //Google configuration
        signInButton = findViewById(R.id.loginGoogle);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInGoogle();
            }
        });



        //Olvidaste contraseña
        txtOlvidarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //Conexión a la base de datos
        mFirestore = FirebaseFirestore.getInstance();

    }

    /**
     Muestra un mensaje Toast en la actividad.
     @param msg Mensaje a mostrar
     */
    public void myToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    /**
     * Valida el formulario de inicio de sesión.
     */    public void validate() {
        email = txtEmailUser.getText().toString().trim();
        password = txtPasswordUser.getText().toString().trim();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmailUser.setError("Correo inválido");
            return;
        } else {
            txtEmailUser.setError(null);
        }

        if (password.isEmpty() || password.length() < 8) {
            txtPasswordUser.setError("Se necesitan 8 caracteres");
            return;
            //tiene q contener unnúmero la contraseña pero no me funciona asi q nada
        } else if (!Pattern.compile("[0-9]").matcher(password).find()) {
            txtPasswordUser.setError("Introduzca algún número");
            return;
        }else{
            txtPasswordUser.setError(null);
        }

        iniciarSesion(email,password);
    }
    /**
     Inicia sesión con el correo electrónico y la contraseña proporcionados.
     @param email Dirección de correo electrónico
     @param password Contraseña
     */
    public void iniciarSesion(String email, String password){
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this,ListaPacientesActivity.class );
                            startActivity(intent);
                            finish();
                        }else{
                            myToast("Las credenciales no son correctas, inténtelo de nuevo");
                        }
                    }
                });
    }
    /**
     Maneja la respuesta del inicio de sesión de Google.
     */
    private ActivityResultLauncher<Intent> resultGoogleLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                    try {
                        GoogleSignInAccount account = task.getResult(ApiException.class);
                        if (account != null) {
                            AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
                            FirebaseAuth.getInstance().signInWithCredential(credential)
                                    .addOnCompleteListener(this, task1 -> {
                                        if (task1.isSuccessful()) {
                                            Intent intent = new Intent(this, ListaPacientesActivity.class);
                                            startActivity(intent);
                                        } else {
                                            myToast( "No se pudo iniciar sesión con Google.");
                                        }
                                    })
                                    .addOnFailureListener(this, e -> {
                                        myToast( "No se pudo iniciar sesión con Google.");
                                    });
                        }
                    } catch (ApiException e) {
                        myToast( "No se pudo iniciar sesión con Google.");
                    }
                }
            }
    );

    /**
     Inicia el flujo de inicio de sesión de Google.
     */
    public void signInGoogle(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_usuario_id))
                .requestEmail()
                .build();

        signInClient = GoogleSignIn.getClient(LoginActivity.this,gso);
        signInClient.signOut();

        resultGoogleLauncher.launch(signInClient.getSignInIntent());
    }


}



