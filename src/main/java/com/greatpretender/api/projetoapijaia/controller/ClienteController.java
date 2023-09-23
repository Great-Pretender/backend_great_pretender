package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatpretender.api.projetoapijaia.entity.Cliente;
import com.greatpretender.api.projetoapijaia.repository.ClienteRepository;
import com.greatpretender.api.projetoapijaia.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private IClienteService service;

    @Autowired
    private ClienteRepository repositorio_cliente;

    @GetMapping
    public List<Cliente> buscarTodosClientes() {
         return service.buscarTodosClientes();
    }

    @PostMapping
    public Cliente cadastar(@RequestBody Cliente cliente){
        return repositorio_cliente.save(cliente);
    }
}
