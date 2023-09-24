package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Servico;
import com.greatpretender.api.projetoapijaia.repository.ServicoRepository;

import jakarta.transaction.Transactional;

@Service
public class ServicoService implements IServicoService {

    @Autowired
    private ServicoRepository servicoRepo;

    public Servico buscarPorId(Long id) {
        Optional<Servico> servicoOp = servicoRepo.findById(id);
        if (servicoOp.isPresent()) {
            return servicoOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }
    @Transactional
    public Servico novoServico(Servico servico) {
        if(servico == null  ||
                servico.getNome() == null  ||
                servico.getDescricao() == null ||
                servico.getRisco() == null ||
                servico.getCusto() == null ||
                servico.getDuracao_dias() == null 
                ) {
            
            throw new IllegalArgumentException("Verificar Dados!");
        }
        
        return servicoRepo.save(servico);
    }

    public List<Servico> buscarTodosServicos() {
        return servicoRepo.findAll();
    }

    public Servico deletarPorId(Long id){
        Optional<Servico> servicoOp = servicoRepo.findById(id);
        if(servicoOp.isPresent()){
            
            servicoRepo.deleteById(id);
            return servicoOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }
}
