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

import com.greatpretender.api.projetoapijaia.entity.Servico;
import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.service.IUsuarioService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
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

   //cd
      @PostMapping(value = "/idSetor")
      public List<Usuario> buscarPorIdSetor(@RequestBody Setor idSetor) {
           return service.buscarPorIdSetor(idSetor);
      }

  //  @GetMapping(value = "/{usuario}")
  //  public Usuario buscarPorNome(@PathVariable("usuario") String nome) {
  //       return service.buscarPorNome(nome);
  //  }

   // Função para deletar servico por id
   @DeleteMapping(value = "/{usuario}")
   public Usuario deleteUsuario(@PathVariable("usuario") Long id) {
     return service.deletarPorId(id);
    }

   @PutMapping("/{usuario}")
   public Usuario editUsuario(@RequestBody Usuario usuario){
     return service.novoUsuario(usuario);
    }     
}
