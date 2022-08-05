package Controladores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Aluno;
import Modelo.BancoDeDados;
import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;
import Visao.PanelCadastroTreino;

public class ControladorTelaCadastroTreino {

	private PanelCadastroTreino tela;

	public ControladorTelaCadastroTreino(PanelCadastroTreino tela) {
		this.tela = tela;
	}

	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if ((tela.getTextField().getText().isBlank() == false) && (tela.getTextField().getText().isEmpty() == false)
					&& (Treino.getUmTreino(tela.getTextField().getText()) == null)
					&& (tela.getListExerciciosTreino().getSelectedIndices().length > 0)) {

				cadastrarTreino(tela.getTextField().getText(), tela.getComboGrupo().getSelectedIndex(),
						tela.getComboAluno().getSelectedItem().toString(),
						tela.getListExerciciosTreino().getSelectedValuesList(), (int) tela.getSpinRep().getValue(),
						(int) tela.getSpinSerie().getValue());

				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnExercicios()) {

			tela.getListExerciciosTreino().setModel(Exercicio.listaExercicio(tela.getComboGrupo().getSelectedIndex()));

			tela.getPanelMain1().setVisible(false);
			tela.getPanelMain2().setVisible(true);

		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain1().setVisible(true);
			tela.getPanelMain2().setVisible(false);
		}
	}

	public void cadastrarTreino(String nome, int tipos, String nomeAluno, List<String> nomes, int nRep, int nSer) {

		Treino treino = new Treino(nome, TipoDeGrupamento.parearTipos(tipos), Exercicio.parearExercicios(nomes), nRep,
				nSer);
		treino.cadastro();
		anexarTreino(nomeAluno, treino);
	}

	public static void anexarTreino(String alunoNome, Treino treinos) {
		ArrayList<Treino> adicionar = new ArrayList<Treino>();
		for (Aluno aluno : BancoDeDados.alunos) {
			if (aluno.getNome() == alunoNome) {
				adicionar.addAll(aluno.getTreinos());
				if (adicionar.size() < 4) {
					adicionar.add(treinos);
				} else {
					// adicionar
					System.out.println("Aluno Sobrecarregado");
				}
				aluno.setTreinos(adicionar);
			}
		}
	}

}
