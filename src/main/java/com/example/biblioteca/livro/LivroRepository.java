package com.example.biblioteca.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT l FROM Livro l WHERE l.ISBN=?1")
    Optional<Livro> findLivrobyISBN(String ISBN);
}
