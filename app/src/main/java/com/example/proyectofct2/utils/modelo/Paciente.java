package com.example.proyectofct2.utils.modelo;

public class Paciente {
    String name,surname,age,UID;

    public Paciente() {
    }

    public Paciente(String name, String surname, String age, String UID) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.UID = UID;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }
}
