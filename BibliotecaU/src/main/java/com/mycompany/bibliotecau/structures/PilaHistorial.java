package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

public class PilaHistorial {

    private NodoHistorial cima;

    public PilaHistorial() {
        cima = null;
    }

    public void push(String accion) {

        NodoHistorial nuevo = new NodoHistorial(accion);

        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public String pop() {

        if (estaVacia()) {
            return null;
        }

        String accion = cima.getAccion();
        cima = cima.getSiguiente();

        return accion;
    }

    public String peek() {

        if (estaVacia()) {
            return null;
        }

        return cima.getAccion();
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public void mostrarHistorial() {

        if (estaVacia()) {
            System.out.println("No hay acciones registradas");
            return;
        }

        NodoHistorial actual = cima;

        while (actual != null) {

            System.out.println(actual.getAccion());

            actual = actual.getSiguiente();
        }
    }
}