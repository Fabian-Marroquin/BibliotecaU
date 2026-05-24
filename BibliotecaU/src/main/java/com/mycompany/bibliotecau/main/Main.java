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

public class Main {

    public static void main(String[] args) {

    Libro libro1 = new Libro(
        50,
        "111",
        "Java",
        "Autor 1",
        "Programacion");
    
    Libro libro2 = new Libro(
        30,
        "222",
        "Estructuras",
        "Autor 2",
        "Programacion");
    
    Libro libro3 = new Libro(
        70,
        "333",
        "Bases de Datos",
        "Autor 3",
        "Base de Datos");
    
    ArbolLibroBST arbol = new ArbolLibroBST();

    arbol.insertar(libro1);
    arbol.insertar(libro2);
    arbol.insertar(libro3);
    
    System.out.println("Libros ordenados:");
    arbol.mostrarInOrden();
    
    System.out.println("\nBusqueda:");
    
    Libro encontrado = arbol.buscar(70);
    
    if (encontrado != null) {
        System.out.println(encontrado);
    }
    }
}
