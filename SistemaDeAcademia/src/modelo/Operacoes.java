package modelo;

/**
 * @author Kauã Vinícius
 *
 * Interface responsável por receber operações de CRUD.
 */
public interface Operacoes {
	/**
	 * Realiza o cadastro do objeto em questão no seu respectivo banco de dados.
	 */
	void cadastro();
	
	/**
	 * Editar o objeto em questão em que tem uma característica única passada 
	 * como endereço nos params.
	 * 
	 * @param endereco Sting contendo a característica unica do objeto que deve
	 * ser trocado.
 	 */
	void editar(String endereco);

	/**
	 * Remove o objeto em questão do seu respectivo banco de dados.
	 */
	void deletar();
}
