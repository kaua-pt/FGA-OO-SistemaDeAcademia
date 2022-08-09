/**
 *
 */
package Modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

/**
 * @author Kauã Vinícius
 *
 *         Classe responsável por armazenar informações sobre os treinos.Ela
 *         implementa a classe operacoes e herda elementos da classe
 *         BaseAcademia
 * 
 * @see BaseAcademia
 * @see Operacoes
 */

public class Treino extends BaseAcademia implements Operacoes {

	private ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
	private int nRepeticao;
	private int nSerie;

	/**
	 * Construtor da classe Treino
	 * 
	 * @param nome
	 * @param tipo
	 * @param exercicios
	 * @param nRepeticao
	 * @param nSerie
	 */
	public Treino(String nome, ArrayList<TipoDeGrupamento> tipo, ArrayList<Exercicio> exercicios, int nRepeticao,
			int nSerie) {

		super(nome, tipo);
		this.exercicios = exercicios;
		this.nRepeticao = nRepeticao;
		this.nSerie = nSerie;
	}

	/**
	 * Sobrescrita do método toString que retorna todas as informações do objeto
	 * treino
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Treino com nome: " + this.getNome() + "Com os exercicios: " + this.getExercicios();
	}

	/**
	 * Sobrescreve o método de cadastro vindo da interface operacao no qual:
	 * {@inheritDoc}
	 *
	 * No presente caso, é apenas adicionado o objeto no banco de dados de treinos.
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void cadastro() {
		BancoDeDados.getTreinos().add(this);
	}

	/**
	 * Sobrescreve o método de edição indo da interface operacao no qual:
	 * {@inheritDoc}
	 * 
	 * No presente caso, é utilizado um loop e uma estutura condicional para
	 * percorrer todo o banco de dados e ir comparando o parâmetro passado com o
	 * nome de cada elemento salvo, caso seja encontrado, será substituído o
	 * elemento atual do loop pelo objeto em que foi chamado.É feito isso para dois
	 * banco de dados, o de treino e o de alunos.
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void editar(String endereco) {
		// Editar no banco de dados de treinos
		for (int i = 0; i < BancoDeDados.getTreinos().size(); i++) {
			if (BancoDeDados.getTreinos().get(i).getNome().contains(this.getNome())) {
				BancoDeDados.getTreinos().set(i, this);
			}
		}
		// Editar no banco de dados de alunos
		for (Aluno aluno : BancoDeDados.getAlunos()) {
			for (int j = 0; j < aluno.getTreinos().size(); j++) {
				if (aluno.getTreinos().get(j).getNome().equals(endereco)) {
					aluno.getTreinos().set(j, this);
				}
			}
		}
	}

	/**
	 * Sobrescreve o método deletar vindo da interface operacao no qual :
	 * {@inheritDoc}
	 * 
	 * No presente caso, é utilizado um loop e uma estutura condicional para
	 * percorrer todo o banco de dados e ir comparando o parâmetro passado com o
	 * nome de cada elemento salvo, caso seja encontrado, o presente elemento do
	 * loop será excluído.É feito isso paradois banco de dados, o de treino e o
	 * de alunos.
	 * 
	 * @see BancoDeDados
	 */
	@Override
	public void deletar() {
		// Deletar no banco de dados de treino
		for (int i = 0; i < BancoDeDados.getTreinos().size(); i++) {
			if (BancoDeDados.getTreinos().get(i).getNome().contains(this.getNome())) {
				BancoDeDados.getTreinos().remove(i);
			}
		}
		// Deletar no banco de dados de alunos
		for (Aluno aluno : BancoDeDados.getAlunos()) {
			for (int j = 0; j < aluno.getTreinos().size(); j++) {
				if (aluno.getTreinos().get(j).getNome().contains(this.getNome())) {
					aluno.getTreinos().remove(j);
				}
			}
		}
	}

	/**
	 * Retorna o treino em que tem o seu nome igual ao parâmetro nome.
	 * 
	 * No método é percorrido cada elemento do banco de dados de treino e é
	 * comparado o nome de cada treino com a string nome, se for encontrado, ele
	 * retorna o Objeto do treino procurado, caso não, retorna null.
	 * 
	 * @param nome String relativo ao nome do treino a ser buscado
	 * @see BancoDeDados
	 * @return Treino
	 */
	public static Treino getUmTreino(String nome) {
		for (Treino treinoComparado : BancoDeDados.getTreinos()) {
			if (nome.equals(treinoComparado.getNome())) {
				return treinoComparado;
			}
		}
		return null;
	}

	/**
	 * Retorna uma String contendo os grupamentos do respectivo treino.
	 * 
	 * No método é utilizado um loop para percorrer cada elemento da arraylist de
	 * tipos, então, é feito uma substring com esses elementos na qual é
	 * retornada sem o primiero caracter de vírgula.
	 * 
	 * @see ArrayList
	 * @return String
	 */
	public String getNomesTipo() {
		String stringTipos = "";
		for (TipoDeGrupamento tipo : this.getTipo()) {
			stringTipos = stringTipos + "," + tipo.toString().toLowerCase();
		}
		return stringTipos.substring(1, stringTipos.length());
	}

	/**
	 * Retorna uma lista de Strings contendo o nome de todos os exercícios anexados
	 * ao presente treino.
	 * 
	 * No método é feito um loop dentro da ArrayList de exercicios para cada
	 * elemento é adicionado uma cópia dele em uma DefaultListModel.
	 * 
	 * @see ArrayList
	 * @see DefaultListModel
	 * @return DefaultListModel<String>
	 */
	public DefaultListModel<String> getNomesExercicios() {
		DefaultListModel<String> listaRetorno = new DefaultListModel<String>();

		for (int i = 0; i < this.getExercicios().size(); i++) {
			listaRetorno.addElement(this.getExercicios().get(i).getNome());
		}
		return listaRetorno;
	}

	/**
	 * Retorna uma string contendo o nome do aluno em que o treino está anexado
	 * 
	 * No método é realizado um loop em todo o Banco de dados de alunos, em que,
	 * para cada aluno é feito um outro loop em cima de seus treinos com a
	 * finalidade de encontrar qual aluno está anexado ao atual treino.
	 * 
	 * @see BancoDeDados
	 * @return String
	 */
	public String getAlunoAnexado() {
		for (Aluno aluno : BancoDeDados.getAlunos()) {
			for (int i = 0; i < aluno.getTreinos().size(); i++) {
				if (aluno.getTreinos().get(0).getNome().equals(this.getNome())) {
					return aluno.getNome();
				}
			}
		}
		return null;
	}

	// Getters e Setters
	public int getnRepeticao() {
		return nRepeticao;
	}

	public void setnRepeticao(int nRepeticao) {
		this.nRepeticao = nRepeticao;
	}

	public int getnSerie() {
		return nSerie;
	}

	public void setnSerie(int nSerie) {
		this.nSerie = nSerie;
	}

	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(ArrayList<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

}
