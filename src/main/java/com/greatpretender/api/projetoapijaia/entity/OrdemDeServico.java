package com.greatpretender.api.projetoapijaia.entity;


import java.time.LocalDate;
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
@Table (name = "ordem_de_servico")
public class OrdemDeServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status_ordem")
    private String status_ordem;

    @Column(name = "status_aprovacao")
    private String status_aprovacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_setor")
    private Setor setor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @Column(name = "data_inicio")
    private LocalDate data_inicio;

    @Column(name = "data_fim")
    private LocalDate data_fim;

    @OneToMany(mappedBy = "ordem")
    @JsonIgnore
    private Set<AtribuicaoOrdemServico> atribuicoes;

        public OrdemDeServico(String descricao, String status_ordem, String status_aprovacao, LocalDate data_inicio, LocalDate data_fim) {
            this();
            this.descricao = descricao;
            this.status_ordem = status_ordem;
            this.status_aprovacao = status_aprovacao;
            this.data_inicio = data_inicio;
            this.data_fim = data_fim;
        }

        public OrdemDeServico() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getStatusOrdem() {
            return status_ordem;
        }

        public void setStatusOrdem(String status_ordem) {
            this.status_ordem = status_ordem;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Setor getSetor() {
            return setor;
        }

        public void setSetor(Setor setor) {
            this.setor = setor;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public String getStatus_ordem() {
            return status_ordem;
        }

        public void setStatus_ordem(String status_ordem) {
            this.status_ordem = status_ordem;
        }

        public String getStatus_aprovacao() {
            return status_aprovacao;
        }

        public void setStatus_aprovacao(String status_aprovacao) {
            this.status_aprovacao = status_aprovacao;
        }

        public Set<AtribuicaoOrdemServico> getAtribuicoes() {
            return atribuicoes;
        }

        public void setAtribuicoes(Set<AtribuicaoOrdemServico> atribuicoes) {
            this.atribuicoes = atribuicoes;
        }

        public LocalDate getData_inicio() {
            return data_inicio;
        }

        public void setData_inicio(LocalDate data_inicio) {
            this.data_inicio = data_inicio;
        }

        public LocalDate getData_fim() {
            return data_fim;
        }

        public void setData_fim(LocalDate data_fim) {
            this.data_fim = data_fim;
        }

       

        
}
