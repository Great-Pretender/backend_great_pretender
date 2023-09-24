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
import com.greatpretender.api.projetoapijaia.service.IServicoService;

@RestController
@RequestMapping("/servico")
@CrossOrigin
public class ServicoController {
   @Autowired
   private IServicoService service;

   @GetMapping
   public List<Servico> buscarTodos() {
        return service.buscarTodosServicos();
   }

   @PostMapping
   public Servico novoServico(@RequestBody Servico servico) {
        return service.novoServico(servico);
   }
   @GetMapping(value = "/{servico}")
   public Servico buscarPorId(@PathVariable("servico") Long id) {
        return service.buscarPorId(id);
   }
   // Função para deletar servico por id
   @DeleteMapping(value = "/{servico}")
   public Servico deleteServico(@PathVariable("servico") Long id) {
     return service.deletarPorId(id);
   }

   @PutMapping("/{servico}")
   public Servico editServico(@RequestBody Servico servico){
     return service.novoServico(servico);
   }     

}
