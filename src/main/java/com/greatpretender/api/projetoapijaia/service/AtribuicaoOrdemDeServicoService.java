package com.greatpretender.api.projetoapijaia.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;
import com.greatpretender.api.projetoapijaia.repository.AtribuicaoOrdemDeServicoRepository;

@Service
public class AtribuicaoOrdemDeServicoService implements IAtribuicaoOrdemDeServico  {
    @Autowired
    private AtribuicaoOrdemDeServicoRepository atribuicaoRepo;

    public AtribuicaoOrdemServico buscarPorId(Long id){
        Optional<AtribuicaoOrdemServico> atribuicaoOrdemDeServicoOp = atribuicaoRepo.findById(id);
        if(atribuicaoOrdemDeServicoOp.isPresent()){
            return atribuicaoOrdemDeServicoOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }

    public AtribuicaoOrdemServico novaAtribuicaoOrdemDeServico(AtribuicaoOrdemServico atribuicaoOrdemServico) {
        if(atribuicaoOrdemServico == null ||
            atribuicaoOrdemServico.getStatus_andamento() == null
           ){
            throw new IllegalArgumentException("Dados inválidos!");
           }
           return atribuicaoRepo.save(atribuicaoOrdemServico);
    }

    // Listar Todas as Atribuicoes
    public List<AtribuicaoOrdemServico> buscarTodasAtribuicoesOrdensDeServico(){
        return(List<AtribuicaoOrdemServico>) atribuicaoRepo.findAll();
    }
}
