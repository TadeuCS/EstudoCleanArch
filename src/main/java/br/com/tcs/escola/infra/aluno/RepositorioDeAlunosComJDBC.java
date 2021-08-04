package br.com.tcs.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tcs.escola.dominio.aluno.Aluno;
import br.com.tcs.escola.dominio.aluno.CPF;
import br.com.tcs.escola.dominio.aluno.FabricaDeAluno;
import br.com.tcs.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.tcs.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

	private final Connection connection;

	public RepositorioDeAlunosComJDBC(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();

			sql = "INSERT INTO ALUNO VALUES (?, ?)";
			PreparedStatement ps2 = connection.prepareStatement(sql);

			for (Telefone telefone : aluno.getTelefone()) {
				ps2.setString(1, telefone.getDdd());
				ps2.setString(2, telefone.getNumero());
				ps2.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT * FROM ALUNO WHERE CPF = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumero());
			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new AlunoNaoEncontrado(cpf);
			}

			Aluno retorno = new FabricaDeAluno()
					.comNomeCpfEmail(rs.getString("NOME"), rs.getString("CPF"), rs.getString("EMAIL"))
					.criar();
			Long id = rs.getLong("id");
			sql = "SELECT * FROM TELEFONE WHERE ALUNO_ID = ?";
			PreparedStatement ps2 = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()) {
				retorno.adicinarTelefone(rs2.getString("DDD"), rs2.getString("NUMERO"));
			}
			
			return retorno;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT * FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<Aluno>();
			while (rs.next()) {
				Aluno alunoMatriculado = new FabricaDeAluno()
						.comNomeCpfEmail(rs.getString("NOME"), rs.getString("CPF"), rs.getString("EMAIL")).criar();
				alunos.add(alunoMatriculado);
			}
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
