package com.example.proyectofct2.informacion_doctores;

import java.util.ArrayList;

public class Dieta {
    private String idDieta;
    private String tipo;
    private ArrayList<Alimentos> alimento;
    private String estatura;
    private String peso;

    public Dieta(){

    }

    public Dieta(String id, String tipo, ArrayList<Alimentos> alimento, String estatura, String peso) {
        this.idDieta = id;
        this.tipo = tipo;
        this.alimento = alimento;
        this.estatura = estatura;
        this.peso = peso;
    }

    public String getIdDieta() {
        return idDieta;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Alimentos> getAlimento() {
        return alimento;
    }

    public void setAlimento(ArrayList<Alimentos> alimento) {
        this.alimento = alimento;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}