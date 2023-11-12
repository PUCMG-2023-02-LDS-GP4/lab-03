package com.unibank.sistemabancario.models.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateEmpresaDTO {

    @NotNull(message = "Nome não pode ser nulo")
    @NotBlank(message = "Nome não pode estar em branco")
    private String nome;

    @NotNull(message = "Email não pode ser nulo")
    @NotBlank(message = "Email não pode estar em branco")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotNull(message = "Senha não pode ser nula")
    @NotBlank(message = "Senha não pode estar em branco")
    @Size(min = 8, max = 60, message = "Senha deve ter entre 8 e 60 caracteres")
    private String password;

}
