package modelo;

import java.util.ArrayList;

/**
 * @author Kaua Vinicius
 * 
 *         Classe responsavel por armanezar todos os bancos de dados
 * 
 */
public class BancoDeDados {

	/**
	 * Lista onde e armazenado todos os alunos, tal elemento deve ser acessado
	 * mediante getters e nao pode ser instanciado novamente
	 */
	private final static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	/**
	 * Lista onde e armazenado todos os exercicios, tal elemento deve ser acessado
	 * mediante getters e nao pode ser instanciado novamente
	 */
	private final static ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();

	/**
	 * Lista onde e armazenado todos os treinos, tal elemento deve ser acessado
	 * mediante getters e nao pode ser instanciado novamente
	 */
	private final static ArrayList<Treino> treinos = new ArrayList<Treino>();

	// Getters
	public static ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public static ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	public static ArrayList<Treino> getTreinos() {
		return treinos;
	}

}
