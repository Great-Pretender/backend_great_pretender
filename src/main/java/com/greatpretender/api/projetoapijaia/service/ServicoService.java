package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.greatpretender.api.projetoapijaia.entity.Servico;
import com.greatpretender.api.projetoapijaia.repository.ServicoRepository;

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

    public Servico novoServico(Servico servico) {
        if(servico == null  ||
                servico.getNome() == null  ||
                servico.getDescricao() == null ||
                servico.getRisco() == null ||
                servico.getDuracao_dias() == null ) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        return servicoRepo.save(servico);
    }

    public List<Servico> buscarTodos() {
        return servicoRepo.findAll();
    }
}
