package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Cliente;

public interface IClienteService {
    
    public Cliente buscarPorId(Long id);
    public Cliente novoCliente(Cliente cliente);
    public List<Cliente> buscarTodos();
}
