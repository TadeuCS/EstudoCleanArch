package br.com.tcs.escola.dominio.indicacao;

import java.time.LocalDateTime;

import br.com.tcs.escola.dominio.aluno.Aluno;

public class Indicacao {
	private Aluno indicado;
	private Aluno indicante;
	private LocalDateTime dtIndicacao;

	public Indicacao(Aluno indicante, Aluno indicado) {
		super();
		this.indicante = indicante;
		this.indicado = indicado;
		this.setDtIndicacao(LocalDateTime.now());
	}

	public Aluno getIndicado() {
		return indicado;
	}

	public void setIndicado(Aluno indicado) {
		this.indicado = indicado;
	}

	public Aluno getIndicante() {
		return indicante;
	}

	public void setIndicante(Aluno indicante) {
		this.indicante = indicante;
	}

	public LocalDateTime getDtIndicacao() {
		return dtIndicacao;
	}

	public void setDtIndicacao(LocalDateTime dtIndicacao) {
		this.dtIndicacao = dtIndicacao;
	}
	
}
