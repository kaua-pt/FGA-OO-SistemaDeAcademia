package Controladores;

import javax.swing.JPanel;

import Visao.PanelBuscaAluno;
import Visao.PanelCadastroAluno;
import Visao.PanelCadastroExercicio;
import Visao.PanelCadastroTreino;
import Visao.PanelListarExercicios;

public class ControladorRedirecionar {

	private JPanel tela;
	private JPanel padrao;
	private JPanel[] telas = new JPanel[20];

	public ControladorRedirecionar(JPanel tela, JPanel padrao) {
		this.tela = tela;
		this.padrao = padrao;
	}

	public void receptacao(String operacao, int id) {
		if (operacao == "Alunos") {
			caminho(id);
		} else if (operacao == "Exercicios") {
			caminho(id + 1);
		} else if (operacao == "Treinos") {
			caminho(id + 2);
		}
	}

	public void caminho(int id) {
		this.padrao.setVisible(false);
		esconderTelas();

		if (id == 1) {
			operarTela(id, this.padrao);
		} else if (id == 2) {
			PanelCadastroAluno cadastroA = new PanelCadastroAluno(this);
			operarTela(id, cadastroA);
		} else if (id == 3) {
			PanelCadastroExercicio cadastroE = new PanelCadastroExercicio(this);
			operarTela(id, cadastroE);
		} else if (id == 4) {
			PanelCadastroTreino cadastroT = new PanelCadastroTreino(this);
			operarTela(id, cadastroT);
		} else if (id == 5) {
			PanelBuscaAluno buscaA = new PanelBuscaAluno(this);
			operarTela(id, buscaA);
		} else if (id == 6) {
			PanelListarExercicios listarE = new PanelListarExercicios(this);
			operarTela(id, listarE);
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
