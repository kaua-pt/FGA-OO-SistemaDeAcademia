package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;

import Controladores.ControladorRedirecionar;

public class PanelTreinoExercicios extends JPanel {

	private JFrame frame;

	public PanelTreinoExercicios(ControladorRedirecionar controlador) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		List list = new List();
		list.setMultipleSelections(false);
		list.setBounds(10, 58, 339, 294);
		add(list);

		JLabel lblNewLabel = new JLabel("Selecione os exerc\u00EDcios desejados");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblNewLabel.setBounds(95, 22, 361, 30);
		add(lblNewLabel);

		JPanel Faixa_1 = new JPanel();
		Faixa_1.setLayout(null);
		Faixa_1.setBackground(new Color(216, 205, 176));
		Faixa_1.setBounds(0, 358, 529, 31);
		add(Faixa_1);

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
				controlador.caminho(1);
			}
		});
		Faixa_1.add(panelCadastrar);

		JLabel lblNewLabel_3 = new JLabel("Cadastrar");
		lblNewLabel_3.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3.setBounds(6, 11, 96, 14);
		panelCadastrar.add(lblNewLabel_3);

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

		JSpinner spinner = new JSpinner();
		spinner.setBounds(380, 115, 65, 20);
		Faixa_1_1.add(spinner);

		JLabel lblNewLabel_1 = new JLabel("S\u00E9ries:");
		lblNewLabel_1.setBounds(370, 75, 91, 29);
		Faixa_1_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Fira Code Light", Font.BOLD, 16));

		JLabel lblNewLabel_1_1 = new JLabel("Repeti\u00E7\u00F5es:");
		lblNewLabel_1_1.setBounds(370, 158, 121, 29);
		Faixa_1_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Fira Code Light", Font.BOLD, 16));

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(380, 198, 65, 20);
		Faixa_1_1.add(spinner_1);

	}
}
