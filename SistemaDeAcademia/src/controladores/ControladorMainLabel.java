/**
 * 
 */
package controladores;

import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.JPanel;

import modelo.Aluno;
import modelo.BancoDeDados;
import modelo.Exercicio;
import modelo.TipoDeGrupamento;
import modelo.Treino;
import visao.PanelInicio;
import visao.PanelMenu;
import visao.PanelRedirecionar;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe criada com o intuito de controlar as acoes no panel menu
 * 
 * @see PanelMenu
 */
public class ControladorMainLabel {

	private PanelMenu tela;
	private JPanel[] telas = new JPanel[12];

	/**
	 * Construtor no qual inicializa com a tela Menu
	 * 
	 * @param painelMenu Tela em que serao adicionada as subtelas
	 * @see PanelMenu
	 */
	public ControladorMainLabel(PanelMenu painelMenu) {
		this.tela = painelMenu;
	}

	/**
	 * Metodo que ira redirecionar o usuario para as diversas funcoes do programa,
	 * que esta separada entre alunos, exercicios e treinos.
	 * 
	 * No metodo, e chamado a funcao esconder telas, apos isso, e inicializada a
	 * tela com o respectivo id, no qual sera adicionada a tela de painel menu e
	 * adicionada em uma array
	 * 
	 * @param id Int contendo o id da tela que deseja chamar.
	 * @see esconderTelas
	 * @see operarTela
	 * @see PanelInicio
	 * @see Panel Redirecionar
	 */
	public void caminho(int id) {
		esconderTelas();

		if (id == 1) {
			PanelInicio inicio = new PanelInicio();
			operarTela(id, inicio);

		} else if (id == 2) {
			PanelRedirecionar redirecionarAluno = new PanelRedirecionar("Alunos", "Consultar ");
			operarTela(id, redirecionarAluno);

		} else if (id == 3) {
			PanelRedirecionar redirecionarExercicio = new PanelRedirecionar("Exercicios", "Listar ");
			operarTela(id, redirecionarExercicio);

		} else if (id == 4) {
			PanelRedirecionar redirecionarTreino = new PanelRedirecionar("Treinos", "Consultar ");
			operarTela(id, redirecionarTreino);
		} else if (id == 5) {
			tela.dispose();
		}
	}

	/**
	 * Metodo no qual ira adicionar a tela criada em uma array e adiciona-la a tela
	 * de menu, isso deve ocorrer para a tela ser sobrescrita a cada vez que o
	 * usuario apertar um botao
	 * 
	 * @param id       Int contendo o id da tela
	 * @param elemento JPanel tela em que sera operada
	 */
	public void operarTela(int id, JPanel elemento) {
		telas[id - 1] = elemento;
		this.tela.getPanelMainMenu().add(elemento);
		elemento.setVisible(true);
	}

	/**
	 * Metodo em que ira deixar todas as JPanels salvas no array invisiveis.
	 * 
	 * E utilizado um loop for para percorrer as tela, e para cada tela sua
	 * visibilidade se torna falsa.
	 */
	public void esconderTelas() {
		for (JPanel telaCriada : telas) {
			if (telaCriada != null) {
				telaCriada.setVisible(false);
			}
		}
	}
	
