package com.greatpretender.api.projetoapijaia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findItemBySetorId(Long idSetor);
    
}
