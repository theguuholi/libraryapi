package com.example.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.sercice.TransacaoService;

@SpringBootTest
public class TransacoesTest {
    @Autowired
    TransacaoService service;

    @Test
    // @Transactional // commit e rollback confirmar e desfazer alteracoes
    void transacaoSimples() {
        // somente funciona quando a transacao tem commit quando tem sucesso
        service.executar();
    }

    @Test
    public void atualizacaoSemAtualizar() {
        service.transacaoSemAtualizar();
    }

}
