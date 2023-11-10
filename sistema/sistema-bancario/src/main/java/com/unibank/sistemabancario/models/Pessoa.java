package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa extends User{
    
    private String cpf;
    
    @OneToOne
    private Extrato extrato = new Extrato();
}