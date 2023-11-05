package com.unibank.sistemabancario.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.repositories.ProfessorRepository;

public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PessoaService pessoaService;

    //  "0 0 0 */6 * *" significa a cada 6 meses às 00:00:00 horas
    @Scheduled(cron = "0 0 0 */6 * *")
    public void addMoedasEmProfessores() {
        List<Professor> professores = professorRepository.findAll();
        for (Professor professor : professores) {
            professor.setSaldoDeMoedas(professor.getSaldoDeMoedas() + 1000);
            professorRepository.save(professor);
        }
    }

    @Transactional
    public void enviarMoedas(Long professorId, Long alunoId, int quantidade) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        
        if (professor.getSaldoDeMoedas() >= quantidade) {
            professor.setSaldoDeMoedas(professor.getSaldoDeMoedas() - quantidade);
            professorRepository.save(professor);

            alunoService.receberMoedas(alunoId, quantidade, "Recebimento de moedas de professor");
            pessoaService.registrarTransacao(professor, -quantidade, "Envio de moedas para aluno");
        } else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }
}

