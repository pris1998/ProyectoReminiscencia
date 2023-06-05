package com.example.proyectofct2.informacion_doctores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyectofct2.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EditActivity extends AppCompatActivity {
    private String dietaId;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        dietaId = getIntent().getStringExtra("dietaId");

    }
    private void actualizarDietas(){


        Map<String,Object> mapDieta = new HashMap<>();
        mapDieta.put("tipo","");
        mapDieta.put("alimento","");
        mapDieta.put("estatura","");
        mapDieta.put("peso","");



        //firebaseFirestore.collection("dietas").document(dietaId).update();
    }
}