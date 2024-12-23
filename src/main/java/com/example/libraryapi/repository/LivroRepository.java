package com.example.libraryapi.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    // Query Method
    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    List<Livro> findByIsbn(String isbn);

    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);
    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    // JPQL -> referencia as Entidades e as propriedades
    @Query("SELECT l FROM Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodos();

    @Query("SELECT a FROM Livro as l join l.autor as a")
    List<Autor> listarAutoresDosLivros();

    @Query("SELECT l.titulo FROM Livro as l")
    List<String> listarNomes();

    @Query("""
            select l.genero
            from Livro l
            join l.autor a
            where a.nacionalidade = 'Brasileiro'
            order by l.genero
            """)
    List<String> listarGenerosAutoresBrasileiros();

    // named parameters
    @Query("""
                select l from Livro l where l.genero = :genero order by :paramOrdenacao
            """)
    List<Livro> findByGenero(@Param("genero") GeneroLivro genero, @Param("paramOrdenacao") String paramOrdenacao);

    // positional parameters
    @Query("""
                select l from Livro l where l.genero = ?1 order by ?2
            """)
    List<Livro> findByGeneroPosicional(GeneroLivro genero, String paramOrdenacao);

}
