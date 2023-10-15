package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
    Empresa findEmpresaByEmail(String email);

    Empresa findEmpresaById(Long id);

}
