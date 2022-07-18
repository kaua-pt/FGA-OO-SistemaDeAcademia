package Controladores;

import java.util.ArrayList;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;

public class ControladorTreino {

	public void cadastrarTreino(String nome, int tipos, Exercicio[] exercicios) {

		Treino treino = new Treino(nome, pegarTipos(parearIndices(tipos + 1)), exercicios);
		BancoDeDados.treinos.add(treino);
		System.out.println("Treino Cadastrado");
	}

	public static ArrayList<TipoDeGrupamento> pegarTipos(ArrayList<Integer> valores) {
		ArrayList<TipoDeGrupamento> grupos = new ArrayList();
		for (int valor : valores) {
			for (TipoDeGrupamento tipo : TipoDeGrupamento.values()) {
				System.out.println(grupos);
				if (tipo.getId() == valor) {
					grupos.add(tipo);
				}
			}
		}
		return grupos;
	}

	public static ArrayList<Integer> parearIndices(int index) {
		System.out.println(index);
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
