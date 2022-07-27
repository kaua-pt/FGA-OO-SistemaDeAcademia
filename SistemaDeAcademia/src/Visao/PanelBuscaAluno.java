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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

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
		panel.setBounds(0, 18, 529, 28);
		add(panel);

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setAlignmentY(1.0f);
		panelInfo.setVisible(false);
		panelInfo.setBounds(0, 103, 529, 250);
		add(panelInfo);
		panelInfo.setLayout(null);

		JLabel labelBusca = new JLabel("Buscar");
		labelBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		labelBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Aluno aluno;

				aluno = BancoDeDados.getUmAluno(textField.getText());
				if (aluno == null) {
					System.out.println("Aluno não encotrado, implementar");
				} else {
					System.out.println(aluno.getPeso());

					resultadoBusca(panelInfo, aluno);
					panelInfo.setVisible(true);
				}
			}
		});
		labelBusca.setHorizontalAlignment(SwingConstants.CENTER);
		labelBusca.setBounds(451, 60, 68, 45);
		add(labelBusca);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);
		panel_1.setBounds(0, 364, 529, 28);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panelVoltar = new JPanel();
		panelVoltar.setBackground(Color.MAGENTA);
		panelVoltar.setToolTipText("Voltar");
		panelVoltar.setBounds(61, 0, 94, 28);
		panel_1.add(panelVoltar);

		JPanel panelVoltar_1 = new JPanel();
		panelVoltar_1.setToolTipText("Voltar");
		panelVoltar_1.setBackground(Color.GREEN);
		panelVoltar_1.setBounds(216, 0, 94, 28);
		panel_1.add(panelVoltar_1);

		JPanel panelVoltar_1_1 = new JPanel();
		panelVoltar_1_1.setToolTipText("Voltar");
		panelVoltar_1_1.setBackground(Color.RED);
		panelVoltar_1_1.setBounds(371, 0, 94, 28);
		panel_1.add(panelVoltar_1_1);

	}

	public void resultadoBusca(JPanel panelInfo, Aluno aluno) {

		System.out.println(aluno.getPeso());

		JLabel lblPeso = new JLabel("Peso:\r " + aluno.getPeso());
		lblPeso.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblPeso.setBounds(26, 152, 95, 14);
		panelInfo.add(lblPeso);

		JLabel lblAltura = new JLabel("Altura:\r" + aluno.getAltura());
		lblAltura.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblAltura.setBounds(26, 214, 113, 14);
		panelInfo.add(lblAltura);

		JLabel lblIdade = new JLabel("Idade:\r" + aluno.getIdade());
		lblIdade.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIdade.setBounds(26, 85, 95, 14);
		panelInfo.add(lblIdade);

		JLabel lblIMC = new JLabel("IMC: " + aluno.calcularImc());
		lblIMC.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIMC.setBounds(422, 21, 81, 14);
		panelInfo.add(lblIMC);

		JLabel lblNome = new JLabel("Nome: " + aluno.getPrimeiroNome());
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNome.setBounds(26, 21, 142, 14);
		panelInfo.add(lblNome);

		JLabel lblIMCPessoa = new JLabel("");
		lblIMCPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMCPessoa.setBounds(419, 46, 87, 157);
		lblIMCPessoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PainelMenu.class.getResource("/Imagens/silhueta-de-corpo-humano-em-pe.png"))
				.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		panelInfo.add(lblIMCPessoa);

		JLabel lblTreinos = new JLabel("Treinos");
		lblTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTreinos.setBounds(260, 21, 71, 14);
		panelInfo.add(lblTreinos);

		JLabel Situação = new JLabel("");
		Situação.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		Situação.setBounds(422, 214, 81, 14);
		panelInfo.add(Situação);

		JList listTreinos = new JList();
		listTreinos.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listTreinos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		listTreinos.setBounds(212, 46, 166, 193);
		panelInfo.add(listTreinos);
	}
}
