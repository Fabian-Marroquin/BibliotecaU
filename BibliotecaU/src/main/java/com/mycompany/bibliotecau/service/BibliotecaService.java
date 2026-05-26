package com.mycompany.bibliotecau.service;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Libro;
import com.mycompany.bibliotecau.model.Prestamo;
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

    private int contadorPrestamos;
    
    public BibliotecaService() {

        arbolLibros = new ArbolLibroBST();
        usuarios = new HashMap<>();
        prestamos = new ListaPrestamos();
        historial = new PilaHistorial();
        colaEspera = new ColaEspera();
        grafo = new GrafoLibros();
        contadorPrestamos = 1;
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
    
    //registrar el prestamo
    public void registrarPrestamo(int codigoLibro, String carnetUsuario, String fecha) {
        Libro libro = buscarLibro(codigoLibro);
        Usuario usuario = buscarUsuario(carnetUsuario);
        
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("Libro no disponible, usuario agregado a cola de espera"
        );

        colaEspera.enqueue(usuario);

        historial.push(
            "Usuario agregado a cola: " + usuario.getNombre()
        );

        return;
    }

    Prestamo prestamo = new Prestamo(
            contadorPrestamos++, libro, usuario, fecha
    );

    prestamos.agregarPrestamo(prestamo);

    libro.setDisponible(false);

    historial.push(
            "Prestamo registrado: " + libro.getTitulo()
    );
    
    System.out.println("Prestamo realizado");
    }
    
    //registrar la devolucion del libro
    public void registrarDevolucion(int idPrestamo) {

        Prestamo prestamo = prestamos.buscarPrestamo(idPrestamo);

        if (prestamo == null) {

            System.out.println("Prestamo no encontrado");
            return;
        }

        prestamos.eliminarPrestamo(idPrestamo);

        Libro libro = prestamo.getLibro();

        historial.push(
            "Devolucion registrada: " + libro.getTitulo()
        );

        if (!colaEspera.estaVacia()) {

            Usuario siguienteUsuario = colaEspera.dequeue();

            Prestamo nuevoPrestamo = new Prestamo(
                contadorPrestamos++,
                libro,
                siguienteUsuario,
                "Pendiente"
            );

            prestamos.agregarPrestamo(nuevoPrestamo);

            libro.setDisponible(false);

            historial.push(
                "Libro asignado desde cola a: "
                + siguienteUsuario.getNombre()
            );

            System.out.println(
                "Libro asignado automaticamente a "  + siguienteUsuario.getNombre()
            );

        } else {
            libro.setDisponible(true);
        }

        System.out.println("Devolucion realizada");
    }  
    
   //mostrar los prestamos
    public void mostrarPrestamos() {
        prestamos.mostrarPrestamos();
    }
}