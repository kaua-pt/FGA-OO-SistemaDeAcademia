package controladores;

import modelo.Treino;
import visao.PanelEditarTreino;
import visao.PanelVerTreino;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          consulta de treinos.
 * 
 * @see PanelVerTreino
 */
@SuppressWarnings("unchecked")
public class ControladorVerTreino {
	private PanelVerTreino tela;
	private Treino treino;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param tela PanelVerTreino panel que chamou o controlador
	 */
	public ControladorVerTreino(PanelVerTreino tela, Treino treino) {
		this.tela = tela;
		this.treino = treino;
	}

	/**
	 * Metodo que ira realizar uma acao para cada botao prescionado pelo usuario.
	 * 
	 * Caso o usuario deseje retornar ao inicio, apenas sera chamado o controlador
	 * redirecionar. Caso o usuario deseje editar algum treino, ele sera
	 * redirecionado para uma tela especifica para editar o aluno.
	 * 
	 * @param e Object contendo a informacoes do botao precionado
	 * 
	 * @see PanelEditarTreino
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnEditar()) {
			PanelEditarTreino editarTreino = new PanelEditarTreino(treino);
			tela.add(editarTreino);
			tela.getPanelBaseGeral().setVisible(false);
		}
	}

	/**
	 * Metodo que mostra as informacoes na tela
	 * 
	 */
	public void inicializar() {
		tela.getLblAluno().setText("Aluno: " + treino.getAlunoAnexado());
		tela.getLblNome().setText(treino.getNome());
		tela.getLblRepeticoes().setText("Repeticoes: " + treino.getnRepeticao());
		tela.getLblSeries().setText("Series: " + treino.getnSerie());
		tela.getTextTipo().setText("Tipo: " + treino.getNomesTipo());
		tela.getListExerciciosTreino().setModel(treino.getNomesExercicios());
	}
}
