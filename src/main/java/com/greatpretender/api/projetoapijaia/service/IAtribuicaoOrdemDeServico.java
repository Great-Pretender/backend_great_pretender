package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;

public interface IAtribuicaoOrdemDeServico {
    public AtribuicaoOrdemServico buscarPorId(Long id);
    public AtribuicaoOrdemServico novaAtribuicaoOrdemDeServico(AtribuicaoOrdemServico atribuicaoOrdemDeServico);
    public List<AtribuicaoOrdemServico> buscarTodasAtribuicoesOrdensDeServico();
    public AtribuicaoOrdemServico deletarPorId(Long id);
}
