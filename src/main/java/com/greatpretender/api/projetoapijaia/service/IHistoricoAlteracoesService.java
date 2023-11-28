package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.HistoricoAlteracoes;

public interface IHistoricoAlteracoesService {

    public HistoricoAlteracoes buscarPorId(Long id);
    public HistoricoAlteracoes novoHistorico(HistoricoAlteracoes cliente);
    public List<HistoricoAlteracoes> buscarTodosHistoricos();
    public HistoricoAlteracoes deletarPorId(Long id);
    
}
