package com.unibank.sistemabancario.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@CrossOrigin
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("ALUNO")
@Table(name = "users")
public class Aluno extends Pessoa {
    
    private String rg;
    
    private String endereco;

    private String curso;
    
    private int saldoDeMoedas;

    @OneToMany(mappedBy = "aluno")
    @JsonManagedReference
    @JsonIgnore
    private List<Cupom> cupons = new ArrayList<>();
}