package com.unibank.sistemabancario.models;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate data;
    
    private Integer quantidade;

    private String mensagem;

    @ManyToOne
    @JsonIgnore
    private Extrato extrato;
}