package controladores;

import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import visao.PanelEditarExercicio;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar as ações
 * 		da tela de consulta de treinos.
 * 
 * @see PanelEditarExercicio
 */

public class ControladorTelaEditarExercicio {

	private PanelEditarExercicio panel;
	private Exercicio exercicioAux;
	private String exercicioNome;
	
	/**
	 * 	Construtor em que inicializa o controlador e integra
	 * o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelEditarExercicio panel que chamou o controlador
	 */
	public ControladorTelaEditarExercicio(PanelEditarExercicio panel) {
		this.panel = panel;
	}
	
	/**
	 * Método que irá realizar uma ação para cada botão prescionado 
	 * pelo usuário.
	 * 
	 * Caso o usuário deseje retornar ao início, apenas será chamado o 
	 * controlador redirecionar. Caso o usuário queria editar, será feita
	 * uma nova instância de exercicio na qual irá substituir a instância que 
	 * será editada no banco de dados.
	 * 
	 * @param e Object contendo a informações do botão precionado 
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
	 * Método que mostra as informações na tela 
	 * 
	 * @param exercicio Exercicio no qual terá as informações do exercicio
	 * a ser editado
	 * @see Exercicio
	 */
	public void iniciarCampos(Exercicio exercicio) {
		exercicioNome = exercicio.getNome();
		panel.getTextNome().setText(exercicio.getNome());
		panel.getTextDescricao().setText(exercicio.getDescricao());
		panel.getComboBoxExercicio().setSelectedItem(exercicio.getTipo().get(0));
	}
}
