package com.example.libraryapi.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    // Query Method
    List<Livro> findByAutor(Autor autor);
    List<Livro> findByTitulo(String titulo);
    List<Livro> findByIsbn(String isbn);
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

}
