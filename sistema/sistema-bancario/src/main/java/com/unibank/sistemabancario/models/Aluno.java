package com.unibank.sistemabancario.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno extends Pessoa {
    
    private String rg;
    
    private String endereco;

    @ManyToOne
    private Instituicao instituicao;
    
    private String curso;
    
    private int saldoDeMoedas;


    public Aluno() {
    }

    public Aluno(String rg, String endereco, Instituicao instituicao, String curso, int saldoDeMoedas) {
        this.rg = rg;
        this.endereco = endereco;
        this.instituicao = instituicao;
        this.curso = curso;
        this.saldoDeMoedas = saldoDeMoedas;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Instituicao getInstituicao() {
        return this.instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSaldoDeMoedas() {
        return this.saldoDeMoedas;
    }

    public void setSaldoDeMoedas(int saldoDeMoedas) {
        this.saldoDeMoedas = saldoDeMoedas;
    }

    public Aluno rg(String rg) {
        setRg(rg);
        return this;
    }

    public Aluno endereco(String endereco) {
        setEndereco(endereco);
        return this;
    }

    public Aluno instituicao(Instituicao instituicao) {
        setInstituicao(instituicao);
        return this;
    }

    public Aluno curso(String curso) {
        setCurso(curso);
        return this;
    }

    public Aluno saldoDeMoedas(int saldoDeMoedas) {
        setSaldoDeMoedas(saldoDeMoedas);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        return Objects.equals(rg, aluno.rg) && Objects.equals(endereco, aluno.endereco) && Objects.equals(instituicao, aluno.instituicao) && Objects.equals(curso, aluno.curso) && Objects.equals(saldoDeMoedas, aluno.saldoDeMoedas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rg, endereco, instituicao, curso, saldoDeMoedas);
    }

    @Override
    public String toString() {
        return "{" +
            " rg='" + getRg() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", instituicao='" + getInstituicao() + "'" +
            ", curso='" + getCurso() + "'" +
            ", saldoDeMoedas='" + getSaldoDeMoedas() + "'" +
            "}";
    }
    
}