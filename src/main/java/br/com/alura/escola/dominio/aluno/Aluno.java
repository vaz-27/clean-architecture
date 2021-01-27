package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private CPF cpf;
	private String nome;
	private Email email;
	
	private List<Telefone> telefones = new ArrayList<>();
	
	private String senha;
	
	public Aluno() {
	}
		
	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}
	
	public void adicionarTelefone(String ddd, String numero) {
		this.telefones.add(new Telefone(ddd, numero));
	}

	public String getCpf() {
		return cpf.toString();
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email.toString();
	}

	public List<Telefone> getTelefone() {
		return telefones;
	}
	
	public String getSenha() {
		return senha;
	}
}

