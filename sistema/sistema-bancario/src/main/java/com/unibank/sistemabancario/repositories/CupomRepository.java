package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, Long> {
    
}
