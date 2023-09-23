package com.greatpretender.api.projetoapijaia.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "setor")
    private String setor;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "validade")
    private String validade;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_servico")
    private Servico servico;


    public Produto() { }

        public Produto(String nome, String setor, String marca, String modelo, String validade) {
            this();
            this.nome = nome;
            this.setor = setor;
            this.marca = marca;
            this.modelo = modelo;
            this.validade = validade;
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

        public String getSetor() {
            return setor;
        }

        public void setSetor(String setor) {
            this.setor = setor;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getValidade() {
            return validade;
        }

        public void setValidade(String validade) {
            this.validade = validade;
        }

        public Servico getServico() {
            return servico;
        }

        public void setServico(Servico servico) {
            this.servico = servico;
        }
        
}
