package com.unibank.sistemabancario.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unibank.sistemabancario.models.Aluno;
import com.unibank.sistemabancario.models.dtos.CreateAlunoDTO;
import com.unibank.sistemabancario.models.dtos.ResgateDeVantagemDTO;
import com.unibank.sistemabancario.services.AlunoService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

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
    public ResponseEntity<Aluno> create(@RequestBody CreateAlunoDTO createAlunoDTO) {
        return ResponseEntity.ok(alunoService.save(createAlunoDTO));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        try {
            return ResponseEntity.ok(alunoService.updateAluno(id, aluno));
        } catch (EntityNotFoundException e) {
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
                ResgateDeVantagemDTO resgateDeVantagemDTO = alunoService.resgatarVantagem(alunoId, vantagemId);
                return ResponseEntity.ok(resgateDeVantagemDTO);
            } catch (RuntimeException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
    }
}
