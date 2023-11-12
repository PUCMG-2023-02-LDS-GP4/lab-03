package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.services.ExtratoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/extratos")
public class ExtratoController {

    private final ExtratoService extratoService;

    public ExtratoController(ExtratoService extratoService) {
        this.extratoService = extratoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Extrato>> getAllExtratos() {
        return ResponseEntity.ok(extratoService.getAllExtratos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Extrato> getExtratoById(@PathVariable Long id) {
        Optional<Extrato> extrato = extratoService.getExtratoById(id);
        if (extrato.isPresent()) {
            return ResponseEntity.ok(extrato.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Extrato> createExtrato(@RequestBody Extrato extrato) {
        return ResponseEntity.ok(extratoService.saveExtrato(extrato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExtrato(@PathVariable Long id) {
        extratoService.deleteExtrato(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Extrato> getExtratoByUserId(@PathVariable Long userId) {
        Optional<Extrato> extrato = extratoService.getExtratoByPessoaId(userId);
        if (extrato.isPresent()) {
            return ResponseEntity.ok(extrato.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}/transacoes")
    public ResponseEntity<List<Transacao>> getTransacoesByUserId(@PathVariable Long userId) {
        List<Transacao> transacoes = extratoService.getTransacoesByUserId(userId);
        if (transacoes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transacoes);
    }

}
