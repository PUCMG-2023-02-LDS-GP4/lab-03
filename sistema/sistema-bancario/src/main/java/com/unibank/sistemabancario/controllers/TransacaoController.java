package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.Transacao;
import com.unibank.sistemabancario.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/realizar")
    public Transacao realizarTransacao(@RequestParam Long professorId, 
                                       @RequestParam Long alunoId, 
                                       @RequestParam int quantidade, 
                                       @RequestParam String mensagem) {
        return transacaoService.realizarTransacao(professorId, alunoId, quantidade, mensagem);
    }
}
