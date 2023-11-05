package com.unibank.sistemabancario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unibank.sistemabancario.services.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/{professorId}/enviarMoedas/{alunoId}")
    public ResponseEntity<?> enviarMoedas(
            @PathVariable Long professorId,
            @PathVariable Long alunoId,
            @RequestParam int quantidade) {

        try {

            professorService.enviarMoedas(professorId, alunoId, quantidade);
            return ResponseEntity.ok().body("Moedas enviadas com sucesso.");

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}