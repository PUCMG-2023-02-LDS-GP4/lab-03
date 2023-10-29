package com.unibank.sistemabancario.services;

import com.unibank.sistemabancario.models.Aluno;
import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.models.Transacao;
import com.unibank.sistemabancario.repositories.AlunoRepository;
import com.unibank.sistemabancario.repositories.ProfessorRepository;
import com.unibank.sistemabancario.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    
    @Autowired
    private TransacaoRepository transacaoRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;
    
    public Transacao realizarTransacao(Long professorId, Long alunoId, int quantidade, String mensagem) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if (professor.getSaldoDeMoedas() < quantidade) {
            throw new RuntimeException("Saldo insuficiente");
        }
        
        professor.setSaldoDeMoedas(professor.getSaldoDeMoedas() - quantidade);
        professorRepository.save(professor);

        aluno.setSaldoDeMoedas(aluno.getSaldoDeMoedas() + quantidade);
        alunoRepository.save(aluno);
        
        Transacao transacao = new Transacao();
        transacao.setQuantidade(quantidade);
        transacao.setMensagem(mensagem);
        transacaoRepository.save(transacao);
        
        return transacao;
    }
}
