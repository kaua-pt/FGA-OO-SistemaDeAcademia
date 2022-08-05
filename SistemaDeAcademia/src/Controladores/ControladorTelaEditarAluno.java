package Controladores;

import Modelo.Aluno;
import Visao.PanelEditarAluno;

public class ControladorTelaEditarAluno {

	private PanelEditarAluno panel;
	private String nomeAluno;

	public ControladorTelaEditarAluno(PanelEditarAluno panel) {
		this.panel = panel;
	}

	public void acaoPerformada(Object e) {
		if (e == panel.getBtnCadastrar()) {
			Aluno alunoSet = new Aluno(panel.getTextNomeAluno().getText(), (int) panel.getSpinIdade().getValue(),
					(double) panel.getSpinAltura().getValue(), (double) panel.getSpinPeso().getValue());
			alunoSet.editar(nomeAluno);
			ControladorRedirecionar.caminho(1);
		} else if (e == panel.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	public void setarInformacoes(Aluno aluno) {
		nomeAluno = aluno.getNome();
		panel.getTextNomeAluno().setText(aluno.getNome());
		panel.getSpinAltura().setValue(aluno.getAltura());
		panel.getSpinIdade().setValue(aluno.getIdade());
		panel.getSpinPeso().setValue(aluno.getPeso());
	}

}
