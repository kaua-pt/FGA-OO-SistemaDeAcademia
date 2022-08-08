package Modelo;

import java.util.ArrayList;

/**
 * @author Kauã Vinícius
 * 
 * 		Classe responsável por armanezar todos os bancos de dados
 * 
 */
public class BancoDeDados {
	
	/**
	 * Lista onde é armazenado todos os alunos, tal elemento deve
	 * ser acessado mediante getters e não pode ser instânciado novamente
	 */
	private final static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	/**
	 * Lista onde é armazenado todos os exercícios, tal elemento deve
	 * ser acessado mediante getters e não pode ser instânciado novamente
	 */
	private final static ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
	
	/**
	 * Lista onde é armazenado todos os treinos, tal elemento deve
	 * ser acessado mediante getters e não pode ser instânciado novamente
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
