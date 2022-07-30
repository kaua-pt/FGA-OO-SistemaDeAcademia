package Controladores;

import Modelo.Aluno;
import Visao.PanelCadastroAluno;

public class ControladorTelaCadastroAluno {

	private PanelCadastroAluno tela;
	private ControladorRedirecionar controlador;

	public ControladorTelaCadastroAluno(PanelCadastroAluno tela, ControladorRedirecionar controlador) {
		this.tela = tela;
		this.controlador = controlador;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if (((tela.getTextNomeAluno().getText().isEmpty() == false)
					&& (tela.getTextNomeAluno().getText().isBlank() == false)
					&& (BancoDeDados.getUmAluno(tela.getTextNomeAluno().getText())) == null)) {

				cadastrarAluno(tela.getTextNomeAluno().getText(), (int) tela.getSpinIdade().getValue(),
						(double) tela.getSpinAltura().getValue(), (double) tela.getSpinPeso().getValue());
				controlador.caminho(1);
			}
		} else if (e == tela.getBtnVoltar()) {
			controlador.caminho(1);
		}
	}

	public void cadastrarAluno(String nome, int idade, double altura, double peso) {
		Aluno aluno = new Aluno(nome, idade, altura, peso);
		aluno.cadastro();
	}
}
