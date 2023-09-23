package com.greatpretender.api.projetoapijaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.AtribuicaoOrdemServico;

public interface AtribuicaoOrdemDeServicoRepository extends JpaRepository<AtribuicaoOrdemServico, Long> {
    
}
