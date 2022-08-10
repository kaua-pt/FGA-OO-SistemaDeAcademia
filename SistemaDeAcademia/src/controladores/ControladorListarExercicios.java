package controladores;

import javax.swing.DefaultListModel;

import modelo.BancoDeDados;
import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import visao.PanelEditarExercicio;
import visao.PanelListarExercicios;

/**
 * @author Kauã Vinícius
 * @version 1.0	
 * 
 * 		Classe criada com o intuito de controlar as ações
 * 		da tela de listagem de exercicios.
 * 
 * @see PanelListarExercicios
 */
@SuppressWarnings("unchecked")
public class ControladorListarExercicios {

	private PanelListarExercicios panel;

	/**
	 * 	Construtor em que inicializa o controlador e integra
	 * o frontend e o backend da respectiva tela.
	 * 
	 * @param tela PanelListarExercicios panel que chamou o controlador
	 */
	public ControladorListarExercicios(PanelListarExercicios panel) {
		this.panel = panel;
	}
	
	/**
	 * Método que irá realizar algo caso algum botão seja
	 * pressionado na tela.
	 * 
	 * O usuário tem a função de voltar para o inicio do programa,
	 * Buscar um Exercicio, no qual irá extrair o nome do exercicio que foi 
	 * inserido e o buscará no banco de dados, Caso seja encontrado,
	 * o usuário pode deletar o exercicio do banco de dados, ou edita-lo
	 * ultimo no qual irá leva-lo a outra tela.
	 * 
	 * Para buscar o aluno, devemos colocar todos os seus nomes em uma lista 
	 * a fim de envia-la para um JList no frontend.Para a edição do exercicio,
	 * deve-se separar o nome de sua descrição, já que o nome vem anexado à 
	 * descriçao do frontend, após isto, apenas resta editar o exercicio com o 
	 * método de editar, caso não seja selecionado nenhum exercício,ele irá 
	 * capturar um erro e não fará nada.
	 * 
	 * @param e Object com as informações do botão precionado.
	 * @see Exercicio
	 * @see DefaultListModel
	 * @see BancoDeDados
	 * @see PanelEditarExercicios
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
				Exercicio.getUmExercicio(nome.substring(0, pos)).deletar();;
				ControladorRedirecionar.caminho(1);
			} catch(Exception error) {
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
				
			} catch(Exception error) {
			}

		} else if (e == panel.getBtnVoltar()) {
			ControladorRedirecionar.caminho(1);
		}
	}
}