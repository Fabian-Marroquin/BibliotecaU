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

public class Main {
    public static void main(String[] args) {
    GrafoLibros grafo = new GrafoLibros();
    
    grafo.agregarRelacion(
        "Java Basico",
        "Java Avanzado"
    );
    
    grafo.agregarRelacion(
        "Java Avanzado",
        "Estructuras de Datos"
    );
    
    grafo.agregarRelacion(
        "Estructuras de Datos",
        "Algoritmos"
    );
    
    grafo.mostrarGrafo();

    System.out.println();

    grafo.mostrarRelacionados("Java Avanzado");
    }
}