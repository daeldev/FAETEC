create database 2024exerciciosTarde;
use 2024exerciciosTarde;

Create table socio(
Idsocio int not null primary key,
Nome varchar(50),
Endereco varchar(70),
Num int,
Genero varchar(1),
Datanasc date);

insert into socio(Idsocio, Nome, Endereco, Num, Genero, Datanasc)
values (1, "João", "Rua a", 6, "M", "2005-02-20"),
(8, "Maria", "Rua f", 9, "F", "1998-03-18"),
(5, "Alex", "Rua g", 0, "M", "1960-05-04"),
(3, "Bluezão", "Rua h", 1, "M", "1988-09-30"),
(4, "Marivaldo", "Rua r", 2, "M", "1996-06-08");

Select * from socio;

update socio set Nome = "Alexandre Borges"
where Idsocio = 1;

Delete from socio where Idsocio = 1;

Alter Table socio
add E_mail varchar(20);

Alter table socio
change E_mail E_mail varchar(70);

Alter table socio
change E_mail Email varchar(70);

Alter Table socio
add Teste int;

Alter Table socio
drop Teste;

describe socio;

drop table socio;