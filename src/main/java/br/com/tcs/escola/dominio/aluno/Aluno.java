package br.com.tcs.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private CPF cpf;
	private String nome;
	private Email email;
	private String senha;
	private List<Telefone> telefone=new ArrayList<>();
	
	public Aluno(CPF cpf, String nome, Email email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	public void adicinarTelefone(String ddd, String numero) {
		this.telefone.add(new Telefone(ddd, numero));
	}

	public String getCpf() {
		return cpf.getNumero();
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email.getEndereco();
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
}
