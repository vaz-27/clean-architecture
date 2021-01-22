package escola;

public class CPF {

	private String numero;

	public CPF(String numero) {
		if (numero == null || !ehValido(numero)) {
			throw new IllegalArgumentException("CPF invalido!");
		} else {
			this.numero = numero;
		}
	}
	private boolean ehValido(String numero) {
		return numero.length() == 11;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
