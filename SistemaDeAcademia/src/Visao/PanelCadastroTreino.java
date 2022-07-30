package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorExercicio;
import Controladores.ControladorRedirecionar;
import Controladores.ControladorTreino;

public class PanelCadastroTreino extends JPanel {
	private static final long serialVersionUID = 6408302848948208845L;

	ControladorTreino controladorT = new ControladorTreino();
	private JTextField textField;
	private JComboBox comboAluno;
	private JComboBox comboGrupo;
	private JList<String> listExerciciosTreino;
	private JSpinner spinSerie;
	private JSpinner spinRep;
	private JPanel panel;
	private ArrayList<String> stringExercicios;

	private JPanel panelMain2;

	private JLabel lblNewLabel_4;

	private JLabel lblNewLabel_1_2;

	private JLabel lblNewLabel_1_1_1;

	private JPanel panelMain1;

	private JPanel panelVoltarCad;

	private JLabel lblNewLabel_3_3;

	private JLabel lblNewLabel;

	private JPanel faixa;

	private JPanel faixa_1;

	private JPanel panelVoltar;

	private JLabel lblNewLabel_3_1;

	private JLabel lblNewLabel_1;

	private JPanel panel_1_1;

	private JLabel lblNewLabel_3;

	private JPanel panelCadastrar;

	private JLabel lblInsiraOsDados;

	private JLabel lblNewLabel_3_2;

	private JPanel panelVerExercicios;

	private JLabel lblNewLabel_1_1;

	private JLabel lblNewLabel_2;

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

		panelVoltarCad = new JPanel();
		panelVoltarCad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMain1.setVisible(true);
				panelMain2.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelVoltarCad.setBackground(new Color(229, 146, 90));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelVoltarCad.setBackground(new Color(255, 163, 100));
			}
		});
		panelVoltarCad.setLayout(null);
		panelVoltarCad.setBackground(new Color(255, 163, 100));
		panelVoltarCad.setBounds(207, 244, 106, 31);
		panelMain2.add(panelVoltarCad);

		lblNewLabel_3_3 = new JLabel("Voltar");
		lblNewLabel_3_3.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(25, 11, 57, 14);
		panelVoltarCad.add(lblNewLabel_3_3);

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

		panelVoltar = new JPanel();
		panelVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelVoltar.setBackground(new Color(169, 46, 23));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelVoltar.setBackground(new Color(226, 71, 43));
			}
		});
		panelVoltar.setLayout(null);
		panelVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(1);
			}
		});
		panelVoltar.setBackground(new Color(226, 71, 43));
		panelVoltar.setBounds(101, 0, 106, 31);
		faixa_1.add(panelVoltar);

		lblNewLabel_3_1 = new JLabel("Inicio");
		lblNewLabel_3_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(25, 11, 64, 14);
		panelVoltar.add(lblNewLabel_3_1);

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
		comboAluno.setModel(new DefaultComboBoxModel<String>(Controladores.BancoDeDados.getTodosAlunos()));
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

		panelVerExercicios = new JPanel();
		panelVerExercicios.setLayout(null);
		panelVerExercicios.setBackground(new Color(255, 163, 100));
		panelVerExercicios.setBounds(207, 234, 106, 31);
		panelVerExercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DefaultListModel listaModelo = new DefaultListModel();
				stringExercicios = ControladorExercicio.getExercicioPorTipo(
						controladorT.pegarTipos(controladorT.parearIndices(comboGrupo.getSelectedIndex())));

				for (String exercicio : stringExercicios) {
					listaModelo.addElement(exercicio);
				}

				listExerciciosTreino.setModel(listaModelo);

				panelMain1.setVisible(false);
				panelMain2.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelVerExercicios.setBackground(new Color(229, 146, 90));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelVerExercicios.setBackground(new Color(255, 163, 100));
			}
		});
		panelMain1.add(panelVerExercicios);

		lblNewLabel_3_2 = new JLabel("Exerc\u00EDcios");
		lblNewLabel_3_2.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(6, 11, 96, 14);
		panelVerExercicios.add(lblNewLabel_3_2);

		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(126, 0, 279, 26);
		panelMain1.add(lblInsiraOsDados);

		panelCadastrar = new JPanel();
		panelCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelCadastrar.setBackground(new Color(21, 113, 35));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelCadastrar.setBackground(new Color(43, 226, 71));
			}
		});
		panelCadastrar.setBackground(new Color(43, 226, 71));
		panelCadastrar.setBounds(313, 0, 106, 31);
		panelCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if ((textField.getText().isBlank() == false) && (textField.getText().isEmpty() == false)
						&& (ControladorTreino.getUmTreino(textField.getText()) == null)
						&& (listExerciciosTreino.getSelectedIndices().length > 0)) {

					controladorT.cadastrarTreino(textField.getText(), comboGrupo.getSelectedIndex(),
							comboAluno.getSelectedItem().toString(), listExerciciosTreino.getSelectedValuesList(),
							(int) spinRep.getValue(), (int) spinSerie.getValue());
					controlador.caminho(1);
				}

			}
		});
		faixa_1.add(panelCadastrar);
		panelCadastrar.setLayout(null);

		lblNewLabel_3 = new JLabel("Cadastrar");
		lblNewLabel_3.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 96, 14);
		panelCadastrar.add(lblNewLabel_3);
	}
}
