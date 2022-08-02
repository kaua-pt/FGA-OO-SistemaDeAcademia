package Controladores;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Visao.PanelEditarExercicio;

public class ControladorTelaEditarExercicio {

	private PanelEditarExercicio panel;
	private ControladorRedirecionar controlador;
	private Exercicio exercicioAux;
	private String exercicioNome;

	public ControladorTelaEditarExercicio(PanelEditarExercicio panel, ControladorRedirecionar controlador) {
		this.panel = panel;
		this.controlador = controlador;
	}

	public void acaoPerformada(Object e) {
		if (e == panel.getBtnInicio()) {
			controlador.caminho(1);
		} else if (e == panel.getBtnFinalizar()) {
			exercicioAux = new Exercicio(panel.getTextNome().getText(),
					TipoDeGrupamento.pegarTipo(panel.getComboBoxExercicio().getSelectedIndex() + 1),
					panel.getTextDescricao().getText());

			exercicioAux.editar(exercicioNome);
			controlador.caminho(1);
		}

	}

	public void iniciarCampos(Exercicio exercicio) {
		exercicioNome = exercicio.getNome();
		panel.getTextNome().setText(exercicio.getNome());
		panel.getTextDescricao().setText(exercicio.getDescricao());
		panel.getComboBoxExercicio().setSelectedIndex(exercicio.getTipo().get(0).getId());
	}
}
