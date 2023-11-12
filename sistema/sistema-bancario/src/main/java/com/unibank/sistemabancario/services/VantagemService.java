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

    private final VantagemRepository vantagemRepository;
    private final EmpresaRepository empresaRepository;

    public VantagemService(VantagemRepository vantagemRepository, EmpresaRepository empresaRepository) {
        this.vantagemRepository = vantagemRepository;
        this.empresaRepository = empresaRepository;
    }

    public List<Vantagem> findAll() {
        return vantagemRepository.findAll();
    }

    public Vantagem findById(Long id) {
        return vantagemRepository.findById(id).orElse(null);
    }

    public Vantagem save(Vantagem vantagem) {
        return vantagemRepository.save(vantagem);
    }

    public void delete(Long id) {
        vantagemRepository.deleteById(id);
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
