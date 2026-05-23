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

public class Main {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario(
        "20240001",
        "Angel",
        "Ingenieria");
        
        Usuario usuario2 = new Usuario(
        "20240002",
        "Maria",
        "Administracion");
        
        Usuario usuario3 = new Usuario(
        "20240003",
        "Jose",
        "Sistemas");
        
        ColaEspera cola = new ColaEspera();
        cola.enqueue(usuario1); 
        cola.enqueue(usuario2);
        cola.enqueue(usuario3);

        System.out.println("Usuarios en cola:");
        cola.mostrarCola();
        
        System.out.println("\nAtendiendo:");
        System.out.println(cola.dequeue());
        
        System.out.println("\nCola actual:");
        cola.mostrarCola();
    }
}
