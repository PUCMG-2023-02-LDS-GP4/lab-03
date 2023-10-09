package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.Empresa;
import com.unibank.sistemabancario.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> listAll() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Long id) {
        Optional<Empresa> optionalEmpresa = empresaService.findById(id);
        if (optionalEmpresa.isPresent()) {
            return ResponseEntity.ok(optionalEmpresa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody Empresa empresa) {
        Optional<Empresa> optionalEmpresa = empresaService.findById(id);
        if (optionalEmpresa.isPresent()) {
            empresa.setId(optionalEmpresa.get().getId());
            return ResponseEntity.ok(empresaService.save(empresa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Empresa> optionalEmpresa = empresaService.findById(id);
        if (optionalEmpresa.isPresent()) {
            empresaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
