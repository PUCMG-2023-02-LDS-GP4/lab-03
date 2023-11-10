package com.unibank.sistemabancario.models.dtos;

import com.unibank.sistemabancario.models.enums.TipoUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {
    private String nome;
    private TipoUser tipoUser;
}
