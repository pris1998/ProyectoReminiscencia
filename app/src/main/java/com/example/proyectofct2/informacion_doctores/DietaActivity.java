package com.example.proyectofct2.informacion_doctores;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofct2.R;

import java.util.ArrayList;

public class DietaActivity extends AppCompatActivity {
    DietaController dietaController;
    TextView txtTipoD;
    Dieta dieta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);

        txtTipoD = findViewById(R.id.txtTipoD);
        dieta = new Dieta("1","tipo", new ArrayList<>(), "estatura", "peso");
        dietaController = new DietaController();
        //le paso la nueva dieta
        dietaController.addDieta(dieta);
    }
}