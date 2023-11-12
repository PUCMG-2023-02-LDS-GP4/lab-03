package com.unibank.sistemabancario.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Extrato;
import com.unibank.sistemabancario.models.Pessoa;
import com.unibank.sistemabancario.models.Transacao;
import com.unibank.sistemabancario.repositories.PessoaRepository;
import com.unibank.sistemabancario.repositories.TransacaoRepository;


@Service
public class PessoaService {
    
    private final PessoaRepository pessoaRepository;
    private final ExtratoService extratoService;
    private final TransacaoRepository transacaoRepository;

    public PessoaService(PessoaRepository pessoaRepository, ExtratoService extratoService, TransacaoRepository transacaoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.extratoService = extratoService;
        this.transacaoRepository = transacaoRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Pessoa save(Pessoa pessoa) {
        
        return pessoaRepository.save(pessoa);
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Transactional
    public void registrarTransacao(Pessoa pessoa, int quantidade, String mensagem) {
        Transacao transacao = new Transacao();
        transacao.setQuantidade(quantidade);
        transacao.setMensagem(mensagem);
        transacao.setData(LocalDate.now());
        
        Extrato extrato = pessoa.getExtrato();
        transacao.setExtrato(extrato);
        
        transacaoRepository.save(transacao);

        extrato.getListaDeTransacoes().add(transacao);
        extratoService.saveExtrato(extrato);
    }


}
