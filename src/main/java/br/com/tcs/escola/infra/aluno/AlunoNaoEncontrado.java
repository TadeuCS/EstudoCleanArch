package br.com.tcs.escola.infra.aluno;

import br.com.tcs.escola.dominio.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlunoNaoEncontrado(CPF cpf) {
		super("CPF "+cpf.getNumero()+" não encontrado!");
	}
}
