package com.unibank.sistemabancario.services;

import com.unibank.sistemabancario.models.Aluno;
import com.unibank.sistemabancario.models.Extrato;
import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.models.Transacao;
import com.unibank.sistemabancario.repositories.AlunoRepository;
import com.unibank.sistemabancario.repositories.ProfessorRepository;
import com.unibank.sistemabancario.repositories.TransacaoRepository;

import java.time.LocalDate;

import javax.transaction.Transactional;

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

    @Autowired
    private ExtratoService extratoService;
    
    @Transactional
    public void realizarTransacao(Long professorId, Long alunoId, int quantidade, String mensagem) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        if (professor.getSaldoDeMoedas() < quantidade) {
            throw new RuntimeException("Saldo insuficiente");
        }
        
        professor.setSaldoDeMoedas(professor.getSaldoDeMoedas() - quantidade);
        aluno.setSaldoDeMoedas(aluno.getSaldoDeMoedas() + quantidade);
        professorRepository.save(professor);
        alunoRepository.save(aluno);
        
        extratoService.updateExtrato(criarTransacao(-quantidade, "Envio de moedas para aluno " + alunoId, professor.getExtrato()));

        extratoService.updateExtrato(criarTransacao(quantidade, mensagem, aluno.getExtrato()));
    
    }


    private Transacao criarTransacao(int quantidade, String mensagem, Extrato extrato) {
        Transacao transacao = new Transacao();
        transacao.setData(LocalDate.now());
        transacao.setQuantidade(quantidade);
        transacao.setMensagem(mensagem);
        transacao.setExtrato(extrato);
        transacaoRepository.save(transacao);
        
        extrato.getListaDeTransacoes().add(transacao);
        return transacao;
    }
}
