package com.unibank.sistemabancario.services;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.repositories.ExtratoRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class ExtratoService {

    private final ExtratoRepository extratoRepository;

    public ExtratoService(ExtratoRepository extratoRepository) {
        this.extratoRepository = extratoRepository;
    }

    public Extrato create(Extrato extrato) {
        return extratoRepository.save(extrato);
    }

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

    @Transactional
    public Extrato updateExtrato(Transacao transacao) {
        Extrato extrato = transacao.getExtrato();
        extratoRepository.save(extrato);
        return extrato;
    }
}
