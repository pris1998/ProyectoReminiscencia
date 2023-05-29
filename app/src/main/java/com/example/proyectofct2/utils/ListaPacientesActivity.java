package com.example.proyectofct2.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;

import com.example.proyectofct2.R;
import com.example.proyectofct2.informacion_doctores.PacientePerfilActivity;
import com.example.proyectofct2.utils.adapter.RecyclerAdapter;
import com.example.proyectofct2.utils.modelo.Paciente;


import java.util.ArrayList;
import java.util.List;

public class ListaPacientesActivity extends AppCompatActivity {
    RecyclerView recView;
    RecyclerAdapter recAdapter;
    PacientePerfilActivity pacientePerfilActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);

        recView = findViewById(R.id.recyclerView);
        //pasar el contexto , a no ser que sea en la parte de mandarlo directamente al PerfilActivity
        recAdapter = new RecyclerAdapter(this,pacientePerfilActivity.getListPacientes());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //añado los elementos creados
        recView.setAdapter(recAdapter);
        recView.setLayoutManager(linearLayoutManager);


    }
    //Tengo que mostrar los pacientes ya que en esta aplicacion se van a
    //registrar solo los doctores y son ellos mismos los que tienen acceso a esta lista

    //Este metodo está en PacientePerfilActivity
    /*public List<Paciente> getList(){
        //Array con el contenido de la lista de los Pacientes
        ArrayList<Paciente> lista = new ArrayList<>();
        PacientePerfilActivity pacientePerfilActivity;
        lista.add(new Paciente("1","José Manuel", "Hernández Prieto","80", "hombre", "Calle San Miguel,4", "12345678"));
        lista.add(new Paciente("2","María", "Dueñas Prieto","75", "mujer", "Plaza Jeus,3", "3456789"));
        lista.add(new Paciente("3","Epifanía", "García García","89", "mujer", "", ""));

        return lista;
    }*/




}