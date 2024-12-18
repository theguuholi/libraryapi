package com.example.libraryapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryapi.model.Autor;

// Extends CrudRepository tem todas as operacoes essenciais
public interface AutorRepository extends JpaRepository<Autor, UUID> {

}
