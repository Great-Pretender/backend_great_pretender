package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.service.ISetorService;



public class SetorController {
    @Autowired
   private ISetorService service;

   @GetMapping
   public List<Setor> buscarTodos() {
        return service.buscarTodos();
   }

   @GetMapping(value = "/{setor}")
   public Setor buscarPorId(@PathVariable("setor") Long id) {
        return service.buscarPorId(id);
   }

   @PostMapping
   public Setor novoUsuario(@RequestBody Setor setor) {
        return service.novoSetor(setor);
   }
}
