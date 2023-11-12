package com.unibank.sistemabancario.models;

import java.util.Optional;

import javax.persistence.*;

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

}
