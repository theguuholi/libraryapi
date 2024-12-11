package com.example.libraryapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    // Query Method
    List<Livro> findByAutor(Autor autor);

}
