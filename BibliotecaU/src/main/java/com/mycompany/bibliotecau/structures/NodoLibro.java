package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Libro;

public class NodoLibro {

    private Libro libro;
    private NodoLibro izquierda;
    private NodoLibro derecha;

    public NodoLibro(Libro libro) {
        this.libro = libro;
        this.izquierda = null;
        this.derecha = null;
    }

    public Libro getLibro() {
        return libro;
    }
    
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public NodoLibro getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoLibro izquierda) {
        this.izquierda = izquierda;
    }

    public NodoLibro getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoLibro derecha) {
        this.derecha = derecha;
    }
}