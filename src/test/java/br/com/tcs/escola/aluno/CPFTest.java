package br.com.tcs.escola.aluno;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.tcs.escola.dominio.aluno.CPF;

class CPFTest {

	@Test
	void falhouAoCriarUmCPFInvalido() {
		assertThrows(IllegalArgumentException.class, ()->new CPF(null));
		assertThrows(IllegalArgumentException.class, ()->new CPF(""));
		assertThrows(IllegalArgumentException.class, ()->new CPF("fasdf"));
		assertThrows(IllegalArgumentException.class, ()->new CPF("11111122222"));
		assertThrows(IllegalArgumentException.class, ()->new CPF("111.111.222-22"));
	}
	
	@Test
	void criouUmCPFValido() {
		assertDoesNotThrow(()->new CPF("10187469601"));
		assertDoesNotThrow(()->new CPF("101.874.696.01"));
	}

}
