package Controladores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;

public class ControladorTreino {

	private ControladorAluno controladorA = new ControladorAluno();

	public void cadastrarTreino(String nome, int tipos, String nomeAluno, List<String> nomes, int nRep, int nSer) {

		Treino treino = new Treino(nome, pegarTipos(parearIndices(tipos)), parearExercicios(nomes), nRep, nSer);
		BancoDeDados.treinos.add(treino);
		controladorA.anexarTreino(nomeAluno, treino);
		System.out.println(treino);
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

	public static Treino getUmTreino(String nome) {
		for (Treino treinoComparado : BancoDeDados.treinos) {
			if (nome.equals(treinoComparado.getNome())) {
				return treinoComparado;
			}
		}
		return null;
	}

	public static void editarTreino(Treino treino) {
		for (int i = 0; i <= BancoDeDados.treinos.size(); i++) {
			if (BancoDeDados.treinos.get(i).getNome().contains(treino.getNome())) {
				BancoDeDados.treinos.set(i, treino);
			}
		}
	}

	public static void removerTreino(String nome) {
		for (int i = 0; i <= BancoDeDados.treinos.size(); i++) {
			if (BancoDeDados.treinos.get(i).getNome().contains(nome)) {
				BancoDeDados.treinos.remove(i);
			}
		}
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
