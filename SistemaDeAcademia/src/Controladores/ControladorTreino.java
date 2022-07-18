package Controladores;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;

public class ControladorTreino {

	public ControladorTreino(String nome, TipoDeGrupamento[] tipo, Exercicio[] exercicios) {
		Treino treino = new Treino(nome, tipo, exercicios);
		BancoDeDados.treinos.add(treino);
		System.out.println("Treino Cadastrado");
	}
}
