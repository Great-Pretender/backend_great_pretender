package com.greatpretender.api.projetoapijaia.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;
import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;
import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.repository.AtribuicaoOrdemDeServicoRepository;

@Service
public class AtribuicaoOrdemDeServicoService implements IAtribuicaoOrdemDeServico  {
    @Autowired
    private AtribuicaoOrdemDeServicoRepository atribuicaoRepo;

    @PreAuthorize("hasAnyRole('ADMIN')")
    public AtribuicaoOrdemServico buscarPorId(Long id){
        Optional<AtribuicaoOrdemServico> atribuicaoOrdemDeServicoOp = atribuicaoRepo.findById(id);
        if(atribuicaoOrdemDeServicoOp.isPresent()){
            return atribuicaoOrdemDeServicoOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public AtribuicaoOrdemServico novaAtribuicaoOrdemDeServico(AtribuicaoOrdemServico atribuicaoOrdemServico) {
        if(atribuicaoOrdemServico.getUsuario() == null ||
            atribuicaoOrdemServico.getServico() == null
           ){ 
            throw new IllegalArgumentException("Dados inválidos!");
           }
           return atribuicaoRepo.save(atribuicaoOrdemServico);
    }

    // Listar Todas as Atribuicoes  
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<AtribuicaoOrdemServico> buscarTodasAtribuicoesOrdensDeServico(){
        return(List<AtribuicaoOrdemServico>) atribuicaoRepo.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public AtribuicaoOrdemServico deletarPorId(Long id){
        Optional<AtribuicaoOrdemServico> atribuicaoOrdemDeServicoOp = atribuicaoRepo.findById(id);
        if(atribuicaoOrdemDeServicoOp.isPresent()){
            
            atribuicaoRepo.deleteById(id);
            return atribuicaoOrdemDeServicoOp.get();


        }
        throw new IllegalArgumentException("ID inválido!");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<AtribuicaoOrdemServico> buscarPorIdOrdem(OrdemDeServico idOrdem){
        
        try{
        List<AtribuicaoOrdemServico> servicos = atribuicaoRepo.findAtribuicaoOrdemServicoByOrdemId(idOrdem.getId());
       
            return servicos;
        } catch (Exception e) {
        
        throw new IllegalArgumentException("Id inválido! "+ e);
            }
    }
}
