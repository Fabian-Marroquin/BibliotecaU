package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Usuario;

public class ColaEspera {

    private NodoCola frente;
    private NodoCola fin;

    public ColaEspera() {
        frente = null;
        fin = null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void enqueue(Usuario usuario) {

        NodoCola nuevo = new NodoCola(usuario);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
            return;
        }

        fin.setSiguiente(nuevo);
        fin = nuevo;
    }

    public Usuario dequeue() {

        if (estaVacia()) {
            return null;
        }

        Usuario usuario = frente.getUsuario();

        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        return usuario;
    }

    public Usuario peek() {

        if (estaVacia()) {
            return null;
        }

        return frente.getUsuario();
    }

    public void mostrarCola() {

        if (estaVacia()) {
            System.out.println("No hay usuarios en espera");
            return;
        }

        NodoCola actual = frente;

        while (actual != null) {

            System.out.println(actual.getUsuario());

            actual = actual.getSiguiente();
        }
    }
}
