/**
 *
 */
package Modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author Kau� Vin�cius Classe respons�vel por armazenar as
 *         informa��es de um aluno
 *
 */
public class Aluno implements Operacoes {

	private String nome;
	private int idade;
	private double altura;
	private double peso;
	private ArrayList<Treino> treinos = new ArrayList<Treino>();

	public Aluno() {
	}

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
		return this.peso / ((this.altura * this.altura) / 10000);
	}

	public String calcularParametro() {
		double imc = calcularImc();
		if (imc < 18.5) {
			return "Abaixo do Peso";
		} else if (imc < 24.9) {
			return "Peso normal";
		} else if (imc < 29.9) {
			return "Acima do Peso";
		} else {
			return "Obesidade";
		}
	}

	@Override
	public void cadastro() {
		BancoDeDados.alunos.add(this);
		System.out.println(this);
	}

	@Override
	public void editar() {
		for (int i = 0; i <= BancoDeDados.alunos.size(); i++) {
			if (BancoDeDados.alunos.get(i).getNome().contains(this.nome)) {
				BancoDeDados.alunos.set(i, this);
			}
		}
	}

	@Override
	public void deletar() {
		for (int i = 0; i <= BancoDeDados.alunos.size(); i++) {
			if (BancoDeDados.alunos.get(i).getNome().contains(this.nome)) {
				BancoDeDados.alunos.remove(i);
			}
		}
	}

	public ListModel<Object> pegarNomesTreino() {
		DefaultListModel<Object> retorno = new DefaultListModel<Object>();
		for (Treino treino : this.getTreinos()) {
			retorno.addElement(treino.getNome());
		}
		return retorno;
	}

	public String getPrimeiroNome() {
		return this.nome.split(" ")[0];
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
