package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;
import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.service.IOrdemDeServicoService;

@RestController
@RequestMapping(value = "/ordemdeservico")
@CrossOrigin
public class OrdemDeServicoController {
    
    @Autowired
    private IOrdemDeServicoService service;

    // Função para buscar todas as ordens de servico
    @GetMapping
    public List<OrdemDeServico> buscarTodasOrdensDeServicos() {
        return service.buscarTodasOrdensDeServico();
    }
    // Função para cadastrar uma nova ordem de servico
    @PostMapping
    public OrdemDeServico novaOrdemDeServico(@RequestBody OrdemDeServico  ordemDeServico){
        return service.novaOrdemDeServico(ordemDeServico);
    }
    // Função para buscar uma ordem de servico pelo ID
    @GetMapping(value = "/{ordemDeServico}")
    public OrdemDeServico buscarPorId(@PathVariable("ordemDeServico") Long id) {
        return service.buscarPorId(id);
    }

    // Função para deletar ordem de serviço por id
    @DeleteMapping(value = "/{ordemDeServico}")
    public OrdemDeServico deleteOrdemDeServico(@PathVariable("ordemDeServico") Long id) {
        return service.deletarPorId(id);
    }

    @PutMapping("/{ordemDeServico}")
    public OrdemDeServico editOrdemDeServico(@RequestBody OrdemDeServico ordemDeServico){
        return service.novaOrdemDeServico(ordemDeServico);
    }

    @PostMapping(value = "/idSetor")
      public List<OrdemDeServico> buscarPorIdSetor(@RequestBody Setor idSetor) {
           return service.buscarPorIdSetor(idSetor);
      }
}
