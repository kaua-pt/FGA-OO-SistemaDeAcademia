/**
 *
 */
package Modelo;

import java.util.ArrayList;

/**
 * @author Kau� Vin�cius
 *
 *         Enumera��o para padronizar os tipos de agrupamento muscular.
 */
public enum TipoDeGrupamento {
	PEITO(1), COSTA(2), BICEPS(3), TRICEPS(4), OMBRO(5), QUADRICEPS(6), POSTERIOR(7), PANTURRILHA(8), AEROBICO(9);

	private final int ID;

	TipoDeGrupamento(int id) {
		this.ID = id;
	}

	public int getId() {
		return ID;
	}

	public static ArrayList<TipoDeGrupamento> pegarTipo(int valor) {

		ArrayList<TipoDeGrupamento> grupos = new ArrayList<TipoDeGrupamento>();
		for (TipoDeGrupamento tipo : TipoDeGrupamento.values()) {
			if (tipo.getId() == valor) {
				grupos.add(tipo);
				return grupos;
			}
		}
		return null;
	}
}
