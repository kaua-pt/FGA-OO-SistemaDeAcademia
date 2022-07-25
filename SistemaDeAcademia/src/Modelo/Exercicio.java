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
public class Exercicio extends BaseAcademia {

	private String descricao;

	public Exercicio(String nome, ArrayList<TipoDeGrupamento> tipo, String descricao) {
		super(nome, tipo);
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + " " + "Tipo: " + this.tipo.toString() + "Descricao: " + this.descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
