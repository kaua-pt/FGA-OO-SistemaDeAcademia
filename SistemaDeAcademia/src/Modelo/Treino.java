/**
 *
 */
package Modelo;

/**
 * @author Kau� Vin�cius
 *
 *         Classe respons�vel por armazenar informa��es sobre os treinos
 */

public class Treino extends BaseAcademia {

	Exercicio[] exercicios = new Exercicio[8];

	public Treino(String nome, TipoDeGrupamento[] tipo, Exercicio[] exercicios) {
		super(nome, tipo);
		this.exercicios = exercicios;
	}

	public Exercicio[] getExercicios() {
		return exercicios;
	}

	public void setExercicios(Exercicio[] exercicios) {
		this.exercicios = exercicios;
	}

}
