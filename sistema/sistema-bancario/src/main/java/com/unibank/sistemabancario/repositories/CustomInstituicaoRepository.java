package com.unibank.sistemabancario.repositories;

import com.unibank.sistemabancario.models.Instituicao;

public interface CustomInstituicaoRepository {
    Instituicao merge(Instituicao instituicao);
}
