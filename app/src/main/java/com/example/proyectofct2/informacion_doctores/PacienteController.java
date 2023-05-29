package com.example.proyectofct2.informacion_doctores;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectofct2.utils.modelo.Paciente;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class PacienteController {
    FirebaseFirestore db =FirebaseFirestore.getInstance();

    CollectionReference usuarios = db.collection("users");

    public void addPaciente(ArrayList<Paciente> paciente){
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
