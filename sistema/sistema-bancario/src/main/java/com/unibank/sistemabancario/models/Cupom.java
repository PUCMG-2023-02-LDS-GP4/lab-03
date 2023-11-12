package com.unibank.sistemabancario.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private Aluno aluno;

}