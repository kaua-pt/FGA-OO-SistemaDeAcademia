package controladores;

import javax.swing.DefaultListModel;

import modelo.BancoDeDados;
import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import visao.PanelEditarExercicio;
import visao.PanelListarExercicios;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes da tela de
 *          listagem de exercicios.
 * 
 * @see PanelListarExercicios
 */
@SuppressWarnings("unchecked")
public class ControladorListarExercicios {

	private PanelListarExercicios panel;

	/**
	 * Construtor em que inicializa o controlador e integra o frontend e o backend
	 * da respectiva tela.
	 * 
	 * @param panel PanelListarExercicios panel que chamou o controlador
	 */
	public ControladorListarExercicios(PanelListarExercicios panel) {
		this.panel = panel;
	}

	/**
	 * Metodo que ira realizar algo caso algum botao seja pressionado na tela.
	 * 
	 * O usuario tem a funcao de voltar para o inicio do programa, Buscar um
	 * Exercicio, no qual ira extrair o nome do exercicio que foi inserido e o
	 * buscara no banco de dados, Caso seja encontrado, o usuario pode deletar o
	 * exercicio do banco de dados, ou edita-lo ultimo no qual ira leva-lo a outra
	 * tela.
	 * 
	 * Para buscar o aluno, devemos colocar todos os seus nomes em uma lista a fim
	 * de envia-la para um JList no frontend.Para a edicao do exercicio, deve-se
	 * separar o nome de sua descricao, ja que o nome vem anexado a descricao do
	 * frontend, apos isto, apenas resta editar o exercicio com o metodo de editar,
	 * caso nao seja selecionado nenhum exercicio,ele ira capturar um erro e nao
	 * fara nada.
	 * 
	 * @param e Object com as informacoes do botao precionado.
	 * @see Exercicio
	 * @see DefaultListModel
	 * @see BancoDeDados
	 * @see PanelEditarExercicio
	 * @see TipoDeGrupamento
	 * @see ControladorRedirecionar
	 */
	public void acaoPerformada(Object e) {
		if (e == panel.getBtnBuscar()) {
			DefaultListModel<Object> retorno = new DefaultListModel<Object>();
			for (Exercicio exercicio : BancoDeDados.getExercicios()) {
				if (exercicio.getTipo()
						.equals(TipoDeGrupamento.pegarTipo(panel.getComboGrupamento().getSelectedIndex() + 1))) {
					retorno.addElement(exercicio.getNome() + "-" + exercicio.getDescricao());
				}
			}

			panel.getListExercicios().setModel(retorno);

		} else if (e == panel.getBtnDeletar()) {
			try {
				String nome = panel.getListExercicios().getSelectedValue().toString();
				int pos = nome.indexOf("-");
				nome.substring(0, pos);
				Exercicio.getUmExercicio(nome.substring(0, pos)).deletar();
				;
				ControladorRedirecionar.caminho(1);
			} catch (Exception error) {
			}

		} else if (e == panel.getBtnEditar()) {

			try {
				String nome = panel.getListExercicios().getSelectedValue().toString();
				int pos = nome.indexOf("-");
				nome.substring(0, pos);
				PanelEditarExercicio panelExercicio = new PanelEditarExercicio(
						Exercicio.getUmExercicio(nome.substring(0, pos)));
				panel.add(panelExercicio);
				panel.getPanelmain().setVisible(false);

			} catch (Exception error) {
			}

		} else if (e == panel.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}
}
