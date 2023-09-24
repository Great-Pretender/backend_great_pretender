package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Cliente;
import com.greatpretender.api.projetoapijaia.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private ClienteRepository clienteRepo;

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> clienteOp = clienteRepo.findById(id);
        if (clienteOp.isPresent()) {
            return clienteOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public Cliente novoCliente(Cliente cliente) {
        if(cliente == null  ||
                cliente.getCnpj() == null  ||
                cliente.getNome_responsavel() == null  ||
                cliente.getNome_fantasia() == null  ||
                cliente.getEmail() == null  ||
                cliente.getCep() == null  ||
                cliente.getEndereco() == null  ||
                cliente.getBairro() == null  ||
                cliente.getCidade() == null  ||
                cliente.getEstado() == null ) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        return clienteRepo.save(cliente);
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepo.findAll();
    }

    public Cliente deletarPorId(Long id){
        Optional<Cliente> clienteOp = clienteRepo.findById(id);
        if(clienteOp.isPresent()){
            
            clienteRepo.deleteById(id);
            return clienteOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }

}
