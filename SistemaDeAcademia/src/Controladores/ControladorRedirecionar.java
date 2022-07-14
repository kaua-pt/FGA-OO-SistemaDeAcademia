package Controladores;

import javax.swing.JPanel;

import Visao.PanelCadastroAluno;

public class ControladorRedirecionar {

	private JPanel tela;
	private JPanel padrao;
	private JPanel[] telas = new JPanel[12];

	public ControladorRedirecionar(JPanel tela, JPanel padrao) {
		this.tela = tela;
		this.padrao = padrao;
	}

	public void caminho(int id) {

		this.padrao.setVisible(false);
		esconderTelas();

		if (id == 1) {
			operarTela(1, this.padrao);
		} else if (id == 2) {
			PanelCadastroAluno cadastroA = new PanelCadastroAluno(this);
			operarTela(2, cadastroA);
		}

	}

	public void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		this.tela.add(elemento);
		elemento.setVisible(true);
	}

	public void esconderTelas() {
		for (JPanel telaCriada : telas) {
			if (telaCriada != null) {
				telaCriada.setVisible(false);
			}
		}
	}

}
