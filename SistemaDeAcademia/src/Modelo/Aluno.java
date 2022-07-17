/**
 *
 */
package Modelo;

/**
 *
 * @author Kau� Vin�cius Classe respons�vel por armazenar as
 *         informa��es de um aluno
 *
 */
public class Aluno extends Dados {

	private int idade;
	private double altura;
	private double peso;
	private Treino[] treino = new Treino[4];

	public Aluno(String nome, int idade, double altura, double peso) {
		super(nome);
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	public Aluno(String nome, int id, int idade, double altura, double peso, Treino treino[]) {
		super(nome, id);
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
		this.treino = treino;
	}

	public double calcularImc() {
		return this.peso / (this.altura * this.altura);
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
