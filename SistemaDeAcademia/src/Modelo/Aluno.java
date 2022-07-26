/**
 *
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Kau� Vin�cius Classe respons�vel por armazenar as
 *         informa��es de um aluno
 *
 */
public class Aluno {

	private String nome;
	private int idade;
	private double altura;
	private double peso;
	private ArrayList<Treino> treinos = new ArrayList<Treino>();

	public Aluno(String nome, int idade, double altura, double peso) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	public Aluno(String nome, int idade, double altura, double peso, ArrayList<Treino> treinos) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
		this.treinos = treinos;
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

	public ArrayList<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(ArrayList<Treino> treinos) {
		this.treinos = treinos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
