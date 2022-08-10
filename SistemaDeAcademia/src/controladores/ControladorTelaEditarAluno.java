package controladores;

import modelo.Aluno;
import visao.PanelEditarAluno;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar as ações
 * 		da tela de consulta de treinos.
 * 
 * @see PanelEditarAluno
 */
public class ControladorTelaEditarAluno {

	private PanelEditarAluno panel;
	private String nomeAluno;

	/**
	 * 	Construtor em que inicializa o controlador e integra
	 * o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelEditarAluno panel que chamou o controlador
	 */
	public ControladorTelaEditarAluno(PanelEditarAluno panel) {
		this.panel = panel;
	}
	
	/**
	 * Método que irá realizar uma ação para cada botão prescionado 
	 * pelo usuário.
	 * 
	 * Caso o usuário deseje retornar ao início, apenas será chamado o 
	 * controlador redirecionar. Caso o usuário queria editar, será feita
	 * uma nova instância de aluno na qual irá substituir a instância que 
	 * será editada no banco de dados.
	 * 
	 * @param e Object contendo a informações do botão precionado 
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
	 * Método que mostra as informações na tela 
	 * 
	 * @param aluno Aluno no qual terá as informações do exercicio
	 * a ser editado
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
