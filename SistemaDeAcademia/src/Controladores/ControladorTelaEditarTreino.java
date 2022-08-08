package Controladores;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;
import Visao.PanelEditarTreino;

public class ControladorTelaEditarTreino {

	private PanelEditarTreino tela;
	private Treino treino;

	public ControladorTelaEditarTreino(PanelEditarTreino tela, Treino treino) {
		this.tela = tela;
		this.treino = treino;
	}

	@SuppressWarnings("unchecked")
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain2().setVisible(false);
			tela.getPanelMain1().setVisible(true);
		} else if (e == tela.getBtnExercicios()) {

			treino.getNomesExercicios();
			tela.getListExerciciosTreino().setModel(Exercicio.listaExercicio(tela.getComboGrupo().getSelectedIndex()));
			tela.getPanelMain2().setVisible(true);
			tela.getPanelMain1().setVisible(false);
		} else if (e == tela.getBtnFinalizar()) {

			Treino treinoaux = new Treino(tela.getTextNome().getText(),
					TipoDeGrupamento.parearTipos(tela.getComboGrupo().getSelectedIndex()),
					Exercicio.parearExercicios(tela.getListExerciciosTreino().getSelectedValuesList()),
					(int) tela.getSpinnerRepeticao().getValue(), (int) tela.getSpinnerSerie().getValue());
			treinoaux.editar(treino.getNome());
			ControladorRedirecionar.caminho(1);
		}
	}
}
