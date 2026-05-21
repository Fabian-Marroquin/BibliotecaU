package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Prestamo;

public class ListaPrestamos {

    private NodoPrestamo cabeza;

    public ListaPrestamos() {
        cabeza = null;
    }

    public void agregarPrestamo(Prestamo prestamo) {

        NodoPrestamo nuevo = new NodoPrestamo(prestamo);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        NodoPrestamo actual = cabeza;

        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevo);
    }

    public void mostrarPrestamos() {

        if (cabeza == null) {
            System.out.println("No hay prestamos registrados");
            return;
        }

        NodoPrestamo actual = cabeza;

        while (actual != null) {
            System.out.println(actual.getPrestamo());
            System.out.println("----------------------");
            actual = actual.getSiguiente();
        }
    }

    public Prestamo buscarPrestamo(int idPrestamo) {

        NodoPrestamo actual = cabeza;

        while (actual != null) {

            if (actual.getPrestamo().getIdPrestamo() == idPrestamo) {
                return actual.getPrestamo();
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    public boolean eliminarPrestamo(int idPrestamo) {

        if (cabeza == null) {
            return false;
        }

        if (cabeza.getPrestamo().getIdPrestamo() == idPrestamo) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        NodoPrestamo actual = cabeza;

        while (actual.getSiguiente() != null) {

            if (actual.getSiguiente().getPrestamo().getIdPrestamo() == idPrestamo) {

                actual.setSiguiente(
                        actual.getSiguiente().getSiguiente()
                );

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }
}