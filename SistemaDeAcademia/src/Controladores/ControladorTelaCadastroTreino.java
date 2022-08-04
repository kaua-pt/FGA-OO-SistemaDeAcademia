package Controladores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import Modelo.Aluno;
import Modelo.BancoDeDados;
import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;
import Visao.PanelCadastroTreino;

public class ControladorTelaCadastroTreino {

	private PanelCadastroTreino tela;
	private ControladorRedirecionar controlador;
	private ArrayList<String> stringExercicios;

	public ControladorTelaCadastroTreino(PanelCadastroTreino tela, ControladorRedirecionar controlador) {
		this.tela = tela;
		this.controlador = controlador;
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

				controlador.caminho(1);
			}
		} else if (e == tela.getBtnInicio()) {
			controlador.caminho(1);
		} else if (e == tela.getBtnExercicios()) {

			DefaultListModel listaModelo = new DefaultListModel();
			stringExercicios = Exercicio.getExercicioPorTipo(parearTipos(tela.getComboGrupo().getSelectedIndex()));

			for (String exercicio : stringExercicios) {
				System.out.println(exercicio);
				listaModelo.addElement(exercicio);
			}

			tela.getListExerciciosTreino().setModel(listaModelo);

			tela.getPanelMain1().setVisible(false);
			tela.getPanelMain2().setVisible(true);

		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain1().setVisible(true);
			tela.getPanelMain2().setVisible(false);
		}
	}

	public void cadastrarTreino(String nome, int tipos, String nomeAluno, List<String> nomes, int nRep, int nSer) {

		Treino treino = new Treino(nome, parearTipos(tipos), parearExercicios(nomes), nRep, nSer);
		treino.cadastro();
		anexarTreino(nomeAluno, treino);
	}

	public static ArrayList<Exercicio> parearExercicios(List<String> nomes) {
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		for (String nome : nomes) {
			for (Exercicio exercicioUnico : BancoDeDados.exercicios) {
				if (nome == exercicioUnico.getNome()) {
					exercicios.add(exercicioUnico);
				}
			}
		}
		return exercicios;
	}

	public static ArrayList<TipoDeGrupamento> parearTipos(int index) {
		ArrayList<Integer> pareador = new ArrayList<Integer>();
		ArrayList<TipoDeGrupamento> grupos = new ArrayList<TipoDeGrupamento>();

		switch (index) {
		case 0:
			pareador.add(1);
			pareador.add(4);
			pareador.add(5);
			break;
		case 1:
			pareador.add(2);
			pareador.add(3);
			break;
		case 2:
			pareador.add(6);
			pareador.add(7);
			pareador.add(8);

			break;
		case 3:
			pareador.add(9);
			break;
		}

		for (int valor : pareador) {
			for (TipoDeGrupamento tipo : TipoDeGrupamento.values()) {
				if (tipo.getId() == valor) {
					grupos.add(tipo);
				}
			}
		}
		System.out.println(grupos);
		return grupos;
	}

	public static void anexarTreino(String alunoNome, Treino treinos) {
		ArrayList<Treino> adicionar = new ArrayList<Treino>();
		for (Aluno aluno : BancoDeDados.alunos) {
			if (aluno.getNome() == alunoNome) {
				adicionar.addAll(aluno.getTreinos());
				if (adicionar.size() < 4) {
					adicionar.add(treinos);
				} else {
					System.out.println("Aluno Sobrecarregado");
				}
				aluno.setTreinos(adicionar);
			}
		}
	}

}
