package com.greatpretender.api.projetoapijaia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.service.IUsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
   @Autowired
   private IUsuarioService service;


   @GetMapping
   public List<Usuario> buscarTodosUsuarios() {
        return service.buscarTodosUsuarios();
   }

   @PostMapping
   public Usuario novoUsuario(@RequestBody Usuario usuario) {

        return service.novoUsuario(usuario);
   }

   @GetMapping(value = "/{usuario}")
   public Usuario buscarPorId(@PathVariable("usuario") Long id) {
        return service.buscarPorId(id);
   }
}
