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

import com.greatpretender.api.projetoapijaia.entity.Produto;
import com.greatpretender.api.projetoapijaia.service.IProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin
public class ProdutoController {
   @Autowired
   private IProdutoService service;

   @GetMapping
   public List<Produto> buscarTodos() {
        return service.buscarTodosProdutos();
   }
   @PostMapping
   public Produto novoProduto(@RequestBody Produto produto) {
        return service.novoProduto(produto);
   }
   
   @GetMapping(value = "/{produto}")
   public Produto buscarPorId(@PathVariable("produto") Long id) {
        return service.buscarPorId(id);
   }

   // Função para deletar produto por id
   @DeleteMapping(value = "/{produto}")
   public Produto deleteProduto(@PathVariable("produto") Long id) {
     return service.deletarPorId(id);
   }

   @PutMapping("/{produto}")
   public Produto editproduto(@RequestBody Produto produto){
     return service.novoProduto(produto);
    }

}
