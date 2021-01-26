package escola;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void testCPFInvalido() {
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("kjhhggg"));
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("656"));
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("000000000000000000000000"));
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("kjhhggg2020"));
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("20-888888"));
	}

	@Test
	void CPFValido(){
		CPF cpf = new CPF("01234567891");
		Assert.assertThat(cpf.getNumero().length(), CoreMatchers.is(11));
	}
	
}
