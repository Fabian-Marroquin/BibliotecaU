package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Prestamo;

public class NodoPrestamo {

    private Prestamo prestamo;
    private NodoPrestamo siguiente;

    public NodoPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.siguiente = null;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public NodoPrestamo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPrestamo siguiente) {
        this.siguiente = siguiente;
    }
}
