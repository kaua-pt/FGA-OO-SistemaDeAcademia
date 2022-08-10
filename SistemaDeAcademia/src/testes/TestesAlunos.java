package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import modelo.BancoDeDados;
import visao.PanelBuscaAluno;
import visao.PanelCadastroAluno;
import visao.PanelCadastroExercicio;
import visao.PanelCadastroTreino;
import visao.PanelEditarAluno;
import visao.PanelRedirecionar;

public class TestesAlunos {
	
	@Before
	public void limparBanco() {
		BancoDeDados.getAlunos().clear();
	}
	
	@Test
	public void testeCadastroAlunoSemDados() {
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(0, BancoDeDados.getAlunos().size());
	}

	@Test
	public void testeCadastroAluno() {
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
	public void cadastroAlunoSemNome() {
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
	public void recadastrarAluno() {
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
	public void buscarAluno() {
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
		assertEquals(-1,buscaAluno.getListTreinos().getMaxSelectionIndex());
		assertTrue(buscaAluno.getLblNome().getText().contains("Kauã"));
		assertTrue(buscaAluno.getLblAltura().getText().contains("160"));
		assertTrue(buscaAluno.getLblIdade().getText().contains("19"));
		assertTrue(buscaAluno.getLblPeso().getText().contains("60"));
	}
	
	@Test 
	public void buscarAlunoTreino() {
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		
		PanelCadastroExercicio cadastroExercicio = new PanelCadastroExercicio();
		
		PanelCadastroTreino cadastroTreino = new PanelCadastroTreino();
	
		
		
		PanelBuscaAluno buscaAluno = new PanelBuscaAluno();
		buscaAluno.getTextField().setText("Kauã");
		buscaAluno.getBtnBuscar().doClick();
		assertEquals(-1,buscaAluno.getListTreinos().getMaxSelectionIndex());
		assertTrue(buscaAluno.getLblNome().getText().contains("Kauã"));
		assertTrue(buscaAluno.getLblAltura().getText().contains("160"));
		assertTrue(buscaAluno.getLblIdade().getText().contains("19"));
		assertTrue(buscaAluno.getLblPeso().getText().contains("60"));
	}
	
	
	@Test 
	public void buscarAlunoInexisteste() {
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelBuscaAluno buscaAluno = new PanelBuscaAluno();
		buscaAluno.getTextField().setText("Kauã");
		buscaAluno.getBtnBuscar().doClick();
		assertTrue(buscaAluno.getPanelNaoEncontrado().isVisible());
	}
	
	@Test
	public void deletarAluno() {
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1,BancoDeDados.getAlunos().size());
		PanelBuscaAluno buscaAluno = new PanelBuscaAluno();
		buscaAluno.getTextField().setText("Kauã");
		buscaAluno.getBtnBuscar().doClick();
		buscaAluno.getBtnDeletar().doClick();
		assertEquals(0,BancoDeDados.getAlunos().size());
	}
	
	@Test
	public void editarAluno() {
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
