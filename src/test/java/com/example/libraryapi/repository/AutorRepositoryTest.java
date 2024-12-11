package com.example.libraryapi.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;

import jakarta.transaction.Transactional;

@SpringBootTest
public class AutorRepositoryTest {
    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setNome("Rodrigo Turini");
        autor.setDataNascimento(LocalDate.of(1982, 1, 25));
        autor.setNacionalidade("Brasileiro");

        var autorSalvo = autorRepository.save(autor);
        System.out.println(autorSalvo);
    }

    @Test
    @Transactional
    public void listarTest() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    @Test
    public void salvarAutorElivrosTest() {
        Autor autor = new Autor();
        autor.setNome("abobora 123 Turini");
        autor.setDataNascimento(LocalDate.of(1982, 1, 25));
        autor.setNacionalidade("Brasileiro");

        autor.setLivros(new ArrayList<>());

        autor.getLivros().add(criarLivro("ablasjdfa", autor));
        autor.getLivros().add(criarLivro("laksdflkjsdaf", autor));

        // utilizando cascade nesse caso faz sentido para a insercao
        autorRepository.save(autor);

        
        List<Livro> byAutor = livroRepository.findByAutor(autor);

        autor.setLivros(byAutor);

        //livro repository save para salvar

        autor.getLivros().forEach(System.out::println);
    }

    private Livro criarLivro(String titulo, Autor autor) {
        Livro livro = new Livro();
        livro.setIsbn("978-85-333-0223-4");
        livro.setTitulo(titulo);
        livro.setGenero(GeneroLivro.AUTOAJUDA);
        livro.setDataPublicacao(LocalDate.of(2014, 2, 24));
        livro.setPreco(69.90);
        livro.setAutor(autor);
        return livro;
    }

}
