package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Vantagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;
    
    private int custoEmMoedas;

    private int quantidade;
    
    @Lob
    private byte[] foto;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}