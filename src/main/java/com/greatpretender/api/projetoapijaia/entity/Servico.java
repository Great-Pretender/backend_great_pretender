package com.greatpretender.api.projetoapijaia.entity;

import java.util.HashSet;
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

    @Column(name = "custo")
    private String custo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_setor")
    private Setor setor;
    
    @OneToMany(mappedBy = "servico")
    @JsonIgnore
    private Set<Item> items;

    @OneToMany(mappedBy = "servico")
    @JsonIgnore
    private Set<AtribuicaoOrdemServico> atribuicoes;

    public Servico() {
        this.items = new HashSet<Item>();
        this.atribuicoes = new HashSet<AtribuicaoOrdemServico>();
    }

    public Servico(String nome, String descricao, String risco, String duracao_dias, String custo) {
        this();
        this.nome = nome;
        this.descricao = descricao;
        this.risco = risco;
        this.duracao_dias = duracao_dias;
        this.custo = custo;

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
    

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public Set<Item> getItems() {
        return items;
    }
    
    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Set<AtribuicaoOrdemServico> getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(Set<AtribuicaoOrdemServico> atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
}
