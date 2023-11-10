package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Contrato;
import com.greatpretender.api.projetoapijaia.repository.ContratoRepository;

@Service
public class ContratoService implements IContratoService{
    
    @Autowired
    private ContratoRepository contratoRepo;

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Contrato buscarPorId(Long id) {
        Optional<Contrato> contratoOp = contratoRepo.findById(id);
        if(contratoOp.isPresent()){
            return contratoOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Contrato novoContrato(Contrato contrato) {
        if(contrato == null ||
            contrato.getNumero_contrato() == null ||
            contrato.getValor_contrato() == null ||
            contrato.getValor_multa() == null ||
            contrato.getInicio_contrato() == null ||
            contrato.getFim_contrato() == null ||
            contrato.getDetalhes_pagamento() == null ||
            contrato.getTempo_prorrogacao() == null ||
            contrato.getClass() == null 
        ){
            throw new IllegalArgumentException("Dados inválidos!");
        }
        return contratoRepo.save(contrato);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<Contrato> buscarTodosContratos(){
        return contratoRepo.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Contrato deletarPorId(Long id){
        Optional<Contrato> contratoOp = contratoRepo.findById(id);
        if(contratoOp.isPresent()){
            contratoRepo.deleteById(id);
            return contratoOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }
}
