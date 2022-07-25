package Controladores;

import java.util.ArrayList;

import javax.swing.JPanel;

import Modelo.TipoDeGrupamento;
import Visao.PanelCadastroAluno;
import Visao.PanelCadastroExercicio;
import Visao.PanelCadastroTreino;
import Visao.PanelTreinoExercicios;

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
		} else if (id == 3) {
			PanelCadastroExercicio cadastroE = new PanelCadastroExercicio(this);
			operarTela(3, cadastroE);
		} else if (id == 4) {
			PanelCadastroTreino cadastroT = new PanelCadastroTreino(this);
			operarTela(4, cadastroT);
		}

	}

	public void caminhoT(ControladorTreino controlador, ArrayList<TipoDeGrupamento> lista) {
		esconderTelas();
		PanelTreinoExercicios TE = new PanelTreinoExercicios(this, controlador, lista);
		operarTela(10, TE);
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
