package com.unibank.sistemabancario.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.unibank.sistemabancario.models.Aluno;
import com.unibank.sistemabancario.models.Cupom;
import com.unibank.sistemabancario.models.Vantagem;
import com.unibank.sistemabancario.models.dtos.CreateAlunoDTO;
import com.unibank.sistemabancario.models.dtos.ResgateDeVantagemDTO;
import com.unibank.sistemabancario.repositories.AlunoRepository;
import com.unibank.sistemabancario.repositories.CupomRepository;
import com.unibank.sistemabancario.repositories.ExtratoRepository;
import com.unibank.sistemabancario.repositories.VantagemRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final VantagemRepository vantagemRepository;
    private final CupomRepository cupomRepository;
    private final PessoaService pessoaService;
    private final ExtratoRepository extratoRepository;

    public AlunoService(AlunoRepository alunoRepository, VantagemRepository vantagemRepository, CupomRepository cupomRepository, ExtratoRepository extratoRepository, PessoaService pessoaService){
        this.alunoRepository = alunoRepository;
        this.vantagemRepository = vantagemRepository;
        this.cupomRepository = cupomRepository;
        this.extratoRepository = extratoRepository;
        this.pessoaService = pessoaService;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno save(CreateAlunoDTO createAlunoDTO) {

            Aluno aluno = new Aluno();
            aluno.setNome(createAlunoDTO.getNome());
            aluno.setEmail(createAlunoDTO.getEmail());
            aluno.setPassword(createAlunoDTO.getPassword());
            aluno.setCpf(createAlunoDTO.getCpf());
            aluno.setRg(createAlunoDTO.getRg());
            aluno.setEndereco(createAlunoDTO.getEndereco());
            aluno.setCurso(createAlunoDTO.getCurso());
            aluno.setSaldoDeMoedas(createAlunoDTO.getSaldoDeMoedas());

            aluno.setInstituicao(createAlunoDTO.getInstituicao());
    
            aluno.setTipoUser(createAlunoDTO.getTipoUser());
    
            aluno = alunoRepository.save(aluno);
    
            return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno aluno) {
        Aluno optionalAluno = this.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        aluno.setId(optionalAluno.getId());
        return this.update(aluno);
    }
    
    public Aluno update(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
    
    public ResgateDeVantagemDTO resgatarVantagem(Long alunoId, Long vantagemId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Vantagem vantagem = vantagemRepository.findById(vantagemId).orElseThrow(() -> new RuntimeException("Vantagem não encontrada"));

        if (aluno.getSaldoDeMoedas() < vantagem.getCustoEmMoedas()) {
            throw new RuntimeException("Saldo insuficiente");
        }

        if (vantagem.getQuantidade() <= 0) {
            throw new RuntimeException("Vantagem esgotada");
        }

        aluno.setSaldoDeMoedas(aluno.getSaldoDeMoedas() - vantagem.getCustoEmMoedas());

        String mensagem = "Resgate de vantagem: " + vantagem.getDescricao();
        pessoaService.registrarTransacao(aluno, -vantagem.getCustoEmMoedas(), mensagem);


        vantagem.setQuantidade(vantagem.getQuantidade() - 1);
        vantagemRepository.save(vantagem);

        Cupom cupom = new Cupom();
        cupom.setCodigo(UUID.randomUUID().toString());
        cupom.setVantagem(vantagem);
        cupom.setAluno(aluno);

        aluno.getCupons().add(cupom);

        ResgateDeVantagemDTO resgateDeVantagemDTO = new ResgateDeVantagemDTO();
        resgateDeVantagemDTO.setCupom(cupom.getCodigo());
        resgateDeVantagemDTO.setEmpresaId(cupom.getVantagem().getEmpresa().getId());

        cupomRepository.save(cupom);
        alunoRepository.save(aluno);


        return resgateDeVantagemDTO;
    }

    @Transactional
    public void receberMoedas(Long alunoId, int quantidade, String mensagem) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.setSaldoDeMoedas(aluno.getSaldoDeMoedas() + quantidade);
        pessoaService.registrarTransacao(aluno, quantidade, mensagem);
        alunoRepository.save(aluno);
    }

    
}
