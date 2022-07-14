/**
 *
 */
package Modelo;

/**
 * @author Kau� Vin�cius
 *
 *         Enumera��o para padronizar os tipos de agrupamento muscular.
 */
public enum TipoDeGrupamento {
	PEITO(1), COSTA(2), BICEPS(3), TRICEPS(4), OMBRO(5), QUADRICEPS(6), POSTERIOR(7), PANTURRILHA(8), AEROBICO(9);

	private final int id;

	TipoDeGrupamento(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
