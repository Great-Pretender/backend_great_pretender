package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;
import com.greatpretender.api.projetoapijaia.entity.Setor;

import com.greatpretender.api.projetoapijaia.entity.Cliente;

public interface IOrdemDeServicoService {
    public OrdemDeServico buscarPorId(Long id);
    public OrdemDeServico novaOrdemDeServico(OrdemDeServico ordemDeServico);
    public List<OrdemDeServico> buscarTodasOrdensDeServico();
    public OrdemDeServico deletarPorId(Long id);
    public List<OrdemDeServico> buscarPorIdSetor(Setor idSetor);
    public List<OrdemDeServico> buscarPorIdCliente(Cliente idCliente);
}
