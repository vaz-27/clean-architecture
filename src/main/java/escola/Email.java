package escola;

public class Email {

	private String email;

	//value object = n possui id, nenhum identificador
	public Email(String email) {
		if (email == null || !ehValido(email)) {
			throw new IllegalArgumentException("Email invalido!");
		}
		else {
			this.email = email;
		}
	}
	private boolean ehValido(String email) {
		return email.contains("@") && email.contains(".com");
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
