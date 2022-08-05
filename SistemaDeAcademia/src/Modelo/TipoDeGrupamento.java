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

	public static ArrayList<TipoDeGrupamento> parearTipos(int index) {
		ArrayList<Integer> pareador = new ArrayList<Integer>();
		ArrayList<TipoDeGrupamento> grupos = new ArrayList<TipoDeGrupamento>();

		switch (index) {
		case 0:
			pareador.add(1);
			pareador.add(4);
			pareador.add(5);
			break;
		case 1:
			pareador.add(2);
			pareador.add(3);
			break;
		case 2:
			pareador.add(6);
			pareador.add(7);
			pareador.add(8);

			break;
		case 3:
			pareador.add(9);
			break;
		}

		for (int valor : pareador) {
			for (TipoDeGrupamento tipo : TipoDeGrupamento.values()) {
				if (tipo.getId() == valor) {
					grupos.add(tipo);
				}
			}
		}
		return grupos;
	}
}
