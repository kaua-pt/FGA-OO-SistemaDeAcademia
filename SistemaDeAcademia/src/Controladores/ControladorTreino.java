package Controladores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;

public class ControladorTreino {

	private Treino treinoAux;
	private ControladorAluno controladorA = new ControladorAluno();
	private String nomeAlunoAux;

	public void cadastrarTreino(String nome, int tipos, String nomeAluno) {
		treinoAux = new Treino(nome, pegarTipos(parearIndices(tipos)));
		nomeAlunoAux = nomeAluno;
	}

	public void finalizarCadastro(List<String> nomes, int nRep, int nSer) {

		Treino treino = new Treino(treinoAux.getNome(), treinoAux.getTipo(), parearExercicios(nomes), nRep, nSer);
		BancoDeDados.treinos.add(treino);
		controladorA.anexarTreino(nomeAlunoAux, treino);
		System.out.println("Finalizado com sucesso");

	}

	public static ArrayList<Exercicio> parearExercicios(List<String> nomes) {
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		for (String nome : nomes) {
			for (Exercicio exercicioUnico : BancoDeDados.exercicios) {
				if (nome == exercicioUnico.getNome()) {
					exercicios.add(exercicioUnico);
				}
			}
		}
		System.out.println(exercicios);
		return exercicios;
	}

	public static ArrayList<TipoDeGrupamento> pegarTipos(ArrayList<Integer> valores) {
		ArrayList<TipoDeGrupamento> grupos = new ArrayList<TipoDeGrupamento>();
		for (int valor : valores) {
			for (TipoDeGrupamento tipo : TipoDeGrupamento.values()) {
				if (tipo.getId() == valor) {
					grupos.add(tipo);
				}
			}
		}
		System.out.println(grupos);
		return grupos;
	}

	public static ArrayList<Integer> parearIndices(int index) {
		ArrayList<Integer> pareador = new ArrayList<Integer>();

		switch (index) {
		case 0:
			pareador.add(1);
			pareador.add(4);
			pareador.add(5);
			break;
		case 1:
			pareador.add(2);
			pareador.add(3);
			break;
		case 2:
			pareador.add(6);
			pareador.add(7);
			pareador.add(8);

			break;
		case 3:
			pareador.add(9);
			break;
		}
		return pareador;
	}
}
