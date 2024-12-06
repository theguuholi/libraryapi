package com.example.libraryapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

}
