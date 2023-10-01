package com.unibank.sistemabancario.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String data;
    
    private Integer quantidade;

    private String mensagem;


    public Transacao() {
    }

    public Transacao(Long id, String data, Integer quantidade, String mensagem) {
        this.id = id;
        this.data = data;
        this.quantidade = quantidade;
        this.mensagem = mensagem;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Transacao id(Long id) {
        setId(id);
        return this;
    }

    public Transacao data(String data) {
        setData(data);
        return this;
    }

    public Transacao quantidade(Integer quantidade) {
        setQuantidade(quantidade);
        return this;
    }

    public Transacao mensagem(String mensagem) {
        setMensagem(mensagem);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transacao)) {
            return false;
        }
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id) && Objects.equals(data, transacao.data) && Objects.equals(quantidade, transacao.quantidade) && Objects.equals(mensagem, transacao.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, quantidade, mensagem);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", data='" + getData() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            ", mensagem='" + getMensagem() + "'" +
            "}";
    }
    
}