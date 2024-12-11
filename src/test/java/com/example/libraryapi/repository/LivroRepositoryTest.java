package com.example.libraryapi.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;

import jakarta.transaction.Transactional;

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
        livro.setPreco(BigDecimal.valueOf(60));

        // var autor =
        // autorRepository.findById(UUID.fromString("e24df2e9-6973-4be0-871d-20bb562c9885")).orElse(null);
        // E raro o cacade, mas profissionais nao e recomendado usar o cascade
        // operacao cascade
        livro.setAutor(newAutor());
        livroRepository.save(livro);
    }

    @Test
    @Transactional
    public void atualizarAuthorDoLivro() {
        Livro livro = new Livro();
        livro.setIsbn("978-85-333-0223-4");
        livro.setTitulo("Java 9 Prático");
        livro.setGenero(GeneroLivro.AUTOAJUDA);
        livro.setDataPublicacao(LocalDate.of(2014, 2, 24));
        livro.setPreco(BigDecimal.valueOf(60));
        var livroDb = livroRepository.save(livro);

        var livroParaAtualizar = livroRepository.findById(livroDb.getId()).orElse(null);
        livroParaAtualizar.setAutor(newAutor());
        // livroRepository.save(livroParaAtualizar);

        var livroAtualizado = livroRepository.findById(livroDb.getId()).orElse(null);
        System.out.println(livroAtualizado.getTitulo());

        // vai carregar pq foi colocado o transactional
        System.out.println(livroAtualizado.getAutor().getNome());

    }

    @Test
    public void buscaPorLivroTest() {
        livroRepository.findByTitulo("Java 9 Prático").forEach(System.out::println);
    }

    @Test
    public void pesquisaPorIsbnTest() {
        livroRepository.findByIsbn("978-85-333-0223-4").forEach(System.out::println);
    }

    @Test
    public void pesquisaPorPrecoAndTituloTest() {
        livroRepository.findByTituloAndPreco("123", new BigDecimal(70)).forEach(System.out::println);
    }

    public Autor newAutor() {
        Autor autor = new Autor();
        autor.setNome("Rodrigo Turini");
        autor.setDataNascimento(LocalDate.of(1982, 1, 25));
        autor.setNacionalidade("Brasileiro");
        return autor;
    }
}
