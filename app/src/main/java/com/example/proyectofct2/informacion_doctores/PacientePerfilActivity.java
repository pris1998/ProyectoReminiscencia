package com.example.proyectofct2.informacion_doctores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.adapter.PerfilAdapter;
import com.example.proyectofct2.utils.modelo.Paciente;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
/**
 Actividad que muestra el perfil de un paciente.
 */
public class PacientePerfilActivity extends AppCompatActivity {
    PacienteController pacienteController;


    RecyclerView recView;
    PerfilAdapter perfilAdapter;

    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    Paciente paciente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_perfil);


        recView = findViewById(R.id.recyclerViewPaciente);
        recView.setLayoutManager(new LinearLayoutManager(this));
        Query query = firebaseFirestore.collection("users").document(
                "HMpzzDqpNiDMLS60kkdY").collection("doctores");
        FirestoreRecyclerOptions<Paciente> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Paciente>()
                .setQuery(query,Paciente.class).build();

        perfilAdapter = new PerfilAdapter(firestoreRecyclerOptions);
        perfilAdapter.notifyDataSetChanged();
        recView.setAdapter(perfilAdapter);

        paciente = new Paciente("1","José Manuel", "Hernández Prieto","20/02/1934", "hombre", "Calle San Miguel,4", "12345678");

        pacienteController = new PacienteController();
        pacienteController.addPaciente(paciente);


    }


    @Override
    protected void onStop() {
        super.onStop();
        perfilAdapter.stopListening();

    }

    @Override
    protected void onStart() {
        super.onStart();
        perfilAdapter.startListening();
    }
}