package Controladores;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;
import Visao.PanelEditarTreino;

public class ControladorTelaEditarTreino {

	private PanelEditarTreino tela;
	private String nomeTreino;

	public ControladorTelaEditarTreino(PanelEditarTreino tela) {
		this.tela = tela;
	}

	@SuppressWarnings("unchecked")
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain2().setVisible(false);
			tela.getPanelMain1().setVisible(true);
		} else if (e == tela.getBtnExercicios()) {
			tela.getListExerciciosTreino().setModel(Exercicio.listaExercicio(tela.getComboGrupo().getSelectedIndex()));
			tela.getPanelMain2().setVisible(true);
			tela.getPanelMain1().setVisible(false);
		} else if (e == tela.getBtnFinalizar()) {

			Treino treinoaux = new Treino(tela.getTextNome().getText(),
					TipoDeGrupamento.parearTipos(tela.getComboGrupo().getSelectedIndex()),
					Exercicio.parearExercicios(tela.getListExerciciosTreino().getSelectedValuesList()),
					(int) tela.getSpinnerRepeticao().getValue(), (int) tela.getSpinnerSerie().getValue());
			treinoaux.editar(nomeTreino);
			ControladorRedirecionar.caminho(1);
		}
	}

	public void iniciarTela(Treino treino) {
		nomeTreino = treino.getNome();
		tela.getTextNome().setText(treino.getNome());
		tela.getComboGrupo().setSelectedItem(treino.getTipo());
		tela.getSpinnerRepeticao().setValue(treino.getnRepeticao());
		tela.getSpinnerSerie().setValue(treino.getnSerie());
	}
}
