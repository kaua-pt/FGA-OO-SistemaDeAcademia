/**
 *
 */
package Modelo;

/**
 * @author Kau� Vin�cius
 *
 *	Classe respons�vel por armazenar elementos da classe exerc�cio
 */
public class Exercicio extends Dados{

	private String descricao;
	private int nRepeticao;
	private int nSerie;

	public Exercicio(String nome, int id,TipoDeGrupamento tipo,
			String descicao,int nRepeticao, int nSerie){
		this.nome = nome;
		this.id = id;
		this.tipo = tipo;
		this.descricao = descicao;
		this.nRepeticao = nRepeticao;
		this.nSerie = nSerie;
	}

	public Exercicio(String nome, int id,TipoDeGrupamento tipo) {
		this.nome = nome;
		this.id = id;
		this.tipo = tipo;
		this.descricao = null;
		this.nRepeticao = 0;
		this.nSerie = 0;
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
