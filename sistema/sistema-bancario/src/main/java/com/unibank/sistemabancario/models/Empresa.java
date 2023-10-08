package com.unibank.sistemabancario.models;

import java.util.List;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Empresa extends Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToMany
    private List<Vantagem> listaDeVantagens;


    public Empresa() {
    }

    public Empresa(Long id, String nome, List<Vantagem> listaDeVantagens) {
        this.id = id;
        this.nome = nome;
        this.listaDeVantagens = listaDeVantagens;
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
        return Objects.equals(id, empresa.id) && Objects.equals(nome, empresa.nome) && Objects.equals(listaDeVantagens, empresa.listaDeVantagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, listaDeVantagens);
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