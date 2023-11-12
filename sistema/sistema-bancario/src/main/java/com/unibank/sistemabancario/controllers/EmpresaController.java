package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.Empresa;
import com.unibank.sistemabancario.models.Vantagem;
import com.unibank.sistemabancario.models.dtos.CreateVantagemDTO;
import com.unibank.sistemabancario.services.EmpresaService;
import com.unibank.sistemabancario.services.VantagemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;
    private final VantagemService vantagemService;

    public EmpresaController(EmpresaService empresaService, VantagemService vantagemService) {
        this.empresaService = empresaService;
        this.vantagemService = vantagemService;
    }

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

    @PostMapping("/{id}/vantagens")
    public ResponseEntity<?> createVantagem(@PathVariable Long id,
                                            @RequestParam("descricao") String descricao,
                                            @RequestParam("quantidade") String quantidade,
                                            @RequestParam("custoEmMoedas") int custoEmMoedas, 
                                            @RequestPart("foto") MultipartFile file) {
    
        Empresa empresa = empresaService.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada"));
    
        byte[] fotoBytes;
        try {
            fotoBytes = file.getBytes();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao processar a foto");
        }
    
        Vantagem vantagem = new Vantagem();
        vantagem.setDescricao(descricao);
        vantagem.setCustoEmMoedas(custoEmMoedas);
        vantagem.setQuantidade(Integer.parseInt(quantidade));
        vantagem.setFoto(fotoBytes);
        vantagem.setEmpresa(empresa);
        vantagemService.save(vantagem);
    
        return ResponseEntity.status(HttpStatus.CREATED).body("Vantagem criada com sucesso.");
    }
    
}


