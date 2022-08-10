package Controladores;

import javax.swing.JPanel;

import Modelo.BancoDeDados;
import Visao.PanelBuscaAluno;
import Visao.PanelCadastroAluno;
import Visao.PanelCadastroExercicio;
import Visao.PanelCadastroTreino;
import Visao.PanelConsultaTreino;
import Visao.PanelListarExercicios;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar o redirecionamento
 * 		de telas do programa.
 * 
 */

public class ControladorRedirecionar {

	private static JPanel tela;
	private static JPanel padrao;
	private static JPanel[] telas = new JPanel[20];
	
	/**
	 * Método para receptar as informações vindas da escolha do usuário
	 * no panelMenu.O método deve ser Static para poder ser utilizado 
	 * globalmente,ou seja, sempre que necessário.
	 * 
	 * @param operacao String contendo para qual parte do programa o usuário
	 * deseja ir
	 * @param id Int contendo a id do que o usuário deseja fazer
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
	 * Método Static que irá mudar a tela para qual o usuário deseja ir.
	 * 
	 * No método, a tela padrão, que é a atual, é setada como invisível,e
	 * logo após é feito o mesmo com todas as telas ativas.É feito então
	 * o redirecionamento com base no id fornecido nos parâmetros. Para 
	 * acessar a tela de Cadastro de Treino,é primeiramente feita uma 
	 * verificação no banco de dados para saber se há ao menos um aluno
	 * e um treino cadastrado.Logo após, a tela criada é passada para a
	 * função de operar tela.
	 * 
	 * @param id Int contendo o id da tela que o usuário deseja acessar.
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
			if(BancoDeDados.getExercicios().size()>0 && 
					BancoDeDados.getAlunos().size() > 0) {
				operarTela(id, cadastroT);
			}else {
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
	 * Método no qual irá adicionar a tela criada em uma array e adiciona-la
	 * a tela de menu, isso deve ocorrer para a tela ser sobrescrita a cada 
	 * vez que o usuário apertar um botão
	 * 
	 * @param id Int contendo o id da tela 
	 * @param elemento JPanel  tela em que será operada
	 */
	public static void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		ControladorRedirecionar.tela.add(elemento);
		elemento.setVisible(true);
	}
	
	/**
	 * Método em que irá deixar todas as JPanels salvas no array
	 * invisíveis.
	 * 
	 * É utilizado um loop for para percorrer as tela, e para cada
	 * tela sua visibilidade se torna falsa.
	 */
	public static void esconderTelas() {
		for (JPanel telaCriada : telas) {
			if (telaCriada != null) {
				telaCriada.setVisible(false);
			}
		}
	}
	
	//Getters e Setters
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
