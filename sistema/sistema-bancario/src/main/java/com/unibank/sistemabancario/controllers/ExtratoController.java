package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.services.ExtratoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/extratos")
public class ExtratoController {

    @Autowired
    private ExtratoService extratoService;

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
}
