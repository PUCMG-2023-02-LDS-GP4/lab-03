package com.unibank.sistemabancario.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Pessoa;
import com.unibank.sistemabancario.repositories.PessoaRepository;


@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository PessoaRepository;

    @Transactional
    public Pessoa authenticateUser(String email, String password) {
        Pessoa user = PessoaRepository.findPessoaByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

}
