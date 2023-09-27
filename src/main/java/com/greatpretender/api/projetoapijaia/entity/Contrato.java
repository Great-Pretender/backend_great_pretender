package com.greatpretender.api.projetoapijaia.entity;
import jakarta.persistence.GenerationType;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_contrato")
    private Long numero_contrato;

    @Column(name = "valor_contrato")
    private Float valor_contrato;

    @Column(name = "valor_multa")
    private Float valor_multa;

    @Column(name = "inicio_contrato")
    private Date inicio_contrato;

    @Column(name = "fim_contrato")
    private Date fim_contrato;

    @Column(name = "detalhes_pagamento")
    private String detalhes_pagamento;

    @Column(name = "tempo_prorrogacao")
    private String tempo_prorrogacao;

    @Column(name = "clausulas_contrato")
    private String clausulas_contrato;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    public Contrato() {}

    public Contrato(Long numero_contrato, Float valor_contrato, Float valor_multa, Date inicio_contrato,
            Date fim_contrato, String detalhes_pagamento, String tempo_prorrogacao, String clausulas_contrato) {
        this.numero_contrato = numero_contrato;
        this.valor_contrato = valor_contrato;
        this.valor_multa = valor_multa;
        this.inicio_contrato = inicio_contrato;
        this.fim_contrato = fim_contrato;
        this.detalhes_pagamento = detalhes_pagamento;
        this.tempo_prorrogacao = tempo_prorrogacao;
        this.clausulas_contrato = clausulas_contrato;
    }

    public Long getNumero_contrato() {
        return numero_contrato;
    }

    public void setNumero_contrato(Long numero_contrato) {
        this.numero_contrato = numero_contrato;
    }

    public Float getValor_contrato() {
        return valor_contrato;
    }

    public void setValor_contrato(Float valor_contrato) {
        this.valor_contrato = valor_contrato;
    }

    public Float getValor_multa() {
        return valor_multa;
    }

    public void setValor_multa(Float valor_multa) {
        this.valor_multa = valor_multa;
    }

    public Date getInicio_contrato() {
        return inicio_contrato;
    }

    public void setInicio_contrato(Date inicio_contrato) {
        this.inicio_contrato = inicio_contrato;
    }

    public Date getFim_contrato() {
        return fim_contrato;
    }

    public void setFim_contrato(Date fim_contrato) {
        this.fim_contrato = fim_contrato;
    }

    public String getDetalhes_pagamento() {
        return detalhes_pagamento;
    }

    public void setDetalhes_pagamento(String detalhes_pagamento) {
        this.detalhes_pagamento = detalhes_pagamento;
    }

    public String getTempo_prorrogacao() {
        return tempo_prorrogacao;
    }

    public void setTempo_prorrogacao(String tempo_prorrogacao) {
        this.tempo_prorrogacao = tempo_prorrogacao;
    }

    public String getClausulas_contrato() {
        return clausulas_contrato;
    }

    public void setClausulas_contrato(String clausulas_contrato) {
        this.clausulas_contrato = clausulas_contrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    
}
