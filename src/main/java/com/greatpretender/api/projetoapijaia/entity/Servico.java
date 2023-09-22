package com.greatpretender.api.projetoapijaia.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "risco")
    private String risco;

    @Column(name = "duracao_dias")
    private String duracao_dias;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_setor")
    private Setor setor;
    
    @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Produto> produtos;

    @OneToMany(mappedBy = "atribuicao_ordem_servico")
    private Set<AtribuicaoOrdemServico> atribuicoes;

    public Servico() {}

    public Servico(String nome, String descricao, String risco, String duracao_dias) {
        this();
        this.nome = nome;
        this.descricao = descricao;
        this.risco = risco;
        this.duracao_dias = duracao_dias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getDuracao_dias() {
        return duracao_dias;
    }

    public void setDuracao_dias(String duracao_dias) {
        this.duracao_dias = duracao_dias;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Set<AtribuicaoOrdemServico> getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(Set<AtribuicaoOrdemServico> atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    
    
}
