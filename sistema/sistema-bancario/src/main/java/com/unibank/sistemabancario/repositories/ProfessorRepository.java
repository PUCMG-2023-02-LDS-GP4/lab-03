package com.unibank.sistemabancario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibank.sistemabancario.models.Professor;
import java.util.Optional;


public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
