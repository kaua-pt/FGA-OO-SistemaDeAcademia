/**
 *
 */
package Modelo;

import java.util.ArrayList;

import Controladores.BancoDeDados;

/**
 * @author Kau� Vin�cius
 *
 *         Classe respons�vel por armazenar informa��es sobre os treinos
 */

public class Treino extends BaseAcademia implements Operacoes {

	private ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
	private int nRepeticao;
	private int nSerie;

	public Treino(String nome, ArrayList<TipoDeGrupamento> tipo, ArrayList<Exercicio> exercicios, int nRepeticao,
			int nSerie) {

		super(nome, tipo);
		this.exercicios = exercicios;
		this.nRepeticao = nRepeticao;
		this.nSerie = nSerie;
	}

	@Override
	public void cadastro() {
		BancoDeDados.treinos.add(this);
	}

	@Override
	public void editar() {
		for (int i = 0; i <= BancoDeDados.treinos.size(); i++) {
			if (BancoDeDados.treinos.get(i).getNome().contains(this.getNome())) {
				BancoDeDados.treinos.set(i, this);
			}
		}
	}

	@Override
	public void deletar() {
		for (int i = 0; i <= BancoDeDados.treinos.size(); i++) {
			if (BancoDeDados.treinos.get(i).getNome().contains(this.getNome())) {
				BancoDeDados.treinos.remove(i);
			}
		}
	}

	public int getnRepeticao() {
		return nRepeticao;
	}

	public void setnRepeticao(int nRepeticao) {
		this.nRepeticao = nRepeticao;
	}

	public int getnSerie() {
		return nSerie;
	}

	public void setnSerie(int nSerie) {
		this.nSerie = nSerie;
	}

	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(ArrayList<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

}
