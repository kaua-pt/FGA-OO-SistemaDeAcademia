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
