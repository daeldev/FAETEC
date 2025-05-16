create database BDProva;
use BDProva;

create table TBPaciente(
IdPaciente int not null auto_increment primary key,
Nome varchar(50),
Endereco varchar(60),
Bairro varchar(30),
UF varchar(2),
DataNasc date,
Profissão varchar(30));
drop table TBPaciente;

-- 2)
select * from TBPaciente;

-- 3)
select avg(YEAR(CURDATE()) - YEAR(DTNasc)) as "Média das idades" FROM TBPaciente;

-- 4)
select count(Profissão) as "Quantidade de professores" from TBPaciente
where Profissão = "Professor";

-- 5)
select Nome from TBPaciente
where UF = "RJ";

-- 6)
alter table TBPaciente
add Salário decimal(10,2);

-- 7)
select * from TBPaciente;

-- 8)
select Bairro, count(Bairro) as "Quantidade de pacientes" from TBPaciente
group by Bairro;

-- 9)
select Nome, Salário from TBPaciente
where Salário > (select avg(Salário) from TBPaciente)
group by Salário;

-- 10) 
alter table TBPaciente
change DataNasc DTNasc date;