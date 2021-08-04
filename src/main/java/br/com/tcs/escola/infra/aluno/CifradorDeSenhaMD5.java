package br.com.tcs.escola.infra.aluno;

import java.math.BigInteger;
import java.security.MessageDigest;

import br.com.tcs.escola.dominio.aluno.CifradorDeSenha;

public class CifradorDeSenhaMD5 implements CifradorDeSenha {
	
	@Override
	public String cifrarSenha(String senha) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(senha.getBytes());
			return new BigInteger(1,md5.digest()).toString(16);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao gerar a hash md5");
		}
	}

	@Override
	public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
		return senhaCifrada.equalsIgnoreCase(cifrarSenha(senha));
	}

}
