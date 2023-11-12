package com.unibank.sistemabancario.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.models.dtos.CreateProfessorDTO;
import com.unibank.sistemabancario.repositories.ExtratoRepository;
import com.unibank.sistemabancario.repositories.ProfessorRepository;

@Service
public class ProfessorService {
    
    private final ProfessorRepository professorRepository;
    private final AlunoService alunoService;
    private final PessoaService pessoaService;
    private final ExtratoRepository extratoRepository;

    public ProfessorService(ProfessorRepository professorRepository, ExtratoRepository extratoRepository, AlunoService alunoService,PessoaService pessoaService) {
        this.professorRepository = professorRepository;
        this.extratoRepository = extratoRepository;
        this.alunoService = alunoService;
        this.pessoaService = pessoaService; 
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com ID: " + id));
    }

    public Professor createProfessor(CreateProfessorDTO createProfessorDTO) {
        Professor professor = new Professor();
        professor.setNome(createProfessorDTO.getNome());
        professor.setEmail(createProfessorDTO.getEmail());
        professor.setPassword(createProfessorDTO.getPassword());
        professor.setCpf(createProfessorDTO.getCpf());
        professor.setDepartamento(createProfessorDTO.getDepartamento());

        professor.setTipoUser(createProfessorDTO.getTipoUser());

        professor = professorRepository.save(professor);

        return professorRepository.save(professor);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    //  "0 0 0 */6 * *" significa a cada 6 meses às 00:00:00 horas
    @Scheduled(cron = "0 0 0 */6 * *")
    @Transactional
    public void addMoedasEmProfessores() {
        List<Professor> professores = professorRepository.findAll();
        for (Professor professor : professores) {
            int moedasAdicionadas = 1000;
            professor.setSaldoDeMoedas(professor.getSaldoDeMoedas() + moedasAdicionadas);
            pessoaService.registrarTransacao(professor, moedasAdicionadas, "Adição semestral de moedas");
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

