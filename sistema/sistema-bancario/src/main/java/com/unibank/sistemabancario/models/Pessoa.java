package com.unibank.sistemabancario.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unibank.sistemabancario.models.enums.Instituicao;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper=false, exclude = {"extrato", "instituicao"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa extends User{
    
    private String cpf;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "extrato_id", referencedColumnName = "id")
    @JsonManagedReference
    private Extrato extrato;

    @Enumerated(EnumType.STRING)
    private Instituicao instituicao;

    @PostPersist
    public void criarExtrato(){
        this.extrato = new Extrato();
        this.extrato.setPessoa(this);
    }
}