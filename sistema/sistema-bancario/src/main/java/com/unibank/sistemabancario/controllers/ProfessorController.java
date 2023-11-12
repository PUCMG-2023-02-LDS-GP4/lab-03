package com.unibank.sistemabancario.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.models.dtos.CreateProfessorDTO;
import com.unibank.sistemabancario.models.dtos.EnviarMoedasDTO;
import com.unibank.sistemabancario.services.ProfessorService;
@CrossOrigin
@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody CreateProfessorDTO createProfessorDTO) {
        return ResponseEntity.ok(professorService.createProfessor(createProfessorDTO));
    }
    

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.save(professor));
    }

    @PostMapping("/enviarMoedas")
    public ResponseEntity<?> enviarMoedas(@RequestBody EnviarMoedasDTO enviarMoedasDTO) {
        try {
            professorService.enviarMoedas(enviarMoedasDTO.getProfessorId(), enviarMoedasDTO.getAlunoId(),enviarMoedasDTO.getQuantidade());
            return ResponseEntity.ok().body("Moedas enviadas com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}