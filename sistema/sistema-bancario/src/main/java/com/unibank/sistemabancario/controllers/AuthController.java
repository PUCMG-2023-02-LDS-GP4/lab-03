package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.User;
import com.unibank.sistemabancario.models.dtos.AuthResponseDTO;
import com.unibank.sistemabancario.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/users/authenticate")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody User user) {
        AuthResponseDTO authenticatedUser = userService.authenticateUser(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
