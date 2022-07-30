/**
 * 
 */
package Controladores;

import java.util.ArrayList;

import Modelo.Aluno;
import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;

/**
 * @author Kauã Vinícius
 *
 */
public class BancoDeDados {
	public static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public static ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
	public static ArrayList<Treino> treinos = new ArrayList<Treino>();

	public static String[] getTodosAlunos() {
		String retornoAluno[] = new String[alunos.size()];
		for (int i = 0; i < alunos.size(); i++) {
			retornoAluno[i] = alunos.get(i).getNome();
		}
		return retornoAluno;
	}

	public static ArrayList<String> getExercicioPorTipo(ArrayList<TipoDeGrupamento> tipos) {

		ArrayList<String> retorno = new ArrayList<String>();
		for (TipoDeGrupamento grupo : tipos) {
			for (int i = 0; i < exercicios.size(); i++) {
				if (exercicios.get(i).toString().contains(grupo.name())) {
					retorno.add(exercicios.get(i).getNome());
				}
			}
		}
		return retorno;
	}

	public static Aluno getUmAluno(String nome) {
		for (Aluno alunoComparado : BancoDeDados.alunos) {
			if (nome.equals(alunoComparado.getNome())) {
				return alunoComparado;
			}
		}
		return null;
	}

	public static Treino getUmTreino(String nome) {
		for (Treino treinoComparado : BancoDeDados.treinos) {
			if (nome.equals(treinoComparado.getNome())) {
				return treinoComparado;
			}
		}
		return null;
	}

	public static Exercicio getUmExercicio(String nome) {
		for (Exercicio exercicioComparado : BancoDeDados.exercicios) {
			if (nome.equals(exercicioComparado.getNome())) {
				return exercicioComparado;
			}
		}
		return null;
	}
}
