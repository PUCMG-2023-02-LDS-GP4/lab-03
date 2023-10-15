package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Vantagem;

public interface VantagemRepository extends JpaRepository<Vantagem, Long> {
}
