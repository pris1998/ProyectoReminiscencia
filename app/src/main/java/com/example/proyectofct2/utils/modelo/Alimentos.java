package com.example.proyectofct2.utils.modelo;

public class Alimentos {
    private String tipo ;
    private String name;
    /**
     * Constructor de la clase Dieta.
     *
     * @param name       el nombre de la dieta
     * @param tipo     el tipo de la dieta
     */
    public Alimentos(String tipo, String name) {
        this.tipo = tipo;
        this.name = name;
    }
    /**
     * Obtiene el tipo de la dieta.
     *
     * @return el tipo de la dieta
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Establece el tipo de la dieta.
     *
     * @param tipo el tipo de la dieta
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
