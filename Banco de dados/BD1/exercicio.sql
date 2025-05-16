create database exerciciobd;

use exerciciobd;

create table exercicio(
idresp int not null auto_increment primary key ,
nome varchar (30),
endereço varchar (20),
genero char (15),
datanasc date,
profissão char (40),
salario double ,
UR varchar (2));

insert into exercicio (nome , endereço , genero , datanasc , profissão , salario , UR) values
("Eduardo","Anchieta","Masculino","2001-04-03", "TI" , 4500 , "RJ"),
("Rafael", "Pavuna" , "Masculino","2002-07-08", "Entregador" , 1200 , "RJ"),
("Gustavo","Olinda","Masculino","2006-07-22","Militar" , 4700 , "MG"),
("Sofia", "Prudente" , "Feminino","2012-03-12", "Entregador" , 1500 , "SP"),
("Rakkel", "Prudente" , "Feminino","2001-05-17", "Manicure" , 1700 , "SP"),
("Piposo","Queimado","Masculino","2001-02-11", "Tráfego" , 2500 , "RJ"),
("Daniel", "Rolândia" , "Duvidoso","2006-08-17", "Garoto de Programa" , 250 , "PR"),
("Gael","Bangu","Masculino","2022-09-11","Militar" , 3400 , "RJ"),
("Marcia", "Olinda" , "Feminino","2011-04-17", "Streamer" , 2500 , "PE"),
("Daffany", "Olinda" , "Feminino","2014-05-21", "Biologa" , 3700 , "PE");

select * from exercicio;

alter table exercicio
add obs varchar (30);

alter table exercicio
change obs cor char (15);

-- // add dados "obs" 

update exercicio set obs = "branco" where idresp = 1;
update exercicio set obs = "preto" where idresp = 2;
update exercicio set obs = "preto" where idresp = 3;
update exercicio set obs = "branco" where idresp = 4;
update exercicio set obs = "preto" where idresp = 5;
update exercicio set obs = "preto" where idresp = 6;
update exercicio set obs = "preto" where idresp = 7;
update exercicio set obs = "preto" where idresp = 8;
update exercicio set obs = "branco" where idresp = 9;
update exercicio set obs = "preto" where idresp = 10;


alter table exercicio
add nomerua varchar (30);

-- // add dados "nomerua" -- (operadores relacionais = > , >= , < , <= , <> , =)

update exercicio set nomerua = "rua b" where idresp = 1;
update exercicio set nomerua = "rua c" where idresp = 2;
update exercicio set nomerua = "rua d" where idresp = 3;
update exercicio set nomerua = "rua b" where idresp = 4;
update exercicio set nomerua = "rua k" where idresp = 5;
update exercicio set nomerua = "rua f" where idresp = 6;
update exercicio set nomerua = "rua g" where idresp = 7;
update exercicio set nomerua = "rua h" where idresp = 8;
update exercicio set nomerua = "rua r" where idresp = 9;
update exercicio set nomerua = "rua p" where idresp = 10;

-- entre
select nome , salario
from exercicio
where salario >= 2000 and salario <= 10000;

-- entre (forma diferente)
select salario from exercicio
where salario between 1000 and 3000;

-- like (exibe dados com letra especifico "a%" , mas pode ser qualquer um com esta letra usando "%a%")
select nome from exercicio
where nome like "s%";

-- distict (remove as repetições dos dados)
select distinct nome from exercicio;

select * from exercicio where UR = "SP" or "RJ";

alter table exercicio
change salario solliq double;

drop table exercicio;

/* 
liste todos os nomes que comecem com a letra s
liste os nomes e os salarios das pessoas cujo o salario esteja entre 2k a 10k (+)
liste o nome , profissao e o salario das pessoas do RJ , MG e SP 
*/


select nome from exercicio
where nome like "m%";
-- //
select nome from exercicio
where nome like "s%";
-- //
select nome , salario
from exercicio
where salario >= 2000 and salario <= 10000;
-- //
select nome , profissão , salario
from exercicio
where UR in ( "SP" , "RJ" , "PE");
