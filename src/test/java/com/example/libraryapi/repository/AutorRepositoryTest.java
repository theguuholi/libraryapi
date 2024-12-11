package com.example.libraryapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.libraryapi.model.Autor;

import jakarta.transaction.Transactional;

@SpringBootTest
public class AutorRepositoryTest {
    @Autowired
    AutorRepository autorRepository;

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

}
