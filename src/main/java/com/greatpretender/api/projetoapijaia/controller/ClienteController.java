package com.greatpretender.api.projetoapijaia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatpretender.api.projetoapijaia.entity.Cliente;
import com.greatpretender.api.projetoapijaia.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repositorio_cliente;

    @GetMapping("/listar")
    public Iterable<Cliente> listar(){
        return repositorio_cliente.findAll();
    }

    @PostMapping("/cadastrar")
    public Cliente cadastar(@RequestBody Cliente obj){
        return repositorio_cliente.save(obj);
    }
}
