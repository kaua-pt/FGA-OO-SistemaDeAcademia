package testes;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import modelo.BancoDeDados;
import visao.PanelBuscaAluno;
import visao.PanelCadastroAluno;
import visao.PanelRedirecionar;

public class TestesAlunos {
	
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
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
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
		
	}
}
