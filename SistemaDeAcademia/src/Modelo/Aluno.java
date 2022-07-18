/**
 *
 */
package Modelo;

/**
 *
 * @author Kau� Vin�cius Classe respons�vel por armazenar as informa��es de um
 *         aluno
 *
 */
public class Aluno {

	private String nome;
	private int idade;
	private double altura;
	private double peso;
	private Treino[] treino = new Treino[4];

	public Aluno(String nome, int idade, double altura, double peso) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	public Aluno(String nome, int idade, double altura, double peso, Treino treino[]) {
		this.nome = nome;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Treino[] getTreino() {
		return treino;
	}

	public void setTreino(Treino[] treino) {
		this.treino = treino;
	}
}
