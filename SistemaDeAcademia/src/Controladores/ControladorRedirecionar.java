package Controladores;

import javax.swing.JPanel;

import Visao.PanelCadastroAluno;

public class ControladorRedirecionar {

	private JPanel tela;

	public ControladorRedirecionar(JPanel tela) {
		this.tela = tela;
	}

	public void caminho(int id, JPanel panel) {

		if (id == 1) {
			this.tela.setVisible(true);
		} else if (id == 2) {
			PanelCadastroAluno cadastro = new PanelCadastroAluno();
			this.tela.add(cadastro);
			cadastro.setVisible(true);
			panel.setVisible(false);
		}
	}

}
