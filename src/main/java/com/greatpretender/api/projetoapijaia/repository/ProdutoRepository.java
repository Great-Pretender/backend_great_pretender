package com.greatpretender.api.projetoapijaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
