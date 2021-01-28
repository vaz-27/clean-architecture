package br.com.alura.escola;

import java.util.Scanner;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaComando {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***MATRICULAS***\n\nNome do Aluno: ");
		String nome = sc.next();
		System.out.println("CPF: ");
		String cpf = sc.next();
		System.out.println("E-mail: ");
		String email = sc.next();
		
		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
		
		matricular.executar(new MatricularAlunoDto(nome, cpf, email));
		
		System.out.println("Dados preenchidos com sucesso!\nSua Matricula foi efetivada!");
		
		sc.close();
	}

}
