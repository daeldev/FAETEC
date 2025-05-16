-- Criar o Banco de Dados
create database BD2024tarde;
-- acessa ou abre o Banco de Dados
use BD2024tarde;
-- cria a Table dentro do banco de dados
Create table Cliente(
IdCliente int not null auto_increment primary key,
Nome varchar (50) not null,
endereço varchar (50),
numero int,
profissão varchar (30),
salario decimal (10,2));
-- inseri os dados na tabela conforme os campos criados
insert into Cliente ( Nome , endereço , numero , profissão , salario)
values ("Eduardo" , "Rua B " , 10 , "aluno" , 500),
("Rafaela" , "Rua C" , 11 , "aluna" , 550); 
-- lista o conteúdo da tabela
select * from Cliente;
-- atualiza os campos do registro com base em uma pesquisa
update Cliente set  nome = "Eduardo Gabriel" where  Idcliente = 2;
-- apaga um registro com base em uma pesquisa
delete from Cliente where Idcliente = 2;
-- alterar a estrutura fisica da tabela (adicionando um novo campo na tabela)
alter table Cliente
add Email varchar (255);
-- remove um campo da tabela
alter table Cliente
drop Email;
-- modificando a tabela (o tipo)
alter table Cliente
modify Idcliente int not null;
-- apaga a chave primária 
alter table Cliente
drop primary key;
-- exibe a descrição dos campos da tabela
describe Cliente;
-- adicionar a chave primária depois de removida
alter table Cliente
add primary key (Idcliente);
-- alterar o nome do registro na tabela
alter table Cliente
change nome nomeCliente varchar(60);