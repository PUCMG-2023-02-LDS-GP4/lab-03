package com.unibank.sistemabancario.services;

import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Instituicao;

import com.unibank.sistemabancario.repositories.InstituicaoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    private final InstituicaoRepository instituicaoRepository;

    public InstituicaoService(InstituicaoRepository instituicaoRepository) {
        this.instituicaoRepository = instituicaoRepository;
    }

    public List<Instituicao> findAll() {
        return instituicaoRepository.findAll();
    }

    public Optional<Instituicao> findById(Long id) {
        return instituicaoRepository.findById(id);
    }

    public Instituicao save(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    public void deleteById(Long id) {
        instituicaoRepository.deleteById(id);
    }
}
