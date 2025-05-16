create database BDJogo;
use BDJogo;
create table tbjogo(
idjogos  int primary key,
titulo varchar(30),
empresa varchar(30),
tipo varchar(30),
anoprod int,
sistema varchar(30),
faturamento decimal (10,2),
produção int);
/*
1) insira 20 registros
2) receita total de cada jogo
3) quantidade de jogos produzidos por ano
4) média do faturamento por tipo de jogo
5) receita total por tipo de jogos ps3 , ps4 e ps5
6) quantidade de produtos por empresas
7) lucro por ano
8) empresas que produzem mais de um jogo
*/
select * from tbjogo;
drop table tbjogo;
drop database BDJogo;
-- 2)
select empresa , sum(faturamento) from tbjogo
group by empresa;
-- 3)
select anoprod , count(*) from tbjogo
group by anoprod;
-- 4)
select tipo , avg(faturamento) from tbjogo
group by tipo;
-- 5)
select tipo , sistema , sum(faturamento) from tbjogo
group by tipo having sistema = "PC" or sistema = "Xbox";
-- 6)
select empresa , count(produção) from tbjogo
group by empresa;
-- 7)
select sum(faturamento) , anoprod from tbjogo
group by anoprod;
-- 8)
select empresa , count(empresa) from tbjogo
group by empresa having count(empresa) > 1;