package br.com.tcs.escola.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.tcs.escola.dominio.aluno.Telefone;

class TelefoneTest {

	@Test
	void falhouAoCriarTelefoneComNumeroInvalido() {
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("034", null));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("034", ""));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("034", "afsdfa"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("034", "1234"));
	}
	@Test
	void falhouAoCriarTelefoneComDDDInvalido() {
		assertThrows(IllegalArgumentException.class, ()-> new Telefone(null, "92898572"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("", "92898572"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("asd", "92898572"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("1", "92898572"));
	}
	@Test
	void criarTelefoneComDDDeNumeroValido() {
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("34", "38222222"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("34", "3822-2222"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("34", "99289-8572"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("034", "99289-8572"));
	}

}
