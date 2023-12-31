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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "setor")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Usuario> usuarios;

    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Servico> servicos;

    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrdemDeServico> ordemDeServicos;

        public Setor() {
        this.usuarios = new HashSet<Usuario>();
        this.servicos = new HashSet<Servico>();
        this.ordemDeServicos = new HashSet<OrdemDeServico>();
        
    }

        public Setor(String nome) {
            this();
            this.nome = nome;
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

        public Set<Servico> getServicos() {
            return servicos;
        }

        public void setServicos(Set<Servico> servicos) {
            this.servicos = servicos;
        }

        public Set<OrdemDeServico> getOrdemDeServicos() {
            return ordemDeServicos;
        }

        public void setOrdemDeServicos(Set<OrdemDeServico> ordemDeServicos) {
            this.ordemDeServicos = ordemDeServicos;
        }

        public Set<Usuario> getUsuarios() {
            return usuarios;
        }

        public void setUsuarios(Set<Usuario> usuarios) {
            this.usuarios = usuarios;
        }
        
        
}
