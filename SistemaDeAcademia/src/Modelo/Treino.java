/**
 *
 */
package Modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

/**
 * @author Kau� Vin�cius
 *
 *         Classe respons�vel por armazenar informa��es sobre os treinos
 */

public class Treino extends BaseAcademia implements Operacoes {

	private ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
	private int nRepeticao;
	private int nSerie;

	public Treino(String nome, ArrayList<TipoDeGrupamento> tipo, ArrayList<Exercicio> exercicios, int nRepeticao,
			int nSerie) {

		super(nome, tipo);
		this.exercicios = exercicios;
		this.nRepeticao = nRepeticao;
		this.nSerie = nSerie;
	}

	@Override
	public String toString() {
		return "Treino com nome: " + this.getNome() + "Com os exercicios: " + this.getExercicios();
	}

	@Override
	public void cadastro() {
		BancoDeDados.treinos.add(this);
	}

	@Override
	public void editar(String endereco) {
		for (int i = 0; i <= BancoDeDados.treinos.size(); i++) {
			if (BancoDeDados.treinos.get(i).getNome().contains(this.getNome())) {
				BancoDeDados.treinos.set(i, this);
			}
		}
	}

	@Override
	public void deletar() {
		for (int i = 0; i <= BancoDeDados.treinos.size(); i++) {
			if (BancoDeDados.treinos.get(i).getNome().contains(this.getNome())) {
				BancoDeDados.treinos.remove(i);
			}
		}
		for (Aluno aluno : BancoDeDados.alunos) {
			for (int j = 0; j <= aluno.getTreinos().size(); j++) {
				if (aluno.getTreinos().get(j).getNome().contains(this.getNome())) {
					aluno.getTreinos().remove(j);
				}
			}
		}
	}

	public static Treino getUmTreino(String nome) {
		for (Treino treinoComparado : BancoDeDados.treinos) {
			if (nome.equals(treinoComparado.getNome())) {
				return treinoComparado;
			}
		}
		return null;
	}

	public String getNomesTipo() {
		String stringTipos = "";
		for (TipoDeGrupamento tipo : this.getTipo()) {
			stringTipos = stringTipos + "," + tipo.toString().toLowerCase();
		}
		return stringTipos.substring(1, stringTipos.length() - 1);
	}

	public DefaultListModel<String> getNomesExercicios() {
		DefaultListModel<String> listaRetorno = new DefaultListModel<String>();

		for (int i = 0; i < this.getExercicios().size(); i++) {
			listaRetorno.addElement(this.getExercicios().get(i).getNome());
		}
		return listaRetorno;
	}

	public String getAlunoAnexado() {
		for (Aluno aluno : BancoDeDados.alunos) {
			for (int i = 0; i < aluno.getTreinos().size(); i++) {
				if (aluno.getTreinos().get(0).getNome().equals(this.getNome())) {
					return aluno.getNome();
				}
			}
		}
		return null;
	}

	public int getnRepeticao() {
		return nRepeticao;
	}

	public void setnRepeticao(int nRepeticao) {
		this.nRepeticao = nRepeticao;
	}

	public int getnSerie() {
		return nSerie;
	}

	public void setnSerie(int nSerie) {
		this.nSerie = nSerie;
	}

	public ArrayList<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(ArrayList<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

}
