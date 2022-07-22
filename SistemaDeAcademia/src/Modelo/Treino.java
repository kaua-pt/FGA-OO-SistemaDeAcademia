/**
 *
 */
package Modelo;

import java.util.ArrayList;

/**
 * @author Kau� Vin�cius
 *
 *         Classe respons�vel por armazenar informa��es sobre os treinos
 */

public class Treino extends BaseAcademia {

	private Exercicio[] exercicios = new Exercicio[8];
	private int nRepeticao;
	private int nSerie;

	public Treino(String nome, ArrayList<TipoDeGrupamento> tipo) {
		super(nome, tipo);
	}

	public Treino(String nome, ArrayList<TipoDeGrupamento> tipo, Exercicio[] exercicios, int nRepeticao, int nSerie) {

		super(nome, tipo);
		this.exercicios = exercicios;
		this.nRepeticao = nRepeticao;
		this.nSerie = nSerie;
	}

	public int getnRepeticao() {
		return nRepeticao;
	}

	public void setnRepeticao(int nRepeticao) {
		this.nRepeticao = nRepeticao;
	}

	public int getnSerie() {
		return nSerie;
	}

	public void setnSerie(int nSerie) {
		this.nSerie = nSerie;
	}

	public Exercicio[] getExercicios() {
		return exercicios;
	}

	public void setExercicios(Exercicio[] exercicios) {
		this.exercicios = exercicios;
	}

}
