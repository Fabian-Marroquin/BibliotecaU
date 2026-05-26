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
    
    public void eliminar(int codigo) {
        raiz = eliminarRecursivo(raiz, codigo);
    }

    private NodoLibro eliminarRecursivo(NodoLibro nodo, int codigo) {

        if (nodo == null) {
            return null;
        }

        if (codigo < nodo.getLibro().getCodigo()) {
            nodo.setIzquierda( eliminarRecursivo(nodo.getIzquierda(), codigo));
        } else if (codigo > nodo.getLibro().getCodigo()) {
            nodo.setDerecha( eliminarRecursivo(nodo.getDerecha(), codigo));

        } else {

            // caso 1: sin hijos
            if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
                return null;
            }

            // caso 2: un hijo
            if (nodo.getIzquierda() == null) {
                return nodo.getDerecha();
            }

            if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }

            // caso 3: dos hijos
            NodoLibro sucesor = encontrarMin(nodo.getDerecha());
                nodo.setLibro(sucesor.getLibro());
                nodo.setDerecha(
                eliminarRecursivo(nodo.getDerecha(), sucesor.getLibro().getCodigo())
            );
        }

        return nodo;
    }

    private NodoLibro encontrarMin(NodoLibro nodo) {

        while (nodo.getIzquierda() != null) {
            nodo = nodo.getIzquierda();
        }

        return nodo;
    }
    
}
