package com.example.biblioteca.livro;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LivroConfig {

    @Bean
    CommandLineRunner commandLineRunner(LivroRepository repository){
        return args -> {
            Livro ulisses = new Livro(
                    "Ulisses",
                    "James Joyce",
                    "Português-Brasil",
                    "Penguin",
                    LocalDate.of(2012, Month.MAY, 8),
                    "8563560425"
            );
            Livro gracaInfinita = new Livro(
                    "Graça Infinita",
                    "David Foster Wallace",
                    "Português-Brasil",
                    "Cia das Letras",
                    LocalDate.of(2014,Month.NOVEMBER, 14),
                    "853592504X"
            );

            repository.saveAll(
                    List.of(ulisses, gracaInfinita)
            );
        };
    }
}
