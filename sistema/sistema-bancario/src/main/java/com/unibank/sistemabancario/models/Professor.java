package com.unibank.sistemabancario.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("PROFESSOR")
@Table(name = "users")
public class Professor extends Pessoa {
    
    private String departamento;
    
    private int saldoDeMoedas = 1000;

    @ManyToOne
    private Admin admin;
}
