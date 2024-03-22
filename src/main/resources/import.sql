insert into estado (nome, sigla) values( 'Tocantins', 'TO');
insert into estado (nome, sigla) values( 'Goiás', 'GO');
insert into estado (nome, sigla) values( 'São Paulo', 'SP');
insert into estado (nome, sigla) values( 'Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values( 'Pará', 'PA');

--insert into usuario (nome, email , idade, senha) values( 'Matheus','Matheus@gmail.com', 29, '123456');
--insert into usuario (nome, email , idade, senha) values( 'Filipe','Filipe@gmail.com', 20, '121212');

insert into usuario (nome, email , senha) values( 'Matheus','Matheus@gmail.com', '12345678');
insert into usuario (nome, email , senha) values( 'Filipe','Filipe@gmail.com', '12121212');


--insert into usuario (nome, email) values( 'Matheus','Matheus@gmail.com');
--insert into usuario (nome, email) values( 'Filipe','Filipe@gmail.com');

insert into cidade (nome, id_estado) values( 'Palmas', 1);
insert into cidade (nome, id_estado) values( 'Paraíso', 1);
insert into cidade (nome, id_estado) values( 'Gurupi', 1);
insert into cidade (nome, id_estado) values( 'Goiânia', 2);
insert into cidade (nome, id_estado) values( 'Anápolis', 2);

insert into fornecedor(nome, cnpj, email) values('FIAT', '00.123.123.0001-00', 'fornecedor1@gmail.com');
insert into fornecedor(nome, cnpj, email) values('TOYOTA', '11.123.123.0001-00', 'fornecedor2@gmail.com');
insert into fornecedor(nome, cnpj, email) values('HONDA', '22.123.123.0001-00', 'fornecedor3@gmail.com');
insert into fornecedor(nome, cnpj, email) values('FORD', '33.123.123.0001-00', 'fornecedor4@gmail.com');
insert into fornecedor(nome, cnpj, email) values('CHEVROLET', '44.123.123.0001-00', 'fornecedor5@gmail.com');

insert into localizacao(cidade, estado, id_Fornecedor) values ('Palmas', 'Tocantins', 1);
insert into localizacao(cidade, estado, id_Fornecedor) values ('Goiania', 'Goias', 1);
insert into localizacao(cidade, estado, id_Fornecedor) values ('Sao Paulo', 'Sao Paulo', 2);