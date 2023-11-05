package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/realizar")
    public ResponseEntity<?> realizarTransacao(
            @RequestParam Long professorId,
            @RequestParam Long alunoId,
            @RequestParam int quantidade,
            @RequestParam String mensagem) {
        try {

            transacaoService.realizarTransacao(professorId, alunoId, quantidade, mensagem);
            return ResponseEntity.ok().body("Transação realizada com sucesso.");
            
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
