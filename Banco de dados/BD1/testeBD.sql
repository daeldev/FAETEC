create database TesteBD;
use TesteBD;

create table funcionario(
codfun int primary key not null,
prinome varchar (30),
segnome varchar (30),
ultnome varchar (30),
datanas date,
CPF varchar (30),
RG varchar (30),
endereço char (15),
CEP varchar (30),
cidade char (20),
NumeroCel varchar (15),
CodDep int,
funcao varchar (30),
salario decimal (10,2));
-- ! --
create table departamento(
Coddep int primary key not null,
nomedep varchar (30),
localizacao char (20),
CodFuncGerente int);
-- ! --
select * from funcionario;
select * from departamento;
drop table funcionario;
drop table departamento;

-- ! -- 1)
select prinome , segnome from funcionario
group by segnome;

-- ! -- 2)
select prinome , segnome , ultnome , datanas , CPF , RG , endereço , CEP , cidade , NumeroCel , CodDep , funcao , salario
from funcionario
where cidade = "RJ";

select prinome , segnome , ultnome , datanas , CPF , RG , endereço , CEP , cidade , NumeroCel , CodDep , funcao , salario
from funcionario
where cidade = "SP";

select prinome , segnome , ultnome , datanas , CPF , RG , endereço , CEP , cidade , NumeroCel , CodDep , funcao , salario
from funcionario
where cidade = "MG";

-- ! -- 3)
select prinome , segnome , ultnome , salario
from funcionario
where salario > 1000;

select prinome , segnome , ultnome , salario
from funcionario
where salario > 2000;

-- ! -- 4)
select sum(salario) from funcionario
where salario > 0;

-- ! -- 5)
select count(0)
from funcionario
where Coddep = "1";

select count(0)
from funcionario
where Coddep = "2";

select count(0)
from funcionario
where Coddep = "3";

-- ! -- 6)
select Coddep , avg(salario)
from funcionario
where Coddep = "1";

select Coddep , avg(salario)
from funcionario
where Coddep = "2";

select Coddep , avg(salario)
from funcionario
where Coddep = "3";

-- ! -- 7)
select prinome , segnome , ultnome 
from funcionario
WHERE segnome = ''
OR segnome IS null;

-- ! -- 8)
select prinome , segnome , ultnome
from funcionario
where cidade = "SP" && funcao = "Telefonista";

-- ! -- 9)
select prinome
from funcionario
where Coddep = "1";

select prinome
from funcionario
where Coddep = "2";

select prinome
from funcionario
where Coddep = "3";

-- ! -- 10)
SELECT prinome, datanas,  YEAR(CURDATE()) - YEAR(datanas) as idade FROM funcionario;