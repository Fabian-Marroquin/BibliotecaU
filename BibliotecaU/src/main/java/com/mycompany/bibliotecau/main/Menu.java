package com.mycompany.bibliotecau.main;

/**
 *
 * @author angel
 */

import com.mycompany.bibliotecau.model.Libro;
import com.mycompany.bibliotecau.model.Usuario;
import com.mycompany.bibliotecau.service.BibliotecaService;
import java.util.Scanner;

public class Menu {

    private BibliotecaService biblioteca;
    private Scanner scanner;

    public Menu() {
        biblioteca = new BibliotecaService();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    registrarLibro();
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    break;

                case 3:
                    buscarLibroPorCodigo();
                    break;

                case 4:
                    buscarLibroPorISBN();
                    break;
                
                case 5:
                    buscarLibroPorTitulo();
                    break;

                case 6:
                    registrarUsuario();
                    break;

                case 7:
                    biblioteca.mostrarUsuarios();
                    break;

                case 8:
                    registrarPrestamo();
                    break;

                case 9:
                    registrarDevolucion();
                    break;

                case 10:
                    biblioteca.mostrarHistorial();
                    break;

                case 11:
                    biblioteca.mostrarColaEspera();
                    break;
                
                case 12:
                    mostrarRelacionados();
                    break;

                case 13:
                    eliminarLibro();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {

        System.out.println("\n===== BIBLIOTECA U =====");
        System.out.println("1. Registrar libro");
        System.out.println("2. Mostrar libros");
        System.out.println("3. Buscar libro por codigo");
        System.out.println("4. Buscar libro por ISBN");
        System.out.println("5. Buscar libro por titulo");
        System.out.println("6. Registrar usuario");
        System.out.println("7. Mostrar usuarios");
        System.out.println("8. Registrar prestamo");
        System.out.println("9. Registrar devolucion");
        System.out.println("10. Ver historial");
        System.out.println("11. Ver  cola de espera");
        System.out.println("12. Ver libros relacionados");
        System.out.println("13. Eliminar libro");
        System.out.println("0. Salir");
    }

    private void registrarLibro() {

        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Libro libro = new Libro( codigo, isbn, titulo, autor, categoria);

        biblioteca.registrarLibro(libro);

        System.out.println("Libro registrado");
    }

    private void registrarUsuario() {

        System.out.print("Carnet: ");
        String carnet = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();

        Usuario usuario = new Usuario(carnet, nombre, carrera );

        biblioteca.registrarUsuario(usuario);

        System.out.println("Usuario registrado");
    }

    private void buscarLibroPorCodigo() {

        System.out.print("Codigo del libro: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Libro libro = biblioteca.buscarLibro(codigo);

        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void registrarPrestamo() {

        System.out.print("Codigo libro: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        System.out.print("Carnet usuario: ");
        String carnet = scanner.nextLine();

        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();

        biblioteca.registrarPrestamo( codigo, carnet, fecha);
    }

    private void registrarDevolucion() {

        System.out.print("ID Prestamo: ");
        int id = Integer.parseInt(scanner.nextLine());

        biblioteca.registrarDevolucion(id);
    }
    
    private void buscarLibroPorISBN(){
        
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        Libro libro = biblioteca.buscarLibroPorISBN(isbn);

        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado");
        }
    }
    
    private void buscarLibroPorTitulo() {

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        Libro libro = biblioteca.buscarLibroPorTitulo(titulo);

        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado");
        }
    }
    
    private void mostrarRelacionados() {

        System.out.print("Titulo del libro: ");
        String titulo = scanner.nextLine();

        biblioteca.mostrarRelacionesLibros(titulo);
    }

    private void eliminarLibro() {

        System.out.print("Codigo del libro: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        biblioteca.eliminarLibro(codigo);
    }   
    
}
