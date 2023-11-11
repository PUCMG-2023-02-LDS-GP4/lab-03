package com.unibank.sistemabancario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Empresa;
import com.unibank.sistemabancario.models.Vantagem;
import com.unibank.sistemabancario.models.dtos.CreateVantagemDTO;
import com.unibank.sistemabancario.repositories.EmpresaRepository;
import com.unibank.sistemabancario.repositories.VantagemRepository;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository vantagemRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Vantagem> findAll() {
        return vantagemRepository.findAll();
    }

    public Vantagem createVantagem(CreateVantagemDTO createVantagemDTO) {
        Vantagem vantagem = new Vantagem();
        vantagem.setDescricao(createVantagemDTO.getDescricao());
        vantagem.setCustoEmMoedas(createVantagemDTO.getCustoEmMoedas());
        vantagem.setFoto(createVantagemDTO.getFoto());

        Empresa empresa = empresaRepository.findById(createVantagemDTO.getEmpresaId())
        .orElseThrow(() -> new RuntimeException("Empresa not found"));

        vantagem.setEmpresa(empresa);
        return vantagemRepository.save(vantagem);
    }
}
