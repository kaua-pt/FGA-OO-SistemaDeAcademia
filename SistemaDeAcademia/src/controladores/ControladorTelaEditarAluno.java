package controladores;

import modelo.Aluno;
import visao.PanelEditarAluno;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          consulta de treinos.
 * 
 * @see PanelEditarAluno
 */
public class ControladorTelaEditarAluno {

	private PanelEditarAluno panel;
	private String nomeAluno;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param panel PanelEditarAluno panel que chamou o controlador
	 */
	public ControladorTelaEditarAluno(PanelEditarAluno panel) {
		this.panel = panel;
	}

	/**
	 * Metodo que ira realizar uma acao para cada botao prescionado pelo usuario.
	 * 
	 * Caso o usuario deseje retornar ao inicio, apenas sera chamado o controlador
	 * redirecionar. Caso o usuario queria editar, sera feita uma nova instancia de
	 * aluno na qual ira substituir a instancia que sera editada no banco de dados.
	 * 
	 * @param e Object contendo a informacoes do botao precionado
	 * 
	 * @see Aluno
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == panel.getBtnCadastrar()) {
			Aluno alunoSet = new Aluno(panel.getTextNomeAluno().getText(), (int) panel.getSpinIdade().getValue(),
					(double) panel.getSpinAltura().getValue(), (double) panel.getSpinPeso().getValue());
			alunoSet.editar(nomeAluno);
			ControladorRedirecionar.caminho(1);
		} else if (e == panel.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}

	/**
	 * Metodo que mostra as informacoes na tela
	 * 
	 * @param aluno Aluno no qual tera as informacoes do exercicio a ser editado
	 * @see Aluno
	 */
	public void setarInformacoes(Aluno aluno) {
		nomeAluno = aluno.getNome();
		panel.getTextNomeAluno().setText(aluno.getNome());
		panel.getSpinAltura().setValue(aluno.getAltura());
		panel.getSpinIdade().setValue(aluno.getIdade());
		panel.getSpinPeso().setValue(aluno.getPeso());
	}

}
