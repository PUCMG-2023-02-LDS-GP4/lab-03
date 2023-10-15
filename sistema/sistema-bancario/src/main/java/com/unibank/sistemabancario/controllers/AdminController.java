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
}
