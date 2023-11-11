package com.unibank.sistemabancario.models.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.unibank.sistemabancario.models.enums.TipoUser;

import lombok.Data;

@Data
public class CreateProfessorDTO {

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

    @NotNull(message = "CPF não pode ser nulo")
    @NotBlank(message = "CPF não pode estar em branco")
    private String cpf;

    @NotNull(message = "Departamento não pode ser nulo")
    @NotBlank(message = "Departamento não pode estar em branco")
    private String departamento;

    @NotNull(message = "ID da Instituição não pode ser nulo")
    private Long instituicaoId;


    @Enumerated(EnumType.STRING)
    private TipoUser tipoUser;

}
