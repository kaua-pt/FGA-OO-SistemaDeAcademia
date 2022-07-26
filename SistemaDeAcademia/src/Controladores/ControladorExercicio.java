/**
 * 
 */
package Controladores;

import java.util.ArrayList;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;

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

}
