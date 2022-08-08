/**
 *
 */
package Modelo;

import java.util.ArrayList;

/**
 * @author Kaua
 * @version 1.0
 *
 *         Classe abstrata em que padroniza as entradas relacionadas a treinos
 */
public abstract class BaseAcademia {

	private String nome;
	private ArrayList<TipoDeGrupamento> tipo;

	/**
	 * Construtor da classe abstrata
	 * 
	 * @param nome
	 * @param tipo
	 */
	public BaseAcademia(String nome, ArrayList<TipoDeGrupamento> tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<TipoDeGrupamento> getTipo() {
		return tipo;
	}
}
