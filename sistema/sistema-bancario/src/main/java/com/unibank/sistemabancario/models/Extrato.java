package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Extrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Pessoa pessoa;

    @OneToMany(mappedBy = "extrato")
    private List<Transacao> listaDeTransacoes;

}