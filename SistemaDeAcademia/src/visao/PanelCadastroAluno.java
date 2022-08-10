package visao;

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

import controladores.ControladorTelaCadastroAluno;

/**
 * @author Kauã Vinícius
 * 
 *         Classe em que é implementado a tela para cadastro de aluno Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteração dos botões
 * 
 * @see JPanel
 * @see ActionListener
 */

public class PanelCadastroAluno extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3855518978965566703L;
	private JTextField textNomeAluno;
	private JPanel panel;
	private JPanel panelNome;
	private JPanel panelIdade;
	private JSpinner spinIdade;
	private JPanel panelAltura;
	private JSpinner spinAltura;
	private JLabel lblTitulo;
	private JPanel panelPeso;
	private JSpinner spinPeso;
	private JPanel faixa;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblInsiraOsDados;
	private JPanel faixaInferior;
	private JLabel lblIconNome;
	private JLabel lblIconIdade;
	private JLabel lblIconAltura;
	private JLabel lblIconPeso;
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private ControladorTelaCadastroAluno controladorTela;

	/**
	 * Construtor no qual cria a tela e suas depend�ncias A��o dos bot�es atrelado
	 * ao BackEnd
	 * 
	 * @see ControladorPanelCadastroAluno
	 */
	@SuppressWarnings("removal")
	public PanelCadastroAluno() {

		// Defino as caracteristicas b�sicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel principal que � usado como base
		panel = new JPanel();
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		// Defino o campo que armazena o textNomeAluno
		panelNome = new JPanel();
		panelNome.setBackground(new Color(240, 240, 240));
		panelNome.setBounds(137, 102, 342, 47);
		panel.add(panelNome);
		panelNome.setLayout(null);

		// Defino o campo onde ser� inserido o nome do aluno
		textNomeAluno = new JTextField();
		textNomeAluno.setFont(new Font("Fira Code", Font.PLAIN, 14));
		textNomeAluno.setBounds(10, 11, 322, 31);
		panelNome.add(textNomeAluno);
		textNomeAluno.setColumns(10);

		// Defino o onde � inserido o spin da idade
		panelIdade = new JPanel();
		panelIdade.setToolTipText("");
		panelIdade.setBounds(137, 160, 55, 41);
		panel.add(panelIdade);
		panelIdade.setLayout(null);

		// Defino spin que absorver� a idade
		spinIdade = new JSpinner();
		spinIdade.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinIdade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinIdade.setFont(new Font("Fira Code", Font.PLAIN, 12));
		spinIdade.setBounds(10, 11, 45, 20);
		panelIdade.add(spinIdade);

		// Defino o campo onde ser� colocado o panel para inserir a altura
		panelAltura = new JPanel();
		panelAltura.setBounds(137, 212, 91, 47);
		panel.add(panelAltura);
		panelAltura.setLayout(null);

		// Defino o spin que absorver� a altura
		spinAltura = new JSpinner();
		spinAltura.setDoubleBuffered(true);
		spinAltura.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		spinAltura.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinAltura.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		spinAltura.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0E7, 5.0));
		spinAltura.setBounds(10, 11, 71, 30);
		panelAltura.add(spinAltura);

		// Defino o campo em que estar� o titulo
		lblTitulo = new JLabel("Cadastro de Aluno");
		lblTitulo.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(128, 33, 279, 26);
		panel.add(lblTitulo);

		// Defino o campo onde ser� colocado o spin de peso
		panelPeso = new JPanel();
		panelPeso.setLayout(null);
		panelPeso.setBounds(137, 270, 91, 47);
		panel.add(panelPeso);

		// Defino o spin onde ser� inserido peso do aluno
		spinPeso = new JSpinner();
		spinPeso.setModel(new SpinnerNumberModel(0.0, 0.0, 100000.0, 1.0));
		spinPeso.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		spinPeso.setBounds(10, 11, 71, 30);
		panelPeso.add(spinPeso);

		// Defino um panel para design da p�gina
		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		// Defino o campo onde ser� colocado um texto de ajuda ao usu�rio em rela��o ao
		// nome
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(75, 112, 63, 26);
		panel.add(lblNome);

		// Defino o campo onde ser� colocado um texto de ajuda ao usu�rio em rela��o a
		// idade
		lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblIdade.setBounds(75, 167, 63, 26);
		panel.add(lblIdade);

		// Defino o campo onde ser� colocado um texto de ajuda ao usu�rio em rela��o a
		// altura
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAltura.setBounds(75, 222, 70, 26);
		panel.add(lblAltura);

		// Defino o campo onde ser� colocado um texto de ajuda ao usu�rio em rela��o ao
		// peso
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblPeso.setBounds(75, 280, 63, 26);
		panel.add(lblPeso);

		// Defino o texto de ajuda principal
		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(128, 71, 279, 26);
		panel.add(lblInsiraOsDados);

		// Defino uma faixa inferior de design
		faixaInferior = new JPanel();
		faixaInferior.setBackground(new Color(216, 205, 176));
		faixaInferior.setBounds(0, 349, 529, 31);
		panel.add(faixaInferior);
		faixaInferior.setLayout(null);

		// Defino o bot�o para voltar ao in�cio
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(98, 0, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(226, 71, 43));
		faixaInferior.add(btnVoltar);

		// Defino o bot�o para cadastro
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnCadastrar.setBounds(313, 0, 117, 31);
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBackground(new Color(43, 226, 71));
		faixaInferior.add(btnCadastrar);

		// Defino uma label para inserir o icone de nome
		lblIconNome = new JLabel("");
		lblIconNome.setBounds(19, 105, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconNome);

		// Defino uma label para inserir o icone de idade
		lblIconIdade = new JLabel("");
		lblIconIdade.setBounds(19, 160, 40, 41);
		lblIconIdade.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/ampulheta.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconIdade);

		// Defino uma label para inserir o icone de altura
		lblIconAltura = new JLabel("");
		lblIconAltura.setBounds(19, 215, 40, 41);
		lblIconAltura.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/altura.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconAltura);

		// Defino uma label para inserir o icone de peso
		lblIconPeso = new JLabel("");
		lblIconPeso.setBounds(19, 273, 40, 41);
		lblIconPeso.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/balancas.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconPeso);

		// Defino o controlador da tela que realizar� a liga��o com o backend
		controladorTela = new ControladorTelaCadastroAluno(this);
	}

	/**
	 * M�todo respons�vel por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um bot�o
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JTextField getTextNomeAluno() {
		return textNomeAluno;
	}

	public JSpinner getSpinIdade() {
		return spinIdade;
	}

	public JSpinner getSpinAltura() {
		return spinAltura;
	}

	public JSpinner getSpinPeso() {
		return spinPeso;
	}

}
