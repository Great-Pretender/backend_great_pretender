package com.greatpretender.api.projetoapijaia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;
import com.greatpretender.api.projetoapijaia.entity.Servico;
import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.repository.OrdemDeServicoRepository;

import com.greatpretender.api.projetoapijaia.entity.Cliente; 

@Service
public class OrdemdeServicoService implements IOrdemDeServicoService {
    @Autowired
    private OrdemDeServicoRepository ordemRepo;

    @PreAuthorize("hasAnyRole('ADMIN')")
    public OrdemDeServico buscarPorId(Long id){
        Optional<OrdemDeServico> ordemDeServicoOp = ordemRepo.findById(id);
        if(ordemDeServicoOp.isPresent()){
            return ordemDeServicoOp.get();
        }
    throw new IllegalArgumentException("ID inválido");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public OrdemDeServico novaOrdemDeServico(OrdemDeServico ordem){
        if(ordem == null ||
            ordem.getDescricao() == null ||
            ordem.getStatusOrdem() == null ||
            ordem.getStatus_aprovacao() == null ||
            //ordem.getUsuario() == null ||
            ordem.getSetor() == null ||
            ordem.getCliente() == null ||
            ordem.getData_inicio() == null ||
            ordem.getData_fim() == null
        )
        {
        throw new IllegalArgumentException("Dados Inválidos!" +ordem.getData_inicio() + ordem.getData_fim());
        }
        return ordemRepo.save(ordem);
    }

    // Listar Todas Ordens de Serviço
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<OrdemDeServico> buscarTodasOrdensDeServico(){
        return(List<OrdemDeServico>) ordemRepo.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public OrdemDeServico deletarPorId(Long id){
        Optional<OrdemDeServico> ordemDeServicoOp = ordemRepo.findById(id);
        if(ordemDeServicoOp.isPresent()){
            
            ordemRepo.deleteById(id);
            return ordemDeServicoOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }

    public List<OrdemDeServico> buscarPorIdSetor(Setor idSetor) {
        try{
        List<OrdemDeServico> ordens = ordemRepo.findOrdemDeServicoBySetorId(idSetor.getId());

    public List<OrdemDeServico> buscarPorIdCliente( Cliente idCliente){
        try{
            
        List<OrdemDeServico> ordens = ordemRepo.findOrdemDeServicoByClienteIdAndStatusOrdem(idCliente.getId(), "Concluido");        
            return ordens;
        } catch (Exception e) {
        
        throw new IllegalArgumentException("Id inválido! "+ e);
            }
    }
}
