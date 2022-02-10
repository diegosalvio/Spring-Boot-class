package com.example.biblioteca.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> getLivros(){
        return livroRepository.findAll();
    }

    public void registrarNovoLivro(Livro livro) {
        Optional<Livro> livroOptional = livroRepository
                .findLivrobyISBN(livro.getISBN());
        if(livroOptional.isPresent()){
            throw new IllegalStateException("Livro já cadastrado!");
        }
        livroRepository.save(livro);
    }

    public void deletarLivro(long livroId){
        boolean exists = livroRepository.existsById(livroId);
        if(!exists){
            throw new IllegalStateException("Livro com id " + livroId + " não existe!");
        }
        livroRepository.deleteById(livroId);
    }

    @Transactional
    public void atualizarLivro(Long livroId,
                               String titulo,
                               String autor){
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new IllegalStateException(
                        "Livro com a id " + livroId + " não existe!"));

        if(titulo!= null && titulo.length()>0){
            livro.setTitulo(titulo);
        }

        if(autor!= null && autor.length()>0){
            livro.setAutor(autor);
        }
    }


}
