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

public class Main {

    public static void main(String[] args) {

        //prueba de la clase libro
        Libro libro = new Libro(
                1,
                "978123456",
                "Ejemplo",
                "Juan",
                "Programacion"
        );

        System.out.println(libro);

        //prueba de la clase usuario
        Usuario usuario = new Usuario(
                "12345678",
                "Maria",
                "Ingenieria"
        );

        System.out.println(usuario);
        
        Prestamo prestamo = new Prestamo(
            1,
            libro,
            usuario,
            "10/08/2025"
        ); 
        
        ListaPrestamos lista = new ListaPrestamos();

        lista.agregarPrestamo(prestamo);

        lista.mostrarPrestamos();
    }
}
