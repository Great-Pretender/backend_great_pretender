package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;
import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;
import com.greatpretender.api.projetoapijaia.entity.Servico;
import com.greatpretender.api.projetoapijaia.entity.Setor;

public interface IAtribuicaoOrdemDeServico {
    public AtribuicaoOrdemServico buscarPorId(Long id);
    public AtribuicaoOrdemServico novaAtribuicaoOrdemDeServico(AtribuicaoOrdemServico atribuicaoOrdemDeServico);
    public List<AtribuicaoOrdemServico> buscarTodasAtribuicoesOrdensDeServico();
    public AtribuicaoOrdemServico deletarPorId(Long id);
    public List<AtribuicaoOrdemServico> buscarPorIdOrdem(OrdemDeServico idSetor);
}
