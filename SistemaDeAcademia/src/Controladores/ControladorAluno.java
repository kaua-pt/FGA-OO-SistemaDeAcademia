package Controladores;

import java.util.List;

import Modelo.Aluno;

public class ControladorAluno {

	public void CadastrarAluno(String nome, int idade, double altura, double peso) {
		Aluno aluno = new Aluno(nome, idade, altura, peso);
		BancoDeDados.alunos.add(aluno);
		System.out.println("Aluno cadastrado");
	}

	public static List<Aluno> listarAlunos() {
		return BancoDeDados.alunos;
	}
}
