package com.unibank.sistemabancario.controllers;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.models.dtos.CreateAdminDTO;
import com.unibank.sistemabancario.models.dtos.CreateEmpresaDTO;
import com.unibank.sistemabancario.models.dtos.CreateProfessorDTO;
import com.unibank.sistemabancario.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

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

    @PutMapping("/update/{id}")
    public Admin update(@PathVariable Long id, @RequestBody CreateAdminDTO createAdminDTO) {
        return adminService.updateAdmin(id, createAdminDTO);
    }

    @PutMapping("/updateProfessor/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody CreateProfessorDTO createProfessorDTO) {
        return adminService.updateProfessor(id, createProfessorDTO);
    }

    @PutMapping("/updateEmpresa/{id}")
    public Empresa updateEmpresa(@PathVariable Long id, @RequestBody CreateEmpresaDTO createEmpresaDTO) {
        return adminService.updateEmpresa(id, createEmpresaDTO);
    }

    @GetMapping("/find/{id}")
    public Admin findAdmin(@PathVariable Long id) {
        return adminService.findAdmin(id);
    }

    @GetMapping("/findProfessor/{id}")
    public Professor findProfessor(@PathVariable Long id) {
        return adminService.findProfessor(id);
    }

    @GetMapping("/findEmpresa/{id}")
    public Empresa findEmpresa(@PathVariable Long id) {
        return adminService.findEmpresa(id);
    }

}
