package br.com.alura.escola.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.FabricaDeAluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.aluno.Telefone;

public class RepositorioDeAlunosJDBC implements RepositorioDeAlunos {

	private Connection connection;

	public RepositorioDeAlunosJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(Aluno aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.setString(2, aluno.getNome());
			ps.setString(1, aluno.getEmail());
			ps.execute();

			sql = "INSERT INTO TELEFONE VALUES(?,?)";
			ps = connection.prepareStatement(sql);
			for (Telefone tel : aluno.getTelefone()) {
				ps.setString(1, tel.getDdd());
				ps.setString(2, tel.getNumero());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		Aluno aluno = new Aluno();
		try {
		String sql = 
				"SELECT a.id, a.nome, a.email, b.ddd, b.numero "
				+ "FROM ALUNO a,TELEFONE b "
				+ "WHERE a.cpf = VALUES(?) AND a.id = b.id_aluno";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, cpf.getNumero());
		
		ResultSet rs = ps.executeQuery();

		boolean encontrou = rs.next();
		if (!encontrou) {
			throw new AlunoNaoEncontrado(cpf);
		} 
		
		String nome = rs.getString("nome");
		String email = rs.getString("email");
	
		aluno = new FabricaDeAluno().comNomeCPFEmail(nome, cpf.toString(), email)
				.criar();
		
		while(rs.next()) {
			String ddd = rs.getString("ddd");
			String numero = rs.getString("numero");
			aluno.adicionarTelefone(ddd, numero);
		}
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return aluno;
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		List<Aluno> alunos = new ArrayList<>();
		try {			
			String sql = "SELECT * FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new AlunoNaoEncontrado();
			}
			
			Aluno aluno;
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String cpf = rs.getString("cpf");
			
				aluno = new FabricaDeAluno().comNomeCPFEmail(nome, cpf, email)
						.criar();
				
				alunos.add(aluno);
			}				
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return alunos;
	}

}
