package Controladores;

import Modelo.Treino;
import Visao.PanelVerTreino;

public class ControladorVerTreino {
	private PanelVerTreino tela;
	private ControladorRedirecionar controlador;
	private Treino treino;

	public ControladorVerTreino(PanelVerTreino tela, ControladorRedirecionar controlador, Treino treino) {
		this.tela = tela;
		this.controlador = controlador;
		this.treino = treino;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnVoltar()) {
			controlador.caminho(1);
		} else if (e == tela.getBtnEditar()) {

		}
	}

	public void inicializar() {
		tela.getLblAluno().setText("Aluno: " + treino.getAlunoAnexado());
		tela.getLblNome().setText(treino.getNome());
		tela.getLblRepeticoes().setText("Repetições: " + treino.getnRepeticao());
		tela.getLblSeries().setText("Séries: " + treino.getnSerie());
		tela.getTextTipo().setText("Tipo: " + treino.getNomesTipo());
		tela.getListExerciciosTreino().setModel(treino.getNomesExercicios());
	}
}
