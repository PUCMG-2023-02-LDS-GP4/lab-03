package com.unibank.sistemabancario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

    Optional<Extrato> findByPessoaId(Long userId);
}
