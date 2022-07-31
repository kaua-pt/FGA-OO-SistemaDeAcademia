/**
 *
 */
package Modelo;

import java.util.ArrayList;

/**
 * @author Kau� Vin�cius
 *
 *         Classe respons�vel por armazenar elementos da classe exerc�cio
 */
public class Exercicio extends BaseAcademia implements Operacoes {

	private String descricao;

	public Exercicio(String nome, ArrayList<TipoDeGrupamento> tipo, String descricao) {
		super(nome, tipo);
		this.descricao = descricao;
	}

	@Override
	public void cadastro() {
		BancoDeDados.exercicios.add(this);
	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar() {
		for (int i = 0; i < BancoDeDados.exercicios.size(); i++) {
			if (BancoDeDados.exercicios.get(i).toString().equals(this.getNome())) {
				BancoDeDados.exercicios.remove(i);
			}
		}
		for (Treino treino : BancoDeDados.treinos) {
			for (int j = 0; j < treino.getExercicios().size(); j++) {
				if (treino.getExercicios().get(j).toString().equals(this.getNome())) {
					treino.getExercicios().remove(j);
				}
			}
		}

	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + " " + "Tipo: " + this.getTipo().toString() + "Descricao: " + this.descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
