package com.greatpretender.api.projetoapijaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findItemBySetor(String nomeSetor);
    
}
