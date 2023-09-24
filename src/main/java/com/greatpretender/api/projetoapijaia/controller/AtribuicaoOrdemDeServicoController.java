package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;
import com.greatpretender.api.projetoapijaia.repository.AtribuicaoOrdemDeServicoRepository;
import com.greatpretender.api.projetoapijaia.service.IAtribuicaoOrdemDeServico;

@RestController
@RequestMapping(value="/atribuicao")
@CrossOrigin
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

    @DeleteMapping(value = "/{atribuicao}")
    public AtribuicaoOrdemServico deleteAtribuicaoOrdemServico(@PathVariable("atribuicao") Long id) {
        return service.deletarPorId(id);
    }

    @PutMapping("/{atribuicao}")
    public AtribuicaoOrdemServico editServico(@RequestBody AtribuicaoOrdemServico atribuicao){
      return service.novaAtribuicaoOrdemDeServico(atribuicao);
    }   

}
