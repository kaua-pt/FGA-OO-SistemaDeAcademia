package Controladores;

import java.util.ArrayList;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;

public class ControladorTreino {

	private Treino treinoAux;

	public void cadastrarTreino(String nome, int tipos) {
		treinoAux = new Treino(nome, pegarTipos(parearIndices(tipos)));
	}

	public void finalizarCadastro(Exercicio[] exercicios, int nRep, int nSer) {

		Treino treino = new Treino(treinoAux.getNome(), treinoAux.getTipo(), exercicios, nRep, nSer);
		BancoDeDados.treinos.add(treino);
		System.out.println("Finalizado com sucesso " + BancoDeDados.treinos.get(0).getNome());

	}

	public static ArrayList<TipoDeGrupamento> pegarTipos(ArrayList<Integer> valores) {
		ArrayList<TipoDeGrupamento> grupos = new ArrayList();
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
		ArrayList<Integer> pareador = new ArrayList();

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
