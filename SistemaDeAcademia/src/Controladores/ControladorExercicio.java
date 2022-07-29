/**
 * 
 */
package Controladores;

import java.util.ArrayList;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;

/**
 * @author kauap
 *
 */
public class ControladorExercicio {

	public void cadastrarExercicio(String nome, int tipo, String descricao) {

		Exercicio exercicio = new Exercicio(nome, pegarTipo(tipo + 1), descricao);
		BancoDeDados.exercicios.add(exercicio);
		System.out.println("Exercicio Cadastrado");

	}

	public static ArrayList<TipoDeGrupamento> pegarTipo(int valor) {

		ArrayList<TipoDeGrupamento> grupos = new ArrayList<TipoDeGrupamento>();

		for (TipoDeGrupamento tipo : TipoDeGrupamento.values()) {
			if (tipo.getId() == valor) {
				grupos.add(tipo);
				return grupos;
			}
		}
		return null;
	}

	public static ArrayList<String> getExercicioPorTipo(ArrayList<TipoDeGrupamento> tipos) {

		ArrayList<String> retorno = new ArrayList<String>();
		for (TipoDeGrupamento grupo : tipos) {
			for (int i = 0; i < BancoDeDados.exercicios.size(); i++) {
				if (BancoDeDados.exercicios.get(i).toString().contains(grupo.name())) {
					retorno.add(BancoDeDados.exercicios.get(i).getNome());
				}
			}
		}
		return retorno;
	}

	public static Exercicio getUmExercicio(String nome) {
		for (Exercicio exercicioComparado : BancoDeDados.exercicios) {
			if (nome.equals(exercicioComparado.getNome())) {
				return exercicioComparado;
			}
		}
		return null;
	}

	public static void deletarExercicio(String nome) {
		for (int i = 0; i < BancoDeDados.exercicios.size(); i++) {
			if (BancoDeDados.exercicios.get(i).toString().equals(nome)) {
				BancoDeDados.exercicios.remove(i);
			}
		}
		for (Treino treino : BancoDeDados.treinos) {
			for (int j = 0; j < treino.getExercicios().size(); j++) {
				if (treino.getExercicios().get(j).toString().equals(nome)) {
					treino.getExercicios().remove(j);
				}
			}
		}
	}
}
