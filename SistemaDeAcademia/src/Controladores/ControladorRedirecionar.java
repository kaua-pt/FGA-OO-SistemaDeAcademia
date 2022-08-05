package Controladores;

import javax.swing.JPanel;

import Visao.PanelBuscaAluno;
import Visao.PanelCadastroAluno;
import Visao.PanelCadastroExercicio;
import Visao.PanelCadastroTreino;
import Visao.PanelConsultaTreino;
import Visao.PanelListarExercicios;

public class ControladorRedirecionar {

	private static JPanel tela;
	private static JPanel padrao;
	private static JPanel[] telas = new JPanel[20];

	public static void receptacao(String operacao, int id) {
		if (operacao == "Alunos") {
			caminho(id);
		} else if (operacao == "Exercicios") {
			caminho(id + 1);
		} else if (operacao == "Treinos") {
			caminho(id + 2);
		}
	}

	public static void caminho(int id) {
		ControladorRedirecionar.padrao.setVisible(false);
		esconderTelas();

		if (id == 1) {
			operarTela(id, ControladorRedirecionar.padrao);
		} else if (id == 2) {
			PanelCadastroAluno cadastroA = new PanelCadastroAluno();
			operarTela(id, cadastroA);
		} else if (id == 3) {
			PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
			operarTela(id, cadastroE);
		} else if (id == 4) {
			PanelCadastroTreino cadastroT = new PanelCadastroTreino();
			operarTela(id, cadastroT);
		} else if (id == 5) {
			PanelBuscaAluno buscaA = new PanelBuscaAluno();
			operarTela(id, buscaA);
		} else if (id == 6) {
			PanelListarExercicios listarE = new PanelListarExercicios();
			operarTela(id, listarE);
		} else if (id == 7) {
			PanelConsultaTreino consultaT = new PanelConsultaTreino();
			operarTela(id, consultaT);
		}

	}

	public static void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		ControladorRedirecionar.tela.add(elemento);
		elemento.setVisible(true);
	}

	public static void esconderTelas() {
		for (JPanel telaCriada : telas) {
			if (telaCriada != null) {
				telaCriada.setVisible(false);
			}
		}
	}

	public static JPanel getTela() {
		return tela;
	}

	public static void setTela(JPanel tela) {
		ControladorRedirecionar.tela = tela;
	}

	public static JPanel getPadrao() {
		return padrao;
	}

	public static void setPadrao(JPanel padrao) {
		ControladorRedirecionar.padrao = padrao;
	}

}
