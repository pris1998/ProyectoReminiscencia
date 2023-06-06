package com.example.proyectofct2.informacion_doctores;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
/**
 Controlador para gestionar las medicinas.
 */
public class MedicinaController {
    FirebaseFirestore db =FirebaseFirestore.getInstance();

    CollectionReference medicinas = db.collection("medicinas");
    /**
     Agrega una medicina a la base de datos.
     @param medicacion La medicación a agregar.
     */
    public void addMedicina(Medicacion medicacion){
        medicinas.add(medicacion).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("Medicina añadida" , medicacion.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Medicina excepcion" , e.getMessage());
            }
        });
    }

}
