package controladores;

import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import visao.PanelEditarExercicio;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          consulta de treinos.
 * 
 * @see PanelEditarExercicio
 */

public class ControladorTelaEditarExercicio {

	private PanelEditarExercicio panel;
	private Exercicio exercicioAux;
	private String exercicioNome;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param panel PanelEditarExercicio panel que chamou o controlador
	 */
	public ControladorTelaEditarExercicio(PanelEditarExercicio panel) {
		this.panel = panel;
	}

	/**
	 * Metodo que ira realizar uma acao para cada botao prescionado pelo usuario.
	 * 
	 * Caso o usuario deseje retornar ao inicio, apenas sera chamado o controlador
	 * redirecionar. Caso o usuario queria editar, sera feita uma nova instancia de
	 * exercicio na qual ira substituir a instancia que sera editada no banco de
	 * dados.
	 * 
	 * @param e Object contendo a informacoes do botao precionado
	 * 
	 * @see TipoDeGrupamento
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == panel.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == panel.getBtnFinalizar()) {

			exercicioAux = new Exercicio(panel.getTextNome().getText(),
					TipoDeGrupamento.pegarTipo(panel.getComboBoxExercicio().getSelectedIndex() + 1),
					panel.getTextDescricao().getText());

			exercicioAux.editar(exercicioNome);
			ControladorRedirecionar.caminho(1);
		}

	}

	/**
	 * Metodo que mostra as informacoes na tela
	 * 
	 * @param exercicio Exercicio no qual tera as informacoes do exercicio a ser
	 *                  editado
	 * @see Exercicio
	 */
	public void iniciarCampos(Exercicio exercicio) {
		exercicioNome = exercicio.getNome();
		panel.getTextNome().setText(exercicio.getNome());
		panel.getTextDescricao().setText(exercicio.getDescricao());
		panel.getComboBoxExercicio().setSelectedItem(exercicio.getTipo().get(0));
	}
}
