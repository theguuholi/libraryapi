package com.example.libraryapi.sercice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.model.GeneroLivro;
import com.example.libraryapi.model.Livro;
import com.example.libraryapi.repository.AutorRepository;
import com.example.libraryapi.repository.LivroRepository;

@Service
public class TransacaoService {
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void executar() {

        // salva o autor
        Autor autor = new Autor();
        autor.setNome("Jose");
        autor.setDataNascimento(LocalDate.of(1982, 1, 25));
        autor.setNacionalidade("Brasileiro");

        autorRepository.saveAndFlush(autor);
        // salva o livro
        Livro livro = new Livro();
        livro.setIsbn("978-85-333-0223-4");
        livro.setTitulo("Java 8 Prático");
        livro.setGenero(GeneroLivro.AUTOAJUDA);
        livro.setDataPublicacao(LocalDate.of(2014, 2, 24));
        livro.setPreco(BigDecimal.valueOf(60));

        livroRepository.save(livro);
        if (autor.getNome().contains("Jose")) {
            throw new RuntimeException("Rollback");
        }
    }

    @Transactional
    public void transacaoSemAtualizar() {
        var livro = livroRepository.findById(UUID.fromString("59a82a81-e56c-4676-84c0-838c812c6288")).orElse(null);
        livro.setTitulo("Java 10 Prático");

    }

    @Transactional
    public void salvarLivroComFoto() {
        // salva o livro
        // repository.save(livro);

        // @pega o id do livro 
        // tudo da transacao e salvo ao final

        // salvar a foto do livro -> bucket na nuvem

        //atualizar o nome arquivo que foi salvo
    }
}
