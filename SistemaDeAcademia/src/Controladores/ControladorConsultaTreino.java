package Controladores;

import javax.swing.DefaultListModel;

import Modelo.BancoDeDados;
import Modelo.Treino;
import Visao.PanelConsultaTreino;
import Visao.PanelVerTreino;

@SuppressWarnings("unchecked")
public class ControladorConsultaTreino {

	private PanelConsultaTreino tela;
	private Treino treino;

	public ControladorConsultaTreino(PanelConsultaTreino tela) {
		this.tela = tela;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnDeletar()) {
			treino = Treino.getUmTreino((String) tela.getListTreinos().getSelectedValue());
			treino.deletar();
			ControladorRedirecionar.caminho(1);

		} else if (e == tela.getBtnVer()) {
			treino = Treino.getUmTreino((String) tela.getListTreinos().getSelectedValue());
			PanelVerTreino verTreino = new PanelVerTreino(treino);
			tela.add(verTreino);
			tela.getPanelGeral().setVisible(false);
		}
	}

	public void inicializar() {
		DefaultListModel<Object> retorno = new DefaultListModel<Object>();
		for (Treino treino : BancoDeDados.getTreinos()) {
			retorno.addElement(treino.getNome());
		}
		tela.getListTreinos().setModel(retorno);
	}
}
