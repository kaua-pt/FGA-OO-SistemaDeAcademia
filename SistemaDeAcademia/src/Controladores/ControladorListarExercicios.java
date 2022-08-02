package Controladores;

import javax.swing.DefaultListModel;

import Modelo.BancoDeDados;
import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Visao.PanelEditarExercicio;
import Visao.PanelListarExercicios;

public class ControladorListarExercicios {

	private PanelListarExercicios panel;
	private ControladorRedirecionar controlador;
	private Exercicio exercicio;

	public ControladorListarExercicios(PanelListarExercicios panel, ControladorRedirecionar controlador) {
		this.panel = panel;
		this.controlador = controlador;
	}

	public void acaoPerformada(Object e) {
		if (e == panel.getBtnBuscar()) {
			DefaultListModel<Object> retorno = new DefaultListModel<Object>();
			for (Exercicio exercicio : BancoDeDados.exercicios) {
				if (exercicio.getTipo()
						.equals(TipoDeGrupamento.pegarTipo(panel.getComboGrupamento().getSelectedIndex() + 1))) {
					System.out.println(exercicio.getNome());
					retorno.addElement(exercicio.getNome() + " / " + exercicio.getDescricao());
				}
			}

			panel.getListExercicios().setModel(retorno);

		} else if (e == panel.getBtnDeletar()) {
			exercicio = Exercicio.getUmExercicio((String) panel.getListExercicios().getSelectedValue());
			System.out.println(exercicio.toString());
			exercicio.deletar();
			controlador.caminho(1);
		} else if (e == panel.getBtnEditar()) {

			PanelEditarExercicio panelExercicio = new PanelEditarExercicio(controlador);
			panel.add(panelExercicio);
			panel.getPanelmain().setVisible(false);
		} else if (e == panel.getBtnVoltar()) {
			controlador.caminho(1);
		}
	}
}
