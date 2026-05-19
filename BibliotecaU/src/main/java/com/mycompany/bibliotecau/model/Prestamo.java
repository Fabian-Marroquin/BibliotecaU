package com.mycompany.bibliotecau.model;

/**
 *
 * @author angel
 */

public class Prestamo {

    private int idPrestamo;
    private Libro libro;
    private Usuario usuario;
    private String fechaPrestamo;

    public Prestamo(int idPrestamo, Libro libro, Usuario usuario, String fechaPrestamo) {
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    @Override
    public String toString() {
        return "Prestamo #" + idPrestamo + "\nLibro: " + libro.getTitulo() + "\nUsuario: " + usuario.getNombre() + "\nFecha: " + fechaPrestamo;
    }
}