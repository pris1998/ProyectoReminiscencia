package com.example.proyectofct2.informacion_doctores;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.adapter.RecyclerDieta;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class DietaActivity extends AppCompatActivity {
    DietaController dietaController;
    Dieta dieta;
    RecyclerView recyclerView;
    RecyclerDieta adapterDieta;
    FirebaseFirestore firebaseFirestore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        recyclerView = findViewById(R.id.recyclerDietaActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseFirestore = FirebaseFirestore.getInstance();
        Query query  = firebaseFirestore.collection("dietas");

        FirestoreRecyclerOptions<Dieta> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Dieta>().setQuery(query,Dieta.class).build();

        adapterDieta = new RecyclerDieta(firestoreRecyclerOptions,this);
        adapterDieta.notifyDataSetChanged();
        recyclerView.setAdapter(adapterDieta);


        dieta = new Dieta("1","tipo", new ArrayList<>(), "estatura", "peso");
        dietaController = new DietaController();
        //le paso la nueva dieta
        dietaController.addDieta(dieta, new FirestoreControllerCallback() {
            /**
             * Método llamado cuando se completa la consulta a la base de datos.
             *
             * @param success indica si la consulta se completó con éxito
             */
            @Override
            public void onQueryComplete(boolean success) {

                Log.d("Mensaje","Ha entrado en la bd");            }
            /**
             * Método llamado cuando ocurre un fallo en la consulta a la base de datos.
             *
             * @param exception la excepción generada durante la consulta
             */
            @Override
            public void onQueryFailure(Exception exception) {
                Log.d("Advertencia","Error al cargar");
                Toast.makeText(DietaActivity.this, "Error al cargar", Toast.LENGTH_SHORT).show();
            }
        });

        dietaController.getDieta("1", new DietaController.DietaCallback() {
            /**
             * Método llamado cuando se completa la consulta de la dieta.
             *
             * @param result la dieta obtenida
             */
            @Override
            public void onQueryComplete(Dieta result) {

                Log.d("Mensaje","Ha entrado en la bd");
            }
            /**
             * Método llamado cuando ocurre un fallo en la consulta de la dieta.
             *
             * @param exception la excepción generada durante la consulta
             */
            @Override
            public void onQueryFailure(Exception exception) {
                Log.d("Advertencia","Error al cargar");

            }
        });





    }
    /**
     * Método llamado cuando la actividad entra en primer plano.
     */
    @Override
    protected void onStart() {
        super.onStart();
        adapterDieta.startListening();
    }
    /**
     * Método llamado cuando la actividad sale de primer plano.
     */
    @Override
    protected void onStop() {
        super.onStop();
        adapterDieta.stopListening();
    }
}