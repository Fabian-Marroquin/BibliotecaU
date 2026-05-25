package com.mycompany.bibliotecau.structures;

/**
 *
 * @author angel
 */

import java.util.ArrayList;
import java.util.HashMap;

public class GrafoLibros {

    private HashMap<String, ArrayList<String>> relaciones;

    public GrafoLibros() {
        relaciones = new HashMap<>();
    }

    public void agregarLibro(String titulo) {

        if (!relaciones.containsKey(titulo)) {
            relaciones.put(titulo, new ArrayList<>());
        }
    }

    public void agregarRelacion(String libro1, String libro2) {

        agregarLibro(libro1);
        agregarLibro(libro2);

        relaciones.get(libro1).add(libro2);
        relaciones.get(libro2).add(libro1);
    }

    public void mostrarRelacionados(String titulo) {

        if (!relaciones.containsKey(titulo)) {
            System.out.println("Libro no encontrado");
            return;
        }

        System.out.println("Libros relacionados con: " + titulo);

        ArrayList<String> relacionados = relaciones.get(titulo);

        if (relacionados.isEmpty()) {
            System.out.println("No tiene relaciones registradas");
            return;
        }

        for (String libro : relacionados) {
            System.out.println("- " + libro);
        }
    }

    public void mostrarGrafo() {

        for (String libro : relaciones.keySet()) {

            System.out.print(libro + " -> ");

            for (String relacionado : relaciones.get(libro)) {
                System.out.print(relacionado + " ");
            }

            System.out.println();
        }
    }
}
