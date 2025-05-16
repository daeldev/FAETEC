create database BD0304;
-- //
use BD0304;
-- //
create table sociop(
idsocio int not null auto_increment primary key ,
nome varchar (50),
salario int,
profissao varchar (45));
-- // ano , mes e dia
insert into sociop (nome , salario , profissao)
values ("Eduardo", 2000 , "programador"),
("Rafaela", 4500 , "cozinheira"),
("Oruam", 3200 , "carteiro"),
("Gustavo", 1200 , "mecanico"),
("Alexandre", 300000 , "Marketing Digital");
-- //
drop table sociop;
-- //
alter table sociop
add salario int;

-- rio de janeiro 04/03/2024
-- select simples
-- lista todos os campos da tabela

select * from sociop;

-- // puxa dados da tabela em especifico
select nome , salario from sociop
where salario >= 3000;

-- listando alguns campos da tabela
select nome , salario from sociop;

-- // adiciona um novo campo na tabela
 alter table sociop add UF varchar (2);

-- // add dados a um novo campo 
update sociop set  UF = "RJ" where  idsocio = 5;

-- // puxa informação dos dados com maior prioridade , caso nao houve então , opta pela segunda opção 
select * from sociop where UF = "SP" or "MG";
