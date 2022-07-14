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
public class Aluno extends Dados {

	public int idade;
	public double altura;
	public double peso;

	public Aluno(String nome, int id, int idade, double altura, double peso) {
		this.nome = nome;
		this.id = id;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	public Aluno(String nome, int id) {
		this.nome = nome;
		this.id = id;
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
