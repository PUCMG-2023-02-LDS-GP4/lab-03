package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.Vantagem;
import com.unibank.sistemabancario.services.VantagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vantagens")
public class VantagemController {

    private final VantagemService vantagemService;

    public VantagemController(VantagemService vantagemService) {
        this.vantagemService = vantagemService;
    }

    @GetMapping
    public ResponseEntity<List<Vantagem>> getAll() {
        return ResponseEntity.ok(vantagemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vantagem> getById(@PathVariable Long id) {
        Vantagem vantagem = vantagemService.findById(id);
        if (vantagem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vantagem);
    }

    @PostMapping
    public ResponseEntity<Vantagem> create(@RequestBody Vantagem vantagem) {
        return ResponseEntity.ok(vantagemService.save(vantagem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vantagemService.delete(id);
        return ResponseEntity.ok().build();
    }
}
