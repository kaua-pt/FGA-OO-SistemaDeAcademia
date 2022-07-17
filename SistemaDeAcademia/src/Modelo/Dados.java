/**
 *
 */
package Modelo;

/**
 * @author Kaua
 *
 *         Classe abstrata em que padroniza as entradas relacionadas a treinos
 */
public abstract class Dados {

	protected String nome;
	protected int id;
	protected TipoDeGrupamento tipo;

	public Dados(String nome) {
		this.nome = nome;
	}

	public Dados(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public Dados(String nome, int id, TipoDeGrupamento tipo) {
		this.nome = nome;
		this.id = id;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
