package com.example.biblioteca.livro;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/livro")
public class LivroController {
    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getLivros(){
        return livroService.getLivros();
    }

    @PostMapping
    public void registrarNovoLivro(@RequestBody Livro livro){
        livroService.registrarNovoLivro(livro);
    }

    @DeleteMapping(path="{livroId}")
    public void deletarLivro(@PathVariable("livroId") Long livroId){
        livroService.deletarLivro(livroId);
    }

    @PutMapping(path="{livroId}")
    public void atualizarLivro(
            @PathVariable("{livroId}") long livroId,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor){
        livroService.atualizarLivro(livroId,titulo, autor);
    }
}
