package Controladores;

import java.util.ArrayList;

import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Visao.PanelCadastroExercicio;

public class ControladorTelaCadastroExercicio {

	private PanelCadastroExercicio tela;
	private ControladorRedirecionar controlador;

	public ControladorTelaCadastroExercicio(PanelCadastroExercicio tela, ControladorRedirecionar controlador) {
		this.tela = tela;
		this.controlador = controlador;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if ((tela.getNomeExercicio().getText().isBlank() == false)
					&& (tela.getNomeExercicio().getText().isEmpty() == false)
					&& (Exercicio.getUmExercicio(tela.getNomeExercicio().getText()) == null)) {

				cadastrarExercicio(tela.getNomeExercicio().getText(), tela.getComboBoxExercicio().getSelectedIndex(),
						tela.getTextArea().getText());
				controlador.caminho(1);
			}
		} else if (e == tela.getBtnVoltar()) {
			controlador.caminho(1);
		}
	}

	public void cadastrarExercicio(String nome, int tipo, String descricao) {
		Exercicio exercicio = new Exercicio(nome, pegarTipo(tipo + 1), descricao);
		exercicio.cadastro();
	}

	public static ArrayList<TipoDeGrupamento> pegarTipo(int valor) {

		ArrayList<TipoDeGrupamento> grupos = new ArrayList<TipoDeGrupamento>();
		for (TipoDeGrupamento tipo : TipoDeGrupamento.values()) {
			if (tipo.getId() == valor) {
				grupos.add(tipo);
				return grupos;
			}
		}
		return null;
	}

}
