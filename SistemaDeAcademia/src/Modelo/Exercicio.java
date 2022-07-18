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
	private int nRepeticao;
	private int nSerie;

	public Exercicio(String nome, ArrayList<TipoDeGrupamento> tipo, String descricao) {
		super(nome, tipo);
		this.descricao = descricao;
	}

	public Exercicio(String nome, ArrayList<TipoDeGrupamento> tipo, String descricao, int nRepeticao, int nSerie) {
		super(nome, tipo);
		this.descricao = descricao;
		this.nRepeticao = nRepeticao;
		this.nSerie = nSerie;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
