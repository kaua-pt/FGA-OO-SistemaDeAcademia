package Controladores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Aluno;
import Modelo.Treino;

public class ControladorAluno {

	public void cadastrarAluno(String nome, int idade, double altura, double peso) {
		Aluno aluno = new Aluno(nome, idade, altura, peso);
		BancoDeDados.alunos.add(aluno);
		System.out.println("Aluno cadastrado " + aluno.getPeso());
	}

	public void anexarTreino(String alunoNome, Treino treinos) {
		ArrayList<Treino> adicionar = new ArrayList<Treino>();
		for (Aluno aluno : BancoDeDados.alunos) {
			if (aluno.getNome() == alunoNome) {
				adicionar.addAll(aluno.getTreinos());
				if (adicionar.size() < 4) {
					adicionar.add(treinos);
				} else {
					System.out.println("Aluno Sobrecarregado");
				}
				aluno.setTreinos(adicionar);
			}
		}
	}

	public static void editarAluno(Aluno aluno) {
		for (int i = 0; i <= BancoDeDados.alunos.size(); i++) {
			if (BancoDeDados.alunos.get(i).getNome().contains(aluno.getNome())) {
				BancoDeDados.alunos.set(i, aluno);
			}
		}
	}

	public static Aluno getUmAluno(String nome) {
		for (Aluno alunoComparado : BancoDeDados.alunos) {
			if (nome.equals(alunoComparado.getNome())) {
				return alunoComparado;
			}
		}
		return null;
	}

	public static void removerAluno(String nome) {
		for (int i = 0; i <= BancoDeDados.alunos.size(); i++) {
			if (BancoDeDados.alunos.get(i).getNome().contains(nome)) {
				BancoDeDados.alunos.remove(i);
			}
		}
	}

	public static List<Aluno> listarAlunos() {
		return BancoDeDados.alunos;
	}

}
