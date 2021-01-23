package escola;

public class Telefone {
	
	private String ddd;
	private String numero;
	
	public Telefone(String ddd, String numero) {
		if (!ehValido(ddd, numero)){
			throw new IllegalArgumentException("Telefone invalido!");
		}
		this.ddd = ddd;  
		this.numero = numero;
	}

	private boolean ehValido(String ddd, String numero) {
		return ddd == null || numero == null || 
				ddd.matches("[0-9]*") || numero.matches("[0-9]*") || 
				ddd.length() !=3 || 
				(numero.length()==8 || numero.length()==9);
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
