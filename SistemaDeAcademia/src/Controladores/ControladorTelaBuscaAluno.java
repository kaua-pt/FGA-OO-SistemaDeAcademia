package Controladores;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import Modelo.Aluno;
import Visao.PainelMenu;
import Visao.PanelBuscaAluno;

public class ControladorTelaBuscaAluno {

	private PanelBuscaAluno tela;
	private Aluno aluno;
	private ControladorRedirecionar controlador;

	public ControladorTelaBuscaAluno(PanelBuscaAluno tela, ControladorRedirecionar controlador) {
		this.tela = tela;
		this.controlador = controlador;
	}

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
				controlador.caminho(1);
			}

		} else if (e == tela.getBtnEditar()) {
			controlador.caminho(1);
		} else if (e == tela.getBtnVoltar()) {
			controlador.caminho(1);
		}
	}

	public void alterarInformacoes() {

		tela.getLblIMCPessoa()
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(PainelMenu.class
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
