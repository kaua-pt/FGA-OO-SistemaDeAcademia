package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Controladores.BancoDeDados;
import Controladores.ControladorExercicio;
import Controladores.ControladorRedirecionar;
import Modelo.TipoDeGrupamento;

public class PanelCadastroExercicio extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -910184885933068706L;
	private JTextField nomeExercicio;

	public PanelCadastroExercicio(ControladorRedirecionar controlador) {
		ControladorExercicio controladorE = new ControladorExercicio();

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(168, 102, 310, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);

		nomeExercicio = new JTextField();
		nomeExercicio.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		nomeExercicio.setBounds(0, 11, 290, 25);
		panel_1.add(nomeExercicio);
		nomeExercicio.setColumns(10);

		JLabel mainMessagem = new JLabel("Cadastro de Exerc\u00EDcio");
		mainMessagem.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		mainMessagem.setHorizontalAlignment(SwingConstants.CENTER);
		mainMessagem.setBounds(128, 33, 279, 26);
		panel.add(mainMessagem);

		JPanel Faixa = new JPanel();
		Faixa.setBackground(new Color(216, 205, 176));
		Faixa.setBounds(0, 28, 529, 31);
		panel.add(Faixa);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(59, 112, 63, 26);
		panel.add(lblNome);

		JLabel lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(128, 71, 279, 26);
		panel.add(lblInsiraOsDados);

		JPanel Faixa_1 = new JPanel();
		Faixa_1.setBackground(new Color(216, 205, 176));
		Faixa_1.setBounds(0, 349, 529, 31);
		panel.add(Faixa_1);
		Faixa_1.setLayout(null);

		JPanel panelVoltar = new JPanel();
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
		Faixa_1.add(panelVoltar);

		JLabel lblNewLabel_3_1 = new JLabel("Voltar");
		lblNewLabel_3_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(26, 11, 64, 14);
		panelVoltar.add(lblNewLabel_3_1);

		JLabel lblIconNome = new JLabel("");
		lblIconNome.setBounds(10, 102, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconNome);

		JComboBox comboBoxExercicio = new JComboBox();
		comboBoxExercicio.setModel(new DefaultComboBoxModel(TipoDeGrupamento.values()));
		comboBoxExercicio.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboBoxExercicio.setBounds(168, 173, 310, 31);
		panel.add(comboBoxExercicio);

		JLabel lbltipo = new JLabel("Tipo:");
		lbltipo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lbltipo.setBounds(59, 181, 113, 14);
		panel.add(lbltipo);

		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 237, 100, 20);
		panel.add(lblNewLabel);

		JPanel panelDescricao = new JPanel();
		panelDescricao.setLayout(null);
		panelDescricao.setBackground(new Color(255, 255, 255));
		panelDescricao.setBounds(168, 243, 324, 78);
		panel.add(panelDescricao);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setTabSize(4);
		textArea.setRows(4);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		textArea.setBounds(0, 0, 324, 78);
		panelDescricao.add(textArea);

		JPanel panelCadastrar = new JPanel();
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
				if ((nomeExercicio.getText().isBlank() == false) && (nomeExercicio.getText().isEmpty() == false)
						&& (BancoDeDados.getUmExercicio(nomeExercicio.getText()) == null)) {

					controladorE.cadastrarExercicio(nomeExercicio.getText(), comboBoxExercicio.getSelectedIndex(),
							textArea.getText());
					controlador.caminho(1);
				}

			}
		});
		panelCadastrar.setBackground(new Color(43, 226, 71));
		panelCadastrar.setBounds(313, 0, 106, 31);
		Faixa_1.add(panelCadastrar);
		panelCadastrar.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Cadastrar");
		lblNewLabel_3.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 89, 14);
		panelCadastrar.add(lblNewLabel_3);
	}
}
