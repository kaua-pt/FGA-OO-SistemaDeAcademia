/**
 *
 */
package Modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author Kauã Vinícius
 * @version 1.0
 *  
 * 	Classe responsável por armazenar as informações de um aluno e suas operações
 * tal classe implementa a interface Operacoes responsável pelo CRUD.
 *
 * @see Operacoes
 */
public class Aluno implements Operacoes {

	private String nome;
	private int idade;
	private double altura;
	private double peso;
	private ArrayList<Treino> treinos = new ArrayList<Treino>();
	
	/**
	 * Constutor do aluno.
	 * 
	 * @param nome
	 * @param idade
	 * @param altura
	 * @param peso
	 */
	public Aluno(String nome, int idade, double altura, double peso) {
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	/**
	 * Método no qual é calculado o IMC do aluno.
	 * 
	 * É utilizado a formula padrão para obter o imc, no qual
	 * pode ser expressa como a divisao do pelo pela altura ao quadrado
	 * 	
	 * @return double
	 */
	public double calcularImc() {
		return this.peso / ((this.altura * this.altura) / 10000);
	}
	
	/**
	 * Método no qual,abstrai o número do IMC do aluno em sua condição de 
	 * gordura corporal.
	 * 
	 * No método, é calculado novamente o imc da pessoa e com base em 
	 * outros parâmetros, é retorado uma String com a condição da pessoa.
	 * 
	 * @see calcularIMC
	 * @return String 
	 */
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

	/**
	 * Sobrescreve o método toString , constroi uma String
	 * com todos os valores de aluno.
	 * 
	 * @return String
	 */
	public String toString() {
		return "Aluno: " + this.getNome() + "Com peso: " + this.getPeso() + "Kg e altura: " + this.getAltura();
	}
	
	/**
	 * Sobrescreve o método cadastro vindo a interface operacao
	 * {@inheritDoc}
	 * 
	 * No método é apenas adicionado o aluno ao banco de dados.
	 */
	@Override
	public void cadastro() {
		BancoDeDados.getAlunos().add(this);
	}
	
	/**
	 * Sobrescreve o método cadastro vindo a interface operacao.
	 * {@inheritDoc}
	 * 
	 * No método, é percorrido todo o banco de dados de alunos, e caso
	 * o nome do aluno seja igual  a algum nome do banco de dados, este 
	 * objeto é substituido.
	 */
	@Override
	public void editar(String endereco) {
		for (int i = 0; i <= BancoDeDados.getAlunos().size(); i++) {
			if (BancoDeDados.getAlunos().get(i).getNome().equals(endereco)) {
				BancoDeDados.getAlunos().set(i, this);
				return;
			}
		}
		BancoDeDados.getAlunos().add(this);
	}
	
	/**
	 * Sobrescreve o método cadastro vindo a interface operacao.
	 * {@inheritDoc}
	 * 
	 * No método, é percorrido todo o banco de dados de aluno para encontrar
	 * o aluno que será removido, em paralelo, é removido os treinos associados
	 * a este aluno.
	 */
	@Override
	public void deletar() {
		for (int i = 0; i <= BancoDeDados.getAlunos().size(); i++) {
			if (BancoDeDados.getAlunos().get(i).getNome().contains(this.nome)) {
				for (Treino treino : BancoDeDados.getAlunos().get(i).getTreinos()) {
					for (Treino treinoaux : BancoDeDados.getTreinos()) {
						if (treinoaux.getNome().contains(treino.getNome())) {
							BancoDeDados.getTreinos().remove(treinoaux);
						}
					}
				}

				BancoDeDados.getAlunos().remove(i);
			}
		}
	}
	
	/**
	 * Método no tal retorna o nome de todos os treinos anexados ao aluno em questão.
	 * 
	 * No método é percorrido todos os treinos do aluno em questão e abstraídos os 
	 * respectivos nomes.
	 * 
	 * @return ListModel<Object>
	 */
	public ListModel<Object> pegarNomesTreino() {
		DefaultListModel<Object> retorno = new DefaultListModel<Object>();
		for (Treino treino : this.getTreinos()) {
			retorno.addElement(treino.getNome());
		}
		return retorno;
	}
	
	/**
	 * Método que retorna o primeiro nome do Aluno.
	 * 
	 * É utilizado o método split para retirar o primiero nome e
	 * retornado o primeiro index da array.
	 * 
	 * @return String
	 */
	public String getPrimeiroNome() {
		return this.nome.split(" ")[0];
	}
	
	/**
	 * Método que retorna o nome de todos os alunos cadastrados.
	 * 
	 * Neste método, é percorrido todo o banco de dados de alunos, e cada
	 * posição nome de aluno é anexado a um vetor 
	 * 
	 * @return String[]
	 */
	public static String[] getTodosAlunos() {
		String retornoAluno[] = new String[BancoDeDados.getAlunos().size()];
		for (int i = 0; i < BancoDeDados.getAlunos().size(); i++) {
			retornoAluno[i] = BancoDeDados.getAlunos().get(i).getNome();
		}
		return retornoAluno;
	}
	
	/**
	 * Método que retorna o objeto aluno com base no nome passado como 
	 * parâmetro, retorna nulo caso o aluno não seja encontrado.
	 * 
	 * @param nome String referente ao nome do aluno que deve ser encotrado
	 * @return Aluno
	 */
	public static Aluno getUmAluno(String nome) {
		for (Aluno alunoComparado : BancoDeDados.getAlunos()) {
			if (nome.equals(alunoComparado.getNome())) {
				return alunoComparado;
			}
		}
		return null;
	}
	
	// Getters e Setters
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
