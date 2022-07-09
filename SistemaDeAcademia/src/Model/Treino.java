/**
 * 
 */
package Model;

/**
 * @author Kau� Vin�cius 
 *
 *	Classe respons�vel por armazenar informa��es sobre os treinos
 */
public class Treino extends Dados {
	
	Exercicio[] exercicios = new Exercicio[8];
	
	public Treino(String nome, int id, TipoDeGrupamento tipo) {
		this.nome = nome;
		this.id = id;
		this.tipo = tipo;
	}

	public Exercicio[] getExercicios() {
		return exercicios;
	}

	public void setExercicios(Exercicio[] exercicios) {
		this.exercicios = exercicios;
	}
	
}
