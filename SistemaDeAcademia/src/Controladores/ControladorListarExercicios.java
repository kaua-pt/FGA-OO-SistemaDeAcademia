package Controladores;

import javax.swing.DefaultListModel;

import Modelo.BancoDeDados;
import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Visao.PanelEditarExercicio;
import Visao.PanelListarExercicios;

public class ControladorListarExercicios {

	private PanelListarExercicios panel;
	private Exercicio exercicio;

	public ControladorListarExercicios(PanelListarExercicios panel) {
		this.panel = panel;
	}

	@SuppressWarnings("unchecked")
	public void acaoPerformada(Object e) {
		if (e == panel.getBtnBuscar()) {
			DefaultListModel<Object> retorno = new DefaultListModel<Object>();
			for (Exercicio exercicio : BancoDeDados.getExercicios()) {
				if (exercicio.getTipo()
						.equals(TipoDeGrupamento.pegarTipo(panel.getComboGrupamento().getSelectedIndex() + 1))) {
					retorno.addElement(exercicio.getNome() + "-" + exercicio.getDescricao());
				}
			}

			panel.getListExercicios().setModel(retorno);

		} else if (e == panel.getBtnDeletar()) {
			exercicio = Exercicio.getUmExercicio((String) panel.getListExercicios().getSelectedValue());
			exercicio.deletar();
			ControladorRedirecionar.caminho(1);
		} else if (e == panel.getBtnEditar()) {

			String nome = panel.getListExercicios().getSelectedValue().toString();
			int pos = nome.indexOf("-");
			nome.substring(0, pos);
			PanelEditarExercicio panelExercicio = new PanelEditarExercicio(
					Exercicio.getUmExercicio(nome.substring(0, pos)));
			panel.add(panelExercicio);
			panel.getPanelmain().setVisible(false);

		} else if (e == panel.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}
}
