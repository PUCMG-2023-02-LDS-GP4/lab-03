package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato, Long>{

    
}
