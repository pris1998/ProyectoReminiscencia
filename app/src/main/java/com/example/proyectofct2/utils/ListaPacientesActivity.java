package com.example.proyectofct2.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Toast;

import com.example.proyectofct2.R;
import com.example.proyectofct2.informacion_doctores.PacientePerfilActivity;
import com.example.proyectofct2.utils.adapter.RecyclerAdapter;
import com.example.proyectofct2.utils.modelo.Paciente;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;
/**
 Actividad que muestra una lista de pacientes y permite filtrarlos mediante una barra de búsqueda.
 */
public class ListaPacientesActivity extends AppCompatActivity {
    RecyclerView recView;
    private RecyclerAdapter recAdapter;

    private ArrayList<Paciente> lista = new ArrayList<>();
    private SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);

        recView = findViewById(R.id.recyclerView);
        recAdapter = new RecyclerAdapter(this,getListPacientes());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recView.setAdapter(recAdapter);
        recView.setLayoutManager(linearLayoutManager);

        search = (SearchView) findViewById(R.id.search);
        search.clearFocus();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

    }
    /**
     Obtiene la lista de pacientes.
     @return Lista de pacientes
     */
    public List<Paciente> getListPacientes(){

        PacientePerfilActivity pacientePerfilActivity;
        lista.add(new Paciente("1","José Manuel", "Hernández Prieto","20/02/1934", "hombre", "Calle San Miguel,4", "12345678"));
        lista.add(new Paciente("2","María", "Dueñas Prieto","20/10/1945", "mujer", "Plaza Jeus,3", "3456789"));
        lista.add(new Paciente("3","Epifanía", "García García","12/02/1937", "mujer", "", "66666666"));
        lista.add(new Paciente("4","Epifanía", "Ibáñez Pueblo","20/05/1930", "mujer", "", "123456789"));
        lista.add(new Paciente("5","Baldomero", "Solana Torrico","09/06/1936", "hombre", "", ""));

        return lista;
    }

    /**
     Filtra la lista de pacientes según el texto de búsqueda.
     @param text Texto de búsqueda
     */
    private void filterList(String text){
        List<Paciente> filterPaciente = new ArrayList<>();
        for (Paciente paciente : lista){
            if (paciente.getName().toLowerCase().contains(text.toLowerCase())){
                filterPaciente.add(paciente);
            }
        }

        if (filterPaciente.isEmpty()) {
            Toast.makeText(this, "No se encuentra", Toast.LENGTH_SHORT).show();
        }else{
            recAdapter.setFilterPaciente(filterPaciente);
        }



    }



}