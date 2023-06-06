package com.example.proyectofct2.informacion_doctores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofct2.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EditActivity extends AppCompatActivity {
    private String dietaId;
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    TextView txtTipoDieta,txtAlimentosDieta,txtEstaturaDieta,txtPesoDieta;
    Button btnActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        txtTipoDieta = findViewById(R.id.txtTipoDieta);
        txtAlimentosDieta = findViewById(R.id.txtAlimentosDieta);
        txtEstaturaDieta = findViewById(R.id.txtEstaturaDieta);
        txtPesoDieta = findViewById(R.id.txtPesoDieta);
        btnActualizar = findViewById(R.id.btnActualizar);

        dietaId = getIntent().getStringExtra("IdDieta");

        obtenerDatos();

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDietas();
            }
        });

    }
    private void obtenerDatos(){
        firebaseFirestore.collection("dietas").document(dietaId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String tipoDieta = documentSnapshot.getString("tipo");
                    String estaturaDieta = documentSnapshot.getString("estatura");
                    String pesoDieta = documentSnapshot.getString("peso");

                    txtTipoDieta.setText(tipoDieta);
                    txtEstaturaDieta.setText(estaturaDieta);
                    txtPesoDieta.setText(pesoDieta);

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EditActivity.this, "Error al obtener datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void actualizarDietas(){
        String tipoDieta = txtTipoDieta.getText().toString().trim();
        String estaturaDieta = txtEstaturaDieta.getText().toString().trim();
        String pesoDieta = txtPesoDieta.getText().toString().trim();

        Map<String,Object> mapDieta = new HashMap<>();
        mapDieta.put("tipo",tipoDieta);
        //mapDieta.put("alimento","");
        mapDieta.put("estatura",estaturaDieta);
        mapDieta.put("peso",pesoDieta);

        firebaseFirestore.collection("dietas").document(dietaId).update(mapDieta);
    }
}