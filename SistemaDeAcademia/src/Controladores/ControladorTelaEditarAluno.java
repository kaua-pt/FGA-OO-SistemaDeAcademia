package Controladores;

import Modelo.Aluno;
import Visao.PanelEditarAluno;

public class ControladorTelaEditarAluno {

	private PanelEditarAluno panel;
	private ControladorRedirecionar controlador;
	private String nomeAluno;

	public ControladorTelaEditarAluno(PanelEditarAluno panel, ControladorRedirecionar controlador) {
		this.panel = panel;
		this.controlador = controlador;
	}

	public void acaoPerformada(Object e) {
		if (e == panel.getBtnCadastrar()) {
			Aluno alunoSet = new Aluno(panel.getTextNomeAluno().getText(), (int) panel.getSpinIdade().getValue(),
					(double) panel.getSpinAltura().getValue(), (double) panel.getSpinPeso().getValue());
			alunoSet.editar(nomeAluno);
			controlador.caminho(1);
		} else if (e == panel.getBtnVoltar()) {
			controlador.caminho(1);
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
