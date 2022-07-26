package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

import Controladores.BancoDeDados;
import Controladores.ControladorRedirecionar;
import Controladores.ControladorTreino;
import Modelo.TipoDeGrupamento;

public class PanelTreinoExercicios extends JPanel {

	@SuppressWarnings("removal")
	public PanelTreinoExercicios(ControladorRedirecionar controlador, ControladorTreino controladorT,
			ArrayList<TipoDeGrupamento> tipos) {

		ArrayList<String> stringExercicios = new ArrayList<String>();

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecione os exerc\u00EDcios desejados");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblNewLabel.setBounds(95, 22, 361, 30);
		add(lblNewLabel);

		JPanel Faixa_1 = new JPanel();
		Faixa_1.setLayout(null);
		Faixa_1.setBackground(new Color(216, 205, 176));
		Faixa_1.setBounds(0, 358, 529, 31);
		add(Faixa_1);

		JPanel panelVoltar = new JPanel();
		panelVoltar.setLayout(null);
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
		panelVoltar.setBackground(new Color(226, 71, 43));
		panelVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(1);
			}
		});
		panelVoltar.setBounds(101, 0, 106, 31);
		Faixa_1.add(panelVoltar);

		JLabel lblNewLabel_3_1 = new JLabel("Voltar");
		lblNewLabel_3_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(26, 11, 64, 14);
		panelVoltar.add(lblNewLabel_3_1);

		JPanel Faixa_1_1 = new JPanel();
		Faixa_1_1.setLayout(null);
		Faixa_1_1.setBackground(new Color(216, 205, 176));
		Faixa_1_1.setBounds(0, 0, 634, 403);
		add(Faixa_1_1);

		JSpinner spinSerie = new JSpinner();
		spinSerie.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinSerie.setBounds(380, 115, 65, 20);
		Faixa_1_1.add(spinSerie);

		JLabel lblNewLabel_1 = new JLabel("S\u00E9ries:");
		lblNewLabel_1.setBounds(370, 75, 91, 29);
		Faixa_1_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Fira Code Light", Font.BOLD, 16));

		JLabel lblNewLabel_1_1 = new JLabel("Repeti\u00E7\u00F5es:");
		lblNewLabel_1_1.setBounds(370, 158, 121, 29);
		Faixa_1_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Fira Code Light", Font.BOLD, 16));

		JSpinner spinRep = new JSpinner();
		spinRep.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinRep.setBounds(380, 198, 65, 20);
		Faixa_1_1.add(spinRep);

		JList listExerciciosTreino = new JList();
		listExerciciosTreino.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listExerciciosTreino.setVisibleRowCount(80);
		DefaultListModel listaModelo = new DefaultListModel();

		stringExercicios = BancoDeDados.getExercicioPorTipo(tipos);
		for (String exercicio : stringExercicios) {
			listaModelo.addElement(exercicio);
		}

		listExerciciosTreino.setModel(listaModelo);

		listExerciciosTreino.setBounds(21, 63, 338, 282);
		Faixa_1_1.add(listExerciciosTreino);

		JPanel panelCadastrar = new JPanel();
		panelCadastrar.setLayout(null);
		panelCadastrar.setBackground(new Color(43, 226, 71));
		panelCadastrar.setBounds(313, 0, 106, 31);
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
		panelCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controladorT.finalizarCadastro(listExerciciosTreino.getSelectedValuesList(), (int) spinRep.getValue(),
						(int) spinSerie.getValue());

				controlador.caminho(1);
			}
		});
		Faixa_1.add(panelCadastrar);

		JLabel lblNewLabel_3 = new JLabel("Cadastrar");
		lblNewLabel_3.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 96, 14);
		panelCadastrar.add(lblNewLabel_3);

	}
}
