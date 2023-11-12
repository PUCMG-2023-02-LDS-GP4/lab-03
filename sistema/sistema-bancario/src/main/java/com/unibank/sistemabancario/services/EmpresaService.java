package com.unibank.sistemabancario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Empresa;
import com.unibank.sistemabancario.models.dtos.CreateEmpresaDTO;
import com.unibank.sistemabancario.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }  

    public Optional<Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    public Empresa createEmpresa(CreateEmpresaDTO createEmpresaDTO) {

        Empresa empresa = new Empresa();
        empresa.setNome(createEmpresaDTO.getNome());
        empresa.setEmail(createEmpresaDTO.getEmail());
        empresa.setPassword(createEmpresaDTO.getPassword());

        return empresaRepository.save(empresa);
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteById(Long id) {
        empresaRepository.deleteById(id);
    }

}
