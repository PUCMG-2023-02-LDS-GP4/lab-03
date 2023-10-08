package com.unibank.sistemabancario.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


import com.unibank.sistemabancario.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
