/**
 *
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * @author Kauã Vinícius
 * @version 1.0
 *         Classe respons�vel por armazenar elementos da classe exercício, 
 *         aqui é herdado elementos da classe BaseAcademia e é implementado
 *         a classe Operacoes para o CRUD.
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
	 * Método toString que retorna uma string com todos os elementos do objeto
	 * 
	 * @return String 
	 */
	@Override
	public String toString() {
		return "Nome: " + this.getNome() + " Grupamento: " + this.getTipo() + " Descri��o : " + this.getDescricao();
	}

	/**
	 * Sobrescreve o método deletar vindo da interface operacao no qual :
	 * {@inheritDoc}
	 * 
	 * Apenas é utilizado o método add para adicionar um exercicio no
	 * banco de dados
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void cadastro() {
		BancoDeDados.getExercicios().add(this);
	}
	
	/**
	 * Sobrescreve o método editar vindo da interface operacao no qual :
	 * {@inheritDoc}
	 * 
	 * No presente caso, é utilizado um loop e uma estutura condicional para 
	 * percorrer todo o banco de dados e ir comparando o parâmetro passado com
	 * o nome de cada elemento salvo, caso seja encontrado, o elemento será 
	 * substituído.É feito isso para dois banco de dados, o de Exercicio e o de 
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
	 * Sobrescreve o método deletar vindo da interface operacao no qual :
	 * {@inheritDoc}
	 * 
	 * No presente caso, é utilizado um loop e uma estutura condicional para 
	 * percorrer todo o banco de dados e ir comparando o parâmetro passado com
	 * o nome de cada elemento salvo, caso seja encontrado, o presente elemento
	 * do loop será excluído.É feito isso paradois banco de dados, o de Exercicio e 
	 * o de Treinos.
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void deletar() {
		for (int i = 0; i < BancoDeDados.getExercicios().size(); i++) {
			System.out.println(this.getNome());
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
	 * Método de retorna uma lista de exercícios com base no que se foi solicitado no
	 * parâmetro tipo.
	 * 
	 * É percorrido todo o enum de TipoDeGrupamentos, e todo o banco de dados de exercícios 
	 * simultaneamente, caso seja encontrado o grupo muscular desejado em um exercício, 
	 * o nome do mesmo é anexado dentro de uma Arraylist.
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
	 * Retorna o objeto do exercício desejado com base no seu nome
	 * 
	 * É percorrido todo o banco de dados e caso o nome do exercicio
	 * seja igual a String passada como parâmetro, o objeto do exercicio
	 * é retornado.Retorna nulo se não for encontrado.
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
	 * Retorna uma lista de todos os exercícios requeridos
	 * 
	 * Utiliza-se do método getExercicioPorTipo para obter uma Arraylist
	 * de todos os exercicios em que se deseja abstrair do banco de dados,
	 * e após isso é convertido todos os valores para uma Lista
	 * 
	 * @param index valor do index para ser pareado com os Grupamentos 
	 * @see Arraylist
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
	 * @param nomes Lista com os nomes dos exercícios
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
