package br.com.tcs.escola.dominio.aluno;

public class Email {
	private String endereco;

	private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public Email(String endereco) {
		super();
		if (!isValid(endereco)) {
			throw new IllegalArgumentException("E-mail inválido");
		}
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isValid(String endereco) {
		if (endereco == null) {
			return false;
		}
		return endereco.matches(EMAIL_PATTERN);
	}
}
