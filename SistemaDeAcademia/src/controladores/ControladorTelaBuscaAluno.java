package controladores;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import modelo.Aluno;
import visao.PanelBuscaAluno;
import visao.PanelEditarAluno;
import visao.PanelMenu;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de busca
 *          de alunos.
 * 
 * @see PanelBuscaAluno
 */
public class ControladorTelaBuscaAluno {

	private PanelBuscaAluno tela;
	private Aluno aluno;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param tela PanelBuscaAluno panel que chamou o controlador
	 */
	public ControladorTelaBuscaAluno(PanelBuscaAluno tela) {
		this.tela = tela;
	}

	/**
	 * Metodo que ira realizar algo caso algum botao seja pressionado na tela.
	 * 
	 * O usuario tem a funcao de voltar para o inicio do programa, Buscar um aluno,
	 * no qual ira extrair o nome do aluno que foi escrito e o buscara no banco de
	 * dados, Caso seja encontrado, o usuario pode deletar o aluno do banco de
	 * dados, ou edita-lo ultimo no qual ira leva-lo a outra tela.
	 * 
	 * @param e Object com as informacoes do botao precionado.
	 * @see Aluno
	 * @see ControladorRedirecionar
	 * @see PanelEditarAluno
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnBuscar()) {

			aluno = Aluno.getUmAluno(tela.getTextField().getText());
			if (aluno == null) {
				tela.getPanelNaoEncontrado().setVisible(true);
				tela.getPanelInfo().setVisible(false);
			} else {
				tela.getPanelNaoEncontrado().setVisible(false);
				alterarInformacoes();
				tela.getPanelInfo().setVisible(true);
			}

		} else if (e == tela.getBtnDeletar()) {

			if (aluno != null) {
				aluno.deletar();
				ControladorRedirecionar.caminho(1);
			}

		} else if (e == tela.getBtnEditar()) {
			if (aluno != null) {
				PanelEditarAluno panelEditarA = new PanelEditarAluno(aluno);
				tela.add(panelEditarA);
				panelEditarA.setVisible(true);
				tela.getPanelbase().setVisible(false);
			}

		} else if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	/**
	 * Metodo que mostra as informacoes na tela
	 * 
	 * @see PanelMenu
	 */
	public void alterarInformacoes() {

		tela.getLblIMCPessoa()
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(PanelMenu.class
								.getResource("/Imagens/" + aluno.calcularParametro().replaceAll(" ", "_") + ".png"))
						.getScaledInstance(160, 160, Image.SCALE_SMOOTH)));
		tela.getLblTreinos().setText("Treinos");
		tela.getLblNome().setText("Nome:" + aluno.getPrimeiroNome());
		tela.getLblAltura().setText("Altura:\r" + aluno.getAltura());
		tela.getLblIMC().setText(String.format("IMC:%.2f", aluno.calcularImc()));
		tela.getLblPeso().setText("Peso:\r" + aluno.getPeso());
		tela.getLblTreinos();
		tela.getLblIdade().setText("Idade:\r" + aluno.getIdade());
		tela.getSituacao().setText(aluno.calcularParametro());
		tela.getListTreinos().setModel(aluno.pegarNomesTreino());
		tela.getLblIMCPessoa().setVisible(true);
		tela.getListTreinos().setVisible(true);
	}
}
