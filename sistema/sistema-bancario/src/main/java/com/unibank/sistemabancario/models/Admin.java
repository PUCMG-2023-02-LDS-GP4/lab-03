package com.unibank.sistemabancario.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    @OneToMany(mappedBy = "admin")
    private List<Empresa> empresas = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<Aluno> alunos = new ArrayList<>();
    
    @OneToMany(mappedBy = "admin")
    private List<Professor> professores = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<Instituicao> instituicoes = new ArrayList<>();
}
