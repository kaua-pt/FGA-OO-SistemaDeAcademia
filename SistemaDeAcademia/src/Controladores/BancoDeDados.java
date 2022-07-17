/**
 * 
 */
package Controladores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Aluno;
import Modelo.Dados;
import Modelo.Exercicio;
import Modelo.Treino;

/**
 * @author Kauã Vinícius
 *
 */
public class BancoDeDados {
	private static ArrayList<Aluno> alunos = new ArrayList();
	private static ArrayList<Exercicio> exercicios = new ArrayList();
	private static ArrayList<Treino> treinos = new ArrayList();
	private Dados variador;

	public static List<Aluno> getTodosAlunos() {
		return alunos;
	}

	public static List<Exercicio> getTodosExercicios() {
		return exercicios;
	}

	public static List<Treino> getTodosTreinos() {
		return treinos;
	}

	public static Aluno getUmAluno(String nome) {
		for (Aluno alunoComparado : alunos) {
			if (alunoComparado.getNome() == nome) {
				return alunoComparado;
			}
		}
		return null;
	}

	public static Treino getUmTreino(String nome) {
		for (Treino treinoComparado : treinos) {
			if (treinoComparado.getNome() == nome) {
				return treinoComparado;
			}
		}
		return null;
	}

	public static Exercicio getUmExercicio(String nome) {
		for (Exercicio exercicioComparado : exercicios) {
			if (exercicioComparado.getNome() == nome) {
				return exercicioComparado;
			}
		}
		return null;
	}
}
