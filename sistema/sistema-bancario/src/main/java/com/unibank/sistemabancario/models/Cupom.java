package com.unibank.sistemabancario.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cupom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String codigo;

    public Cupom() {
    }

    public Cupom(Long id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cupom id(Long id) {
        setId(id);
        return this;
    }

    public Cupom codigo(String codigo) {
        setCodigo(codigo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cupom)) {
            return false;
        }
        Cupom cupom = (Cupom) o;
        return Objects.equals(id, cupom.id) && Objects.equals(codigo, cupom.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", codigo='" + getCodigo() + "'" +
            "}";
    }
    
}