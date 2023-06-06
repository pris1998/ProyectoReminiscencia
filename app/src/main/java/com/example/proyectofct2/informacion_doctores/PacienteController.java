package com.example.proyectofct2.informacion_doctores;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectofct2.utils.modelo.Paciente;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 Controlador para gestionar la información de los pacientes.
 */
public class PacienteController {
    FirebaseFirestore db =FirebaseFirestore.getInstance();

    CollectionReference usuarios = db.collection("users");
    /**
     Agrega un nuevo paciente a la base de datos.
     @param paciente El objeto Paciente a agregar.
     */
    public void addPaciente(Paciente paciente){
        usuarios.add(paciente).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("Perfil añadido" , paciente.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Perfil excepcion" , e.getMessage());
            }
        });
    }
}
