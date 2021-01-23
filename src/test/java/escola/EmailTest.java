package escola;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class EmailTest {
	
	@Test
	void naoDeveriaCriarEmailsInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new Email(null));
		assertThrows(IllegalArgumentException.class, () -> new Email(""));
		assertThrows(IllegalArgumentException.class, () -> new Email("amiguinha.com"));
		assertThrows(IllegalArgumentException.class, () -> new Email("amiguinha.@"));
	}
	
	@Test
	void deveriaCriarEmailValido() {
		Email email = new Email("biabia@gmail.com");
		Assert.assertEquals("biabia@gmail.com", email.getEmail());
	}

}
