package com.mycompany.bibliotecau.model;

/**
 *
 * @author angel
 */

public class Libro {

    private int codigo;
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponible;

    public Libro(int codigo, String isbn, String titulo, String autor, String categoria) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponible = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | ISBN: " + isbn + " | Titulo: " + titulo + " | Autor: " + autor + " | Categoria: " + categoria + " | Disponible: " + disponible;
    }
}
