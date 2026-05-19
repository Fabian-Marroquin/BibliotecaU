package com.mycompany.bibliotecau.main;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Libro;
import com.mycompany.bibliotecau.model.Usuario;
import com.mycompany.bibliotecau.model.Prestamo;

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
    }
}
