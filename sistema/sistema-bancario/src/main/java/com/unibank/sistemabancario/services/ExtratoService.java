package com.unibank.sistemabancario.services;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.repositories.ExtratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExtratoService {

    @Autowired
    private ExtratoRepository extratoRepository;

    public List<Extrato> getAllExtratos() {
        return extratoRepository.findAll();
    }

    public Optional<Extrato> getExtratoById(Long id) {
        return extratoRepository.findById(id);
    }

    public Extrato saveExtrato(Extrato extrato) {
        return extratoRepository.save(extrato);
    }

    public void deleteExtrato(Long id) {
        extratoRepository.deleteById(id);
    }
}
