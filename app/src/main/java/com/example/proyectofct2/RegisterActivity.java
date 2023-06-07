package com.example.proyectofct2;

import static com.example.proyectofct2.LoginActivity.auth;
import static com.example.proyectofct2.LoginActivity.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofct2.utils.ListaPacientesActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/**
 * Actividad para el registro de usuarios.
 */
public class RegisterActivity extends AppCompatActivity {
    ImageView imageViewRegister;
    TextView txtVEmailR, txtnewUser;

    TextInputEditText txtEEmail, txtEPassword, confirmarPassword, txtName;

    Button btnInicioS;

    String email ;
    String password;
    String confirmPassword;

    private FirebaseAuth Fauth = FirebaseAuth.getInstance();

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtEEmail = findViewById(R.id.txtEEmail);
        txtEPassword = findViewById(R.id.txtEPassword);
        confirmarPassword = findViewById(R.id.confirmarPassword);

        btnInicioS = findViewById(R.id.btnInicioS);
        txtnewUser = findViewById(R.id.txtnewUser);


        txtnewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vuelve al pulsar el texto al inicio
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class );
                startActivity(intent);
            }
        });

        btnInicioS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }
    /**
     * Muestra un mensaje Toast en la actividad.
     *
     * @param mensaje Mensaje a mostrar
     */
    public void myToast(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }


    /**
     * Valida el formulario de registro.
     */    public void validate() {

        email = txtEEmail.getText().toString().trim();
        password = txtEPassword.getText().toString().trim();
        confirmPassword = confirmarPassword.getText().toString().trim();

        //esto lo que pone en rojo el email sino existe
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEEmail.setError("Correo invalido");
            return;
        } else {
            txtEEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 8) {
            txtEPassword.setError("Se necesitan 8 caracteres");
            return;
        } else if (!Pattern.compile("[0-9]").matcher(password).find()) {
            txtEPassword.setError("Introduzca algún número");
            return;
        } else {
            txtEPassword.setError(null);
        }
        if (!confirmPassword.equals(password)) {
            confirmarPassword.setError("Deben ser iguales");
            return;
        } else {
            registroBD(email, password);
            registro(email, password);
        }
    }
    /**
     * Realiza el registro de usuario.
     *
     * @param email    Dirección de correo electrónico
     * @param password Contraseña
     */
    public void registro(String email,String password){
        Fauth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(RegisterActivity.this, ListaPacientesActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            myToast("Error al registrarse");
                        }
                    }
                });
    }


    /**
     * Realiza el registro en la base de datos.
     *
     * @param email    Dirección de correo electrónico
     * @param password Contraseña
     */    public void registroBD(String email,String password){
        //Uso un HashMap porque es más facil ya que tiene un clave por (String)
        // y un valor (Object) son los objetos que se guardan al ecribirlo mediante la pantalla de Registro
        Map<String,Object> mapDatos = new HashMap<>();
        mapDatos.put("email",email);
        mapDatos.put("password",password);
        firebaseFirestore.collection("users").document(


                        "HMpzzDqpNiDMLS60kkdY").
                collection("doctores").add(mapDatos)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                //Salga bien
                myToast("Usuario creado en BD");
                //finaliza la activity
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                myToast("Error al registrar usuario");
            }
        });


    }


}