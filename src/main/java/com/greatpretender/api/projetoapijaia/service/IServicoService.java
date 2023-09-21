package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Servico;

public interface IServicoService {
    
    public Servico buscarPorId(Long id);
    public Servico novoServico(Servico servico);
    public List<Servico> buscarTodos();
}