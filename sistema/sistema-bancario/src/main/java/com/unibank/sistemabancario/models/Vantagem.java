package com.unibank.sistemabancario.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Vantagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descricao;
    
    private Integer custoEmMoedas;
    
    private String foto;  // Simplificando para um caminho de arquivo ou URL


    public Vantagem() {
    }

    public Vantagem(Long id, String descricao, Integer custoEmMoedas, String foto) {
        this.id = id;
        this.descricao = descricao;
        this.custoEmMoedas = custoEmMoedas;
        this.foto = foto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCustoEmMoedas() {
        return this.custoEmMoedas;
    }

    public void setCustoEmMoedas(Integer custoEmMoedas) {
        this.custoEmMoedas = custoEmMoedas;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Vantagem id(Long id) {
        setId(id);
        return this;
    }

    public Vantagem descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    public Vantagem custoEmMoedas(Integer custoEmMoedas) {
        setCustoEmMoedas(custoEmMoedas);
        return this;
    }

    public Vantagem foto(String foto) {
        setFoto(foto);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Vantagem)) {
            return false;
        }
        Vantagem vantagem = (Vantagem) o;
        return Objects.equals(id, vantagem.id) && Objects.equals(descricao, vantagem.descricao) && Objects.equals(custoEmMoedas, vantagem.custoEmMoedas) && Objects.equals(foto, vantagem.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, custoEmMoedas, foto);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", custoEmMoedas='" + getCustoEmMoedas() + "'" +
            ", foto='" + getFoto() + "'" +
            "}";
    }
    
}