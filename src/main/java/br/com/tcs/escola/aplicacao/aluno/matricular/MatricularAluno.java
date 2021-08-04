package br.com.tcs.escola.aplicacao.aluno.matricular;

import br.com.tcs.escola.dominio.aluno.Aluno;
import br.com.tcs.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
	private RepositorioDeAlunos repositorio;

	public MatricularAluno(RepositorioDeAlunos repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	public void executa(MatricularAlunoDTO dados) {
		Aluno aluno = dados.criarAluno();
		repositorio.matricular(aluno);
	}
}
