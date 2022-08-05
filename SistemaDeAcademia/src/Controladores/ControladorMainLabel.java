/**
 * 
 */
package Controladores;

import javax.swing.JPanel;

import Visao.PanelInicio;
import Visao.PanelMenu;
import Visao.PanelRedirecionar;

/**
 * @author Kauã Vinícius
 * 
 * 
 * @see PanelMenu
 */
public class ControladorMainLabel {

	private PanelMenu tela;
	private JPanel[] telas = new JPanel[12];

	public ControladorMainLabel(PanelMenu painelMenu) {
		this.tela = painelMenu;
	}

	public void caminho(int id) {
		esconderTelas();

		if (id == 1) {
			PanelInicio inicio = new PanelInicio();
			operarTela(id, inicio);

		} else if (id == 2) {
			PanelRedirecionar redirecionarAluno = new PanelRedirecionar("Alunos", "Consultar ");
			operarTela(id, redirecionarAluno);

		} else if (id == 3) {
			PanelRedirecionar redirecionarExercicio = new PanelRedirecionar("Exercicios", "Listar ");
			operarTela(id, redirecionarExercicio);

		} else if (id == 4) {
			PanelRedirecionar redirecionarTreino = new PanelRedirecionar("Treinos", "Consultar ");
			operarTela(id, redirecionarTreino);
		} else if (id == 5) {
			tela.dispose();
		}
	}

	public void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		this.tela.getPanelMainMenu().add(elemento);
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
