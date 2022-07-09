/**
 * 
 */
package Model;

/**
 * @author Kauã Vinícius
 *
 *	Enumeração para padronizar os tipos de agrupamento muscular.
 */
public enum TipoDeGrupamento {
	PEITO(1),COSTA(2),BÍCEPS(3),TRÍCEPS(4),OMBRO(5),
	QUADRÍCEPS(6),POSTERIOR(7),PANTURRILHA(8),AERÓBICO(9);
	
	private final int id;
	
	TipoDeGrupamento(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
