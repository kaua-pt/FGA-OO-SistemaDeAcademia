package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorRedirecionar;
import Controladores.ControladorTelaCadastroTreino;
import Modelo.BancoDeDados;

public class PanelCadastroTreino extends JPanel implements ActionListener {
	private static final long serialVersionUID = 6408302848948208845L;

	private ControladorTelaCadastroTreino controladorTela;
	private JTextField textField;
	private JComboBox comboAluno;
	private JComboBox comboGrupo;
	private JList<String> listExerciciosTreino;
	private JSpinner spinSerie;
	private JSpinner spinRep;
	private JPanel panel;
	private JPanel panelMain2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_1_1;
	private JPanel panelMain1;
	private JLabel lblNewLabel;
	private JPanel faixa;
	private JPanel faixa_1;
	private JLabel lblNewLabel_1;
	private JPanel panel_1_1;
	private JLabel lblInsiraOsDados;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JButton btnInicio;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private JButton btnExercicios;

	public PanelCadastroTreino(ControladorRedirecionar controlador) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panel = new JPanel();
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		panelMain2 = new JPanel();
		panelMain2.setBounds(0, 61, 529, 277);
		panel.add(panelMain2);
		panelMain2.setVisible(false);
		panelMain2.setLayout(null);

		lblNewLabel_4 = new JLabel("Selecione os exerc\u00EDcios desejados");
		lblNewLabel_4.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblNewLabel_4.setBounds(100, 11, 361, 30);
		panelMain2.add(lblNewLabel_4);

		lblNewLabel_1_2 = new JLabel("S\u00E9ries:");
		lblNewLabel_1_2.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(375, 68, 91, 20);
		panelMain2.add(lblNewLabel_1_2);

		spinSerie = new JSpinner();
		spinSerie.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinSerie.setBounds(375, 99, 65, 20);
		panelMain2.add(spinSerie);

		lblNewLabel_1_1_1 = new JLabel("Repeti\u00E7\u00F5es:");
		lblNewLabel_1_1_1.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(375, 139, 121, 29);
		panelMain2.add(lblNewLabel_1_1_1);

		spinRep = new JSpinner();
		spinRep.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinRep.setBounds(375, 179, 65, 20);
		panelMain2.add(spinRep);

		panelMain1 = new JPanel();
		panelMain1.setVisible(true);
		panelMain1.setBounds(0, 70, 529, 266);
		panel.add(panelMain1);
		panelMain1.setLayout(null);

		lblNewLabel = new JLabel("Cadastro de Treino");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 33, 279, 26);
		panel.add(lblNewLabel);

		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		faixa_1 = new JPanel();
		faixa_1.setBackground(new Color(216, 205, 176));
		faixa_1.setBounds(0, 349, 529, 31);
		panel.add(faixa_1);
		faixa_1.setLayout(null);

		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnInicio.setBounds(96, 0, 117, 31);
		btnInicio.addActionListener(this);
		btnInicio.setBackground(new Color(226, 71, 43));
		faixa_1.add(btnInicio);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnCadastrar.setBounds(311, 0, 117, 31);
		btnCadastrar.setBackground(new Color(43, 226, 71));
		btnCadastrar.addActionListener(this);
		faixa_1.add(btnCadastrar);

		lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(64, 52, 63, 26);
		panelMain1.add(lblNewLabel_1);

		panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(SystemColor.menu);
		panel_1_1.setBounds(126, 37, 342, 47);
		panelMain1.add(panel_1_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 11, 332, 25);
		panel_1_1.add(textField);

		comboAluno = new JComboBox();
		comboAluno.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboAluno.setBounds(126, 116, 343, 31);
		comboAluno.setModel(new DefaultComboBoxModel<String>(BancoDeDados.getTodosAlunos()));
		panelMain1.add(comboAluno);

		lblNewLabel_2 = new JLabel("Aluno:");
		lblNewLabel_2.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(64, 124, 75, 14);
		panelMain1.add(lblNewLabel_2);

		lblNewLabel_1_1 = new JLabel("Tipo:");
		lblNewLabel_1_1.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(64, 195, 63, 26);
		panelMain1.add(lblNewLabel_1_1);

		comboGrupo = new JComboBox();
		comboGrupo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboGrupo.setBounds(125, 193, 343, 31);
		comboGrupo.setModel(new DefaultComboBoxModel(new String[] { "A- Peito, Tr\u00EDceps e Ombro",
				"B- Costa e B\u00EDceps", "C- Perna", "D- Aer\u00F3bico" }));
		panelMain1.add(comboGrupo);

		listExerciciosTreino = new JList();
		listExerciciosTreino.setBorder(new LineBorder(new Color(0, 0, 0)));
		listExerciciosTreino.setVisibleRowCount(80);
		listExerciciosTreino.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listExerciciosTreino.setBounds(27, 44, 338, 189);
		panelMain2.add(listExerciciosTreino);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(204, 244, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(255, 163, 100));
		btnVoltar.setForeground(Color.BLACK);
		panelMain2.add(btnVoltar);

		btnExercicios = new JButton("Exercicios");
		btnExercicios.setBounds(204, 235, 117, 31);
		panelMain1.add(btnExercicios);
		btnExercicios.addActionListener(this);
		btnExercicios.setBackground(new Color(255, 163, 100));
		btnExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 12));

		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(126, 0, 279, 26);
		panelMain1.add(lblInsiraOsDados);

		controladorTela = new ControladorTelaCadastroTreino(this, controlador);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JList<String> getListExerciciosTreino() {
		return listExerciciosTreino;
	}

	public void setListExerciciosTreino(JList<String> listExerciciosTreino) {
		this.listExerciciosTreino = listExerciciosTreino;
	}

	public JComboBox getComboAluno() {
		return comboAluno;
	}

	public JComboBox getComboGrupo() {
		return comboGrupo;
	}

	public JSpinner getSpinSerie() {
		return spinSerie;
	}

	public JSpinner getSpinRep() {
		return spinRep;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnExercicios() {
		return btnExercicios;
	}

	public JPanel getPanelMain2() {
		return panelMain2;
	}

	public JPanel getPanelMain1() {
		return panelMain1;
	}

}
