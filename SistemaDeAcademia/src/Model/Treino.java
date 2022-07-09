/**
 * 
 */
package Model;

/**
 * @author Kauã Vinícius 
 *
 *	Classe responsável por armazenar informações sobre os treinos
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
