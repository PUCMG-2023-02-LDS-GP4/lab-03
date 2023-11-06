package com.unibank.sistemabancario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unibank.sistemabancario.models.Aluno;
import com.unibank.sistemabancario.models.Cupom;
import com.unibank.sistemabancario.services.AlunoService;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        Optional<Aluno> optionalAluno = alunoService.findById(id);
        return optionalAluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.save(aluno));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> optionalAluno = alunoService.findById(id);
        if (optionalAluno.isPresent()) {
            aluno.setId(optionalAluno.get().getId());
            return ResponseEntity.ok(alunoService.save(aluno));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Aluno> optionalAluno = alunoService.findById(id);
        if (optionalAluno.isPresent()) {
            alunoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{alunoId}/vantagens/{vantagemId}/resgatar")
    public ResponseEntity<?> resgatarVantagem(
            @PathVariable Long alunoId,
            @PathVariable Long vantagemId) {
        try {
            
            Cupom cupom = alunoService.resgatarVantagem(alunoId, vantagemId);
            return ResponseEntity.ok(cupom);
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
