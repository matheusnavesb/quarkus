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

insert into fornecedor(nome, cnpj, email) values('FORNECEDOR 1', '00.123.123.0001-00', 'fornecedor1@gmail.com');
insert into fornecedor(nome, cnpj, email) values('FORNECEDOR 2', '11.123.123.0001-00', 'fornecedor2@gmail.com');
insert into fornecedor(nome, cnpj, email) values('FORNECEDOR 3', '22.123.123.0001-00', 'fornecedor3@gmail.com');