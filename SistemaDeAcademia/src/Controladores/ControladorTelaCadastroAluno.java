package Controladores;

import Modelo.Aluno;
import Visao.PanelCadastroAluno;

public class ControladorTelaCadastroAluno {

	private PanelCadastroAluno tela;

	public ControladorTelaCadastroAluno(PanelCadastroAluno tela) {
		this.tela = tela;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if (((tela.getTextNomeAluno().getText().isEmpty() == false)
					&& (tela.getTextNomeAluno().getText().isBlank() == false)
					&& (Aluno.getUmAluno(tela.getTextNomeAluno().getText())) == null)) {

				cadastrarAluno(tela.getTextNomeAluno().getText(), (int) tela.getSpinIdade().getValue(),
						(double) tela.getSpinAltura().getValue(), (double) tela.getSpinPeso().getValue());
				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	public void cadastrarAluno(String nome, int idade, double altura, double peso) {
		Aluno aluno = new Aluno(nome, idade, altura, peso);
		aluno.cadastro();
	}
}
