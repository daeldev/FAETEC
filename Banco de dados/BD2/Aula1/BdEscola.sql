SELECT * FROM BdEscola.Professor;
/*
select Prof_Turma.Nome, Turma.Descricao, Disciplina.nome
inner join Prof_Turma as Pt (Prof_idProfessor = Pt.P_idProfessor)
inner join Turma as T (Turma.idTurma = T.T_idTurma)
inner join Disc_Turma as Dt (Disc_Turma*/

SELECT Professor.Nome, Turma.Descricao, Disciplina.Nome from Professor
inner join Prof_Turma as pt on (Professor.idProfessor = pt.PT_idProfessor)
inner join Turma on (Turma.idTurma = pt.PT_idTurma)
inner join Disc_Turma as dt on (dt.DT_idTurma = Turma.idTurma)
inner join Disciplina on (Disciplina.idDisciplina = dt.DT_idDisciplina);