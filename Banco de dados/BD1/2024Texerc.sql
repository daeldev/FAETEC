create database 2024Texerc;
use 2024Texerc;

create table Vendedor(
CodVend int,
Nome varchar(50),
Telefone varchar(13));

select * from Vendedor;
drop table Vendedor;

create table Fornecedores(
CodFor int,
Nome varchar(10),
Endereco varchar(50),
Bairro varchar(30),
Uf varchar(13));

select * from Fornecedores;
drop table Fornecedores;

create table Produtos(
CodProd int,
Nome varchar(50),
Valor decimal(10,2),
DataCad date,
Qtd int,
QtdLimite int);

select * from Produtos;
drop table Produtos;

create table For_Prod;

-- 1
alter table Vendedor
add primary key (CodVend);

alter table Produtos
add primary key (CodProd);

alter table For_Prod
add constraint CodFor
foreign key (CodFor)
references Fornecedores(CodFor);

alter table For_Prod
add constraint CodProd
foreign key (CodProd)
references Produtos (CodProd);

alter table For_Prod
add constraint CodVend
foreign key (CodVend)
references Vendedor(CodVend);

alter table For_Prod
add constraint DataCad
foreign key (DataCad)
references Produtos(DataCad);

-- 2
insert into Vendedor(CodVend, Nome, Telefone)
values (72836, "Alexandre", "98727-1924"),
(85728, "Borge", "28567-9172"),
(92758, "Daniel", "96827-1029"),
(85716, "Kaio", "94728-0192"),
(95827, "João", "02958-1824");

insert into Fornecedores(CodFor, Nome, Endereco, Bairro, Uf)
values (95821, "Carlos", "Rua B", "F", "RJ"),
(26745, "Caio", "Rua C", "K", "ES"),
(28456, "João", "Rua F", "F", "BH"),
(92783, "Guilherme", "Rua E", "O", "RJ"),
(87367, "José", "Rua O", "U", "SP");

insert into Produtos(CodProd, Nome, Valor, DataCad, Qtd, QtdLimite)
values (25634, "Martelo", 15, "2024-04-02", 1, 5),
(78574, "Marreta", 20, "2023-02-07", 2, 5),
(74535, "Picareta", 40, "2024-04-23", 2, 5),
(98765, "Serrote", 18, "2024-07-13", 4, 5),
(25436, "Cimento", 30, "2023-06-23", 3, 5);

-- 3
alter table Vendedor
add TempoDeServico int;

-- 4
alter table Produtos
add Margem int;

-- 5
-- TempoDeServico
update Vendedor set TempoDeServico = 500
where CodVend = 72836;

update Vendedor set TempoDeServico = 300
where CodVend = 85728;

update Vendedor set TempoDeServico = 350
where CodVend = 92758;

update Vendedor set TempoDeServico = 120
where CodVend = 85716;

update Vendedor set TempoDeServico = 620
where CodVend = 95827;

-- Margem
update Produtos set Margem = 50
where CodProd = 25634;

update Produtos set Margem = 80
where CodProd = 78574;

update Produtos set Margem = 125
where CodProd = 74535;

update Produtos set Margem = 500
where CodProd = 98765;

update Produtos set Margem = 345
where CodProd = 25436;

-- 6
select CodProd, Nome, Valor+((Valor * Margem)/100) as "Preço" from Produtos;

-- 7
Select avg(valor) as Media from Produtos;

-- 8
select max(Valor) from Produtos;

-- 9
select min(Valor) from Produtos;

-- 10
select min(Valor) from Produtos;