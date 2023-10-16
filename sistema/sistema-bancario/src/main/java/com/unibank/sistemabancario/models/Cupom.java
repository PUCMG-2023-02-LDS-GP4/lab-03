package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Cupom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigo;

    @ManyToOne
    private Vantagem vantagem;
    
    @ManyToOne
    private Aluno aluno;
}