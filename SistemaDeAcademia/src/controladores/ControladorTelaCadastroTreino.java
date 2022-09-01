package controladores;

import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;
import modelo.BancoDeDados;
import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import modelo.Treino;
import visao.PanelCadastroTreino;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          cadastro de treino.
 * 
 * @see PanelCadastroTreino
 */
@SuppressWarnings("unchecked")
public class ControladorTelaCadastroTreino {

	private PanelCadastroTreino tela;

	/**
	 * Construtor do controlador que ira receber a tela que o chamou realizando a
	 * integracao entre o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelCadastroTreino que chamou a tela
	 */
	public ControladorTelaCadastroTreino(PanelCadastroTreino tela) {
		this.tela = tela;
	}

	/**
	 * Metodo que ira realizar uma acao a cada vez que o usuario apertar um botao.
	 * 
	 * Caso o usuario deseje voltar para a tela inicial, ele sera direcionado para a
	 * tela de inicio por meio do controladorRedirecionar;Caso deseje cadastrar um
	 * treino, os elementos da tela competentes a receber dados serao solicitadas
	 * para serem enviadas ao banco de dados, antes de efetivamente cadastrar o
	 * treino, e feito uma validacao para analisar se o campo de nome de treino esta
	 * vazio , se o treino ja esta cadastrado no sistema, se a lista de Exercicios
	 * esta vazia ou se nenhum aluno foi selecionado.Ha tambem a funcao para
	 * alternar oque o usuario vera na tela em questao, caso o botao exercicio seje
	 * apertado, o programa ira mostrar para o usuario elementos como a lista de
	 * exercicios compativeis com o grupamento do treino nos quais podera escolhar
	 * um numero de repeticoes e series, entretanto, caso deseje voltar para a tela
	 * inicial de cadastro de exercicio, o botao voltar deve ser acionado.
	 *
	 * 
	 * @param e Object contendo qual botao o usuario apertou
	 * @see Aluno
	 * @see Treino
	 * @see Exercicio
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if ((tela.getTextField().getText().isBlank() == false) && (tela.getTextField().getText().isEmpty() == false)
					&& (Treino.getUmTreino(tela.getTextField().getText()) == null)
					&& (tela.getListExerciciosTreino().getSelectedIndices().length > 0)
					&& (Aluno.getUmAluno(tela.getComboAluno().getSelectedItem().toString()).getTreinos().size() < 5)) {

				cadastrarTreino(tela.getTextField().getText(), tela.getComboGrupo().getSelectedIndex(),
						tela.getComboAluno().getSelectedItem().toString(),
						tela.getListExerciciosTreino().getSelectedValuesList(), (int) tela.getSpinRep().getValue(),
						(int) tela.getSpinSerie().getValue());

				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnExercicios()) {

			tela.getListExerciciosTreino().setModel(Exercicio.listaExercicio(tela.getComboGrupo().getSelectedIndex()));
			tela.getPanelMain1().setVisible(false);
			tela.getPanelMain2().setVisible(true);

		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain1().setVisible(true);
			tela.getPanelMain2().setVisible(false);
		}
	}

	/**
	 * Metodo responsavel por cadastrar o Treino.
	 * 
	 * E criado uma instancia de treino no qual sera utilizado o metodo de cadastro
	 * para envia-lo ao banco de dados, para ser criado a instancia, e utilizado a
	 * funcao parearTipos para realizar a conversao do id para o grupamento
	 * muscular correspondente. Logo apos, e realizado a anexacao do aluno ao treino
	 * cadastrado.
	 * 
	 * @param nome      String contendo o nome do treino
	 * @param tipos     Int contendo o id dos grupamentos musculares do treino
	 * @param nomeAluno String contendo o nome do aluno que recebera o treino
	 * @param nomes     List contendo o nome dos exercicios do treino
	 * @param nRep      Int contendo o numero de repeticoes do treino
	 * @param nSer      Int contendo o numero de series do treino
	 * 
	 * @see Treino
	 * @see Exercicio
	 * @see TipoDeGrupamento
	 * @see anexarTreino
	 */
	public void cadastrarTreino(String nome, int tipos, String nomeAluno, List<String> nomes, int nRep, int nSer) {

		Treino treino = new Treino(nome, TipoDeGrupamento.parearTipos(tipos), Exercicio.parearExercicios(nomes), nRep,
				nSer);
		treino.cadastro();
		anexarTreino(nomeAluno, treino);
	}

	/**
	 * Metodo responsavel por anexar o treino ao seu respectivo aluno.
	 * 
	 * E feito uma busca do nome do aluno no banco de dados,e caso o aluno tenha
	 * menos que 3 treinos um novo treino sera adicionado para ele, caso nao, os
	 * treinos do aluno se manterao o mesmo.
	 * 
	 * @param alunoNome String contendo o nome do aluno que recebera o treino
	 * @param treinos   Treino contendo o treino que o aluno recebera
	 * @see Aluno
	 * @see BancoDeDados
	 */
	public void anexarTreino(String alunoNome, Treino treinos) {
		ArrayList<Treino> adicionar = new ArrayList<Treino>();
		for (Aluno aluno : BancoDeDados.getAlunos()) {
			if (aluno.getNome() == alunoNome) {
				adicionar.addAll(aluno.getTreinos());
				if (adicionar.size() < 4) {
					adicionar.add(treinos);
				}
				aluno.setTreinos(adicionar);
			}
		}
	}

}
