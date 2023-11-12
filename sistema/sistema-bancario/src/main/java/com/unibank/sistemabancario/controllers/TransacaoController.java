package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.services.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

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
