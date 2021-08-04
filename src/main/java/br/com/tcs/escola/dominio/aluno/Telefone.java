package br.com.tcs.escola.dominio.aluno;

public class Telefone {
	private String ddd;
	private String numero;

	public Telefone(String ddd, String numero) {
		super();
		if (!isValidDDD(ddd) || !isValidNumber(numero)) {
			throw new IllegalArgumentException("Telefone inválido");
		}
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	private static boolean isValidDDD(String ddd) {
		if (ddd == null) {
			return false;
		}
		ddd = ddd.replaceAll("\\D+", "");
		return ddd.length() == 2 || ddd.length() == 3;
	}

	private static boolean isValidNumber(String numero) {
		if (numero == null) {
			return false;
		}
		numero = numero.replaceAll("\\D+", "");
		return numero.length() == 10 || numero.length() == 11;
	}
}
