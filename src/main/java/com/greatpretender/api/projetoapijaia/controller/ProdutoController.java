package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatpretender.api.projetoapijaia.entity.Produto;
import com.greatpretender.api.projetoapijaia.service.IProdutoService;

public class ProdutoController {
   @Autowired
   private IProdutoService service;

   @GetMapping
   public List<Produto> buscarTodos() {
        return service.buscarTodos();
   }

   @GetMapping(value = "/{produto}")
   public Produto buscarPorId(@PathVariable("produto") Long id) {
        return service.buscarPorId(id);
   }

   @PostMapping
   public Produto novoProduto(@RequestBody Produto produto) {
        return service.novoProduto(produto);
   }
}
