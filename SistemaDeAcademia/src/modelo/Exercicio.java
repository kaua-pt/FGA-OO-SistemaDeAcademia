/**
 *
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * @author Kaua Vinicius
 * @version 1.0
 *  
 * 			Classe responsavel por armazenar elementos da classe exercicio,
 *          aqui e herdado elementos da classe BaseAcademia e e implementado a
 *          classe Operacoes para o CRUD.
 * 
 * @see BaseAcademia
 * @see Operacoes
 */
public class Exercicio extends BaseAcademia implements Operacoes {

	private String descricao;

	/**
	 * Construtor da classe
	 * 
	 * @param nome
	 * @param tipo
	 * @param descricao
	 */
	public Exercicio(String nome, ArrayList<TipoDeGrupamento> tipo, String descricao) {
		super(nome, tipo);
		this.descricao = descricao;
	}

	/**
	 * Metodo toString que retorna uma string com todos os elementos do objeto
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Nome: " + this.getNome() + " Grupamento: " + this.getTipo() + " Descri��o : " + this.getDescricao();
	}

	/**
	 * Sobrescreve o metodo deletar vindo da interface operacao no qual :
	 * {@inheritDoc}
	 * 
	 * Apenas e utilizado o metodo add para adicionar um exercicio no banco de dados
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void cadastro() {
		BancoDeDados.getExercicios().add(this);
	}

	/**
	 * Sobrescreve o metodo editar vindo da interface operacao no qual :
	 * {@inheritDoc}
	 * 
	 * No presente caso, e utilizado um loop e uma estutura condicional para
	 * percorrer todo o banco de dados e ir comparando o parametro passado com o
	 * nome de cada elemento salvo, caso seja encontrado, o elemento sera
	 * substituido, feito isso para dois banco de dados, o de Exercicio e o de
	 * treinos.
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void editar(String endereco) {
		for (int i = 0; i <= BancoDeDados.getExercicios().size(); i++) {
			if (BancoDeDados.getExercicios().get(i).getNome().contains(endereco)) {
				BancoDeDados.getExercicios().set(i, this);
				return;
			}
		}
		BancoDeDados.getExercicios().add(this);
	}

	/**
	 * Sobrescreve o metodo deletar vindo da interface operacao no qual :
	 * {@inheritDoc}
	 * 
	 * No presente caso, e utilizado um loop e uma estutura condicional para
	 * percorrer todo o banco de dados e ir comparando o parametro passado com o
	 * nome de cada elemento salvo, caso seja encontrado, o presente elemento do
	 * loop sera excluido.E feito isso paradois banco de dados, o de Exercicio e o
	 * de Treinos.
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void deletar() {
		for (int i = 0; i < BancoDeDados.getExercicios().size(); i++) {
			if (BancoDeDados.getExercicios().get(i).getNome().equals(this.getNome())) {
				BancoDeDados.getExercicios().remove(i);
			}
		}
		for (Treino treino : BancoDeDados.getTreinos()) {
			for (int j = 0; j < treino.getExercicios().size(); j++) {
				if (treino.getExercicios().get(j).getNome().equals(this.getNome())) {
					treino.getExercicios().remove(j);
				}
			}
		}

	}

	/**
	 * Metodo de retorna uma lista de exercicios com base no que se foi solicitado
	 * no parametro tipo.
	 * 
	 * E percorrido todo o enum de TipoDeGrupamentos, e todo o banco de dados de
	 * exercicios simultaneamente, caso seja encontrado o grupo muscular desejado em
	 * um exercicio, o nome do mesmo e anexado dentro de uma Arraylist.
	 * 
	 * @see ArrayList
	 * @param tipos Arraylist de todos os tipos que se deseja encontrar
	 * @return ArrayList
	 */
	public static ArrayList<String> getExercicioPorTipo(ArrayList<TipoDeGrupamento> tipos) {

		ArrayList<String> retorno = new ArrayList<String>();
		for (TipoDeGrupamento grupo : tipos) {
			for (int i = 0; i < BancoDeDados.getExercicios().size(); i++) {
				if (BancoDeDados.getExercicios().get(i).toString().contains(grupo.name())) {
					retorno.add(BancoDeDados.getExercicios().get(i).getNome());
				}
			}
		}
		return retorno;
	}

	/**
	 * Retorna o objeto do exercicio desejado com base no seu nome
	 * 
	 * E percorrido todo o banco de dados e caso o nome do exercicio seja igual a
	 * String passada como parametro, o objeto do exercicio e retornado.Retorna nulo
	 * se nao for encontrado.
	 * 
	 * @param nome String com o nome do exercicio que se quer achar
	 * @return Exercicio
	 */
	public static Exercicio getUmExercicio(String nome) {
		for (Exercicio exercicioComparado : BancoDeDados.getExercicios()) {
			if (nome.equals(exercicioComparado.getNome())) {
				return exercicioComparado;
			}
		}
		return null;
	}

	/**
	 * Retorna uma lista de todos os exercicios requeridos
	 * 
	 * Utiliza-se do metodo getExercicioPorTipo para obter uma Arraylist de todos os
	 * exercicios em que se deseja abstrair do banco de dados, e apos isso e
	 * convertido todos os valores para uma Lista
	 * 
	 * @param index valor do index para ser pareado com os Grupamentos
	 * @see ArrayList
	 * @see TipoDeGrupamento
	 * @return DefaultListModel
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static DefaultListModel listaExercicio(int index) {
		ArrayList<String> stringExercicios;
		DefaultListModel listaModelo = new DefaultListModel();

		stringExercicios = Exercicio.getExercicioPorTipo(TipoDeGrupamento.parearTipos(index));
		for (String exercicio : stringExercicios) {
			listaModelo.addElement(exercicio);
		}

		return listaModelo;
	}

	/**
	 * Todo o ArrayList vira uma Lista comum.
	 * 
	 * @param nomes Lista com os nomes dos exercicios
	 * @return ArrayList
	 */
	public static ArrayList<Exercicio> parearExercicios(List<String> nomes) {
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		for (String nome : nomes) {
			for (Exercicio exercicioUnico : BancoDeDados.getExercicios()) {
				if (nome == exercicioUnico.getNome()) {
					exercicios.add(exercicioUnico);
				}
			}
		}
		return exercicios;
	}

	// Getters e Setters
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
