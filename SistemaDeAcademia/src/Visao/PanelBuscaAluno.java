package Visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.BancoDeDados;
import Controladores.ControladorRedirecionar;
import Modelo.Aluno;

public class PanelBuscaAluno extends JPanel {

	private static final long serialVersionUID = 7399066554867365317L;
	private JTextField textField;

	public PanelBuscaAluno(ControladorRedirecionar controlador) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Buscar Aluno");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblNewLabel.setBounds(184, 11, 151, 45);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setToolTipText("Digite o nome do aluno");
		textField.setBounds(65, 72, 376, 20);
		add(textField);
		textField.setColumns(10);

		JLabel IconeBusca = new JLabel("");
		IconeBusca.setHorizontalAlignment(SwingConstants.CENTER);
		IconeBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		IconeBusca.setBounds(0, 52, 68, 58);
		IconeBusca.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/lupa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		add(IconeBusca);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setBounds(1, 18, 527, 28);
		add(panel);

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setAlignmentY(1.0f);
		panelInfo.setVisible(false);
		panelInfo.setBounds(1, 103, 527, 250);
		panelInfo.setVisible(false);
		add(panelInfo);
		panelInfo.setLayout(null);

		JLabel lblnaoEncont = new JLabel("Aluno N\u00E3o Encontrado!");
		lblnaoEncont.setVisible(false);
		lblnaoEncont.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblnaoEncont.setBounds(153, 111, 220, 14);
		panelInfo.add(lblnaoEncont);

		JLabel labelBusca = new JLabel("Buscar");
		labelBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		labelBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Aluno aluno;

				aluno = BancoDeDados.getUmAluno(textField.getText());
				if (aluno == null) {
					lblnaoEncont.setVisible(true);
					panelInfo.setVisible(true);
				} else {
					lblnaoEncont.setVisible(false);
					controlador.caminhoBuscaA(panelInfo, aluno);
				}
			}
		});
		labelBusca.setHorizontalAlignment(SwingConstants.CENTER);
		labelBusca.setBounds(451, 60, 68, 45);
		add(labelBusca);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);
		panel_1.setBounds(1, 364, 527, 28);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panelVoltar = new JPanel();
		panelVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(1);
			}

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
		panelVoltar.setToolTipText("Voltar");
		panelVoltar.setBounds(61, 0, 94, 28);
		panel_1.add(panelVoltar);
		panelVoltar.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(18, 9, 60, 14);
		panelVoltar.add(lblNewLabel_1);

		JPanel panelEditar = new JPanel();
		panelEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelEditar.setBackground(new Color(21, 113, 35));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelEditar.setBackground(new Color(43, 226, 71));
			}
		});
		panelEditar.setToolTipText("Voltar");
		panelEditar.setBackground(Color.GREEN);
		panelEditar.setBounds(216, 0, 94, 28);
		panel_1.add(panelEditar);
		panelEditar.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Editar");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(18, 9, 60, 14);
		panelEditar.add(lblNewLabel_1_1);

		JPanel panelDeletar = new JPanel();
		panelDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeletar.setBackground(new Color(113, 35, 36));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelDeletar.setBackground(new Color(162, 51, 52));
			}
		});
		panelDeletar.setToolTipText("Voltar");
		panelDeletar.setBackground(new Color(162, 51, 52));
		panelDeletar.setBounds(371, 0, 94, 28);
		panel_1.add(panelDeletar);
		panelDeletar.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Deletar");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 9, 74, 14);
		panelDeletar.add(lblNewLabel_1_1_1);

	}
}
