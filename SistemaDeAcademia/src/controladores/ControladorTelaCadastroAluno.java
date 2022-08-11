package controladores;

import modelo.Aluno;
import modelo.Operacoes;
import visao.PanelCadastroAluno;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          cadastro de aluno.
 * 
 * @see PanelCadastroAluno
 */

public class ControladorTelaCadastroAluno {

	private PanelCadastroAluno tela;

	/**
	 * Construtor do controlador que ira receber a tela que o chamou realizando a
	 * integracao entre o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelCadastroAluno que chamou a tela
	 */
	public ControladorTelaCadastroAluno(PanelCadastroAluno tela) {
		this.tela = tela;
	}

	/**
	 * Metodo que ira realizar uma acao a cada vez que o usuario apertar um botao.
	 * 
	 * Caso o usuario deseje voltar para a tela inicial, ele sera direcionado para a
	 * tela de inicio por meio do controladorRedirecionar;Caso deseje cadastrar um
	 * aluno, os elementos da tela competentes a receber dados serao solicitadas
	 * para serem enviadas ao banco de dados, antes de efetivamente cadastrar o
	 * aluno, E feito uma validacao para analisar se o campo de nome de aluno esta
	 * vazio ou se o aluno ja esta cadastrado no sistema.
	 *
	 * 
	 * @param e Object contendo qual botao o usuario apertou
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
	 * Metodo responsavel por cadastrar o aluno.
	 * 
	 * E criado uma instancia de aluno no qual sera utilizado o metodo de cadastro
	 * para envia-lo ao banco de dados
	 * 
	 * @param nome   String contendo o nome do aluno
	 * @param idade  Int contendo a idade do aluno
	 * @param altura Double contendo a altura do aluno
	 * @param peso   Double contendo o peso do aluno
	 * @see Aluno
	 * @see Operacoes
	 */
	public void cadastrarAluno(String nome, int idade, double altura, double peso) {
		Aluno aluno = new Aluno(nome, idade, altura, peso);
		aluno.cadastro();
	}
}
