package modelo;

/**
 * @author Kaua Vinicius
 *
 *         Interface responsavel por receber operacoes de CRUD.
 */
public interface Operacoes {
	/**
	 * Realiza o cadastro do objeto em questao no seu respectivo banco de dados.
	 */
	void cadastro();

	/**
	 * Editar o objeto em questao em que tem uma caracteristica unica passada como
	 * endereco nos params.
	 * 
	 * @param endereco Sting contendo a característica unica do objeto que deve ser
	 *                 trocado.
	 */
	void editar(String endereco);

	/**
	 * Remove o objeto em questao do seu respectivo banco de dados.
	 */
	void deletar();
}
