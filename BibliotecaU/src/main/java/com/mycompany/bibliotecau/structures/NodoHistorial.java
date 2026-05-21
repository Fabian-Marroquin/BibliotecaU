package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

public class NodoHistorial {

    private String accion;
    private NodoHistorial siguiente;

    public NodoHistorial(String accion) {
        this.accion = accion;
        this.siguiente = null;
    }

    public String getAccion() {
        return accion;
    }

    public NodoHistorial getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHistorial siguiente) {
        this.siguiente = siguiente;
    }
}