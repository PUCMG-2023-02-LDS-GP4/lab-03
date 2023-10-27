package com.unibank.sistemabancario.services;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.repositories.ExtratoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtratoService {

    @Autowired
    private ExtratoRepository extratoRepository; 

    public List<Transacao> gerarExtratoAluno(Long alunoId) {
        
        
        return extrato.getListaDeTransacoes();
    }

    public List<Transacao> gerarExtratoProfessor(Long professorId) {
       
        
        return extrato.getListaDeTransacoes();
    }
}
