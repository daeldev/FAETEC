create database run;
use run;
create table tbproduto(
idproduto int primary key,
nomeproduto varchar (45),
idcategoria int,
marcaproduto varchar (40),
numeroserie varchar (60),
precounit decimal (10,0),
custounit decimal (10,2));
-- 
select * from tbproduto;
drop table tbproduto;
drop database run;
-- 
select idcategoria , count(*) from tbproduto
group by idcategoria;
-- 
/*
count = conta os valores da determinada especificação;
sum = soma todos os valores da determinada especificação;
avg = mostra a média dos valores da determinada especificação;
min = mostra o menor valor da determinada especificação;
*/
-- 
select marcaproduto, min(precounit) 
from tbproduto
where idcategoria = 3 group by marcaproduto;
-- 
/*
Exercício - 25/03 - 14:46
	com base nos dados já inseridos responda as seguintes questões:
    
a) qual a média de preço das televisões?
b) qual a televisão mais barata?
c) qual a televisão mais cara?
d) quantos microondas da Samsung existe em estoque?
e) qual a média dos telefones da Samsung?
f) qual o total da diferença do preço unitário para o custo unitário de 1 telefone celular?

*/
-- a)
select marcaproduto, avg(precounit)
from tbproduto
where idcategoria = 1 group by marcaproduto;
-- b)
select marcaproduto, min(precounit)
from tbproduto
where idcategoria = 3 group by marcaproduto;
-- c)
select marcaproduto, max(precounit)
from tbproduto
where idcategoria = 3 group by marcaproduto;
-- d)
select marcaproduto, count(*)
from tbproduto
where idcategoria = 6 group by marcaproduto;
-- e)
select marcaproduto , avg(precounit) from tbproduto
where idcategoria = 3
group by marcaproduto;
-- f)
select marcaproduto , sum(custounit - precounit)
from tbproduto
where idcategoria = 3 group by marcaproduto;