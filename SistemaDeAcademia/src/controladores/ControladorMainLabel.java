/**
 * 
 */
package controladores;

import java.awt.Panel;

import javax.swing.JPanel;

import visao.PanelInicio;
import visao.PanelMenu;
import visao.PanelRedirecionar;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes no panel menu
 * 
 * @see PanelMenu
 */
public class ControladorMainLabel {

	private PanelMenu tela;
	private JPanel[] telas = new JPanel[12];

	/**
	 * Construtor no qual inicializa com a tela Menu
	 * 
	 * @param painelMenu Tela em que serao adicionada as subtelas
	 * @see PanelMenu
	 */
	public ControladorMainLabel(PanelMenu painelMenu) {
		this.tela = painelMenu;
	}

	/**
	 * Metodo que ira redirecionar o usuario para as diversas funcoes do programa,
	 * que esta separada entre alunos, exercicios e treinos.
	 * 
	 * No metodo, e chamado a funcao esconder telas, apos isso, e inicializada a
	 * tela com o respectivo id, no qual sera adicionada a tela de painel menu e
	 * adicionada em uma array
	 * 
	 * @param id Int contendo o id da tela que deseja chamar.
	 * @see esconderTelas
	 * @see operarTela
	 * @see PanelInicio
	 * @see Panel Redirecionar
	 */
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

	/**
	 * Metodo no qual ira adicionar a tela criada em uma array e adiciona-la a tela
	 * de menu, isso deve ocorrer para a tela ser sobrescrita a cada vez que o
	 * usuario apertar um botao
	 * 
	 * @param id       Int contendo o id da tela
	 * @param elemento JPanel tela em que sera operada
	 */
	public void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		this.tela.getPanelMainMenu().add(elemento);
		elemento.setVisible(true);
	}

	/**
	 * Metodo em que ira deixar todas as JPanels salvas no array invisiveis.
	 * 
	 * E utilizado um loop for para percorrer as tela, e para cada tela sua
	 * visibilidade se torna falsa.
	 */
	public void esconderTelas() {
		for (JPanel telaCriada : telas) {
			if (telaCriada != null) {
				telaCriada.setVisible(false);
			}
		}
	}
}
