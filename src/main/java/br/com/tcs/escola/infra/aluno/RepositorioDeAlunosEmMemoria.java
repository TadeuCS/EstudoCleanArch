package br.com.tcs.escola.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.tcs.escola.dominio.aluno.Aluno;
import br.com.tcs.escola.dominio.aluno.CPF;
import br.com.tcs.escola.dominio.aluno.RepositorioDeAlunos;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

	private List<Aluno> matriculados = new ArrayList<Aluno>();

	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(m -> m.getCpf().equals(cpf.getNumero()))
				.findFirst().orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return matriculados;
	}

}
