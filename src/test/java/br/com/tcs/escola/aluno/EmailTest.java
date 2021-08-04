package br.com.tcs.escola.aluno;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.tcs.escola.dominio.aluno.Email;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecosInvalidos() {
		assertThrows(IllegalArgumentException.class, ()-> new Email(null));
		assertThrows(IllegalArgumentException.class, ()-> new Email(""));
		assertThrows(IllegalArgumentException.class, ()-> new Email("emailinvalido"));
	}
	
	@Test
	void deveriaCriarEmailsComEnderecosInvalidos() {
		assertDoesNotThrow(()-> new Email("teste@gmail.com"));
	}

}
