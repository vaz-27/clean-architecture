package br.com.alura.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Telefone;

class TelefoneTest {

	@Test
	void testInvalido() {
		assertThrows(IllegalArgumentException.class, ()-> new Telefone(null,"552"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("451", null));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("252","akslsk"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("9k0","552"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("lalala","lL"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("323666","552"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("kdldk","222222222222"));
		assertThrows(IllegalArgumentException.class, ()-> new Telefone("kdldk",""));
	}

	@Test
	void testValido() {
		Telefone tel = new Telefone("011", "959157332");
		Telefone tel2 = new Telefone("011", "25227878");
		Assert.assertThat(tel.getNumero().length(), CoreMatchers.is(9));
		Assert.assertThat(tel2.getNumero().length(), CoreMatchers.is(8));
	}
}
