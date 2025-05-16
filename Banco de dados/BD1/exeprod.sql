create database exeprod;

use exeprod;

create table prod(
codigo int primary key not null,
descriçao char (45),
preco decimal(10,2),
quantidade int,
valorcompra decimal (10,2));

insert into prod (codigo,descriçao,preco,quantidade,valorcompra) values
("1","PÁ","21","1","21"),
("2","enxada","40","2","80"),
("3","cimento","10","5","50"),
("4","ajudante","120","3","360"),
("5","tinta","30","3","90");

select * from prod;

drop table prod;

select descriçao , min(quantidade) , valorcompra from prod
group by codigo;
