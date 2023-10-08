package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.Pessoa;
import com.unibank.sistemabancario.services.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas/authenticate")
public class AuthController {

    @Autowired
    private PessoaService PessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> authenticate(@RequestBody Pessoa user) {
        Pessoa authenticatedUser = PessoaService.authenticateUser(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
