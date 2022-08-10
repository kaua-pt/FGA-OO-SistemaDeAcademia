package Controladores;

import Modelo.Aluno;
import Visao.PanelCadastroAluno;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar as ações
 * 		da tela de cadastro de aluno.
 * 
 * @see PanelCadastroAluno
 */

public class ControladorTelaCadastroAluno {

	private PanelCadastroAluno tela;
	
	/**
	 * Construtor do controlador que irá receber a tela que o chamou
	 * realizando a integração entre o frontend e o backend da respectiva
	 * tela. 
	 * 
	 * @param tela PanelCadastroAluno que chamou a tela
	 */
	public ControladorTelaCadastroAluno(PanelCadastroAluno tela) {
		this.tela = tela;
	}
	
	/**
	 * Método que irá realizar uma ação a cada vez que o usuário apertar 
	 * um botão.
	 * 
	 * Caso o usuário deseje voltar para a tela inicial, ele será direcionado
	 * para a tela de inicio por meio do controladorRedirecionar;Caso deseje
	 * cadastrar um aluno, os elementos da tela competentes a receber dados
	 * serão solicitadas para serem enviadas ao banco de dados, antes de efetivamente
	 * cadastrar o aluno, é feito uma validação para analisar se o campo de nome
	 * de aluno está vazio ou se o aluno já está cadastrado no sistema.
	 *
	 * 
	 * @param e Object contendo qual botão o usuário apertou
	 * @see Aluno
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if (((tela.getTextNomeAluno().getText().isEmpty() == false)
					&& (tela.getTextNomeAluno().getText().isBlank() == false)
					&& (Aluno.getUmAluno(tela.getTextNomeAluno().getText())) == null)) {

				cadastrarAluno(tela.getTextNomeAluno().getText(), (int) tela.getSpinIdade().getValue(),
						(double) tela.getSpinAltura().getValue(), (double) tela.getSpinPeso().getValue());
				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}
	
	/**
	 * Método responsável por cadastrar o aluno.
	 * 
	 * É criado uma instância de aluno no qual será utilizado
	 * o método de cadastro para envia-lo ao banco de dados
	 * 
	 * @param nome String contendo o nome do aluno
	 * @param idade Int contendo a idade do aluno
	 * @param altura Double contendo a altura do aluno
	 * @param peso Double contendo o peso do aluno
	 * @see Aluno
	 * @see Operacoes
	 */
	public void cadastrarAluno(String nome, int idade, double altura, double peso) {
		Aluno aluno = new Aluno(nome, idade, altura, peso);
		aluno.cadastro();
	}
}
