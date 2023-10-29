package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

}
