package com.unibank.sistemabancario.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateVantagemDTO {

    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull(message = "Nome não pode ser nulo")
    private String descricao;

    @NotNull(message = "Custo em moedas não pode ser nulo")
    private int custoEmMoedas;

    private int quantidade;

    private Long empresaId;
}