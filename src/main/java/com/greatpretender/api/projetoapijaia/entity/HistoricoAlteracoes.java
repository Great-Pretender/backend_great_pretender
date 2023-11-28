package com.greatpretender.api.projetoapijaia.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historico_alteracoes")
public class HistoricoAlteracoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOVO_STATUS")
    private String novoStatus;

    @Column(name = "DATA_ALTERACAO")
    private Timestamp dataAlteracao;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_ordem")
    private OrdemDeServico ordem_de_servico;

        public HistoricoAlteracoes(String novoStatus, Timestamp dataAlteracao){
            this.novoStatus = novoStatus;
            this.dataAlteracao = dataAlteracao;
        }


        public Long getId(){
            return id;
        }
        public void setId(Long id){
            this.id = id;
        }

        public String getNovoStatus(){
            return novoStatus;
        }
        public void setNovoStatus(String novoStatus){
            this.novoStatus = novoStatus;
        }

        public Timestamp getDataAlteracao(){
            return dataAlteracao;
        }
        public void setDataAlteracao(Timestamp dataAlteracao){
            this.dataAlteracao = dataAlteracao;
        }

        public OrdemDeServico getOrdemDeServico(){
            return ordem_de_servico;
        }
        public void setOrdemDeServico(OrdemDeServico ordemDeServico){
            this.ordem_de_servico = ordemDeServico;
        }

}