package com.unibank.sistemabancario.models.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateAlunoDTO {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 60)
    private String password;

    @NotNull
    @NotEmpty
    private String cpf;

    private String rg;
    
    private String endereco;

    @NotNull
    private Long instituicaoId;
    
    private String curso;
    
    private int saldoDeMoedas;

}
