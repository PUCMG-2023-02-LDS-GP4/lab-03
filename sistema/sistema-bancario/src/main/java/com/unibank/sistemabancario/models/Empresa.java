package com.unibank.sistemabancario.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("EMPRESA")
@Table(name = "users")
public class Empresa extends User {
    
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Vantagem> listaDeVantagens = new ArrayList<>();


}