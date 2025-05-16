create database Exercicio;
use Exercicio;

create table Produto(
Codigo int primary key auto_increment,
Descricao varchar(40),
Preco Decimal(10,2),
Quantidade int,
ValorCompra Decimal(10,2));

insert into Produto(Codigo, Descricao, Preco, Quantidade, ValorCompra)
values (1, "Martelo", 15.00, 1, 15.00),
(2, "Marreta", 25.00, 2, 50.00),
(3, "Picareta", 50.00, 1, 50.00),
(4, "Pá", 15.00, 2, 30.00),
(5, "Enxada", 20.00, 1, 20.00);

select * from Produto;
drop table Produto;

select Descricao, sum(Quantidade), Preco from Produto
group by Codigo;

select Descricao, max(Quantidade), Preco from Produto
group by Codigo;

select Descricao, min(Quantidade), Preco from Produto
group by Codigo;

select Descricao, count(Quantidade), Preco from Produto
group by Codigo;

select Descricao, avg(Quantidade), Preco from Produto
group by Codigo;