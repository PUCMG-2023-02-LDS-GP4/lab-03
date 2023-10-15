package com.unibank.sistemabancario.models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String data;
    
    private Integer quantidade;

    private String mensagem;

}