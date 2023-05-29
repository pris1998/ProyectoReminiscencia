package com.example.proyectofct2.informacion_doctores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.proyectofct2.R;
import com.example.proyectofct2.utils.adapter.PerfilAdapter;
import com.example.proyectofct2.utils.adapter.RecyclerAdapter;
import com.example.proyectofct2.utils.modelo.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacientePerfilActivity extends AppCompatActivity {
    PacienteController pacienteController;
    RecyclerView recView;
    PerfilAdapter perfilAdapter;


    Paciente paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_perfil);

        recView = findViewById(R.id.recyclerViewPaciente);
        //pasar el contexto , a no ser que sea en la parte de mandarlo directamente al PerfilActivity
        //Metodo obtener datos desde Firebase
        //perfilAdapter = new PerfilAdapter(this,);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //añado los elementos creados
        recView.setAdapter(perfilAdapter);
        recView.setLayoutManager(linearLayoutManager);



        pacienteController = new PacienteController();
        //le paso la nueva dieta
        pacienteController.addPaciente(paciente.getLis);




    }
//este metodo lo llamo directamente desde la lista (ListaPacientesActivity)
    public List<Paciente> getListPacientes(){
        ArrayList<Paciente> lista = new ArrayList<>();
        lista.add(new Paciente("1","José Manuel", "Hernández Prieto","80", "hombre", "Calle San Miguel,4", "12345678"));
        lista.add(new Paciente("2","María", "Dueñas Prieto","75", "mujer", "Plaza Jeus,3", "3456789"));
        lista.add(new Paciente("3","Epifanía", "García García","89", "mujer", "", ""));
        pacienteController = new PacienteController();
        //le paso la nueva dieta
        pacienteController.addPaciente(lista);
        return lista;
    }
}