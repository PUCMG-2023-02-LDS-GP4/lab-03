package com.unibank.sistemabancario.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResgateDeVantagemDTO {
    private String cupom;
    private Long empresaId;
}
