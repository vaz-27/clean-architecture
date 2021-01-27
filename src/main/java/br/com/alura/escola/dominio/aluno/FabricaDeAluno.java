package br.com.alura.escola.dominio.aluno;

public class FabricaDeAluno {
	
	//padrao builder
	
	private Aluno aluno;
	
	protected FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
		this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
		return this;
	}
	
	protected FabricaDeAluno comTelefone(String ddd, String numero) {
		this.aluno.adicionarTelefone(ddd, numero);
		return this;
	}
		
	public Aluno criar() {
		return this.aluno;  
	}

}
