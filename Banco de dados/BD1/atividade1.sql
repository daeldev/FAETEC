create database 2024exerciciotarde;
-- //
use 2024exerciciotarde;
-- //
create table sociop(
idsocio int not null auto_increment primary key ,
nome varchar (50),
endereço varchar (70),
numero int,
genero varchar (1),
datanasc date);
-- // ano , mes e dia
insert into sociop (nome , endereço , numero , genero , datanasc)
values ("Eduardo","Rua B",7,"M","2001-05-03"),
("Rafaela","Rua C",12,"F","2001-02-01"),
("Oruam","Rua D",15,"M","1996-05-12"),
("Gustavo","Rua Z",22,"M","2004-07-22"),
("Alexandre","Rua P",32,"M","2015-01-06");
-- //
select * from sociop;
-- //
update sociop set  nome = "Fernanda" where  idsocio = 2;
-- //
delete from sociop where idsocio = 5;
-- //
alter table sociop
add Email varchar (20);
-- //
alter table sociop
modify Email varchar (70);
-- //
describe sociop;
-- //
alter table sociop
change Email gmail varchar(70);
-- //
alter table sociop
add teste int;
-- //
alter table sociop
drop teste;
-- //
drop table sociop;