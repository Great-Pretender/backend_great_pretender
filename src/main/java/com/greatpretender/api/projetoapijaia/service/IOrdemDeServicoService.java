package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;

public interface IOrdemDeServicoService {
    public OrdemDeServico buscarPorId(Long id);
    public OrdemDeServico novaOrdemDeServico(OrdemDeServico ordemDeServico);
    public List<OrdemDeServico> buscarTodasOrdensDeServico();
    public OrdemDeServico deletarPorId(Long id);

}
