package Visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorAluno;
import Controladores.ControladorRedirecionar;

public class PanelCadastroAluno extends JPanel {

	private static final long serialVersionUID = 3855518978965566703L;
	private JTextField textNomeAluno;
	private ControladorAluno controladorAluno;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JSpinner spinIdade;
	private JPanel panel_3;
	private JSpinner spinAltura;
	private JLabel lblNewLabel;
	private JPanel panel_3_1;
	private JSpinner spinPeso;
	private JPanel faixa;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblInsiraOsDados;
	private JPanel faixa_1;
	private JPanel panelCadastrar;
	private JLabel lblNewLabel_3;
	private JPanel panelVoltar;
	private JLabel lblNewLabel_3_1;
	private JLabel lblIconNome;
	private JLabel lblIconIdade;
	private JLabel lblIconAltura;
	private JLabel lblIconPeso;

	@SuppressWarnings("removal")
	public PanelCadastroAluno(ControladorRedirecionar controlador) {

		controladorAluno = new ControladorAluno();

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panel = new JPanel();
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(137, 102, 342, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);

		textNomeAluno = new JTextField();
		textNomeAluno.setFont(new Font("Fira Code", Font.PLAIN, 14));
		textNomeAluno.setBounds(10, 11, 322, 31);
		panel_1.add(textNomeAluno);
		textNomeAluno.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBounds(137, 160, 55, 41);
		panel.add(panel_2);
		panel_2.setLayout(null);

		spinIdade = new JSpinner();
		spinIdade.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinIdade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinIdade.setFont(new Font("Fira Code", Font.PLAIN, 12));
		spinIdade.setBounds(10, 11, 45, 20);
		panel_2.add(spinIdade);

		panel_3 = new JPanel();
		panel_3.setBounds(137, 212, 91, 47);
		panel.add(panel_3);
		panel_3.setLayout(null);

		spinAltura = new JSpinner();
		spinAltura.setDoubleBuffered(true);
		spinAltura.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		spinAltura.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinAltura.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		spinAltura.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0E7, 5.0));
		spinAltura.setBounds(10, 11, 71, 30);
		panel_3.add(spinAltura);

		lblNewLabel = new JLabel("Cadastro de Aluno");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 33, 279, 26);
		panel.add(lblNewLabel);

		panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(137, 270, 91, 47);
		panel.add(panel_3_1);

		spinPeso = new JSpinner();
		spinPeso.setModel(new SpinnerNumberModel(0.0, 0.0, 100000.0, 1.0));
		spinPeso.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		spinPeso.setBounds(10, 11, 71, 30);
		panel_3_1.add(spinPeso);

		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(75, 112, 63, 26);
		panel.add(lblNewLabel_1);

		lblNewLabel_1_1 = new JLabel("Idade:");
		lblNewLabel_1_1.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(75, 167, 63, 26);
		panel.add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("Altura:");
		lblNewLabel_1_2.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(75, 222, 70, 26);
		panel.add(lblNewLabel_1_2);

		lblNewLabel_1_3 = new JLabel("Peso:");
		lblNewLabel_1_3.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(75, 280, 63, 26);
		panel.add(lblNewLabel_1_3);

		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(128, 71, 279, 26);
		panel.add(lblInsiraOsDados);

		faixa_1 = new JPanel();
		faixa_1.setBackground(new Color(216, 205, 176));
		faixa_1.setBounds(0, 349, 529, 31);
		panel.add(faixa_1);
		faixa_1.setLayout(null);

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

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(textNomeAluno);
				if (((textNomeAluno.getText().isEmpty() == false) && (textNomeAluno.getText().isBlank() == false)
						&& (Controladores.ControladorAluno.getUmAluno(textNomeAluno.getText())) == null)) {

					controladorAluno.cadastrarAluno(textNomeAluno.getText(), (int) spinIdade.getValue(),
							(double) spinAltura.getValue(), (double) spinPeso.getValue());
					controlador.caminho(1);
				}
			}
		});
		panelCadastrar.setBackground(new Color(43, 226, 71));
		panelCadastrar.setBounds(313, 0, 106, 31);
		faixa_1.add(panelCadastrar);
		panelCadastrar.setLayout(null);

		lblNewLabel_3 = new JLabel("Cadastrar");
		lblNewLabel_3.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 89, 14);
		panelCadastrar.add(lblNewLabel_3);

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

		lblNewLabel_3_1 = new JLabel("Voltar");
		lblNewLabel_3_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(26, 11, 64, 14);
		panelVoltar.add(lblNewLabel_3_1);

		lblIconNome = new JLabel("");
		lblIconNome.setBounds(19, 105, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconNome);

		lblIconIdade = new JLabel("");
		lblIconIdade.setBounds(19, 160, 40, 41);
		lblIconIdade.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/ampulheta.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconIdade);

		lblIconAltura = new JLabel("");
		lblIconAltura.setBounds(19, 215, 40, 41);
		lblIconAltura.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/altura.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconAltura);

		lblIconPeso = new JLabel("");
		lblIconPeso.setBounds(19, 273, 40, 41);
		lblIconPeso.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/balancas.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconPeso);

	}

}
