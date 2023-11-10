package com.unibank.sistemabancario.services;

import com.unibank.sistemabancario.models.*;
import com.unibank.sistemabancario.models.dtos.CreateAdminDTO;
import com.unibank.sistemabancario.models.dtos.CreateAlunoDTO;
import com.unibank.sistemabancario.models.dtos.CreateEmpresaDTO;
import com.unibank.sistemabancario.models.dtos.CreateProfessorDTO;
import com.unibank.sistemabancario.models.dtos.UpdateProfessorDTO;
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

    @Autowired
    private ExtratoRepository extratoRepository;

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

        Admin admin = adminRepository.findById(createAlunoDTO.getAdminId())
        .orElseThrow(() -> new RuntimeException("Admin not found"));

        aluno.setAdmin(admin);
        aluno.setTipoUser(createAlunoDTO.getTipoUser());

        aluno = alunoRepository.save(aluno);

        Extrato extrato = new Extrato();
        extrato.setPessoa(aluno);
        aluno.setExtrato(extrato);

        extratoRepository.save(extrato);

        return alunoRepository.save(aluno);
    }

    public Professor createProfessor(CreateProfessorDTO createProfessorDTO) {
        Professor professor = new Professor();
        professor.setNome(createProfessorDTO.getNome());
        professor.setEmail(createProfessorDTO.getEmail());
        professor.setPassword(createProfessorDTO.getPassword());
        professor.setCpf(createProfessorDTO.getCpf());
        professor.setDepartamento(createProfessorDTO.getDepartamento());

        Long adminId = createProfessorDTO.getAdminId();
        if (adminId == null) {
            throw new IllegalArgumentException("Admin ID must not be null");
        }

        Admin admin = adminRepository.findById(createProfessorDTO.getAdminId())
        .orElseThrow(() -> new RuntimeException("Admin not found"));

        professor.setAdmin(admin);
        professor.setTipoUser(createProfessorDTO.getTipoUser());

        professor = professorRepository.save(professor);

        Extrato extrato = new Extrato();
        extrato.setPessoa(professor);
        professor.setExtrato(extrato);

        extratoRepository.save(extrato);

        return professorRepository.save(professor);
    }

    public Empresa createEmpresa(CreateEmpresaDTO createEmpresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setNome(createEmpresaDTO.getNome());
        empresa.setEmail(createEmpresaDTO.getEmail());
        empresa.setPassword(createEmpresaDTO.getPassword());

        Admin admin = adminRepository.findById(createEmpresaDTO.getAdminId())
        .orElseThrow(() -> new RuntimeException("Admin not found"));

        empresa.setAdmin(admin);

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

    public Admin updateAdmin(Long id, CreateAdminDTO createAdminDTO) {
        Admin existingAdmin = adminRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Admin not found")
        );
        existingAdmin.setNome(createAdminDTO.getNome());
        existingAdmin.setEmail(createAdminDTO.getEmail());
        existingAdmin.setPassword(createAdminDTO.getPassword());
        return adminRepository.save(existingAdmin);
    }

    public Professor updateProfessor(Long id, UpdateProfessorDTO updateProfessorDTO) {
        Professor existingProfessor = professorRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Professor not found")
        );
        existingProfessor.setNome(updateProfessorDTO.getNome());
        existingProfessor.setEmail(updateProfessorDTO.getEmail());
        existingProfessor.setPassword(updateProfessorDTO.getPassword());
        existingProfessor.setCpf(updateProfessorDTO.getCpf());
        existingProfessor.setDepartamento(updateProfessorDTO.getDepartamento());
        existingProfessor.setSaldoDeMoedas(updateProfessorDTO.getSaldoDeMoedas());

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
