/**
 * 
 */
package Controladores;

import java.util.ArrayList;

import Modelo.Aluno;
import Modelo.Exercicio;
import Modelo.Treino;

/**
 * @author Kauã Vinícius
 *
 */
public class BancoDeDados {
	public static ArrayList<Aluno> alunos = new ArrayList();
	public static ArrayList<Exercicio> exercicios = new ArrayList();
	public static ArrayList<Treino> treinos = new ArrayList();

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
