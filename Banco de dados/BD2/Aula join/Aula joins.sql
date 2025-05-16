/* Aula de Inner Join
Junção das tabelas por igualdade de chave
*/

select C.Nome, L.Senha from Cliente as C
inner join Login as L on (C.Email = L.Cliente_Email);

/* Aula de Left Join
Retorno os registros da tabela esquerda e os registros correspondentes da tabela da direita
*/

select C.Nome, L.Senha from Cliente as C
left join Login as L on (C.Email = L.Cliente_Email);

/* Aula de Right Join
Retorna os registro da tabela direita e os registros
*/

select C.Nome, L.Senha from Cliente as C
right join Login as L on (C.Email = L.Cliente_Email);

/* Aula de Cross Join
Retorna os registro da tabela direita e os registros
*/

select C.Nome, L.Senha from Cliente as C
cross join Login as L on (C.Email = L.Cliente_Email);

/* Aula de Full Join
Retorna os registro quando houver uma correspondencia na tabela esquerda ou direita
*/

select C.Nome, L.Senha from Cliente as C
full join Login as L on (C.Email = L.Cliente_Email);