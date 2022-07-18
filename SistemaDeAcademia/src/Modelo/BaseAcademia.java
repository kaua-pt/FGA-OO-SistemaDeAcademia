/**
 *
 */
package Modelo;

import java.util.ArrayList;

/**
 * @author Kaua
 *
 *         Classe abstrata em que padroniza as entradas relacionadas a treinos
 */
public abstract class BaseAcademia {

	protected String nome;
	protected static ArrayList<TipoDeGrupamento> tipo;

	public BaseAcademia(String nome) {
		this.nome = nome;
	}

	public BaseAcademia(String nome, ArrayList<TipoDeGrupamento> tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static ArrayList<TipoDeGrupamento> getTipo() {
		return tipo;
	}

	public static void setTipo(ArrayList<TipoDeGrupamento> tipo) {
		BaseAcademia.tipo = tipo;
	}
}
