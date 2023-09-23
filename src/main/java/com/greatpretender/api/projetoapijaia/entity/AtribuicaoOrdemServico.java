package com.greatpretender.api.projetoapijaia.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "atribuicao_ordem_servico")
public class AtribuicaoOrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "comentario")
    private String comentario;

    @Column (name = "status_andamento")
    private String status_andamento;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_servico")
    private Servico servico;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "fk_ordem_de_servico")
    private OrdemDeServico ordem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getStatus_andamento() {
        return status_andamento;
    }

    public void setStatus_andamento(String status_andamento) {
        this.status_andamento = status_andamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

   
  
}
