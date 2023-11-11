package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.Instituicao;
import com.unibank.sistemabancario.services.InstituicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituicoes")
public class InstituicaoController {

    private final InstituicaoService instituicaoService;

    public InstituicaoController(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    @GetMapping
    public List<Instituicao> getAllInstituicoes() {
        return instituicaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instituicao> getInstituicaoById(@PathVariable Long id) {
        return instituicaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instituicao createInstituicao(@RequestBody Instituicao instituicao) {
        return instituicaoService.save(instituicao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstituicao(@PathVariable Long id) {
        instituicaoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
