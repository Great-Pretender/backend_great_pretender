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

import com.greatpretender.api.projetoapijaia.entity.Contrato;
import com.greatpretender.api.projetoapijaia.service.IContratoService;

@RestController
@RequestMapping("/contrato")
@CrossOrigin
public class ContratoController {
    @Autowired
    private IContratoService service;

    @GetMapping
    public List<Contrato> buscarTodos(){
        return service.buscarTodosContratos();
    }
    @PostMapping
    public Contrato novocContrato(@RequestBody Contrato contrato){
        return service.novoContrato(contrato);
    }
    @GetMapping(value = "/{contrato}")
    public Contrato buscarPorId(@PathVariable("contrato") Long id){
        return service.buscarPorId(id);
    }
    @PutMapping("/{contrato}")
    public Contrato editContrato(@RequestBody Contrato servico){
      return service.novoContrato(servico);
    }  

    @DeleteMapping(value = "/{contrato}")
    public Contrato deleteServico(@PathVariable("contrato") Long id) {
      return service.deletarPorId(id);
    }

}
