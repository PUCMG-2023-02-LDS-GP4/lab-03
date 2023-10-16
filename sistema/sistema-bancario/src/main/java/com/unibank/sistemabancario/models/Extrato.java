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
    
    @OneToMany
    private List<Transacao> listaDeTransacoes;

}