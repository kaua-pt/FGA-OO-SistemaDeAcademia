package controladores;

import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import modelo.Treino;
import visao.PanelEditarTreino;

/**
 * @author Kauã Vinícius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as ações da tela de
 *          consulta de treinos.
 * 
 * @see PanelEditarTreino
 */
@SuppressWarnings("unchecked")
public class ControladorTelaEditarTreino {

	private PanelEditarTreino tela;
	private String nomeTreino;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param tela PanelEditarTreino panel que chamou o controlador
	 */
	public ControladorTelaEditarTreino(PanelEditarTreino tela) {
		this.tela = tela;
	}

	/**
	 * Método que irá realizar uma ação para cada botão prescionado pelo
	 * usuário.
	 * 
	 * Caso o usuário deseje voltar para a tela inicial, ele será direcionado para
	 * a tela de inicio por meio do controladorRedirecionar;Caso deseje editar um
	 * treino, os elementos da tela competentes a receber dados serão solicitadas
	 * para serem reinstânciadas em um novo objeto no qual será enviado ao banco
	 * de dado.Há também a função para alternar oque o usuário verá na tela em
	 * questão, caso o botão exercício seje apertado, o programa irá mostrar
	 * para o usuário elementos como a lista de exercícios compatíveis com o
	 * grupamento do treino nos quais poderá escolhar um número de repetições e
	 * séries, entretanto, caso deseje voltar para a tela inicial de cadastro de
	 * exercício, o botão voltar deve ser acionado.
	 * 
	 * @param e Object contendo a informações do botão precionado
	 * 
	 * @see TipoDeGrupamento
	 * @see Exercicio
	 * @see Treino
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain2().setVisible(false);
			tela.getPanelMain1().setVisible(true);
		} else if (e == tela.getBtnExercicios()) {
			tela.getListExerciciosTreino().setModel(Exercicio.listaExercicio(tela.getComboGrupo().getSelectedIndex()));
			tela.getPanelMain2().setVisible(true);
			tela.getPanelMain1().setVisible(false);
		} else if (e == tela.getBtnFinalizar()) {

			Treino treinoaux = new Treino(tela.getTextNome().getText(),
					TipoDeGrupamento.parearTipos(tela.getComboGrupo().getSelectedIndex()),
					Exercicio.parearExercicios(tela.getListExerciciosTreino().getSelectedValuesList()),
					(int) tela.getSpinnerRepeticao().getValue(), (int) tela.getSpinnerSerie().getValue());

			treinoaux.editar(nomeTreino);

			ControladorRedirecionar.caminho(1);
		}
	}

	/**
	 * Método que mostra as informações na tela
	 * 
	 * @param treino Treino que conterá as informações do treino a ser editado
	 * @see Treino
	 */
	public void iniciarTela(Treino treino) {
		nomeTreino = treino.getNome();
		tela.getTextNome().setText(treino.getNome());
		tela.getComboGrupo().setSelectedItem(treino.getTipo());
		tela.getSpinnerRepeticao().setValue(treino.getnRepeticao());
		tela.getSpinnerSerie().setValue(treino.getnSerie());
	}
}
