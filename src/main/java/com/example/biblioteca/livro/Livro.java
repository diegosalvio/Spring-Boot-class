package com.example.biblioteca.livro;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table
public class Livro {
    @Id
    @SequenceGenerator(
            name = "livro_sequence",
            sequenceName = "livro_sequence",
            allocationSize =  1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Livro_sequence"
    )
    private long id;
    private String titulo;
    private String autor;
    private String idioma;
    private String editora;
    private LocalDate dataPublicacao;
    private String ISBN;

    public Livro(long id, String titulo, String autor, String idioma, String editora, LocalDate dataPublicacao, String ISBN) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
        this.ISBN = ISBN;
    }

    public Livro(String titulo, String autor, String idioma, String editora, LocalDate dataPublicacao, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
        this.ISBN = ISBN;
    }

    public Livro() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", editora='" + editora + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
