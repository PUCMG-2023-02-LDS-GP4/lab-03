package com.unibank.sistemabancario.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Extrato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany
    private List<Transacao> listaDeTransacoes;


    public Extrato() {
    }

    public Extrato(Long id, List<Transacao> listaDeTransacoes) {
        this.id = id;
        this.listaDeTransacoes = listaDeTransacoes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Transacao> getListaDeTransacoes() {
        return this.listaDeTransacoes;
    }

    public void setListaDeTransacoes(List<Transacao> listaDeTransacoes) {
        this.listaDeTransacoes = listaDeTransacoes;
    }

    public Extrato id(Long id) {
        setId(id);
        return this;
    }

    public Extrato listaDeTransacoes(List<Transacao> listaDeTransacoes) {
        setListaDeTransacoes(listaDeTransacoes);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Extrato)) {
            return false;
        }
        Extrato extrato = (Extrato) o;
        return Objects.equals(id, extrato.id) && Objects.equals(listaDeTransacoes, extrato.listaDeTransacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, listaDeTransacoes);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", listaDeTransacoes='" + getListaDeTransacoes() + "'" +
            "}";
    }
    
}