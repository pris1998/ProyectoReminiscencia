package com.example.proyectofct2.utils.modelo;

public class Medicacion {
    private String id_medicina;
    private  String name_medicamento;
    private String dosis;//por ejemplo, mg, ml, unidades, etc.
    private String frecuencia;//una vez al día, dos veces al día, cada 6 horas
    private String via_administracion;// oral, tópica, intravenosa,
    private String duracion;//tomar con comida, evitar el consumo de alcohol,
    private String intrucciones;

    public Medicacion(){

    }
    public Medicacion(String id_medicina, String name_medicamento, String dosis, String frecuencia, String via_administracion, String duracion, String intrucciones) {
        this.id_medicina = id_medicina;
        this.name_medicamento = name_medicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.via_administracion = via_administracion;
        this.duracion = duracion;
        this.intrucciones = intrucciones;
    }

    public String getId_medicina() {
        return id_medicina;
    }


    public String getName_medicamento() {
        return name_medicamento;
    }

    public void setName_medicamento(String name_medicamento) {
        this.name_medicamento = name_medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getVia_administracion() {
        return via_administracion;
    }

    public void setVia_administracion(String via_administracion) {
        this.via_administracion = via_administracion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getIntrucciones() {
        return intrucciones;
    }

    public void setIntrucciones(String intrucciones) {
        this.intrucciones = intrucciones;
    }
}
