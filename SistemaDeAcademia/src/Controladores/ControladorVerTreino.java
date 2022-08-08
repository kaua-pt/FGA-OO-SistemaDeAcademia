package Controladores;

import Modelo.Treino;
import Visao.PanelVerTreino;

public class ControladorVerTreino {
	private PanelVerTreino tela;
	private Treino treino;

	public ControladorVerTreino(PanelVerTreino tela, Treino treino) {
		this.tela = tela;
		this.treino = treino;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnEditar()) {

		}
	}

	@SuppressWarnings("unchecked")
	public void inicializar() {
		tela.getLblAluno().setText("Aluno: " + treino.getAlunoAnexado());
		tela.getLblNome().setText(treino.getNome());
		tela.getLblRepeticoes().setText("Repeti��es: " + treino.getnRepeticao());
		tela.getLblSeries().setText("S�ries: " + treino.getnSerie());
		tela.getTextTipo().setText("Tipo: " + treino.getNomesTipo());
		tela.getListExerciciosTreino().setModel(treino.getNomesExercicios());
	}
}
