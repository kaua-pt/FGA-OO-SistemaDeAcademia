/**
 * 
 */
package Controladores;

import javax.swing.JPanel;

import Visao.PainelInicio;
import Visao.PainelRedirecionar;

/**
 * @author PC
 *
 */
public class ControladorMainLabel {

	private JPanel tela;
	private PainelInicio inicio = new PainelInicio();
	private PainelRedirecionar redirecionarAluno = new PainelRedirecionar("Alunos", "Consultar ");
	private PainelRedirecionar redirecionarExercicio = new PainelRedirecionar("Exercicios", "Listar ");
	private PainelRedirecionar redirecionarTreino = new PainelRedirecionar("Treinos", "Consultar ");

	public ControladorMainLabel(JPanel tela) {
		this.tela = tela;
		this.tela.add(inicio);
		this.tela.add(redirecionarAluno);
		this.tela.add(redirecionarExercicio);
		this.tela.add(redirecionarTreino);
	}

	public void caminho(int id) {

		inicio.setVisible(false);
		redirecionarAluno.setVisible(false);
		redirecionarExercicio.setVisible(false);
		redirecionarTreino.setVisible(false);

		if (id == 1) {
			inicio.setVisible(true);
		} else if (id == 2) {
			redirecionarAluno.setVisible(true);
		} else if (id == 3) {
			redirecionarExercicio.setVisible(true);
		} else if (id == 4) {
			redirecionarTreino.setVisible(true);
		}
	}
}
