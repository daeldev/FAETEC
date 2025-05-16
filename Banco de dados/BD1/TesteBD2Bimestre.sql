-- 5)
select Tecnico.Nome from TesteBD2Bimestre.OrdemServico
inner join Tecnico on (Tecnico.IdTecnico = TesteBD2Bimestre.OrdemServico.Tecnico_IdTecnico)
where Tecnico.Nome = "Alex";

-- 6)
select Cliente.Nome, Valor from TesteBD2Bimestre.OrdemServico
inner join Cliente on (Cliente.IdCliente = TesteBD2Bimestre.OrdemServico.Cliente_idCliente)
where Cliente.Nome = "André";

-- 7)
select nome, count(Especialidade) as Especialidades from TesteBD2Bimestre.Tecnico
group by nome, Especialidade;

-- 8)
select Tecnico.Nome, DataServico from TesteBD2Bimestre.OrdemServico
inner join Tecnico on (Tecnico.IdTecnico = TesteBD2Bimestre.OrdemServico.Tecnico_IdTecnico)
where DataServico between "2024-06-20" and "2024-06-30";