
insert into spring.laudo() values();

insert into spring.setor(nome) values ("Saúde");
insert into spring.setor(nome) values ("TI");
insert into spring.setor(nome) values ("Construção Civil");

insert into spring.servico(nome, descricao, custo, risco, duracao_dias, fk_setor)
values("Manutenção das placas de aviso", "Arrumar as placas de aviso e colocar onde está faltando", "R$500", "Sem risco", "2", 3);

insert into servico(nome, descricao, custo, risco, duracao_dias, fk_setor)
values("Manutenção de servidores", "Verificar funcionalidades e conexões pertinentes", "R$1200", "risco baixo", "3", 2);

insert into servico(nome, descricao, custo, risco, duracao_dias, fk_setor)
values("Manutenção das placas de aviso", "Arrumar as placas de aviso e colocar onde está faltando", "R$500", "Sem risco", "2", 3);

insert into spring.produto(nome, setor, marca, modelo, validade, fk_servico) values ("Chave de fenda", "Construção Civil", "Tramontina", "8mm", "25/08/2024", 1);
insert into spring.produto(nome, setor, marca, modelo, validade, fk_servico) values ("Alicate de corte", "Construção Civil", "Hikari", "5mm", "26/05/2025", 1);
insert into spring.produto(nome, setor, marca, modelo, validade, fk_servico) values ("Óculos de Proteção", "Construção Civil", "Hikari", "Óculos de Hastes", "23/12/2025", 1);

insert into spring.cliente(cnpj, nome_responsavel, nome_fantasia, email, CEP, endereco, bairro, cidade, estado) 
values ("888.888.888-88", "Felipe", "Prédios São José", "felipe@gmail.com", "999999-99", "Rua Alfredo, 167", "Jardim Satelite", "São José dos Campos", "São Paulo");

insert into spring.usuario(cpf, nome, senha, email, fk_setor) values ("000.000.000-00", "Gabriel", "123", "gabriel@gmail.com", 1, 3);
insert into spring.usuario(cpf, nome, senha, email, fk_setor) values ("111.111.111-11", "Leonardo", "456", "leo@outlook.com", 1, 3);
insert into spring.usuario(cpf, nome, senha, email, fk_setor) values ("222.222.222-22", "Vitor", "789", "vitor@gmail.com", 1, 3);