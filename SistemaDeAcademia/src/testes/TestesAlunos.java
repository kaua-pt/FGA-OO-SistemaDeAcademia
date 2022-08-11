package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.BancoDeDados;
import visao.PanelBuscaAluno;
import visao.PanelCadastroAluno;
import visao.PanelCadastroExercicio;
import visao.PanelCadastroTreino;
import visao.PanelEditarAluno;
import visao.PanelRedirecionar;

/**
 * 
 * @author Kaua Vinicius
 * 
 *         Classe respons�vel pelos testes relacionados aos alunos
 *
 */
public class TestesAlunos {

	/**
	 * Metodo que sera chamado antes de cada teste
	 */
	@BeforeEach
	void limparBanco() {
		BancoDeDados.getAlunos().clear();
	}

	@Test
	void testeCadastroAlunoSemDados() {
		/**
		 * Aqui ha o teste para tentativa de cadastrar um aluno caso nao tenha nenhum
		 * dado inserido
		 */

		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(0, BancoDeDados.getAlunos().size());
	}

	@Test
	void testeCadastroAluno() {
		/**
		 * Aqui ha o teste para tentar cadastrar um aluno
		 */
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getAlunos().size());
	}

	@Test
	void cadastroAlunoSemNome() {
		/**
		 * Aqui ha o teste para cadastrar um aluno, entretanto, o campo de nome esta
		 * vazio.
		 */

		BancoDeDados.getAlunos().clear();
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(0, BancoDeDados.getAlunos().size());
	}

	@Test
	void recadastrarAluno() {
		/**
		 * Aqui ha o teste da tentativa de recadastrar um aluno
		 */
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		PanelCadastroAluno segundoCadastroAluno = new PanelCadastroAluno();
		segundoCadastroAluno.getTextNomeAluno().setText("Kauã");
		segundoCadastroAluno.getSpinAltura().setValue(160.0);
		segundoCadastroAluno.getSpinIdade().setValue(19);
		segundoCadastroAluno.getSpinPeso().setValue(60.0);
		segundoCadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getAlunos().size());
	}

	@Test
	void buscarAluno() {
		/**
		 * Aqui ha o teste de busca de aluno
		 */
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		PanelBuscaAluno buscaAluno = new PanelBuscaAluno();
		buscaAluno.getTextField().setText("Kauã");
		buscaAluno.getBtnBuscar().doClick();
		assertEquals(-1, buscaAluno.getListTreinos().getMaxSelectionIndex());
		assertTrue(buscaAluno.getLblNome().getText().contains("Kauã"));
		assertTrue(buscaAluno.getLblAltura().getText().contains("160"));
		assertTrue(buscaAluno.getLblIdade().getText().contains("19"));
		assertTrue(buscaAluno.getLblPeso().getText().contains("60"));
	}

	@Test
	void buscarAlunoTreino() {
		/**
		 * Aqui ha o teste para buscar um treino de um aluno
		 */
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();

		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Cadeira Extensora");
		cadastroE.getComboBoxExercicio().setSelectedIndex(5);
		cadastroE.getTextArea().setText("2x50");
		cadastroE.getBtnCadastrar().doClick();

		PanelCadastroTreino cadastroT = new PanelCadastroTreino();
		cadastroT.getTextField().setText("Treino de peito");
		cadastroT.getComboGrupo().setSelectedIndex(0);
		cadastroT.getComboAluno().setSelectedIndex(0);
		cadastroT.getListExerciciosTreino().setSelectionInterval(0, 0);
		cadastroT.getSpinRep().setValue(4);
		cadastroT.getSpinSerie().setValue(3);
		cadastroT.getBtnCadastrar().doClick();

		PanelBuscaAluno buscaAluno = new PanelBuscaAluno();
		buscaAluno.getTextField().setText("Kauã");
		buscaAluno.getBtnBuscar().doClick();

		assertEquals("Treino de peito", buscaAluno.getListTreinos().getModel().getElementAt(0));
	}

	@Test
	void buscarAlunoInexisteste() {
		/**
		 * Aqui ha o teste de buscar um aluno nao existente
		 */
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelBuscaAluno buscaAluno = new PanelBuscaAluno();
		buscaAluno.getTextField().setText("Kauã");
		buscaAluno.getBtnBuscar().doClick();
		assertTrue(buscaAluno.getPanelNaoEncontrado().isVisible());
	}

	@Test
	void deletarAluno() {
		/**
		 * Aqui ha o teste de deletar um aluno
		 */
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getAlunos().size());
		PanelBuscaAluno buscaAluno = new PanelBuscaAluno();
		buscaAluno.getTextField().setText("Kauã");
		buscaAluno.getBtnBuscar().doClick();
		buscaAluno.getBtnDeletar().doClick();
		assertEquals(0, BancoDeDados.getAlunos().size());
	}

	@Test
	void editarAluno() {
		/**
		 * Aqui ha o teste de editar um aluno
		 */
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertTrue(BancoDeDados.getAlunos().get(0).toString().contains("60"));

		PanelEditarAluno editarA = new PanelEditarAluno(BancoDeDados.getAlunos().get(0));
		editarA.getSpinPeso().setValue(58.0);
		editarA.getBtnCadastrar().doClick();
		assertTrue(BancoDeDados.getAlunos().get(0).toString().contains("58"));
	}
}
