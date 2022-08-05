package Controladores;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Visao.PanelCadastroExercicio;

public class ControladorTelaCadastroExercicio {

	private PanelCadastroExercicio tela;

	public ControladorTelaCadastroExercicio(PanelCadastroExercicio tela) {
		this.tela = tela;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if ((tela.getNomeExercicio().getText().isBlank() == false)
					&& (tela.getNomeExercicio().getText().isEmpty() == false)
					&& (Exercicio.getUmExercicio(tela.getNomeExercicio().getText()) == null)) {

				cadastrarExercicio(tela.getNomeExercicio().getText(), tela.getComboBoxExercicio().getSelectedIndex(),
						tela.getTextArea().getText());
				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	public void cadastrarExercicio(String nome, int tipo, String descricao) {
		Exercicio exercicio = new Exercicio(nome, TipoDeGrupamento.pegarTipo(tipo + 1), descricao);
		exercicio.cadastro();
	}

}
