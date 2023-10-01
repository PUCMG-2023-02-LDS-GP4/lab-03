package com.unibank.sistemabancario.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Professor extends Pessoa {
    
    private String departamento;
    
    private int saldoDeMoedas;


    public Professor() {
    }

    public Professor(String departamento, int saldoDeMoedas) {
        this.departamento = departamento;
        this.saldoDeMoedas = saldoDeMoedas;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getSaldoDeMoedas() {
        return this.saldoDeMoedas;
    }

    public void setSaldoDeMoedas(int saldoDeMoedas) {
        this.saldoDeMoedas = saldoDeMoedas;
    }

    public Professor departamento(String departamento) {
        setDepartamento(departamento);
        return this;
    }

    public Professor saldoDeMoedas(int saldoDeMoedas) {
        setSaldoDeMoedas(saldoDeMoedas);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Professor)) {
            return false;
        }
        Professor professor = (Professor) o;
        return Objects.equals(departamento, professor.departamento) && Objects.equals(saldoDeMoedas, professor.saldoDeMoedas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departamento, saldoDeMoedas);
    }

    @Override
    public String toString() {
        return "{" +
            " departamento='" + getDepartamento() + "'" +
            ", saldoDeMoedas='" + getSaldoDeMoedas() + "'" +
            "}";
    }
    
}
