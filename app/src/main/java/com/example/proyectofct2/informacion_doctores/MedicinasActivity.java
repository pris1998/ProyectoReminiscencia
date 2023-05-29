package com.example.proyectofct2.informacion_doctores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyectofct2.R;

import java.util.ArrayList;

public class MedicinasActivity extends AppCompatActivity {
    MedicinaController medicinaController;
    Medicacion medicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicinas);

        medicacion = new Medicacion("001M","Ibuprofeno","mg","Cada 6 horas","Vía Oral","Antes de comer","Ingerir con agua");
        medicinaController = new MedicinaController();
        //le paso la nueva medicacion
        medicinaController.addMedicina(medicacion);
    }


}