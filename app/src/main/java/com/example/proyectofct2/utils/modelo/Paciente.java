package com.example.proyectofct2.utils.modelo;

public class Paciente {
    String idDieta;
    String name,surname,fecha_nacimiento;
    String genero;
    String direccion;
    String telContacto;


    public Paciente(){
    }


    public Paciente(String idDieta, String name, String surname, String fecha_nacimiento, String genero, String direccion, String telContacto) {
        this.idDieta = idDieta;
        this.name = name;
        this.surname = surname;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.telContacto = telContacto;

    }

    public String getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
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
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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


}
