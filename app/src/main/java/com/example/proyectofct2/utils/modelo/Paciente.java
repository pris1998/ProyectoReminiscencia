package com.example.proyectofct2.utils.modelo;

import java.util.List;

public class Paciente {
    String idDieta;
    String name,surname,fecha_nacimiento;
    String género;
    String direccion;
    String telContacto;
    //Datos de contacot emergencia
    String titulo;
    String nombre_contacto;
    String tel_emergencia;
    //Informacion medica basica
    String grupo_sanguineo;
    String alergias;
    //Informacion de seguro medico
    String compania_seguro;
    String num_poliza;
    //Informacion sobre estilo de visa
    String actividad_fisica;
    String historial_tabaquismo;


    public Paciente(String idDieta, String name, String surname, String fecha_nacimiento, String género, String direccion, String telContacto) {
        this.idDieta = idDieta;
        this.name = name;
        this.surname = surname;
        this.fecha_nacimiento = fecha_nacimiento;
        this.género = género;
        this.direccion = direccion;
        this.telContacto = telContacto;
        this.titulo = titulo;
        this.nombre_contacto = nombre_contacto;
        this.tel_emergencia = tel_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
        this.alergias = alergias;
        this.compania_seguro = compania_seguro;
        this.num_poliza = num_poliza;
        this.actividad_fisica = actividad_fisica;
        this.historial_tabaquismo = historial_tabaquismo;
    }

    public String getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    public String getGénero() {
        return género;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String age) {
        this.fecha_nacimiento = age;
    }



    public String getGenero() {
        return género;
    }

    public void setGénero(String género) {
        this.género = género;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelContacto() {
        return telContacto;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getTel_emergencia() {
        return tel_emergencia;
    }

    public void setTel_emergencia(String tel_emergencia) {
        this.tel_emergencia = tel_emergencia;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCompania_seguro() {
        return compania_seguro;
    }

    public void setCompania_seguro(String compania_seguro) {
        this.compania_seguro = compania_seguro;
    }

    public String getNum_poliza() {
        return num_poliza;
    }

    public void setNum_poliza(String num_poliza) {
        this.num_poliza = num_poliza;
    }

    public String getActividad_fisica() {
        return actividad_fisica;
    }

    public void setActividad_fisica(String actividad_fisica) {
        this.actividad_fisica = actividad_fisica;
    }

    public String getHistorial_tabaquismo() {
        return historial_tabaquismo;
    }

    public void setHistorial_tabaquismo(String historial_tabaquismo) {
        this.historial_tabaquismo = historial_tabaquismo;
    }
}
