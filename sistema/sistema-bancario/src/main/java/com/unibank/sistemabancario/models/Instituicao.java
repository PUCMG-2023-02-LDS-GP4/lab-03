package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "instituicao")
    private List<Professor> listaDeProfessores;

}