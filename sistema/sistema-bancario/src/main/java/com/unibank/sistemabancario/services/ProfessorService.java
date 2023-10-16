package com.unibank.sistemabancario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.repositories.ProfessorRepository;

public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    //  "0 0 0 */6 * *" significa a cada 6 meses às 00:00:00 horas
    @Scheduled(cron = "0 0 0 */6 * *")
    public void addMoedasEmProfessores() {
        List<Professor> professores = professorRepository.findAll();
        for (Professor professor : professores) {
            professor.setSaldoDeMoedas(professor.getSaldoDeMoedas() + 1000);
            professorRepository.save(professor);
        }
    }

}

