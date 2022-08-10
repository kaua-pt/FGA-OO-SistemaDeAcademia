package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.BancoDeDados;
import visao.PanelCadastroAluno;
import visao.PanelCadastroExercicio;
import visao.PanelCadastroTreino;
import visao.PanelConsultaTreino;
import visao.PanelRedirecionar;

public class TestesTreino {
	@Test
	public void cadastrarTreino() {
		
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1,BancoDeDados.getAlunos().size());
		
		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Voador");
		cadastroE.getComboBoxExercicio().setSelectedIndex(0);
		cadastroE.getTextArea().setText("Crucifixo");
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(1,BancoDeDados.getExercicios().size());
		
		new PanelRedirecionar("Treinos", "Consultar ");
		PanelCadastroTreino cadastroT = new PanelCadastroTreino();
		cadastroT.getTextField().setText("Treino de peito");
		cadastroT.getComboGrupo().setSelectedIndex(0);
		cadastroT.getComboAluno().setSelectedIndex(0);
		cadastroT.getListExerciciosTreino().setSelectionInterval(0, 0);;
		System.out.println(cadastroT.getListExerciciosTreino().getSelectedIndex());
		cadastroT.getSpinRep().setValue(4);
		cadastroT.getSpinSerie().setValue(3);
		cadastroT.getBtnCadastrar().doClick();
		assertEquals(1,BancoDeDados.getTreinos().size());
	}
	
	@Test
	public void deletarTreino() {
		new PanelRedirecionar("Alunos", "Consultar ");
		PanelCadastroAluno cadastroAluno = new PanelCadastroAluno();
		cadastroAluno.getTextNomeAluno().setText("Kauã");
		cadastroAluno.getSpinAltura().setValue(160.0);
		cadastroAluno.getSpinIdade().setValue(19);
		cadastroAluno.getSpinPeso().setValue(60.0);
		cadastroAluno.getBtnCadastrar().doClick();
		assertEquals(1,BancoDeDados.getAlunos().size());
		
		new PanelRedirecionar("Exercicios", "Consultar ");
		PanelCadastroExercicio cadastroE = new PanelCadastroExercicio();
		cadastroE.getNomeExercicio().setText("Voador");
		cadastroE.getComboBoxExercicio().setSelectedIndex(0);
		cadastroE.getTextArea().setText("Crucifixo");
		cadastroE.getBtnCadastrar().doClick();
		assertEquals(1,BancoDeDados.getExercicios().size());
		
		new PanelRedirecionar("Treinos", "Consultar ");
		PanelCadastroTreino cadastroT = new PanelCadastroTreino();
		cadastroT.getTextField().setText("Treino de peito");
		cadastroT.getComboGrupo().setSelectedIndex(0);
		cadastroT.getComboAluno().setSelectedIndex(0);
		cadastroT.getListExerciciosTreino().setSelectionInterval(0, 0);
		cadastroT.getSpinRep().setValue(4);
		cadastroT.getSpinSerie().setValue(3);
		cadastroT.getBtnCadastrar().doClick();
		
		PanelConsultaTreino consultaT =  new PanelConsultaTreino();
		consultaT.getListTreinos().setSelectedValue("Treino de peito", false);
		consultaT.getBtnDeletar().doClick();
		assertEquals(0,BancoDeDados.getTreinos().size());
	}
}
