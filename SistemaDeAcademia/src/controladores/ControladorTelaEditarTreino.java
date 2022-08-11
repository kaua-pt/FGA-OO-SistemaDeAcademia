package controladores;

import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import modelo.Treino;
import visao.PanelEditarTreino;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
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
	 * Metodo que ira realizar uma acao para cada botao prescionado pelo usuario.
	 * 
	 * Caso o usuario deseje voltar para a tela inicial, ele sera direcionado para a
	 * tela de inicio por meio do controladorRedirecionar;Caso deseje editar um
	 * treino, os elementos da tela competentes a receber dados serao solicitadas
	 * para serem reinstanciadas em um novo objeto no qual sera enviado ao banco de
	 * dado.Ha tambem a funcao para alternar oque o usuario vera na tela em questao,
	 * caso o botao exercicio seje apertado, o programa ira mostrar para o usuario
	 * elementos como a lista de exercicios compataveis com o grupamento do treino
	 * nos quais podera escolhar um numero de repeticoes e series, entretanto, caso
	 * deseje voltar para a tela inicial de cadastro de exercicio, o botao voltar
	 * deve ser acionado.
	 * 
	 * @param e Object contendo a informacoes do botao precionado
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
	 * Metodo que mostra as informacoes na tela
	 * 
	 * @param treino Treino que contera as informacoes do treino a ser editado
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
