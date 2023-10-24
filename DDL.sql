drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;


CREATE TABLE cliente (
  id bigint NOT NULL AUTO_INCREMENT,
  cnpj varchar(18) NOT NULL,
  nome_responsavel varchar(100) NOT NULL,
  nome_fantasia varchar(50) NOT NULL,
  telefone1 varchar(11) NOT NULL,
  telefone2 varchar(11),
  email varchar(50) NOT NULL,
  cep varchar(9),
  endereco varchar(50) ,
  bairro varchar(30) ,
  cidade varchar(30) ,
  estado varchar(25),
  PRIMARY KEY (id),
  UNIQUE KEY cnpj_unique (cnpj)
);

CREATE TABLE contrato (
  id bigint NOT NULL AUTO_INCREMENT,
  numero_contrato bigint NOT NULL,
  valor_contrato float(9,2) NOT NULL,
  valor_multa float(9,2) NOT NULL,
  inicio_contrato date NOT NULL,
  fim_contrato date NOT NULL,
  detalhes_pagamento varchar(50) NOT NULL,
  tempo_prorrogacao varchar(45) DEFAULT NULL,
  descricao_contrato varchar(500) DEFAULT NULL,
  clausulas_contrato varchar(500) DEFAULT NULL,
  cliente_id bigint NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_contrato_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
) ;

CREATE TABLE laudo (
  laudo_ID bigint NOT NULL AUTO_INCREMENT,
  cliente_id bigint NOT NULL,
  PRIMARY KEY (laudo_ID),
  CONSTRAINT fk_laudo_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);

CREATE TABLE setor (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE usuario (
  id bigint NOT NULL AUTO_INCREMENT,
  cpf  varchar(14) NOT NULL,
  nome varchar(100) NOT NULL,
  senha varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  cargo varchar(50),
  fk_setor bigint,
  PRIMARY KEY (id),
  UNIQUE KEY cpf_unique (cpf),
  CONSTRAINT FOREIGN KEY fk_usuario_setor (fk_setor) REFERENCES setor(id)
);

CREATE TABLE ordem_de_servico (
  id bigint NOT NULL AUTO_INCREMENT,
    descricao varchar(500) ,
    status_ordem varchar(15),
    status_aprovacao varchar(20),
    data_inicio date,
    data_fim date,
    fk_usuario bigint,
    fk_setor bigint,
    fk_cliente bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_ordem_de_servico_cliente FOREIGN KEY (fk_cliente) REFERENCES cliente (id),
  CONSTRAINT fk_ordem_de_servico_usuario FOREIGN KEY (fk_usuario) REFERENCES usuario (id),
  CONSTRAINT fk_ordem_de_servico_setor FOREIGN KEY (fk_setor) REFERENCES setor (id)
);

CREATE TABLE servico (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(50) DEFAULT NULL,
  descricao varchar(500) DEFAULT NULL,
  custo varchar(10) DEFAULT NULL,
  risco varchar(30) DEFAULT NULL,
  duracao_dias varchar(5) DEFAULT NULL,
  fk_setor bigint,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY fk_usuario_setor (fk_setor) REFERENCES setor(id)
);

CREATE TABLE item (
  id bigint NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  setor varchar(40) DEFAULT NULL,
  marca varchar(30) DEFAULT NULL,
  modelo varchar(30) DEFAULT NULL,
  validade  varchar(10) DEFAULT NULL,
  fk_servico bigint,
  PRIMARY KEY (id),
  CONSTRAINT fk_produto_servico FOREIGN KEY (fk_servico) REFERENCES servico (id)
);

CREATE TABLE atribuicao_ordem_servico (
  id bigint NOT NULL AUTO_INCREMENT,
  comentario varchar(300) DEFAULT NULL,
  status_andamento varchar(25) DEFAULT NULL,
  PRIMARY KEY (id),
  fk_servico bigint,
  fk_ordem_de_servico bigint,
  fk_usuario bigint ,
  CONSTRAINT fk_atribuicao_servico FOREIGN KEY (fk_servico) REFERENCES servico (id),
  CONSTRAINT fk_atribuicao_usuario FOREIGN KEY (fk_usuario) REFERENCES usuario (id),
  CONSTRAINT fk_atribuicao_ordem_de_servico FOREIGN KEY (fk_ordem_de_servico) REFERENCES ordem_de_servico (id)
  );

-- CREATE TABLE contrato(
--   id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--   numero_contrato BIGINT,
--   valor_contrato FLOAT(9,2),
--   valor_multa FLOAT(9,2),
--   inicio_contrato DATE,
--   fim_contrato DATE,
--   detalhes_pagamento VARCHAR(500),
--   tempo_prorrogacao  VARCHAR(500),
--   clausulas_contrato  VARCHAR(500),
--   fk_cliente BIGINT,
--   CONSTRAINT fk_contrato_cliente FOREIGN KEY (fk_cliente) REFERENCES cliente(id)
-- )