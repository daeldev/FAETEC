.-- Cria o banco de dados
create database BD2024TAula;

-- Acessa ou abre o Banco de dados
use BD2024TAula;

-- Cria a tabela dentro do banco de dados
Create table Cliente(
IdCLiente int not null auto_increment key,
Nome varchar(50) not null,
Endereco varchar(50),
Numero int,
Profissao varchar(30),
Salario decimal (10,2));

-- Insere os dados na tabela conforme os campos criados
insert into Cliente(Nome, Endereco, Numero, Profissao, Salario)
values ("Alexandre", "Rua A",10, "Professor de Ti", 20000),
("Bluezão", "Rua L", 14, "Ator", 100),
("Ednaldo", "Rua U", 17, "Músico", 10000),
("Popo", "Rua J", 12, "Boxe", 3000),
("Dora", "Rua H", 18, "TI", 1200);

drop table Cliente;

-- Lista o conteúdo da tabela
Select * from Cliente;

-- Atualizo os campos do registro com base em uma pesquisa
update Cliente set Nome = "Alexandre Borges"
where IdCLiente = 2;

-- Apaga um registr com base em uma pesquisa
Delete from Cliente where IdCliente = 2;

-- Altera a estrutura física da tabela
-- Adicionando um novo campo na tabela
Alter Table Cliente
add Email varchar(255);

-- Remove um campo da tabela
Alter table Cliente
drop Email;
-- Modificando a tabela
Alter Table Cliente
modify IdCliente int Not Null;

-- Apagando a chave primaria
Alter Table Cliente
drop primary key;

-- Exibe a descrição dos campos da tabela
describe Cliente;

-- Adicionando a chave primária
Alter table Cliente
Add primary key(IdCliente);
Alter table Cliente
change Nome NomeCliente varchar(60);

-- Rio de Janeiro 04/03/2024
-- Select simples
-- Lista todos os campos da tabela cliente
select * from Cliente;

-- Listando alguns campos da tabela
select NomeCliente, Profissao, Salario from Cliente;

-- Listando com consulta
select NomeCliente, Salario from Cliente;
where Salario >= 1100;

-- Adiciona um novo campo na tabela
Alter table Cliente add UF varchar(2);

update Cliente set UF = "RJ" where IdCliente = 2;

insert into Cliente(IdCLiente, Nome, Endereco, Numero, Profissao, Salario, UF)
values (2, "Alexandre", "Rua A",10, "Professor de Ti", 20000, "SP"),
(3, "Bluezão", "Rua L", 14, "Ator", 100, "BH"),
(4, "Ednaldo", "Rua U", 17, "Músico", 10000, "ES"),
(5, "Popo", "Rua J", 12, "Boxe", 3000, "RJ"),
(6, "Dora", "Rua H", 18, "TI", 1200, "MG");

select * from Cliente where UF = "RJ" or "SP";

-- Cláusula in
where UF in("RJ", "SP", "MG");

-- Operadores relacionais
-- >, >=, <, <=, <>, =

select Nome, Salario
from Cliente
where Salario >= 1000 and Salario <= 3000;

select Salario from Cliente
where Salario between 1000 and 4000;

-- Like que é o próximo
-- Mostra os usuário que começam com "a" no nome
select NomeCliente from Cliente
where NomeCliente Like "a%";

-- Mostra os usuário que terminam com "a" no nome
select NomeCliente from Cliente
where NomeCliente Like "%a";

-- Mostra os usuário que tem "a" no nome
select NomeCliente from Cliente
where NomeCliente Like "%a%";

-- O distinct mostra os usuários sem repetição de dados
select distinct NomeCliente from Cliente;