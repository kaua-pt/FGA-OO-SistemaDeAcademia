/**
 * 
 */
package Controladores;

import javax.swing.JPanel;

import Visao.PainelInicio;
import Visao.PainelRedirecionar;

/**
 * @author Kauã Vinícius
 *
 */
public class ControladorMainLabel {

	private JPanel tela;
	private JPanel[] telas = new JPanel[12];

	public ControladorMainLabel(JPanel tela) {
		this.tela = tela;
	}

	public void caminho(int id) {

		esconderTelas();

		if (id == 1) {
			PainelInicio inicio = new PainelInicio();
			operarTela(id, inicio);

		} else if (id == 2) {
			PainelRedirecionar redirecionarAluno = new PainelRedirecionar("Alunos", "Consultar ");
			operarTela(id, redirecionarAluno);

		} else if (id == 3) {
			PainelRedirecionar redirecionarExercicio = new PainelRedirecionar("Exercicios", "Listar ");
			operarTela(id, redirecionarExercicio);

		} else if (id == 4) {
			PainelRedirecionar redirecionarTreino = new PainelRedirecionar("Treinos", "Consultar ");
			operarTela(id, redirecionarTreino);
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
