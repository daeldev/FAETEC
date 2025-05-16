create database 2024texerc;

use 2024texerc;

-- (1)

/*
	tabela fornecedor 
*/
create table fornecedor(
codfor int primary key not null,
nome varchar (40),
endereço varchar (50),
bairro char (20),
UF varchar (2),
telefone varchar (13));

/*
	tabela vendedor
*/
create table vendedor(
codvend int primary key not null,
nome char (30),
telefone varchar (13));

/*
	tabela produto
*/
create table produto(
codprod int primary key not null,
nome varchar (50),
valor decimal (10,2),
datacad date,
qtd int,
qtdlimite int);

/*
	tabela for_prod
*/
create table for_prod(
codfor int primary key not null,
codprod int,
codvend int,
datacad date);


alter table for_prod 
add constraint for_prod
foreign key (codfor,codprod,codvend)
references fornecedor(codfor);

-- (2)
/*
	dados da tabela fornecedor:
*/   
insert into fornecedor(codfor,nome,endereço,bairro,UF,telefone) values
("1","Eduardo","Cidade de Deus","Rua Dos Ap's","RJ","02190901872"),
("2","Gustavo","Rocinha","Beco da 17","RJ","02189923013"),
("3","Cidney","Parque Esperança","Rua Sem Nome","RJ","02121090982"),
("4","Borges","Penha","Decida Do Diabo","RJ","02199998321"),
("5","Rakkel","Chapadão","Campinho Verde","RJ","02132219031");

/*
	dados da tabela vendedor
*/
insert into vendedor(codvend,nome,telefone)values
("1","Jorge","021187870954"),
("2","Patricia","02166665443"),
("3","Caxote","02114632094"),
("4","Yasuo","021168684303"),
("5","Zenki","021969540302");

/*
	dados da tabela produto
*/
insert into produto(codprod,nome,valor,datacad,qtd,qtdlimite)values
("1","Glock",2000,"2000-12-01","20","5"),
("2","AK105",5500,"2001-02-12","30","4"),
("3","M16A4",4250,"1998-03-12","32","4"),
("4","M134 Minigun",4050,"2012-04-11","15","3"),
("5","AWP",3250,"2011-11-02","20","7");

/* 
	dados for_prod
*/
insert into for_prod(codfor,codprod,codvend,datacad)values
();

-- (3)
alter table vendedor
add temposerviço int;

-- (4)
alter table produto
add margem int;

-- (5)
update vendedor set temposerviço = "8" where codvend = 1;
update vendedor set temposerviço = "8" where codvend = 2;
update vendedor set temposerviço = "10" where codvend = 3;
update vendedor set temposerviço = "10" where codvend = 4;
update vendedor set temposerviço = "10" where codvend = 5;
--
update produto set margem = "3" where codprod = 1;
update produto set margem = "2" where codprod = 2;
update produto set margem = "015" where codprod = 3;
update produto set margem = "3" where codprod = 4;
update produto set margem = "3" where codprod = 5;

-- (6)

select valor+((valor*margem)/100) from produto
group by codprod , nome;

-- (6)

select min(valor) from produto
group by codprod;

-- (7)

select nome
from produto
where valor >= 5000;

-- (8)

select nome
from produto
where valor <= 3000;

-- (9)

select sum(valor) from produto;

-- bonus --

select nome from produto where valor >=(select avg(valor) as medio from produto);

-- menus -- 

select * from fornecedor;
select * from vendedor;
select * from produto;
select * from for_prod;

drop table fornecedor;
drop table vendedor;
drop table produto;
drop table for_prod;