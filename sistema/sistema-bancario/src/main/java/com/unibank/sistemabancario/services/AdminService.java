package com.unibank.sistemabancario.services;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.models.dtos.CreateAdminDTO;
import com.unibank.sistemabancario.models.dtos.CreateAlunoDTO;
import com.unibank.sistemabancario.models.dtos.CreateEmpresaDTO;
import com.unibank.sistemabancario.models.dtos.CreateProfessorDTO;
import com.unibank.sistemabancario.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public Admin create(CreateAdminDTO createAdminDTO) {
        Admin admin = new Admin();
        admin.setNome(createAdminDTO.getNome());
        admin.setEmail(createAdminDTO.getEmail());
        admin.setPassword(createAdminDTO.getPassword());
        return adminRepository.save(admin);
    }

    public Aluno createAluno(CreateAlunoDTO createAlunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(createAlunoDTO.getNome());
        aluno.setEmail(createAlunoDTO.getEmail());
        aluno.setPassword(createAlunoDTO.getPassword());
        aluno.setCpf(createAlunoDTO.getCpf());
        aluno.setRg(createAlunoDTO.getRg());
        aluno.setEndereco(createAlunoDTO.getEndereco());
        aluno.setCurso(createAlunoDTO.getCurso());
        aluno.setSaldoDeMoedas(createAlunoDTO.getSaldoDeMoedas());
        return alunoRepository.save(aluno);
    }

    public Professor createProfessor(CreateProfessorDTO createProfessorDTO) {
        Professor professor = new Professor();
        professor.setNome(createProfessorDTO.getNome());
        professor.setEmail(createProfessorDTO.getEmail());
        professor.setPassword(createProfessorDTO.getPassword());
        professor.setCpf(createProfessorDTO.getCpf());
        professor.setDepartamento(createProfessorDTO.getDepartamento());
        professor.setSaldoDeMoedas(createProfessorDTO.getSaldoDeMoedas());
        return professorRepository.save(professor);
    }

    public Empresa createEmpresa(CreateEmpresaDTO createEmpresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setNome(createEmpresaDTO.getNome());
        empresa.setEmail(createEmpresaDTO.getEmail());
        empresa.setPassword(createEmpresaDTO.getPassword());
        return empresaRepository.save(empresa);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
