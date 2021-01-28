package br.com.alura.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;

class AlunoTest {
	
	CPF cpf = new CPF("48748748700");
	Email email = new Email("bibi@gmail.com");

	@Ignore
	@Test
	void testNomeInvalido() {
		assertThrows(IllegalStateException.class,() -> new Aluno(cpf, null,email));
		assertThrows(IllegalStateException.class,() -> new Aluno(cpf, "",email));
		assertThrows(IllegalStateException.class,() -> new Aluno(cpf, "haha744",email));
		assertThrows(IllegalStateException.class,() -> new Aluno(cpf, "54545",email));
		assertThrows(IllegalStateException.class,() -> new Aluno(cpf, "hhh%$%",email));
	}

}
