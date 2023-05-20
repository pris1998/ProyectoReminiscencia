package com.example.proyectofct2.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.adapter.MiAdapter;
import com.example.proyectofct2.utils.modelo.Paciente;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ListaPacientesActivity extends AppCompatActivity {
    RecyclerView recyclerLista;
    MiAdapter miAdapter;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);

        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerLista = findViewById(R.id.recyclerView);
        recyclerLista.setLayoutManager(new LinearLayoutManager(this));
        //leer la query , que apunta a la coleccion llamada pacientes
        Query query = firebaseFirestore.collection("pacientes");
        //pasa el modelo y se le da un nombre

        FirestoreRecyclerOptions<Paciente> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Paciente>().setQuery(query,Paciente.class).build();

        //cada uno de los datos hay que teferenciarlos
        miAdapter = new MiAdapter(firestoreRecyclerOptions);
        //lee cada uno de los cambios de la base de datos
        miAdapter.notifyDataSetChanged();
        //lo manda al adapter
        recyclerLista.setAdapter(miAdapter);
    }
    //Comenzar el adaptardor a que escuche
    @Override
    protected void onStart() {
        super.onStart();
        miAdapter.startListening();
    }
    //deje de escuchar y pare
    @Override
    protected void onStop() {
        super.onStop();
        miAdapter.stopListening();
    }
}