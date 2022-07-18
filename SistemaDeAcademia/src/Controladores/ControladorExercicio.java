/**
 * 
 */
package Controladores;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;

/**
 * @author kauap
 *
 */
public class ControladorExercicio {

	public ControladorExercicio(String nome, TipoDeGrupamento[] tipo, String descricao) {
		Exercicio exercicio = new Exercicio(nome, tipo, descricao);
		BancoDeDados.exercicios.add(exercicio);
		System.out.println("Exercicio Cadastrado");
	}

	public ControladorExercicio(String nome, TipoDeGrupamento[] tipo, String descricao, int nRepeticao, int nSerie) {

		Exercicio exercicio = new Exercicio(nome, tipo, descricao, nRepeticao, nSerie);
		BancoDeDados.exercicios.add(exercicio);
		System.out.println("Exercicio com series e repetições cadastrado");

	}

}
