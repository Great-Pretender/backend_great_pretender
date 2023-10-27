package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Item;
import com.greatpretender.api.projetoapijaia.repository.ItemRepository;

@Service
public class ItemService implements IItemService {
    
    @Autowired
    private ItemRepository itemRepo;

    public Item buscarPorId(Long id) {
        Optional<Item> itemOp = itemRepo.findById(id);
        if (itemOp.isPresent()) {
            return itemOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public Item novoItem(Item Item) {
        if(Item == null  ||
                Item.getNome() == null  ||
                Item.getSetor() == null  ||
                Item.getMarca() == null  ||
                Item.getModelo() == null  ||
                Item.getValidade() == null ) {
            throw new IllegalArgumentException("Dados inválidos!");
        }
        return itemRepo.save(Item);
    }

    public List<Item> buscarTodosItems() {
        return itemRepo.findAll();
    }

    public Item deletarPorId(Long id){
        Optional<Item> itemOp = itemRepo.findById(id);
        if(itemOp.isPresent()){
            
            itemRepo.deleteById(id);
            return itemOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }
}
