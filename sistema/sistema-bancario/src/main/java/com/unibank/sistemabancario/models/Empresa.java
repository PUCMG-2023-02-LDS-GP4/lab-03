package com.unibank.sistemabancario.models;

import java.util.List;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Empresa extends User {
    
    @OneToMany
    private List<Vantagem> listaDeVantagens;


    public Empresa() {
    }

    public Empresa(List<Vantagem> listaDeVantagens) {
        this.listaDeVantagens = listaDeVantagens;
    }

    public List<Vantagem> getListaDeVantagens() {
        return this.listaDeVantagens;
    }

    public void setListaDeVantagens(List<Vantagem> listaDeVantagens) {
        this.listaDeVantagens = listaDeVantagens;
    }

    public Empresa id(Long id) {
        setId(id);
        return this;
    }

    public Empresa nome(String nome) {
        setNome(nome);
        return this;
    }

    public Empresa listaDeVantagens(List<Vantagem> listaDeVantagens) {
        setListaDeVantagens(listaDeVantagens);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empresa)) {
            return false;
        }
        Empresa empresa = (Empresa) o;
        return Objects.equals(listaDeVantagens, empresa.listaDeVantagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaDeVantagens);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", listaDeVantagens='" + getListaDeVantagens() + "'" +
            "}";
    }

    
}