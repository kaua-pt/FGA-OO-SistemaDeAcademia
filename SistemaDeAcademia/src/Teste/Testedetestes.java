/**
 * 
 */
package Teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Modelo.BancoDeDados;
import Visao.PanelCadastroAluno;
import Visao.PanelMenu;
import Visao.PanelRedirecionar;

/**
 * @author PC
 *
 */

public class Testedetestes {

	@BeforeAll
	public static void iniciar() {
		PanelMenu frame = new PanelMenu("Dale");
	}

	@AfterAll
	public static void finalizar() {
		System.out.println("final");
	}

	@Test
	public void testeInicializacao() {
		PanelMenu frame = new PanelMenu("Dale");
		String titulo = frame.getLabelTitulo().getText();
		assertEquals("Dale", titulo);
	}

	@Test
	public void testeCadastroAlunoSemDados() {
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(0, BancoDeDados.alunos.size());
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
		assertEquals(1, BancoDeDados.alunos.size());
	}

}
