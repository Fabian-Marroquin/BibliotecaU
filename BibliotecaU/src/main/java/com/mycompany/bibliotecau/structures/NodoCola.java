package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Usuario;

public class NodoCola {

    private Usuario usuario;
    private NodoCola siguiente;

    public NodoCola(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
}