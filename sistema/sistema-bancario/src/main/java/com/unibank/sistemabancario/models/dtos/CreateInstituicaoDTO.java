package com.unibank.sistemabancario.models.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CreateInstituicaoDTO {

    private String nome;

    private List<CreateProfessorDTO> listaDeProfessores;
}
