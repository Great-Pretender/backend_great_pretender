package com.greatpretender.api.projetoapijaia.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome_responsavel")
    private String nome;

    @Column(name = "nome_fantasia")
    private String nome_fantasia;

    @Column(name = "email")
    private String email;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "ordemsrv", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrdemDeServico> ordemDeServicos;

    @OneToMany(mappedBy = "servicood", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SrvOrdemDeServico> srvOrdemDeServicos;


    public Cliente() {}

        public Cliente(String cnpj, String nome, String nome_fantasia, String email, String cep, String endereco, String bairro, String cidade, String estado) {
            this();
            this.cnpj = cnpj;
            this.nome = nome;
            this.nome_fantasia = nome_fantasia;
            this.email = email;
            this.cep = cep;
            this.endereco = endereco;
            this.bairro = bairro;
            this.cidade = cidade;
            this.estado = estado;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNome_fantasia() {
            return nome_fantasia;
        }

        public void setNome_fantasia(String nome_fantasia) {
            this.nome_fantasia = nome_fantasia;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCep() {
            return cep;
        }

        public void setCep(String cep) {
            this.cep = cep;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setendereco(String endereco) {
            this.endereco = endereco;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
}
