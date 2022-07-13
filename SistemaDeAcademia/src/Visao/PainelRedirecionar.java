package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PainelRedirecionar extends JPanel {

	private JFrame frame;
	private JPanel tela;
	private JPanel main;
	private String operacao;
	private String listagem;

	public PainelRedirecionar(String operacao, String listagem) {

		this.operacao = operacao;
		this.listagem = listagem;
		this.tela = tela;
		this.main = main;

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(135, 148, 192));
		panelCadastro.setBounds(36, 103, 218, 206);
		panelCadastro.addMouseListener(new PanelAdaptador(panelCadastro));
		add(panelCadastro);
		panelCadastro.setLayout(null);

		JLabel lblCadastro = new JLabel("");
		lblCadastro.setBounds(89, 60, 45, 58);
		lblCadastro.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/cadastro.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelCadastro.add(lblCadastro);

		JLabel lblNewLabel_1 = new JLabel("Cadastrar " + this.operacao);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Fira Code", Font.BOLD, 16));
		lblNewLabel_1.setBounds(0, 108, 218, 76);
		panelCadastro.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Escolha uma op\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Fira Code", Font.BOLD, 20));
		lblNewLabel.setBounds(165, 27, 213, 61);
		add(lblNewLabel);

		JPanel Listagem = new JPanel();
		Listagem.setLayout(null);
		Listagem.setBackground(new Color(135, 148, 192));
		Listagem.setBounds(290, 103, 213, 206);
		Listagem.addMouseListener(new PanelAdaptador(Listagem));
		add(Listagem);

		JLabel lblCadastro_1 = new JLabel("");
		lblCadastro_1.setBounds(80, 58, 40, 58);
		lblCadastro_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/pesquisa-de-dados.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		Listagem.add(lblCadastro_1);

		JLabel lblNewLabel_1_1 = new JLabel(this.listagem + this.operacao);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Fira Code", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 119, 213, 58);
		Listagem.add(lblNewLabel_1_1);

	}

	class PanelAdaptador extends MouseAdapter {

		JPanel panel;

		public PanelAdaptador(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(90, 103, 148));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}
	}
}
