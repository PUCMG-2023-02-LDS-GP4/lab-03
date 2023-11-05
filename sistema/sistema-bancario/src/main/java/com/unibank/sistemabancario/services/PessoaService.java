package com.unibank.sistemabancario.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Extrato;
import com.unibank.sistemabancario.models.Pessoa;
import com.unibank.sistemabancario.models.Transacao;
import com.unibank.sistemabancario.repositories.PessoaRepository;
import com.unibank.sistemabancario.repositories.TransacaoRepository;


@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ExtratoService extratoService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa save(Pessoa pessoa) {
        Extrato novoExtrato = new Extrato();
        novoExtrato = extratoService.saveExtrato(novoExtrato);
        
        pessoa.setExtrato(novoExtrato);
        
        return pessoaRepository.save(pessoa);
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

}
