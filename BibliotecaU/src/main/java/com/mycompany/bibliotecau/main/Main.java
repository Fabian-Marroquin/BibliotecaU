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
import com.mycompany.bibliotecau.structures.ColaEspera;
import com.mycompany.bibliotecau.structures.NodoLibro;
import com.mycompany.bibliotecau.structures.ArbolLibroBST;
import com.mycompany.bibliotecau.structures.GrafoLibros;
import com.mycompany.bibliotecau.service.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();

        Usuario usuario = new Usuario(
            "20240001",
            "Angel",
            "Ingenieria"
        );

        biblioteca.registrarUsuario(usuario);

        Libro libro = new Libro(
            1,
            "978123",
            "Java Basico",
            "Juan Perez",
            "Programacion"
        );

        biblioteca.registrarLibro(libro);

        biblioteca.registrarPrestamo(
            1,
            "20240001",
            "10/05/2026"
        );

        System.out.println();

        biblioteca.mostrarPrestamos();

        System.out.println();

        biblioteca.registrarDevolucion(1);

        System.out.println();

        biblioteca.mostrarHistorial();
    }
}