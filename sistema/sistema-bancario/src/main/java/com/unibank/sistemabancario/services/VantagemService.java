package com.unibank.sistemabancario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Vantagem;
import com.unibank.sistemabancario.models.dtos.CreateVantagemDTO;
import com.unibank.sistemabancario.repositories.VantagemRepository;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository vantagemRepository;

    public Vantagem createVantagem(CreateVantagemDTO createVantagemDTO) {
        Vantagem vantagem = new Vantagem();
        vantagem.setDescricao(createVantagemDTO.getDescricao());
        vantagem.setCustoEmMoedas(createVantagemDTO.getCustoEmMoedas());
        vantagem.setFoto(createVantagemDTO.getFoto());

        vantagem.setEmpresa(createVantagemDTO.getEmpresa());

        return vantagemRepository.save(vantagem);
    }
}
