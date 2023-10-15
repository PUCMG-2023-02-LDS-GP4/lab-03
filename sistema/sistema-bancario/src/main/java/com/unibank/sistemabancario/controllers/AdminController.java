package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.models.dtos.CreateAdminDTO;
import com.unibank.sistemabancario.models.dtos.CreateEmpresaDTO;
import com.unibank.sistemabancario.models.dtos.CreateProfessorDTO;
import com.unibank.sistemabancario.repositories.AdminRepository;
import com.unibank.sistemabancario.repositories.EmpresaRepository;
import com.unibank.sistemabancario.repositories.ProfessorRepository;
import com.unibank.sistemabancario.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private EmpresaRepository empresaRepository;


    @PostMapping("/create")
    public Admin create(@RequestBody CreateAdminDTO createAdminDTO) {
        return adminService.create(createAdminDTO);
    }

    @PostMapping("/createProfessor")
    public Professor createProfessor(@RequestBody CreateProfessorDTO createProfessorDTO) {
        return adminService.createProfessor(createProfessorDTO);
    }

    @PostMapping("/createEmpresa")
    public Empresa createEmpresa(@RequestBody CreateEmpresaDTO createEmpresaDTO) {
        return adminService.createEmpresa(createEmpresaDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    @DeleteMapping("/deleteProfessor/{id}")
    public void deleteProfessor(@PathVariable Long id) {
        adminService.deleteProfessor(id);
    }

    @DeleteMapping("/deleteEmpresa/{id}")
    public void deleteEmpresa(@PathVariable Long id) {
        adminService.deleteEmpresa(id);
    }

    public Admin updateAdmin(Long id, CreateAdminDTO createAdminDTO) {
        Admin existingAdmin = adminRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Admin not found")
        );
        existingAdmin.setNome(createAdminDTO.getNome());
        existingAdmin.setEmail(createAdminDTO.getEmail());
        existingAdmin.setPassword(createAdminDTO.getPassword());
        return adminRepository.save(existingAdmin);
    }

    public Professor updateProfessor(Long id, CreateProfessorDTO createProfessorDTO) {
        Professor existingProfessor = professorRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Professor not found")
        );
        existingProfessor.setNome(createProfessorDTO.getNome());
        existingProfessor.setEmail(createProfessorDTO.getEmail());
        existingProfessor.setPassword(createProfessorDTO.getPassword());
        existingProfessor.setCpf(createProfessorDTO.getCpf());
        existingProfessor.setDepartamento(createProfessorDTO.getDepartamento());
        existingProfessor.setSaldoDeMoedas(createProfessorDTO.getSaldoDeMoedas());

        return professorRepository.save(existingProfessor);
    }

    public Empresa updateEmpresa(Long id, CreateEmpresaDTO createEmpresaDTO) {
        Empresa existingEmpresa = empresaRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Empresa not found")
        );
        existingEmpresa.setNome(createEmpresaDTO.getNome());
        existingEmpresa.setEmail(createEmpresaDTO.getEmail());
        existingEmpresa.setPassword(createEmpresaDTO.getPassword());
        
        return empresaRepository.save(existingEmpresa);
    }

    public Admin findAdmin(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Professor findProfessor(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Empresa findEmpresa(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }
}
