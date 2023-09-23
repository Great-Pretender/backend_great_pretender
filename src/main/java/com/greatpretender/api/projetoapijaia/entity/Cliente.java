package com.greatpretender.api.projetoapijaia.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome_responsavel")
    private String nome_responsavel;

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


    public Cliente() {}

        public Cliente(String cnpj, String nome_responsavel, String nome_fantasia, String email, String cep, String endereco, String bairro, String cidade, String estado) {
            this();
            this.cnpj = cnpj;
            this.nome_responsavel = nome_responsavel;
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

        public String getNome_responsavel() {
            return nome_responsavel;
        }

        public void setNome_responsavel(String nome_responsavel) {
            this.nome_responsavel = nome_responsavel;
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

        public void setEndereco(String endereco) {
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
