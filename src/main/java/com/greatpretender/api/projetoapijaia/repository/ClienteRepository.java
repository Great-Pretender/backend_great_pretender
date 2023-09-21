package com.greatpretender.api.projetoapijaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
