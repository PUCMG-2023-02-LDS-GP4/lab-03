package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("PROFESSOR")
public class Professor extends Pessoa {
    
    private String departamento;
    
    private int saldoDeMoedas = 1000;

    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;

    @ManyToOne
    private Admin admin;

}
