package controladores;

import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import visao.PanelCadastroExercicio;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          cadastro de exercicio.
 * 
 * @see PanelCadastroExercicio
 */
public class ControladorTelaCadastroExercicio {

	private PanelCadastroExercicio tela;

	/**
	 * Construtor do controlador que ira receber a tela que o chamou realizando a
	 * integracao entre o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelCadastroExercicio que chamou a tela
	 */
	public ControladorTelaCadastroExercicio(PanelCadastroExercicio tela) {
		this.tela = tela;
	}

	/**
	 * Metodo que ira realizar uma acao a cada vez que o usuario apertar um botao.
	 * 
	 * Caso o usuario deseje voltar para a tela inicial, ele sera direcionado para a
	 * tela de inicio por meio do controladorRedirecionar;Caso deseje cadastrar um
	 * Exercicio, os elementos da tela competentes a receber dados serao solicitadas
	 * para serem enviadas ao banco de dados, antes de efetivamente cadastrar o
	 * exercicio, e feito uma validacao para analisar se o campo de nome de
	 * exercicio esta vazio ou se o exercicio ja esta cadastrado no sistema.
	 *
	 * 
	 * @param e Object contendo qual botão o usuario apertou
	 * @see Exercicio
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if ((tela.getNomeExercicio().getText().isBlank() == false)
					&& (tela.getNomeExercicio().getText().isEmpty() == false)
					&& (Exercicio.getUmExercicio(tela.getNomeExercicio().getText()) == null)) {

				cadastrarExercicio(tela.getNomeExercicio().getText(), tela.getComboBoxExercicio().getSelectedIndex(),
						tela.getTextArea().getText());
				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	/**
	 * Metodo responsavel por cadastrar o Exercicio.
	 * 
	 * E criado uma instancia de exercicio no qual sera utilizado o metodo de
	 * cadastro para envia-lo ao banco de dados, para ser criado a instancia, E
	 * utilizado a funcao pegarTipo para realizar a conversao do id para o
	 * grupamento muscular correspondente.
	 * 
	 * @param nome      String contendo o nome do exercicio
	 * @param tipo      Int contendo o id do grupamento muscular do exercício
	 * @param descricao String contendo a descricao do exercicio
	 * 
	 * @see Exercicio
	 * @see TipoDeGrupamento
	 */
	public void cadastrarExercicio(String nome, int tipo, String descricao) {
		Exercicio exercicio = new Exercicio(nome, TipoDeGrupamento.pegarTipo(tipo + 1), descricao);
		exercicio.cadastro();
	}

}
