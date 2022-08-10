package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.BancoDeDados;
import visao.PanelCadastroExercicio;
import visao.PanelRedirecionar;

public class TestesExercicios {
	
	@Test
	public void cadastrarExercicio() {
		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Cadeira Extensora");
		cadastroE.getComboBoxExercicio().setSelectedIndex(5);
		cadastroE.getTextArea().setText("2x50");
		cadastroE.getBtnCadastrar().doClick();
		assertTrue(cadastroE.getComboBoxExercicio().getSelectedItem().toString().contains("QUADRICEPS"));
		assertEquals(1, BancoDeDados.getExercicios().size());
	}
	
	@Test
	public void testeCadastroAlunoSemDados() {
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(0, BancoDeDados.getExercicios().size());
	}
	
}
