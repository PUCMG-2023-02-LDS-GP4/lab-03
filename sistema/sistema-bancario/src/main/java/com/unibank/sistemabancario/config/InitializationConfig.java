package com.unibank.sistemabancario.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unibank.sistemabancario.models.Instituicao;
import com.unibank.sistemabancario.models.Professor;
import com.unibank.sistemabancario.repositories.InstituicaoRepository;
import com.unibank.sistemabancario.repositories.ProfessorRepository;

@Component
public class InitializationConfig {

    private final InstituicaoRepository instituicaoRepository;
    private final ProfessorRepository professorRepository;

    public InitializationConfig(InstituicaoRepository instituicaoRepository, ProfessorRepository professorRepository) {
        this.instituicaoRepository = instituicaoRepository;
        this.professorRepository = professorRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        if (instituicaoRepository.count() == 0) {
            criarInstituicoesELerProfessores();
        }
    }

    @Transactional
    private void criarInstituicoesELerProfessores() {
        for (long i = 1; i <= 4; i++) {
            Instituicao instituicao = new Instituicao();
            instituicao.setNome("Instituição " + i);
            instituicao = instituicaoRepository.save(instituicao);
    
            List<Professor> professores = lerProfessoresDaInstituicao(i);
            for (Professor professor : professores) {
                Instituicao instManaged = instituicaoRepository.merge(instituicao);
                //professor.setInstituicao(instManaged);
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
