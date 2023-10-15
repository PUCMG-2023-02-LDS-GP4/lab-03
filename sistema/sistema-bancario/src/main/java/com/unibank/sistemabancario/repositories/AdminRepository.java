package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
