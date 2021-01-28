package br.com.alura.escola.aplicacao.aluno.matricular;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Ignore
	@Test
	void testDeveriaPersistirAluno() {
		RepositorioDeAlunosEmMemoria repositorio = 
				new RepositorioDeAlunosEmMemoria();
		MatricularAluno useCase = new MatricularAluno(repositorio);
		
		MatricularAlunoDto dados = new MatricularAlunoDto(
				"bibi", "48700422211", "mmm@gmail.com");
		useCase.executar(dados);
		
		System.out.println(repositorio.listarTodosAlunosMatriculados().get(0).getCpf());
		
		Aluno encontrado = 
				repositorio.buscarPorCPF(new CPF("48700422211"));
		
		Assert.assertEquals("bibi", encontrado.getNome());
		Assert.assertEquals("mmm@gmail.com",encontrado.getEmail());
	}

}
