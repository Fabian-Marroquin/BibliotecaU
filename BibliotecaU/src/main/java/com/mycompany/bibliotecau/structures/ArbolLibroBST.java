package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Libro;

public class ArbolLibroBST {

    private NodoLibro raiz;

    public ArbolLibroBST() {
        raiz = null;
    }

    public void insertar(Libro libro) {
        raiz = insertarRecursivo(raiz, libro);
    }

    private NodoLibro insertarRecursivo(NodoLibro nodo, Libro libro) {

        if (nodo == null) {
            return new NodoLibro(libro);
        }

        if (libro.getCodigo() < nodo.getLibro().getCodigo()) {
            nodo.setIzquierda(
                    insertarRecursivo(nodo.getIzquierda(), libro)
            );
        } else if (libro.getCodigo() > nodo.getLibro().getCodigo()) {
            nodo.setDerecha(
                    insertarRecursivo(nodo.getDerecha(), libro)
            );
        }

        return nodo;
    }

    public Libro buscar(int codigo) {

        NodoLibro actual = raiz;

        while (actual != null) {

            if (codigo == actual.getLibro().getCodigo()) {
                return actual.getLibro();
            }

            if (codigo < actual.getLibro().getCodigo()) {
                actual = actual.getIzquierda();
            } else {
                actual = actual.getDerecha();
            }
        }

        return null;
    }

    public void mostrarInOrden() {
        mostrarInOrdenRecursivo(raiz);
    }

    private void mostrarInOrdenRecursivo(NodoLibro nodo) {

        if (nodo != null) {

            mostrarInOrdenRecursivo(nodo.getIzquierda());

            System.out.println(nodo.getLibro());

            mostrarInOrdenRecursivo(nodo.getDerecha());
        }
    }
}
