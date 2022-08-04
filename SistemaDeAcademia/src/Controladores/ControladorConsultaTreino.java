package Controladores;

import javax.swing.DefaultListModel;

import Modelo.BancoDeDados;
import Modelo.Treino;
import Visao.PanelConsultaTreino;
import Visao.PanelVerTreino;

public class ControladorConsultaTreino {

	private PanelConsultaTreino tela;
	private ControladorRedirecionar controlador;
	private Treino treino;

	public ControladorConsultaTreino(PanelConsultaTreino tela, ControladorRedirecionar controlador) {
		this.tela = tela;
		this.controlador = controlador;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnVoltar()) {
			controlador.caminho(1);
		} else if (e == tela.getBtnDeletar()) {
			treino = Treino.getUmTreino((String) tela.getListTreinos().getSelectedValue());
			treino.deletar();
			controlador.caminho(1);

		} else if (e == tela.getBtnVer()) {
			treino = Treino.getUmTreino((String) tela.getListTreinos().getSelectedValue());
			PanelVerTreino verTreino = new PanelVerTreino(controlador, treino);
			tela.add(verTreino);
			tela.getPanelGeral().setVisible(false);
		}
	}

	public void inicializar() {
		DefaultListModel<Object> retorno = new DefaultListModel<Object>();
		for (Treino treino : BancoDeDados.treinos) {
			retorno.addElement(treino.getNome());
		}
		tela.getListTreinos().setModel(retorno);
	}
}
