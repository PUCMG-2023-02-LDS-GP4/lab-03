package com.unibank.sistemabancario.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Aluno;
import com.unibank.sistemabancario.models.Cupom;
import com.unibank.sistemabancario.models.Vantagem;
import com.unibank.sistemabancario.repositories.AlunoRepository;
import com.unibank.sistemabancario.repositories.CupomRepository;
import com.unibank.sistemabancario.repositories.VantagemRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private VantagemRepository vantagemRepository;
    
    @Autowired
    private CupomRepository cupomRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
    
    public Cupom resgatarVantagem(Long alunoId, Long vantagemId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Vantagem vantagem = vantagemRepository.findById(vantagemId).orElseThrow(() -> new RuntimeException("Vantagem não encontrada"));

        if (aluno.getSaldoDeMoedas() < vantagem.getCustoEmMoedas()) {
            throw new RuntimeException("Saldo insuficiente");
        }

        if (vantagem.getQuantidade() <= 0) {
            throw new RuntimeException("Vantagem esgotada");
        }

        aluno.setSaldoDeMoedas(aluno.getSaldoDeMoedas() - vantagem.getCustoEmMoedas());
        alunoRepository.save(aluno);

        vantagem.setQuantidade(vantagem.getQuantidade() - 1);
        vantagemRepository.save(vantagem);

        Cupom cupom = new Cupom();
        cupom.setCodigo(UUID.randomUUID().toString());
        cupom.setVantagem(vantagem);
        cupom.setAluno(aluno);

        aluno.getCupons().add(cupom);

        
        cupomRepository.save(cupom);
        alunoRepository.save(aluno);


        return cupom;
    }
}
