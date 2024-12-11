package com.example.libraryapi.repository;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;

@SpringBootTest
public class LivroRepositoryTest {
    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest() {
        Livro livro = new Livro();
        livro.setIsbn("978-85-333-0223-4");
        livro.setTitulo("Java 8 Prático");
        livro.setGenero(GeneroLivro.AUTOAJUDA);
        livro.setDataPublicacao(LocalDate.of(2014, 2, 24));
        livro.setPreco(69.90);

        // var autor =
        // autorRepository.findById(UUID.fromString("e24df2e9-6973-4be0-871d-20bb562c9885")).orElse(null);

        // operacao cascade
        livro.setAutor(newAutor());
        livroRepository.save(livro);
    }

    public Autor newAutor() {
        Autor autor = new Autor();
        autor.setNome("Rodrigo Turini");
        autor.setDataNascimento(LocalDate.of(1982, 1, 25));
        autor.setNacionalidade("Brasileiro");
        return autor;
    }
}
