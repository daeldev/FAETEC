create database aulka2;

use aulka2;

create table aluno(
matricula int primary key not null,
nome varchar (30),
endereço char (30),
genero char (1),
datanasc date ,
escolaridade char (45));


create table turma(
turma int primary key not null ,
turno char (45),
qntTurma int,
descriçao varchar (30));


insert into aluno (matricula , nome , endereço , genero , datanasc , escolaridade) values
("1","Eduardo","Anchieta","M","2001-04-03","Ensino Médio 2"),
("2","Rafaela","Deodoro","F","2002-07-03","Ensino Médio 1"),
("3","Daniel","Pavuna","M","2003-02-01","Ensino Fundamental 3"),
("4","Maria Eduardo","Bangú","F","2000-07-07","Ensino Médio 1"),
("5","Patolino Pinto","Olinda","M","2003-04-03","Ensino Médio 3");


insert into turma (turma , turno , qntTurma , descriçao) values
("221","Manhã","30","Segundo Andar"),
("321","Manhã","45","Terceiro Andar"),
("211","Manhã","25","Primeiro Andar"),
("331","Manhã","45","Terceiro Andar"),
("121","Manhã","30","Segundo Andar"),
("111","Manhã","25","Primeiro Andar");


select * from aluno;
select * from turma;
select * from alunoturma;


drop table alunoturma;
drop table aluno;
drop table turma;


create table alunoturma (
idalunoturma int primary key not null,
matricula int,
turma int);


insert into alunoturma (idalunoturma , matricula , turma) values
("1","2","221"),
("2","5","321"),
("3","3","121"),
("4","1","331"),
("5","4","111");

/*
	cria a chave estrangeira com base na referencia da chave primaria
*/

alter table alunoturma 
add constraint fk_matricula
foreign key (matricula)
references aluno(matricula);

alter table alunoturma 
add constraint fk_turma
foreign key (turma)
references turma(turma);

/*
	renomeia as tabelas
*/

rename table turma to turmo;
rename table turmo to turma;

/*
	criando chave primaria
*/

alter table aluno add
constraint primary key (matricula);

select matricula , turma from alunoturma
group by turma;

/*
	funções de agregação: count() , max() , min() , avg() , sum();
    count() = contador
    max() = mostra o maior valor
    min() = 
    avg() = 
    sum() =
*/

alter table alunoturma add column
quantidade int;

update alunoturma set quantidade = 11
where matricula = 5;

