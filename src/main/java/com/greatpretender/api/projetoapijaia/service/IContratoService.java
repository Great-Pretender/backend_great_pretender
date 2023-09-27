package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Contrato;

public interface IContratoService {
    public Contrato buscarPorId(Long id);
    public Contrato novoContrato(Contrato contrato);
    public List<Contrato> buscarTodosContratos();
    public Contrato deletarPorId(Long id);
}
