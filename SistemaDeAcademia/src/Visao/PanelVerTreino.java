package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorVerTreino;
import Modelo.Treino;

public class PanelVerTreino extends JPanel implements ActionListener {

	private JPanel panel;
	private JPanel panel_1;
	private JButton btnVoltar;
	private JButton btnEditar;
	private JLabel lblNome;
	private JLabel lblAluno;
	private JLabel lblSeries;
	private JLabel lblRepeticoes;
	private JList listExerciciosTreino;
	private JLabel lblExercicios;
	private JTextArea textTipo;
	private ControladorVerTreino controladorTela;

	public PanelVerTreino(Treino treino) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);
		panel_1.setBounds(0, 357, 527, 28);
		add(panel_1);

		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.setBounds(116, 0, 89, 28);
		btnVoltar.addActionListener(this);
		panel_1.add(btnVoltar);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnEditar.setBackground(Color.GREEN);
		btnEditar.setBounds(321, 0, 89, 28);
		panel_1.add(btnEditar);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);
		panel.setBounds(0, 11, 529, 28);
		add(panel);

		lblNome = new JLabel();
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(122, 0, 290, 26);
		panel.add(lblNome);
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 16));

		lblAluno = new JLabel();
		lblAluno.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblAluno.setBounds(10, 70, 254, 14);
		add(lblAluno);

		lblSeries = new JLabel();
		lblSeries.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblSeries.setBounds(10, 199, 254, 20);
		add(lblSeries);

		lblRepeticoes = new JLabel();
		lblRepeticoes.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblRepeticoes.setBounds(10, 258, 254, 29);
		add(lblRepeticoes);

		listExerciciosTreino = new JList();
		listExerciciosTreino.setVisibleRowCount(80);
		listExerciciosTreino.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listExerciciosTreino.setBorder(new LineBorder(new Color(0, 0, 0)));
		listExerciciosTreino.setBounds(274, 97, 245, 235);
		add(listExerciciosTreino);

		lblExercicios = new JLabel("Exercicios:");
		lblExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblExercicios.setBounds(274, 63, 110, 26);
		add(lblExercicios);

		controladorTela = new ControladorVerTreino(this, treino);

		textTipo = new JTextArea();
		textTipo.setLineWrap(true);
		textTipo.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		textTipo.setEditable(false);
		textTipo.setBounds(10, 121, 254, 43);
		add(textTipo);
		controladorTela.inicializar();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorTela.acaoPerformada(e.getSource());
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblAluno() {
		return lblAluno;
	}

	public void setLblAluno(JLabel lblAluno) {
		this.lblAluno = lblAluno;
	}

	public JTextArea getTextTipo() {
		return textTipo;
	}

	public void setTextTipo(JTextArea textTipo) {
		this.textTipo = textTipo;
	}

	public JLabel getLblSeries() {
		return lblSeries;
	}

	public void setLblSeries(JLabel lblSeries) {
		this.lblSeries = lblSeries;
	}

	public JLabel getLblRepeticoes() {
		return lblRepeticoes;
	}

	public void setLblRepeticoes(JLabel lblRepeticoes) {
		this.lblRepeticoes = lblRepeticoes;
	}

	public JList getListExerciciosTreino() {
		return listExerciciosTreino;
	}

	public void setListExerciciosTreino(JList listExerciciosTreino) {
		this.listExerciciosTreino = listExerciciosTreino;
	}
}
