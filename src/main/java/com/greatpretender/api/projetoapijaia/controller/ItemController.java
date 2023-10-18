package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatpretender.api.projetoapijaia.entity.Item;
import com.greatpretender.api.projetoapijaia.service.IItemService;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {
   @Autowired
   private IItemService service;

   @GetMapping
   public List<Item> buscarTodos() {
        return service.buscarTodosItems();
   }
   @PostMapping
   public Item novoItem(@RequestBody Item item) {
        return service.novoItem(item);
   }
   
   @GetMapping(value = "/{item}")
   public Item buscarPorId(@PathVariable("item") Long id) {
        return service.buscarPorId(id);
   }

   // Função para deletar produto por id
   @DeleteMapping(value = "/{produto}")
   public Item deleteItem(@PathVariable("produto") Long id) {
     return service.deletarPorId(id);
   }

   @PutMapping("/{produto}")
   public Item editproduto(@RequestBody Item item){
     return service.novoItem(item);
    }

}
