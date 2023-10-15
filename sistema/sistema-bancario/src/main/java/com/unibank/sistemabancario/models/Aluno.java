package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("ALUNO")
public class Aluno extends Pessoa {
    
    private String rg;
    
    private String endereco;

    @ManyToOne
    private Instituicao instituicao;
    
    private String curso;
    
    private int saldoDeMoedas;

    @ManyToOne
    private Admin admin;
}