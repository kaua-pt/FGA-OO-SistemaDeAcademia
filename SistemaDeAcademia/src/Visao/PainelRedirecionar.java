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

public class PainelRedirecionar extends JPanel {

	private String operacao;
	private String listagem;

	public PainelRedirecionar(String operacao, String listagem) {

		this.operacao = operacao;
		this.listagem = listagem;

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		ControladorRedirecionar controlador = new ControladorRedirecionar(this);

		JLabel lblNewLabel = new JLabel("Escolha uma op\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Fira Code", Font.BOLD, 20));
		lblNewLabel.setBounds(153, 56, 213, 61);
		panel.add(lblNewLabel);

		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBackground(new Color(135, 148, 192));
		panelCadastro.setBounds(24, 132, 218, 206);
		panelCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(2, panel);
			}
		});
		panel.add(panelCadastro);

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

		JPanel Listagem = new JPanel();
		Listagem.setLayout(null);
		Listagem.setBackground(new Color(135, 148, 192));
		Listagem.setBounds(278, 132, 213, 206);
		panel.add(Listagem);

		JLabel lblList = new JLabel("");
		lblList.setBounds(80, 58, 40, 58);
		lblList.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/pesquisa-de-dados.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		Listagem.add(lblList);

		JLabel lblNewLabel_1_1 = new JLabel(this.listagem + this.operacao);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Fira Code", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(0, 119, 213, 58);
		Listagem.add(lblNewLabel_1_1);

	}
}
