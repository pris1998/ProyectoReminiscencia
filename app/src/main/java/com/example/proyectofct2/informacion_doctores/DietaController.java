package com.example.proyectofct2.informacion_doctores;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectofct2.controlador.FirestoreControllerCallback;
import com.example.proyectofct2.utils.ListaPacientesActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;



public class DietaController {

    public interface DietaCallback {

        void onQueryComplete(Dieta result);


        void onQueryFailure(Exception exception);
    }


    FirebaseFirestore db =FirebaseFirestore.getInstance();

    CollectionReference dietas = db.collection("dietas");

    public void addDieta(Dieta dieta, FirestoreControllerCallback calback){
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

    public void getDieta(String idDieta, DietaCallback callback) {
        dietas.whereEqualTo("idDieta", idDieta).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot documents) {
                        for (DocumentSnapshot document : documents) {
                            Dieta dieta = document.toObject(Dieta.class);
                            callback.onQueryComplete(dieta);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        callback.onQueryFailure(exception);
                    }
                });
    }

}
