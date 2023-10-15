package com.unibank.sistemabancario.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Empresa;
import com.unibank.sistemabancario.models.Vantagem;
import com.unibank.sistemabancario.models.dtos.CreateVantagemDTO;
import com.unibank.sistemabancario.repositories.EmpresaRepository;
import com.unibank.sistemabancario.repositories.VantagemRepository;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private VantagemRepository vantagemRepository;

    public Vantagem createVantagem(Long empresaId, CreateVantagemDTO createVantagemDTO) {
        Empresa empresa = empresaRepository.findById(empresaId)
        .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada"));

        Vantagem vantagem = new Vantagem();
        vantagem.setDescricao(createVantagemDTO.getDescricao());
        vantagem.setCustoEmMoedas(createVantagemDTO.getCustoEmMoedas());
        vantagem.setFoto(createVantagemDTO.getFoto());
        vantagem.setEmpresa(empresa);

        return vantagemRepository.save(vantagem);
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }  

    public Optional<Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteById(Long id) {
        empresaRepository.deleteById(id);
    }

}
