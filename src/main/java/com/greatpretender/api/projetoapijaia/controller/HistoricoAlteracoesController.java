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

import com.greatpretender.api.projetoapijaia.entity.HistoricoAlteracoes;
import com.greatpretender.api.projetoapijaia.service.IHistoricoAlteracoesService;

@RestController
@RequestMapping("/historico")
@CrossOrigin
public class HistoricoAlteracoesController {
	
	@Autowired
    private IHistoricoAlteracoesService service;

    @GetMapping
    public List<HistoricoAlteracoes> buscarTodos() {
         return service.buscarTodosHistoricos();
    }

    @PostMapping
    public HistoricoAlteracoes novoServico(@RequestBody HistoricoAlteracoes historico) {
         return service.novoHistorico(historico);
    }
    
    @GetMapping(value = "/{historico}")
    public HistoricoAlteracoes buscarPorId(@PathVariable("servico") Long id) {
    return service.buscarPorId(id);
     }
    
    @DeleteMapping(value = "/{historico}")
    public HistoricoAlteracoes deleteHistorico(@PathVariable("historico") Long id) {
         return service.deletarPorId(id);
    }

    @PutMapping(value = "/{servico}")
    public HistoricoAlteracoes editServico(@RequestBody HistoricoAlteracoes historico) {
         return service.novoHistorico(historico);
    }

}
