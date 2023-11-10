package com.greatpretender.api.projetoapijaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;

import com.greatpretender.api.projetoapijaia.entity.Cliente;

import java.util.List;

public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long> {
    
    List<OrdemDeServico> findOrdemDeServicoByClienteIdAndStatusOrdem(Long idCliente, String sts); 
}
