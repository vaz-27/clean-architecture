package br.com.alura.escola.dominio.aluno;

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
		return (numero.length() == 11 && numero.matches("[0-9]*"));
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CPF other = (CPF) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CPF [numero=" + numero + "]";
	}
}