	/**
	 * Metodo responsavel por iniciar as variaveis para o programa
	 * 
	 * @see Aluno
	 * @see BancoDeDados
	 * @see Exercicio
	 * @see ArrayList
	 * @see Treino
	 */
	public void iniciarValores() {
		//Iniciar alunos
		Aluno aluno = new Aluno("Paulo Muzy",43,185,93);
		BancoDeDados.getAlunos().add(aluno);
		Aluno aluno1 = new Aluno("Neymar",30,175,68);
		BancoDeDados.getAlunos().add(aluno1);
		Aluno aluno2 = new Aluno("Roberto Dinamite",68,186,50);
		BancoDeDados.getAlunos().add(aluno2);
		
		//Iniciar Exercicios
		ArrayList<TipoDeGrupamento> tipo =  new ArrayList<TipoDeGrupamento>();
		tipo.add(TipoDeGrupamento.PEITO);
		System.out.println(tipo);
		Exercicio exercicio = new Exercicio("Supino Reto",tipo,"4x15");
		BancoDeDados.getExercicios().add(exercicio);
		
		ArrayList<TipoDeGrupamento> tipo1 =  new ArrayList<TipoDeGrupamento>();
		tipo1.add(TipoDeGrupamento.COSTA);
		Exercicio exercicio1 = new Exercicio("Remada Baixa",tipo1,"3x15 Barra Romana");
		BancoDeDados.getExercicios().add(exercicio1);
		
		ArrayList<TipoDeGrupamento> tipo2 =  new ArrayList<TipoDeGrupamento>();
		tipo2.add(TipoDeGrupamento.TRICEPS);
		Exercicio exercicio2 = new Exercicio("Tríceps Sinuca",tipo2,"3x15 na Corda");
		BancoDeDados.getExercicios().add(exercicio2);
		
		ArrayList<TipoDeGrupamento> tipo3 =  new ArrayList<TipoDeGrupamento>();
		tipo3.add(TipoDeGrupamento.OMBRO);
		Exercicio exercicio3 = new Exercicio("Desenvolvimento Arnold",tipo3,"3x10 Sentado no banco");
		BancoDeDados.getExercicios().add(exercicio3);
		
		ArrayList<TipoDeGrupamento> tipo4 =  new ArrayList<TipoDeGrupamento>();
		tipo4.add(TipoDeGrupamento.BICEPS);
		Exercicio exercicio4 = new Exercicio("Scott",tipo4,"3x MAX");
		BancoDeDados.getExercicios().add(exercicio4);
		
		ArrayList<TipoDeGrupamento> tipo5 =  new ArrayList<TipoDeGrupamento>();
		tipo5.add(TipoDeGrupamento.QUADRICEPS);
		Exercicio exercicio5 = new Exercicio("Cadeira Extensora",tipo5,"2x50");
		BancoDeDados.getExercicios().add(exercicio5);
		
		ArrayList<TipoDeGrupamento> tipo6 =  new ArrayList<TipoDeGrupamento>();
		tipo6.add(TipoDeGrupamento.POSTERIOR);
		Exercicio exercicio6 = new Exercicio("Stiff",tipo6,"3x10 na barra");
		BancoDeDados.getExercicios().add(exercicio6);
		
		ArrayList<TipoDeGrupamento> tipo7 =  new ArrayList<TipoDeGrupamento>();
		tipo7.add(TipoDeGrupamento.PANTURRILHA);
		Exercicio exercicio7 = new Exercicio("Cavalinho",tipo7,"4x15 + max");
		BancoDeDados.getExercicios().add(exercicio7);
		
		ArrayList<TipoDeGrupamento> tipo8 =  new ArrayList<TipoDeGrupamento>();
		tipo8.add(TipoDeGrupamento.AEROBICO);
		Exercicio exercicio8 = new Exercicio("Corrida",tipo8,"15 minutos no 14 para atingir 3 km");
		BancoDeDados.getExercicios().add(exercicio8);
		
		// Inicializando treinos
		ArrayList<TipoDeGrupamento> tipo9 =  new ArrayList<TipoDeGrupamento>();
		tipo9.add(TipoDeGrupamento.PEITO);
		tipo9.add(TipoDeGrupamento.TRICEPS);
		tipo9.add(TipoDeGrupamento.OMBRO);
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		exercicios.add(exercicio);
		exercicios.add(exercicio2);
		exercicios.add(exercicio3);
		Treino treinos =  new Treino("Treino pesado de peito",tipo9,exercicios,3,10);
		anexarTreino("Paulo Muzy", treinos);
		BancoDeDados.getTreinos().add(treinos);
		
		ArrayList<TipoDeGrupamento> tipo10 =  new ArrayList<TipoDeGrupamento>();
		tipo10.add(TipoDeGrupamento.COSTA);
		tipo10.add(TipoDeGrupamento.BICEPS);
		ArrayList<Exercicio> exercicios1 = new ArrayList<Exercicio>();
		exercicios1.add(exercicio1);
		exercicios1.add(exercicio4);
		Treino treinos2 =  new Treino("Treino pesado de costas",tipo10,exercicios1,3,10);
		anexarTreino("Paulo Muzy", treinos2);
		BancoDeDados.getTreinos().add(treinos2);
		
		ArrayList<TipoDeGrupamento> tipo11 =  new ArrayList<TipoDeGrupamento>();
		tipo11.add(TipoDeGrupamento.QUADRICEPS);
		tipo11.add(TipoDeGrupamento.POSTERIOR);
		tipo11.add(TipoDeGrupamento.PANTURRILHA);
		ArrayList<Exercicio> exercicios3 = new ArrayList<Exercicio>();
		exercicios3.add(exercicio5);
		exercicios3.add(exercicio6);
		exercicios3.add(exercicio7);
		Treino treinos3 =  new Treino("Treino pesado de perna",tipo11,exercicios3,3,10);
		anexarTreino("Paulo Muzy", treinos3);
		BancoDeDados.getTreinos().add(treinos3);
		
		ArrayList<TipoDeGrupamento> tipo12 =  new ArrayList<TipoDeGrupamento>();
		tipo12.add(TipoDeGrupamento.AEROBICO);
		ArrayList<Exercicio> exercicios4 = new ArrayList<Exercicio>();
		exercicios4.add(exercicio8);
		Treino treinos4 =  new Treino("Corrida pesada",tipo12,exercicios4,3,10);
		anexarTreino("Paulo Muzy", treinos4);
		BancoDeDados.getTreinos().add(treinos4);
		
	}
	
	/**
	 * Metodo responsavel por anexar o treino ao seu respectivo aluno.
	 * 
	 * E feito uma busca do nome do aluno no banco de dados,e caso o aluno tenha
	 * menos que 3 treinos um novo treino sera adicionado para ele, caso nao, os
	 * treinos do aluno se manterao o mesmo.
	 * 
	 * @param alunoNome String contendo o nome do aluno que recebera o treino
	 * @param treinos   Treino contendo o treino que o aluno recebera
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
