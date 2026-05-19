package com.mycompany.bibliotecau.model;

/**
 *
 * @author angel
 */

public class Usuario {

    private String carnet;
    private String nombre;
    private String carrera;

    public Usuario(String carnet, String nombre, String carrera) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return "Carnet: " + carnet + " | Nombre: " + nombre + " | Carrera: " + carrera;
    }
}
