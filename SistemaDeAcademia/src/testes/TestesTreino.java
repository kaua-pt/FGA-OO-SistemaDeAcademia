package testes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.BancoDeDados;
import visao.PanelCadastroAluno;
import visao.PanelCadastroExercicio;
import visao.PanelCadastroTreino;
import visao.PanelConsultaTreino;
import visao.PanelEditarTreino;
import visao.PanelRedirecionar;

/**
 * 
 * @author Kaua Vinicius
 * 
 *         Classe respons�vel pelos testes relacionados aos treinos
 *
 */

public class TestesTreino {

	@BeforeEach
	void antes() {
		/**
		 * Aqui ha o metodo que e executado antes de ser realizado qualquer teste
		 */
		BancoDeDados.getAlunos().clear();
		BancoDeDados.getTreinos().clear();
		BancoDeDados.getExercicios().clear();
	}

	@Test
	void cadastrarTreino() {
		/**
		 * Aqui ha o teste relacionado ao cadastro de treino
		 */

		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getAlunos().size());

		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Voador");
		cadastroE.getComboBoxExercicio().setSelectedIndex(0);
		cadastroE.getTextArea().setText("Crucifixo");
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getExercicios().size());

		new PanelRedirecionar("Treinos", "Consultar ");
		PanelCadastroTreino cadastroT = new PanelCadastroTreino();
		cadastroT.getTextField().setText("Treino de peito");
		cadastroT.getComboGrupo().setSelectedIndex(0);
		cadastroT.getComboAluno().setSelectedIndex(0);
		cadastroT.getListExerciciosTreino().setSelectionInterval(0, 0);
		cadastroT.getSpinRep().setValue(4);
		cadastroT.getSpinSerie().setValue(3);
		cadastroT.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getTreinos().size());
	}

	@Test
	void deletarTreino() {
		/**
		 * Aqui ha o teste relacionado a delecao de treino
		 */

		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getAlunos().size());

		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Voador");
		cadastroE.getComboBoxExercicio().setSelectedIndex(0);
		cadastroE.getTextArea().setText("Crucifixo");
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getExercicios().size());

		new PanelRedirecionar("Treinos", "Consultar ");
		PanelCadastroTreino cadastroT = new PanelCadastroTreino();
		cadastroT.getTextField().setText("Treino de peito");
		cadastroT.getComboGrupo().setSelectedIndex(0);
		cadastroT.getComboAluno().setSelectedIndex(0);
		cadastroT.getListExerciciosTreino().setSelectionInterval(0, 0);
		cadastroT.getSpinRep().setValue(4);
		cadastroT.getSpinSerie().setValue(3);
		cadastroT.getBtnCadastrar().doClick();

		PanelConsultaTreino consultaT = new PanelConsultaTreino();
		consultaT.getListTreinos().setSelectedValue("Treino de peito", false);
		consultaT.getBtnDeletar().doClick();
		assertEquals(0, BancoDeDados.getTreinos().size());
	}

	@Test
	void editarTreino() {
		/**
		 * Aqui ha o teste relacionado a edicao de um treino
		 */

		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getAlunos().size());

		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Voador");
		cadastroE.getComboBoxExercicio().setSelectedIndex(0);
		cadastroE.getTextArea().setText("Crucifixo");
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getExercicios().size());

		new PanelRedirecionar("Treinos", "Consultar ");
		PanelCadastroTreino cadastroT = new PanelCadastroTreino();
		cadastroT.getTextField().setText("Treino de peito");
		cadastroT.getComboGrupo().setSelectedIndex(0);
		cadastroT.getComboAluno().setSelectedIndex(0);
		cadastroT.getListExerciciosTreino().setSelectionInterval(0, 0);
		cadastroT.getSpinRep().setValue(4);
		cadastroT.getSpinSerie().setValue(3);
		cadastroT.getBtnCadastrar().doClick();

		PanelEditarTreino editarT = new PanelEditarTreino(BancoDeDados.getTreinos().get(0));
		editarT.getTextNome().setText("Outro treino de peito");
		editarT.getListExerciciosTreino().setSelectionInterval(0, 0);
		editarT.getBtnFinalizar().doClick();
		assertEquals("Outro treino de peito", BancoDeDados.getTreinos().get(0).getNome());
	}
}
