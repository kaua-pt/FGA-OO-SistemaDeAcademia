/**
 *
 */
package Modelo;

/**
 * @author Kaua
 *
 *         Classe abstrata em que padroniza as entradas relacionadas a treinos
 */
public abstract class BaseAcademia {

	protected String nome;
	protected TipoDeGrupamento[] tipo;

	public BaseAcademia(String nome) {
		this.nome = nome;
	}

	public BaseAcademia(String nome, TipoDeGrupamento[] tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
