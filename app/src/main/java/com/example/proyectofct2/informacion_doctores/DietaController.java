package com.example.proyectofct2.informacion_doctores;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DietaController {
    FirebaseFirestore db =FirebaseFirestore.getInstance();

    CollectionReference dietas = db.collection("dietas");

    public void addDieta(Dieta dieta){
        dietas.add(dieta).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("Dieta añadida" , dieta.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Dieta excepcion" , e.getMessage());
            }
        });
    }
}
