package com.unibank.sistemabancario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>, CustomInstituicaoRepository{
    
    Optional<Instituicao> findById(Long id);
}
