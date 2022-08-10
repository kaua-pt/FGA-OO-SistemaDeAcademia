package Controladores;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Visao.PanelCadastroExercicio;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar as ações
 * 		da tela de cadastro de exercício.
 * 
 * @see PanelCadastroExercicio
 */
public class ControladorTelaCadastroExercicio {

	private PanelCadastroExercicio tela;
	
	/**
	 * Construtor do controlador que irá receber a tela que o chamou
	 * realizando a integração entre o frontend e o backend da respectiva
	 * tela. 
	 * 
	 * @param tela PanelCadastroExercicio que chamou a tela
	 */
	public ControladorTelaCadastroExercicio(PanelCadastroExercicio tela) {
		this.tela = tela;
	}
	
	/**
	 * Método que irá realizar uma ação a cada vez que o usuário apertar 
	 * um botão.
	 * 
	 * Caso o usuário deseje voltar para a tela inicial, ele será direcionado
	 * para a tela de inicio por meio do controladorRedirecionar;Caso deseje
	 * cadastrar um Exercicio, os elementos da tela competentes a receber dados
	 * serão solicitadas para serem enviadas ao banco de dados, antes de efetivamente
	 * cadastrar o exercício, é feito uma validação para analisar se o campo de nome
	 * de exercicio está vazio ou se o exercicio já está cadastrado no sistema.
	 *
	 * 
	 * @param e Object contendo qual botão o usuário apertou
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
	 * Método responsável por cadastrar o Exercício.
	 * 
	 * É criado uma instância de exercicio no qual será utilizado
	 * o método de cadastro para envia-lo ao banco de dados, para 
	 * ser criado a instância, é utilizado a função pegarTipo para 
	 * realizar a conversão do id para o grupamento muscular correspondente.
	 * 
	 * @param nome String contendo o nome do exercicio
	 * @param tipo 	Int contendo o id do grupamento muscular do exercício
	 * @param descricao String contendo a descrição do exercício
	 * 
	 * @see Exercicio
	 * @see TipoDeGrupamento
	 */
	public void cadastrarExercicio(String nome, int tipo, String descricao) {
		Exercicio exercicio = new Exercicio(nome, TipoDeGrupamento.pegarTipo(tipo + 1), descricao);
		exercicio.cadastro();
	}

}
