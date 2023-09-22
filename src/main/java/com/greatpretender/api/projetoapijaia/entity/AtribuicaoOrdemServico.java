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
}
