package Visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorTelaEditarAluno;
import Modelo.Aluno;

public class PanelEditarAluno extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3855518978965566703L;
	private JTextField textNomeAluno;
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
	private JLabel lblIconNome;
	private JLabel lblIconIdade;
	private JLabel lblIconAltura;
	private JLabel lblIconPeso;
	private JButton btnInicio;
	private JButton btnFinalizar;
	private ControladorTelaEditarAluno controladorT;

	public PanelEditarAluno(Aluno aluno) {

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

		lblNewLabel = new JLabel("Editar aluno");
		faixa.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

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

		btnInicio = new JButton("Inicio");
		btnInicio.setForeground(Color.BLACK);
		btnInicio.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnInicio.setBounds(98, 0, 117, 31);
		btnInicio.addActionListener(this);
		btnInicio.setBackground(new Color(226, 71, 43));
		faixa_1.add(btnInicio);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(Color.BLACK);
		btnFinalizar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnFinalizar.setBounds(313, 0, 117, 31);
		btnFinalizar.addActionListener(this);
		btnFinalizar.setBackground(new Color(43, 226, 71));
		faixa_1.add(btnFinalizar);

		lblIconNome = new JLabel("");
		lblIconNome.setBounds(19, 105, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconNome);

		lblIconIdade = new JLabel("");
		lblIconIdade.setBounds(19, 160, 40, 41);
		lblIconIdade.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/ampulheta.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconIdade);

		lblIconAltura = new JLabel("");
		lblIconAltura.setBounds(19, 215, 40, 41);
		lblIconAltura.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/altura.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconAltura);

		lblIconPeso = new JLabel("");
		lblIconPeso.setBounds(19, 273, 40, 41);
		lblIconPeso.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/balancas.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconPeso);

		controladorT = new ControladorTelaEditarAluno(this);
		controladorT.setarInformacoes(aluno);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorT.acaoPerformada(e.getSource());
	}

	public JTextField getTextNomeAluno() {
		return textNomeAluno;
	}

	public void setTextNomeAluno(JTextField textNomeAluno) {
		this.textNomeAluno = textNomeAluno;
	}

	public JSpinner getSpinIdade() {
		return spinIdade;
	}

	public void setSpinIdade(JSpinner spinIdade) {
		this.spinIdade = spinIdade;
	}

	public JSpinner getSpinAltura() {
		return spinAltura;
	}

	public void setSpinAltura(JSpinner spinAltura) {
		this.spinAltura = spinAltura;
	}

	public JSpinner getSpinPeso() {
		return spinPeso;
	}

	public void setSpinPeso(JSpinner spinPeso) {
		this.spinPeso = spinPeso;
	}

	public JButton getBtnVoltar() {
		return btnInicio;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnInicio = btnVoltar;
	}

	public JButton getBtnCadastrar() {
		return btnFinalizar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnFinalizar = btnCadastrar;
	}

}
