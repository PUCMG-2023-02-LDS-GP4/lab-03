package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>{
    
}
