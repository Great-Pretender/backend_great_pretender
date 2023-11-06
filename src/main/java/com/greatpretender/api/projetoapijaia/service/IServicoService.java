package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Servico;
import com.greatpretender.api.projetoapijaia.entity.Setor;

public interface IServicoService {
    
    public Servico buscarPorId(Long id);
    public Servico novoServico(Servico servico);
    public List<Servico> buscarTodosServicos();
    public Servico deletarPorId(Long id);
    public List<Servico> buscarPorIdSetor(Setor idSetor);
}