package com.example.proyectofct2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;
/**
 Actividad que permite al usuario recuperar su contraseña a través del correo electrónico.
 */
public class ForgotPasswordActivity extends AppCompatActivity {

    MaterialButton btnRecuperar;
    TextInputEditText txtEmailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnRecuperar = findViewById(R.id.btnRecuperar);
        txtEmailUser = findViewById(R.id.txtEmailUser);

        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmail();
            }
        });

    }
    /**
     Muestra un mensaje Toast en la actividad.
     @param msg Mensaje a mostrar
     */
    public void myToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    /**
     Valida la dirección de correo electrónico ingresada por el usuario.
     */
    public void validateEmail() {
        String email = txtEmailUser.getText().toString().trim();


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmailUser.setError("Correo inválido");
            return;
        } else {
            txtEmailUser.setError(null);
        }
        sendEmail(email);
    }
    /**
     Método para gestionar la acción de retroceder cuando se presiona el botón de retroceso del dispositivo.
     */    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    /**
     Envía un correo electrónico para restablecer la contraseña del usuario.
     @param email Dirección de correo electrónico del usuario
     */
    public void sendEmail(String email){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAdress = email;

        auth.sendPasswordResetEmail(emailAdress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            myToast("Correo enviado");
                            Intent intent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            myToast("Error en el correo ");
                        }
                    }
                });
    }

}