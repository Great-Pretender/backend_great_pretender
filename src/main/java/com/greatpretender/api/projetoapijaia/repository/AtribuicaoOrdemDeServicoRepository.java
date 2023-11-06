package com.greatpretender.api.projetoapijaia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;
import com.greatpretender.api.projetoapijaia.entity.Servico;

public interface AtribuicaoOrdemDeServicoRepository extends JpaRepository<AtribuicaoOrdemServico, Long> {

    List<AtribuicaoOrdemServico> findAtribuicaoOrdemServicoByOrdemId(Long idOrdem);
    
}
