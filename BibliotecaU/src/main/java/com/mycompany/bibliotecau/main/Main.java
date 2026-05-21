package com.mycompany.bibliotecau.main;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Libro;
import com.mycompany.bibliotecau.model.Usuario;
import com.mycompany.bibliotecau.model.Prestamo;
import com.mycompany.bibliotecau.structures.ListaPrestamos;
import com.mycompany.bibliotecau.structures.NodoPrestamo;
import com.mycompany.bibliotecau.structures.PilaHistorial;

public class Main {

    public static void main(String[] args) {

        PilaHistorial historial = new PilaHistorial();

        historial.push("Libro agregado");
        historial.push("Usuario registrado");
        historial.push("Prestamo realizado");

        historial.mostrarHistorial();
    }
}
