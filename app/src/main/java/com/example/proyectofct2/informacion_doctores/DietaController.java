package com.example.proyectofct2.informacion_doctores;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.proyectofct2.utils.modelo.Dieta;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

/**

 Controlador para las operaciones relacionadas con la dieta en la base de datos.
 */

public class DietaController {
    /**

     Interfaz para manejar el resultado de la consulta de la dieta.
     */
    public interface DietaCallback {
        /**

         Método llamado cuando se completa la consulta de la dieta.
         @param result la dieta obtenida
         */
        void onQueryComplete(Dieta result);

        /**

         Método llamado cuando ocurre un error durante la consulta de la dieta.
         @param exception la excepción que ocurrió
         */
        void onQueryFailure(Exception exception);
    }


    FirebaseFirestore db =FirebaseFirestore.getInstance();

    CollectionReference dietas = db.collection("dietas");
    /**

     Agrega una dieta a la base de datos.
     @param dieta la dieta a agregar

     */
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
    /**

     Obtiene una dieta de la base de datos por su ID.
     @param idDieta el ID de la dieta a obtener
     @param callback el callback para manejar el resultado de la operación
     */
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
