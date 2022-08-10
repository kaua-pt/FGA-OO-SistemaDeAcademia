package Controladores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Aluno;
import Modelo.BancoDeDados;
import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;
import Modelo.Treino;
import Visao.PanelCadastroTreino;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar as ações
 * 		da tela de cadastro de treino.
 * 
 * @see PanelCadastroTreino
 */
@SuppressWarnings("unchecked")
public class ControladorTelaCadastroTreino {

	private PanelCadastroTreino tela;
	
	/**
	 * Construtor do controlador que irá receber a tela que o chamou
	 * realizando a integração entre o frontend e o backend da respectiva
	 * tela. 
	 * 
	 * @param tela PanelCadastroTreino que chamou a tela
	 */
	public ControladorTelaCadastroTreino(PanelCadastroTreino tela) {
		this.tela = tela;
	}

	/**
	 * Método que irá realizar uma ação a cada vez que o usuário apertar 
	 * um botão.
	 * 
	 * Caso o usuário deseje voltar para a tela inicial, ele será direcionado
	 * para a tela de inicio por meio do controladorRedirecionar;Caso deseje
	 * cadastrar um usuário, os elementos da tela competentes a receber dados
	 * serão solicitadas para serem enviadas ao banco de dados, antes de efetivamente
	 * cadastrar o treino, é feito uma validação para analisar se o campo de nome
	 * de treino está vazio , se o treino já está cadastrado no sistema, se a lista
	 * de Exercicios está vazia ou se nenhum aluno foi selecionado.Há também a função
	 * para alternar oque o usuário verá na tela em questão, caso o botão exercício
	 * seje apertado, o programa irá mostrar para o usuário elementos como a lista de
	 * exercícios compatíveis com o grupamento do treino nos quais poderá escolhar um
	 * número de repetições e séries, entretanto, caso deseje voltar para a tela inicial
	 * de cadastro de exercício, o botão voltar deve ser acionado.
	 *
	 * 
	 * @param e Object contendo qual botão o usuário apertou
	 * @see Aluno
	 * @see Treino
	 * @see Exercicio
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == tela.getBtnCadastrar()) {
			if ((tela.getTextField().getText().isBlank() == false) && (tela.getTextField().getText().isEmpty() == false)
					&& (Treino.getUmTreino(tela.getTextField().getText()) == null)
					&& (tela.getListExerciciosTreino().getSelectedIndices().length > 0)
					&& (Aluno.getUmAluno(tela.getComboAluno().getSelectedItem().toString()).getTreinos().size() < 5)) {

				cadastrarTreino(tela.getTextField().getText(), tela.getComboGrupo().getSelectedIndex(),
						tela.getComboAluno().getSelectedItem().toString(),
						tela.getListExerciciosTreino().getSelectedValuesList(), (int) tela.getSpinRep().getValue(),
						(int) tela.getSpinSerie().getValue());

				ControladorRedirecionar.caminho(1);
			}
		} else if (e == tela.getBtnInicio()) {
			ControladorRedirecionar.caminho(1);
		} else if (e == tela.getBtnExercicios()) {

			tela.getListExerciciosTreino().setModel(Exercicio.listaExercicio(tela.getComboGrupo().getSelectedIndex()));
			tela.getPanelMain1().setVisible(false);
			tela.getPanelMain2().setVisible(true);

		} else if (e == tela.getBtnVoltar()) {
			tela.getPanelMain1().setVisible(true);
			tela.getPanelMain2().setVisible(false);
		}
	}
	
	/**
	 * Método responsável por cadastrar o Treino.
	 * 
	 * É criado uma instância de treino no qual será utilizado
	 * o método de cadastro para envia-lo ao banco de dados, para 
	 * ser criado a instância, é utilizado a função parearTipos para 
	 * realizar a conversão do id para o grupamento muscular correspondente.
	 * Logo após, é realizado a anexação do aluno ao treino cadastrado.
	 * 
	 * @param nome String contendo o nome do treino
	 * @param tipos Int contendo o id dos grupamentos musculares do treino
	 * @param nomeAluno String contendo o nome do aluno que receberá o treino
	 * @param nomes List contendo o nome dos exercícios do treino
	 * @param nRep Int contendo o número de repetições do treino
	 * @param nSer Int contendo o número de séries do treino
	 * 
	 * @see Treino
	 * @see Exercicio
	 * @see TipoDeGrupamento
	 * @see anexarTreino
	 */
	public void cadastrarTreino(String nome, int tipos, String nomeAluno, List<String> nomes, int nRep, int nSer) {

		Treino treino = new Treino(nome, TipoDeGrupamento.parearTipos(tipos), Exercicio.parearExercicios(nomes), nRep,
				nSer);
		treino.cadastro();
		anexarTreino(nomeAluno, treino);
	}
	
	/**
	 * Método responsável por anexar o treino ao seu respectivo aluno.
	 * 
	 * É feito uma busca do nome do aluno no banco de dados,e caso o aluno
	 * tenha menos que 3 treinos um novo treino será adicionado para ele, 
	 * caso não, os treinos do aluno se manterão o mesmo.
	 * 
	 * @param alunoNome String contendo o nome do aluno que receberá
	 * o treino
	 * @param treinos Treino contendo o treino que o aluno receberá
	 * @see Aluno
	 * @see BancoDeDados
	 */
	public void anexarTreino(String alunoNome, Treino treinos) {
		ArrayList<Treino> adicionar = new ArrayList<Treino>();
		for (Aluno aluno : BancoDeDados.getAlunos()) {
			if (aluno.getNome() == alunoNome) {
				adicionar.addAll(aluno.getTreinos());
				if (adicionar.size() < 4) {
					adicionar.add(treinos);
				} 
				aluno.setTreinos(adicionar);
			}
		}
	}

}
