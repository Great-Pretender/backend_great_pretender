package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.service.IUsuarioService;

public class UsuarioController {
   @Autowired
   private IUsuarioService service;

   @GetMapping
   public List<Usuario> buscarTodos() {
        return service.buscarTodos();
   }

   @GetMapping(value = "/{usuario}")
   public Usuario buscarPorId(@PathVariable("usuario") Long id) {
        return service.buscarPorId(id);
   }

   @PostMapping
   public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return service.novoUsuario(usuario);
   }
}
