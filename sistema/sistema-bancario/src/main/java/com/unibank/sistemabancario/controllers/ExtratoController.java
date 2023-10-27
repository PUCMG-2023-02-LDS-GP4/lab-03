package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/extrato")
public class ExtratoController {

    @Autowired
    private ExtratoService extratoService;

    @GetMapping("/aluno/{id}")
    public List<Transacao> extratoAluno(@PathVariable Long id) {
        return extratoService.gerarExtratoAluno(id);
    }

    @GetMapping("/professor/{id}")
    public List<Transacao> extratoProfessor(@PathVariable Long id) {
        return extratoService.gerarExtratoProfessor(id);
    }
}
