package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorRedirecionar;

@SuppressWarnings({"unused"})
public class PanelRedirecionar extends JPanel {

	private static final long serialVersionUID = -5262748883391237838L;
	private String operacao;
	private String listagem;
	private JPanel panel;
	private ControladorRedirecionar controlador;
	private JLabel lblNewLabel;
	private JPanel panelCadastro;
	private JLabel lblCadastro;
	private JLabel lblNewLabel_1;
	private JPanel listagem2;
	private JLabel lblList;
	private JLabel lblNewLabel_1_1;

	public PanelRedirecionar(String operacao, String listagem) {

		this.operacao = operacao;
		this.listagem = listagem;

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		controlador = new ControladorRedirecionar();
		ControladorRedirecionar.setTela(this);
		ControladorRedirecionar.setPadrao(panel);

		lblNewLabel = new JLabel("Escolha uma op\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Fira Code", Font.BOLD, 20));
		lblNewLabel.setBounds(153, 56, 213, 61);
		panel.add(lblNewLabel);

		panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBackground(new Color(135, 148, 192));
		panelCadastro.setBounds(24, 132, 218, 206);
		panelCadastro.addMouseListener(new AcaoPerformada(panelCadastro, 2, operacao));
		panel.add(panelCadastro);

		lblCadastro = new JLabel("");
		lblCadastro.setBounds(89, 60, 45, 58);
		lblCadastro.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/cadastro.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelCadastro.add(lblCadastro);

		lblNewLabel_1 = new JLabel("Cadastrar " + this.operacao);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Fira Code", Font.BOLD, 16));
		lblNewLabel_1.setBounds(0, 108, 218, 76);
		panelCadastro.add(lblNewLabel_1);

		listagem2 = new JPanel();
		listagem2.setLayout(null);
		listagem2.setBackground(new Color(135, 148, 192));
		listagem2.setBounds(278, 132, 213, 206);
		listagem2.addMouseListener(new AcaoPerformada(listagem2, 5, operacao));
		panel.add(listagem2);

		lblList = new JLabel("");
		lblList.setBounds(80, 58, 40, 58);
		lblList.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/pesquisa-de-dados.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		listagem2.add(lblList);

		lblNewLabel_1_1 = new JLabel(this.listagem + this.operacao);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Fira Code", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 119, 213, 58);
		listagem2.add(lblNewLabel_1_1);

	}

	private class AcaoPerformada extends MouseAdapter {

		JPanel panel;
		int id;
		String operacao;

		public AcaoPerformada(JPanel panel, int id, String operacao) {
			this.panel = panel;
			this.id = id;
			this.operacao = operacao;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
			ControladorRedirecionar.receptacao(operacao, id);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(90, 103, 148));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}
	}
}
