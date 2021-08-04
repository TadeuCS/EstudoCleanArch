package br.com.tcs.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.tcs.escola.dominio.aluno.Aluno;
import br.com.tcs.escola.dominio.aluno.CPF;
import br.com.tcs.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {
	String nome="Teste";
	String cpf="68681333240";
	String email="teste@email.com";
	
	static RepositorioDeAlunosEmMemoria repositorio;
	static MatricularAluno useCase;
	
	@BeforeAll
	static void init() {
		repositorio= new RepositorioDeAlunosEmMemoria();
		useCase = new MatricularAluno(repositorio);
	}
	
	
	@Test
	void alunoDeveriaSerPersistido() {
		MatricularAlunoDTO dados = new MatricularAlunoDTO(nome, cpf, email);
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCPF(new CPF(cpf));
		
		assertEquals(nome, encontrado.getNome());
		assertEquals(cpf, encontrado.getCpf());
		assertEquals(email, encontrado.getEmail());
	}
	
	@Test
	void deveriaDarErroDeCpfInvalido() {
		cpf="11111111111";
		MatricularAlunoDTO dados = new MatricularAlunoDTO(nome, cpf, email);
		
		assertThrows(IllegalArgumentException.class, ()-> useCase.executa(dados));
	}
	
	@Test
	void deveriaDarErroDeEmailInvalido() {
		email="testeemail.com";
		MatricularAlunoDTO dados = new MatricularAlunoDTO(nome, cpf, email);
		
		assertThrows(IllegalArgumentException.class, ()-> useCase.executa(dados));
	}

}
