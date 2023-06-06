package com.example.proyectofct2.utils;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.proyectofct2.LoginActivity;
import com.example.proyectofct2.R;
import com.example.proyectofct2.informacion_doctores.DietaActivity;
import com.example.proyectofct2.informacion_doctores.MedicinasActivity;
import com.example.proyectofct2.informacion_doctores.PacientePerfilActivity;
import com.google.android.material.navigation.NavigationView;
/**
 Actividad para mostrar la información del paciente y su navegación.
 */
public class InformationPatient extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView nav;
    ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_paciente);

        drawerLayout = findViewById(R.id.drawer_layout);
        nav = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Configuración del menú de navegación
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                    {
                        Intent intent = new Intent(InformationPatient.this, PacientePerfilActivity.class);
                        startActivity(intent);

                        break;
                    }
                    case R.id.logout:
                    {
                        Intent intent = new Intent(InformationPatient.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    }
                    case R.id.dieta:
                    {
                        Intent intent = new Intent(InformationPatient.this, DietaActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.perfil:
                    {
                        Intent intent = new Intent(InformationPatient.this, PacientePerfilActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.vaccine:
                    {
                        Intent intent = new Intent(InformationPatient.this, MedicinasActivity.class);
                        startActivity(intent);
                        break;
                    }
                }
                return false;
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}