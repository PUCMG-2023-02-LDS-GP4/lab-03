package com.unibank.sistemabancario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.unibank.sistemabancario.models.Aluno;
import com.unibank.sistemabancario.services.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @PostMapping
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno update(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        return alunoService.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alunoService.delete(id);
    }
}
