package com.example.proyectofct2.informacion_doctores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.adapter.RecyclerMedicacion;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
/**
 Activity para mostrar y gestionar la lista de medicinas.
 */
public class MedicinasActivity extends AppCompatActivity {
    MedicinaController medicinaController;

    RecyclerView recyclerView;
    RecyclerMedicacion recyclerMedicacion;
    FirebaseFirestore mFirestore;
    Medicacion medicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinas);


        medicinaController = new MedicinaController();

        medicacion = new Medicacion("002M","Valium","mg","1 o dos veces al día","Vía Oral","Después comer","Ingerir con líquido");
        //le paso la nueva medicacion
        medicinaController.addMedicina(medicacion);

        recyclerView= findViewById(R.id.recyclerViewMedicina);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirestore = FirebaseFirestore.getInstance();
        Query query = mFirestore.collection("medicinas");

        FirestoreRecyclerOptions<Medicacion> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Medicacion>()
                .setQuery(query,Medicacion.class).build();

        recyclerMedicacion = new RecyclerMedicacion(firestoreRecyclerOptions);
        recyclerMedicacion.notifyDataSetChanged();
        recyclerView.setAdapter(recyclerMedicacion);


    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerMedicacion.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        recyclerMedicacion.stopListening();
    }
}