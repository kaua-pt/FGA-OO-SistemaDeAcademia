package Controladores;

import Modelo.Treino;
import Visao.PanelEditarTreino;
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
			PanelEditarTreino editarTreino = new PanelEditarTreino(treino);
			tela.add(editarTreino);
			tela.getPanelBaseGeral().setVisible(false);
		}
	}

	@SuppressWarnings("unchecked")
	public void inicializar() {
		tela.getLblAluno().setText("Aluno: " + treino.getAlunoAnexado());
		tela.getLblNome().setText(treino.getNome());
		tela.getLblRepeticoes().setText("Repetições: " + treino.getnRepeticao());
		tela.getLblSeries().setText("Séries: " + treino.getnSerie());
		tela.getTextTipo().setText("Tipo: " + treino.getNomesTipo());
		tela.getListExerciciosTreino().setModel(treino.getNomesExercicios());
	}
}
