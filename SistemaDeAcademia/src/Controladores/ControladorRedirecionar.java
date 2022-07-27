package Controladores;

import java.util.ArrayList;

import javax.swing.JPanel;

import Modelo.Aluno;
import Modelo.TipoDeGrupamento;
import Visao.AlunoEncontrado;
import Visao.PanelBuscaAluno;
import Visao.PanelCadastroAluno;
import Visao.PanelCadastroExercicio;
import Visao.PanelCadastroTreino;
import Visao.PanelTreinoExercicios;

public class ControladorRedirecionar {

	private JPanel tela;
	private JPanel padrao;
	private JPanel[] telas = new JPanel[12];
	private JPanel[] buscaAtual = new JPanel[12];

	public ControladorRedirecionar(JPanel tela, JPanel padrao) {
		this.tela = tela;
		this.padrao = padrao;
	}

	public void caminho(int id) {
		this.padrao.setVisible(false);
		esconderTelas();

		if (id == 1) {
			operarTela(id, this.padrao);
		} else if (id == 2) {
			PanelCadastroAluno cadastroA = new PanelCadastroAluno(this);
			operarTela(id, cadastroA);
		} else if (id == 3) {
			PanelCadastroExercicio cadastroE = new PanelCadastroExercicio(this);
			operarTela(id, cadastroE);
		} else if (id == 4) {
			PanelCadastroTreino cadastroT = new PanelCadastroTreino(this);
			operarTela(id, cadastroT);
		} else if (id == 5) {
			PanelBuscaAluno buscaA = new PanelBuscaAluno(this);
			operarTela(id, buscaA);
		}

	}

	public void caminhoBuscaA(JPanel elemento, Aluno aluno) {
		AlunoEncontrado alunoE = new AlunoEncontrado(aluno);
		buscaAtual[0] = alunoE;
		elemento.add(buscaAtual[0]);
		elemento.setVisible(true);
	}

	public void caminhoT(ControladorTreino controlador, ArrayList<TipoDeGrupamento> lista) {
		esconderTelas();
		PanelTreinoExercicios TE = new PanelTreinoExercicios(this, controlador, lista);
		operarTela(10, TE);
	}

	public void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		this.tela.add(elemento);
		elemento.setVisible(true);
	}

	public void esconderTelas() {
		for (JPanel telaCriada : telas) {
			if (telaCriada != null) {
				telaCriada.setVisible(false);
			}
		}
	}

}
