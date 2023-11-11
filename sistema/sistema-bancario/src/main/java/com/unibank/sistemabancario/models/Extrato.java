package com.unibank.sistemabancario.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Extrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pessoa_id")
    @JsonBackReference
    private Pessoa pessoa;

    @OneToMany(mappedBy = "extrato")
    private List<Transacao> listaDeTransacoes = new ArrayList<>();

}