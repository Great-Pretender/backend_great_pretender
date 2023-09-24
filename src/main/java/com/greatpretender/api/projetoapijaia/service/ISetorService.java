package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Setor;


public interface ISetorService {
    
    public Setor buscarPorId(Long id);
    public Setor novoSetor(Setor setor);
    public List<Setor> buscarTodosSetores();
    public Setor deletarPorId(Long id);

  
}
