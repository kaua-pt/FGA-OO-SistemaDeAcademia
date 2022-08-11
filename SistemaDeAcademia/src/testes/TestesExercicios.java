package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.BancoDeDados;
import visao.PanelCadastroExercicio;
import visao.PanelEditarExercicio;
import visao.PanelListarExercicios;
import visao.PanelRedirecionar;

/**
 * 
 * @author Kaua Vinicius
 * 
 *         Classe responsavel pelos testes relacionados aos exercicios.
 *
 */

public class TestesExercicios {

	@BeforeEach
	void antes() {
		/**
		 * Aqui ha o método que será executado antes de qualquer teste
		 */
		BancoDeDados.getExercicios().clear();
	}

	@Test
	void cadastrarExercicio() {
		/**
		 * Aqui ha o teste para cadastrar um exercício
		 */
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
	void testeCadastroExercicioSemDados() {
		/**
		 * Aqui ha o teste de cadastrar um exercicio sem dados
		 */
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(0, BancoDeDados.getExercicios().size());
	}

	@Test
	void editarExercicio() {
		/**
		 * Aqui ha o teste de editar um exercício
		 */
		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Cadeira Extensora");
		cadastroE.getComboBoxExercicio().setSelectedIndex(5);
		cadastroE.getTextArea().setText("2x50");
		cadastroE.getBtnCadastrar().doClick();

		PanelEditarExercicio editarE = new PanelEditarExercicio(BancoDeDados.getExercicios().get(0));
		editarE.getTextNome().setText("Leg press");
		editarE.getBtnFinalizar().doClick();
		assertEquals("Leg press", BancoDeDados.getExercicios().get(0).getNome());
	}

	@Test
	void deletarExercicio() {
		/**
		 * Aqui ha o teste de deletar o exercicio
		 */
		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Crucifixo");
		cadastroE.getComboBoxExercicio().setSelectedIndex(0);
		cadastroE.getTextArea().setText("Voador");
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(1, BancoDeDados.getExercicios().size());

		PanelListarExercicios listaE = new PanelListarExercicios();
		listaE.getBtnBuscar().doClick();
		listaE.getListExercicios().setSelectionInterval(0, 0);
		listaE.getBtnDeletar().doClick();
		assertEquals(0, BancoDeDados.getExercicios().size());
	}
}
