package com.greatpretender.api.projetoapijaia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.HistoricoAlteracoes;
import com.greatpretender.api.projetoapijaia.repository.HistoricoAlteracoesRepository;


@Service
public class HistoricoAlteracoesService implements IHistoricoAlteracoesService {
    @Autowired
    private HistoricoAlteracoesRepository histRepo;

    //@PreAuthorize("hasAnyRole('ADMIN')")
    public HistoricoAlteracoes buscarPorId(Long id){
        Optional<HistoricoAlteracoes> histDeServicoOp = histRepo.findById(id);
        if(histDeServicoOp.isPresent()){
            return histDeServicoOp.get();
        }
    throw new IllegalArgumentException("ID inválido");
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    public HistoricoAlteracoes novoHistorico(HistoricoAlteracoes hist){
        if(hist == null
        )
        {
        throw new IllegalArgumentException("Dados Inválidos!");
        }
        return histRepo.save(hist);
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    public List<HistoricoAlteracoes> buscarTodosHistoricos(){
        return(List<HistoricoAlteracoes>) histRepo.findAll();
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    public HistoricoAlteracoes deletarPorId(Long id){
        Optional<HistoricoAlteracoes> histDeServicoOp = histRepo.findById(id);
        if(histDeServicoOp.isPresent()){
            
            histRepo.deleteById(id);
            return histDeServicoOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }

}
