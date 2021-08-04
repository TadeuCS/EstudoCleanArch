package br.com.tcs.escola.aplicacao.indicacao;

import br.com.tcs.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	void enviarPara(Aluno indicado);
}
