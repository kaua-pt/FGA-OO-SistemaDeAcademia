/**
 *
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * @author Kauï¿½ Vinï¿½cius
 *
 *         Classe responsï¿½vel por armazenar elementos da classe exercï¿½cio
 */
public class Exercicio extends BaseAcademia implements Operacoes {

	private String descricao;

	public Exercicio(String nome, ArrayList<TipoDeGrupamento> tipo, String descricao) {
		super(nome, tipo);
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + " Grupamento: " + this.getTipo() + " Descrição : " + this.getDescricao();
	}

	@Override
	public void cadastro() {
		BancoDeDados.exercicios.add(this);
	}

	@Override
	public void editar(String endereco) {
		for (int i = 0; i <= BancoDeDados.exercicios.size(); i++) {
			if (BancoDeDados.exercicios.get(i).getNome().contains(endereco)) {
				BancoDeDados.exercicios.set(i, this);
				return;
			}
		}
		BancoDeDados.exercicios.add(this);
	}

	@Override
	public void deletar() {
		for (int i = 0; i < BancoDeDados.exercicios.size(); i++) {
			System.out.println("vrau2");
			System.out.println(this.getNome());
			if (BancoDeDados.exercicios.get(i).getNome().equals(this.getNome())) {
				System.out.println("vrau3");
				BancoDeDados.exercicios.remove(i);
			}
		}
		for (Treino treino : BancoDeDados.treinos) {
			for (int j = 0; j < treino.getExercicios().size(); j++) {
				if (treino.getExercicios().get(j).getNome().equals(this.getNome())) {
					treino.getExercicios().remove(j);
				}
			}
		}

	}

	public static ArrayList<String> getExercicioPorTipo(ArrayList<TipoDeGrupamento> tipos) {

		ArrayList<String> retorno = new ArrayList<String>();
		for (TipoDeGrupamento grupo : tipos) {
			for (int i = 0; i < BancoDeDados.exercicios.size(); i++) {
				if (BancoDeDados.exercicios.get(i).toString().contains(grupo.name())) {
					retorno.add(BancoDeDados.exercicios.get(i).getNome());
				}
			}
		}
		return retorno;
	}

	public static Exercicio getUmExercicio(String nome) {
		for (Exercicio exercicioComparado : BancoDeDados.exercicios) {
			if (nome.equals(exercicioComparado.getNome())) {
				return exercicioComparado;
			}
		}
		return null;
	}

	public static DefaultListModel listaExercicio(int index) {
		ArrayList<String> stringExercicios;
		DefaultListModel listaModelo = new DefaultListModel();

		stringExercicios = Exercicio.getExercicioPorTipo(TipoDeGrupamento.parearTipos(index));
		for (String exercicio : stringExercicios) {
			listaModelo.addElement(exercicio);
		}

		return listaModelo;
	}

	public static ArrayList<Exercicio> parearExercicios(List<String> nomes) {
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		for (String nome : nomes) {
			for (Exercicio exercicioUnico : BancoDeDados.exercicios) {
				if (nome == exercicioUnico.getNome()) {
					exercicios.add(exercicioUnico);
				}
			}
		}
		return exercicios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
