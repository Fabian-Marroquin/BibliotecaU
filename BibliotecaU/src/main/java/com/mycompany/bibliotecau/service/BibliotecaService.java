package com.mycompany.bibliotecau.service;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Libro;
import com.mycompany.bibliotecau.model.Usuario;
import com.mycompany.bibliotecau.structures.ArbolLibroBST;
import com.mycompany.bibliotecau.structures.ColaEspera;
import com.mycompany.bibliotecau.structures.GrafoLibros;
import com.mycompany.bibliotecau.structures.ListaPrestamos;
import com.mycompany.bibliotecau.structures.PilaHistorial;
import java.util.HashMap;

public class BibliotecaService {

    private ArbolLibroBST arbolLibros;
    private HashMap<String, Usuario> usuarios;
    private ListaPrestamos prestamos;
    private PilaHistorial historial;
    private ColaEspera colaEspera;
    private GrafoLibros grafo;

    public BibliotecaService() {

        arbolLibros = new ArbolLibroBST();
        usuarios = new HashMap<>();
        prestamos = new ListaPrestamos();
        historial = new PilaHistorial();
        colaEspera = new ColaEspera();
        grafo = new GrafoLibros();
    }
    
    //agregar registro de usuario
    public void registrarUsuario(Usuario usuario) {

    usuarios.put(
            usuario.getCarnet(),
            usuario
    );

    historial.push(
            "Usuario registrado: " + usuario.getNombre()
    );
    }
    
    //buscqueda de usuario
    public Usuario buscarUsuario(String carnet) {
        return usuarios.get(carnet);
    }
    
    //Mostar usuarios
    public void mostrarUsuarios() {

    if (usuarios.isEmpty()) {

        System.out.println(
            "No hay usuarios registrados"
        );

        return;
    }

    for (Usuario usuario : usuarios.values()) {
        System.out.println(usuario);
    }

    }
    
    //guardar libro
    public void registrarLibro(Libro libro) {

    arbolLibros.insertar(libro);

    historial.push(
            "Libro registrado: " + libro.getTitulo()
    );

    grafo.agregarLibro(
            libro.getTitulo()
    );
    }
    
    //busar libro
    public Libro buscarLibro(int codigo) {
        return arbolLibros.buscar(codigo);
    }
    
    
    //mostar libro
    public void mostrarLibros() {
        arbolLibros.mostrarInOrden();
    }
    
    //mostar el historial
    public void mostrarHistorial() {
        historial.mostrarHistorial();
    }
    
    //mostrar cola
    public void mostrarColaEspera() {
        colaEspera.mostrarCola();
    }
    
}