package com.unibank.sistemabancario.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.unibank.sistemabancario.models.Instituicao;

public class CustomInstituicaoRepositoryImpl implements CustomInstituicaoRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Instituicao merge(Instituicao instituicao) {
        return entityManager.merge(instituicao);
    }
    
}
