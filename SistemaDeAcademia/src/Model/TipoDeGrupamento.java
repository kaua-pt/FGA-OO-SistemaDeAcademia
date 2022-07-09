/**
 * 
 */
package Model;

/**
 * @author Kau� Vin�cius
 *
 *	Enumera��o para padronizar os tipos de agrupamento muscular.
 */
public enum TipoDeGrupamento {
	PEITO(1),COSTA(2),B�CEPS(3),TR�CEPS(4),OMBRO(5),
	QUADR�CEPS(6),POSTERIOR(7),PANTURRILHA(8),AER�BICO(9);
	
	private final int id;
	
	TipoDeGrupamento(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
