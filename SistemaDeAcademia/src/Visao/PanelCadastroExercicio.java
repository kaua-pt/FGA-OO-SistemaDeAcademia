package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Controladores.ControladorTelaCadastroExercicio;
import Modelo.TipoDeGrupamento;

public class PanelCadastroExercicio extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -910184885933068706L;
	private JTextField nomeExercicio;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel mainMessagem;
	private JPanel faixa;
	private JLabel lblNome;
	private JLabel lblInsiraOsDados;
	private JPanel faixa_1;
	private JLabel lblIconNome;
	private JComboBox comboBoxExercicio;
	private JLabel lbltipo;
	private JLabel lblNewLabel;
	private JPanel panelDescricao;
	private JTextArea textArea;
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private ControladorTelaCadastroExercicio controladorTela;

	public PanelCadastroExercicio() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(168, 102, 310, 47);
		panel.add(panel_1);
		panel_1.setLayout(null);

		nomeExercicio = new JTextField();
		nomeExercicio.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		nomeExercicio.setBounds(0, 11, 290, 25);
		panel_1.add(nomeExercicio);
		nomeExercicio.setColumns(10);

		mainMessagem = new JLabel("Cadastro de Exerc\u00EDcio");
		mainMessagem.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		mainMessagem.setHorizontalAlignment(SwingConstants.CENTER);
		mainMessagem.setBounds(128, 33, 279, 26);
		panel.add(mainMessagem);

		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(59, 112, 63, 26);
		panel.add(lblNome);

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

		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(98, 0, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(226, 71, 43));
		faixa_1.add(btnVoltar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnCadastrar.setBounds(313, 0, 117, 31);
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBackground(new Color(43, 226, 71));
		faixa_1.add(btnCadastrar);

		lblIconNome = new JLabel("");
		lblIconNome.setBounds(10, 102, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconNome);

		comboBoxExercicio = new JComboBox();
		comboBoxExercicio.setModel(new DefaultComboBoxModel(TipoDeGrupamento.values()));
		comboBoxExercicio.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboBoxExercicio.setBounds(168, 173, 310, 31);
		panel.add(comboBoxExercicio);

		lbltipo = new JLabel("Tipo:");
		lbltipo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lbltipo.setBounds(59, 181, 113, 14);
		panel.add(lbltipo);

		lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 237, 100, 20);
		panel.add(lblNewLabel);

		panelDescricao = new JPanel();
		panelDescricao.setLayout(null);
		panelDescricao.setBackground(new Color(255, 255, 255));
		panelDescricao.setBounds(168, 243, 324, 78);
		panel.add(panelDescricao);

		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setTabSize(4);
		textArea.setRows(4);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		textArea.setBounds(0, 0, 324, 78);
		panelDescricao.add(textArea);

		controladorTela = new ControladorTelaCadastroExercicio(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	public JTextField getNomeExercicio() {
		return nomeExercicio;
	}

	public JComboBox getComboBoxExercicio() {
		return comboBoxExercicio;
	}

	public JPanel getPanelDescricao() {
		return panelDescricao;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

}
