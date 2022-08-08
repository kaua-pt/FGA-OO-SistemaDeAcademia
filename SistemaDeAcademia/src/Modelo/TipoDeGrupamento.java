/**
 *
 */
package Modelo;

import java.util.ArrayList;

/**
 * @author Kau� Vin�cius
 *
 *         Enumeração para padronizar os tipos de agrupamento muscular.
 *         Pode ser escolhido grupamentos como: PEITO, COSTA, BICEPS, 
 *         TRICEPS, OMBRO, QUADRICEPS, POSTERIOR, PANTURRILHA, AEROBICO
 */
public enum TipoDeGrupamento {
	
	PEITO(1), COSTA(2), BICEPS(3), TRICEPS(4), OMBRO(5), QUADRICEPS(6), POSTERIOR(7), PANTURRILHA(8), AEROBICO(9);

	private final int ID;
	
	/**
	 * Espécie de construtor do enum, utilizado para criar a relação id/nome
	 * 
	 * @param id inteiro que será utilizado para identificar um grupamento
	 */
	TipoDeGrupamento(int id) {
		this.ID = id;
	}

	/**
	 * Método no qual retorna um objeto único de TipoDeGrupamento
	 * em forma de ArrayList
	 * 
	 * É feito uma busca dentro do enum e para cada tipo é analizado
	 * se o id é igual o valor, se o valor for encontrado, reporta o 
	 * TipoDeGrupamento em questão.
	 * 
	 * @see ArrayList
	 * @param valor inteiro com o index vindo do controlador
	 * @return ArrayList<TipoDeGrupamento>
	 */
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
	
	/**
	 * Método no qual retorna uma lista de TipoDeGrupamento
	 * 
	 * O método em questao adquire o índice indo o Frontend e
	 * realiza o pareamento já pre-settado, com isso, ele apenas
	 * transforma esses valores para os enums.
	 * 
	 * @see ArrayList
	 * @param index inteiro vindo do controlador
	 * @return ArrayList<TipoDeGrupamento>
	 */
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
	
	//getter
	public int getId() {
		return ID;
	}
}
