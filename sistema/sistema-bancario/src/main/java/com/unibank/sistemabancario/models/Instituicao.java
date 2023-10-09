package com.unibank.sistemabancario.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "instituicao")
    private List<Professor> listaDeProfessores;


    public Instituicao() {
    }

    public Instituicao(Long id, String nome, List<Professor> listaDeProfessores) {
        this.id = id;
        this.nome = nome;
        this.listaDeProfessores = listaDeProfessores;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Professor> getListaDeProfessores() {
        return this.listaDeProfessores;
    }

    public void setListaDeProfessores(List<Professor> listaDeProfessores) {
        this.listaDeProfessores = listaDeProfessores;
    }

    public Instituicao id(Long id) {
        setId(id);
        return this;
    }

    public Instituicao nome(String nome) {
        setNome(nome);
        return this;
    }

    public Instituicao listaDeProfessores(List<Professor> listaDeProfessores) {
        setListaDeProfessores(listaDeProfessores);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Instituicao)) {
            return false;
        }
        Instituicao instituicao = (Instituicao) o;
        return Objects.equals(id, instituicao.id) && Objects.equals(nome, instituicao.nome) && Objects.equals(listaDeProfessores, instituicao.listaDeProfessores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, listaDeProfessores);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", listaDeProfessores='" + getListaDeProfessores() + "'" +
            "}";
    }
    
}