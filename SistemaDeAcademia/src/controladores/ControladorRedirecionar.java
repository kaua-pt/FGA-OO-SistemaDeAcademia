package controladores;

import javax.swing.JPanel;

import modelo.BancoDeDados;
import visao.PanelBuscaAluno;
import visao.PanelCadastroAluno;
import visao.PanelCadastroExercicio;
import visao.PanelCadastroTreino;
import visao.PanelConsultaTreino;
import visao.PanelListarExercicios;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar o redirecionamento de telas
 *          do programa.
 * 
 */

public class ControladorRedirecionar {

	private static JPanel tela;
	private static JPanel padrao;
	private static JPanel[] telas = new JPanel[20];

	/**
	 * Metodo para receptar as informacoes vindas da escolha do usuario no
	 * panelMenu.O metodo deve ser Static para poder ser utilizado globalmente,ou
	 * seja, sempre que necessario.
	 * 
	 * @param operacao String contendo para qual parte do programa o usuario deseja
	 *                 ir
	 * @param id       Int contendo a id do que o usuario deseja fazer
	 */
	public static void receptacao(String operacao, int id) {
		if (operacao == "Alunos") {
			caminho(id);
		} else if (operacao == "Exercicios") {
			caminho(id + 1);
		} else if (operacao == "Treinos") {
			caminho(id + 2);
		}
	}

	/**
	 * Metodo Static que ira mudar a tela para qual o usuario deseja ir.
	 * 
	 * No metodo, a tela padrao, que e a atual, e setada como invisivel,e logo apos
	 * e feito o mesmo com todas as telas ativas.E feito entao o redirecionamento
	 * com base no id fornecido nos parametros. Para acessar a tela de Cadastro de
	 * Treino,e primeiramente feita uma verificacao no banco de dados para saber se
	 * ha ao menos um aluno e um treino cadastrado.Logo apos, a tela criada e
	 * passada para a funcao de operar tela.
	 * 
	 * @param id Int contendo o id da tela que o usuario deseja acessar.
	 * @see esconderTelas
	 * @see operarTela
	 * @see PanelCadastroAluno
	 * @see PanelCadastroExercicio
	 * @see PanelCadastroTreino
	 * @see PanelBuscaAluno
	 * @see PanelListarExercicios
	 * @see PanelConsultaTreino
	 * @see BancoDeDados
	 */
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
			if (BancoDeDados.getExercicios().size() > 0 && BancoDeDados.getAlunos().size() > 0) {
				operarTela(id, cadastroT);
			} else {
				operarTela(id, ControladorRedirecionar.padrao);
			}
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

	/**
	 * Metodo no qual ira adicionar a tela criada em uma array e adiciona-la a tela
	 * de menu, isso deve ocorrer para a tela ser sobrescrita a cada vez que o
	 * usuario apertar um botão
	 * 
	 * @param id       Int contendo o id da tela
	 * @param elemento JPanel tela em que sera operada
	 */
	public static void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		ControladorRedirecionar.tela.add(elemento);
		elemento.setVisible(true);
	}

	/**
	 * Metodo em que ira deixar todas as JPanels salvas no array invisiveis.
	 * 
	 * E utilizado um loop for para percorrer as tela, e para cada tela sua
	 * visibilidade se torna falsa.
	 */
	public static void esconderTelas() {
		for (JPanel telaCriada : telas) {
			if (telaCriada != null) {
				telaCriada.setVisible(false);
			}
		}
	}

	// Getters e Setters
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
