package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;
import com.greatpretender.api.projetoapijaia.service.IAtribuicaoOrdemDeServico;

@RestController
@RequestMapping(value="/atribuicao")
public class AtribuicaoOrdemDeServicoController {
    
    @Autowired
    private IAtribuicaoOrdemDeServico service;

    // Função para buscar todas as atribuições de servico
    @GetMapping
    public List<AtribuicaoOrdemServico> buscarTodasAtribuicaoOrdemServicos() {
        return service.buscarTodasAtribuicoesOrdensDeServico();
    }
    // Função para atribuir um servico
    @PostMapping
    public AtribuicaoOrdemServico novaAtribuicaoOrdemServico(@RequestBody AtribuicaoOrdemServico atribuicaoOrdemServico){
        return service.novaAtribuicaoOrdemDeServico(atribuicaoOrdemServico);
    }
    @GetMapping(value="/{atribuicao}")
    public AtribuicaoOrdemServico buscarPorId(@PathVariable("atribuicao") Long id){
        return service.buscarPorId(id);
    }
}
