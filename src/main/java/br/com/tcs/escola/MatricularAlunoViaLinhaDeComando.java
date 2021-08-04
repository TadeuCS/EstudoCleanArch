package br.com.tcs.escola;

import br.com.tcs.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.tcs.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.tcs.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaLinhaDeComando {
	public static void main(String[] args) {
		String nome = "Fulado da Silva";
		String cpf = "101.874.696-01";
		String email = "teste@email.com";

		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
		matricular.executa(new MatricularAlunoDTO(nome, cpf, email));
	}
}
