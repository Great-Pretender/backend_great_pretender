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

import com.greatpretender.api.projetoapijaia.entity.Cliente;
import com.greatpretender.api.projetoapijaia.repository.ClienteRepository;
import com.greatpretender.api.projetoapijaia.service.IClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin
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
    public Cliente cadastrar(@RequestBody Cliente cliente){
        return repositorio_cliente.save(cliente);
    }

    @GetMapping(value="/{cliente}")
    public Cliente buscarPorId(@PathVariable("cliente") Long id){
        return service.buscarPorId(id);
    }

    // Função para deletar cliente por id
    @DeleteMapping(value = "/{cliente}")
    public Cliente deleteCLiente(@PathVariable("cliente") Long id) {
        return service.deletarPorId(id);
    }

    @PutMapping("/{cliente}")
    public Cliente editCliente(@RequestBody Cliente cliente){
         return service.novoCliente(cliente);
    }     
}
