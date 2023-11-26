package com.unibank.sistemabancario.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.repositories.ProfessorRepository;

@Component
@AllArgsConstructor
public class InitializationConfig {

    private final ProfessorRepository professorRepository;

    @PostConstruct
    @Transactional
    public void init() {
        if (professorRepository.count() == 0) {
            criarInstituicoesELerProfessores();
        }
    }

    @Transactional
    private void criarInstituicoesELerProfessores() {
        for (long i = 1; i <= 4; i++) {
    
            List<Professor> professores = lerProfessoresDaInstituicao(i);
            for (Professor professor : professores) {
                professorRepository.save(professor);
            }
        }
    }
    

    private List<Professor> lerProfessoresDaInstituicao(long numeroInstituicao) {
        try {
            File file = new File("sistema/sistema-bancario/src/main/resources/professores/professores" + numeroInstituicao + ".json");
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(file, Professor[].class));

            
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
