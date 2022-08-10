package controladores;

import modelo.Treino;
import visao.PanelEditarTreino;
import visao.PanelVerTreino;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar as ações
 * 		da tela de consulta de treinos.
 * 
 * @see PanelverTreino
 */
@SuppressWarnings("unchecked")
public class ControladorVerTreino {
	private PanelVerTreino tela;
	private Treino treino;
	
	/**
	 * 	Construtor em que inicializa o controlador e integra
	 * o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelVerTreino panel que chamou o controlador
	 */
	public ControladorVerTreino(PanelVerTreino tela, Treino treino) {
		this.tela = tela;
		this.treino = treino;
	}

	/**
	 * Método que irá realizar uma ação para cada botão prescionado 
	 * pelo usuário.
	 * 
	 * Caso o usuário deseje retornar ao início, apenas será chamado o 
	 * controlador redirecionar. Caso o usuário deseje editar algum treino,
	 * ele será redirecionado para uma tela específica para editar o aluno.
	 * 
	 * @param e Object contendo a informações do botão precionado 
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
	 * Método que mostra as informações na tela 
	 * 
	 */
	public void inicializar() {
		tela.getLblAluno().setText("Aluno: " + treino.getAlunoAnexado());
		tela.getLblNome().setText(treino.getNome());
		tela.getLblRepeticoes().setText("Repeti��es: " + treino.getnRepeticao());
		tela.getLblSeries().setText("S�ries: " + treino.getnSerie());
		tela.getTextTipo().setText("Tipo: " + treino.getNomesTipo());
		tela.getListExerciciosTreino().setModel(treino.getNomesExercicios());
	}
}
