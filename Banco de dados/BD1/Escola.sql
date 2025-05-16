create database Exercicio2;
use Exercicio2;

create table Aluno(
Matricula int primary key auto_increment,
Nome varchar (45),
Endereco varchar (45),
Genero varchar(15),
DataNasc date,
Escolaridade varchar(30));

create table Turma(
Turma int primary key auto_increment,
Turno varchar(30),
QuantidadeTurma int,
Descricao varchar (30));

create table AlunoTurma(
IDAlunoTurma int primary key not null,
Matricula int,
Turma int);

insert into Aluno(Nome, Endereco, Genero, DataNasc, Escolaridade)
values ("Alexandre", "Rua A", "M", "2001-04-20", "Ensino Médio"),
("Bluezão", "Rua H", "M", "1993-05-20", "Ensino Superior"),
("Ednaldo", "Rua U", "M", "1992-02-08", "Ensino Fundamental I"),
("Popo", "Rua J", "M", "1991-08-26", "Ensino Fundamental II"),
("Dora", "Rua H", "F", "1997-08-21", "Ensino Fundamental I");

insert into Turma(Turno, QuantidadeTurma, Descricao)
values ("Tarde", 15, "Andar 1"),
("Manhã", 30, "Andar 1"),
("Tarde", 25, "Andar 1"),
("Manhã", 32, "Andar 1"),
("Tarde", 15, "Andar 2");

insert into AlunoTurma(IDAlunoTurma, Matricula, Turma, Quantidade)
values(1, 1, 4, ),
(2, 4, 2),
(3, 5, 5),
(4, 3, 1),
(5, 2, 3),
(6, 1, 5);

select * from Aluno;
drop table Aluno;

select * from Turma;
drop table Turma;

select * from AlunoTurma;
drop table AlunoTurma;

-- Cria a chave estrangeira com base na referência da chave primária
alter table AlunoTurma
add constraint fk_matricula
foreign key (Matricula)
references Aluno(Matricula);

-- Renomeia as tabelas
rename table Turma to Turno;
rename table Turno to Turma;

-- Criado a chave primária
alter table Aluno
add constraint primary key (Matricula);

select count(Matricula), Turma from AlunoTurma
group by Turma;

-- Funções de agregação: 
-- Count() - Contagem 
-- Max() - Exibe o maior elemento
-- Min() - Exibe o menor elemento
-- Avg() - Exibe

alter table AlunoTurma
add column Quantidade int;

update AlunoTurma set Quantidade = 10
where Matricula = 1;

update AlunoTurma set Quantidade = 12
where Matricula = 2;

update AlunoTurma set Quantidade = 16
where Matricula = 3;

update AlunoTurma set Quantidade = 15
where Matricula = 4;

update AlunoTurma set Quantidade = 14
where Matricula = 5;