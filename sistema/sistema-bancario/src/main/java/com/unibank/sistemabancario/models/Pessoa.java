package com.unibank.sistemabancario.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "instituicao_id")
    @JsonIgnore
    private Instituicao instituicao;

    @PostPersist
    public void criarExtrato(){
        this.extrato = new Extrato();
        this.extrato.setPessoa(this);
    }
}