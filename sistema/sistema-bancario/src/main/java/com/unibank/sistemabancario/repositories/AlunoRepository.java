package com.unibank.sistemabancario.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.unibank.sistemabancario.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Transactional(readOnly = true)
    Aluno findAlunoByEmail(String email);

    @Transactional(readOnly = true)
    Aluno findAlunoById(Long id);
    
}
