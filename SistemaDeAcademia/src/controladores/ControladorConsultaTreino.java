package controladores;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import modelo.BancoDeDados;
import modelo.Treino;
import visao.PanelConsultaTreino;
import visao.PanelVerTreino;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          consulta de treinos.
 * 
 * @see PanelConsultaTreino
 */
@SuppressWarnings("unchecked")
public class ControladorConsultaTreino {

	private PanelConsultaTreino tela;
	private Treino treino;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param tela PanelConsultaTreino panel que chamou o controlador
	 */
	public ControladorConsultaTreino(PanelConsultaTreino tela) {
		this.tela = tela;
	}

	/**
	 * Metodo que ira realizar algo caso algum botao seja pressionado na tela.
	 * 
	 * O usuario tem a funcao de voltar para o inicio do programa, ver um treino, no
	 * qual ira leva-lo a uma outra tela com as informacoes do treino e a de deletar
	 * o treino no qual ira efetivamente deletar o treino, extraindo a instancia do
	 * treino em que foi selecionado e deletando-o.
	 * 
	 * @param e Object com as informacoes do botao precionado.
	 * @see Treino
	 * @see ControladorRedirecionar
	 * @see PanelVerTreino
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnDeletar()) {
			treino = Treino.getUmTreino((String) tela.getListTreinos().getSelectedValue());
			if (treino != null) {
				treino.deletar();
				ControladorRedirecionar.caminho(1);
			}

		} else if (e == tela.getBtnVer()) {
			treino = Treino.getUmTreino((String) tela.getListTreinos().getSelectedValue());
			if (treino != null) {
				PanelVerTreino verTreino = new PanelVerTreino(treino);
				tela.add(verTreino);
				tela.getPanelGeral().setVisible(false);
			}

		}
	}

	/**
	 * Metodo que mostra as informacoes na tela.
	 * 
	 * E utilizado um loop para percorrer todos os treinos cadastrados, nos quais
	 * sao extraidos seus respectivos nomes e colocados em uma lista no qual
	 * incorporara uma JList
	 * 
	 * @see JList
	 * @see Treino
	 * @see BancoDeDados
	 * @see DefaultListModel
	 */
	public void inicializar() {
		DefaultListModel<Object> retorno = new DefaultListModel<Object>();
		for (Treino treino : BancoDeDados.getTreinos()) {
			retorno.addElement(treino.getNome());
		}
		tela.getListTreinos().setModel(retorno);
	}
}
