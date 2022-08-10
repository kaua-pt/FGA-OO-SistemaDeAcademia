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

import controladores.ControladorTelaEditarAluno;
import modelo.Aluno;

/**
 * @author Kau� Vin�cius
 * 
 *         Classe em que é implementado a tela para edi�ao de aluno.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteração dos botões
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "removal" })
public class PanelEditarAluno extends JPanel implements ActionListener {

	private static final long serialVersionUID = 3855518978965566703L;
	private JTextField textNomeAluno;
	private JPanel panel;
	private JPanel panelDesign1;
	private JPanel panelDesign2;
	private JSpinner spinIdade;
	private JPanel panelDesign3;
	private JSpinner spinAltura;
	private JLabel lblEditarAluno;
	private JPanel panelDesign4;
	private JSpinner spinPeso;
	private JPanel faixa;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblInsiraOsDados;
	private JPanel faixa2;
	private JLabel lblIconNome;
	private JLabel lblIconIdade;
	private JLabel lblIconAltura;
	private JLabel lblIconPeso;
	private JButton btnInicio;
	private JButton btnFinalizar;
	private ControladorTelaEditarAluno controladorT;

	/**
	 * Construitor em que é gerado a tela de edi��o de aluno juntamente com seus
	 * componentes. Métodos atrelados aos botões estão no backend
	 * 
	 * @see ControladorTelaEditarAluno
	 */
	public PanelEditarAluno(Aluno aluno) {
		// Defino as caracteristicas b�sicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel base da tela
		panel = new JPanel();
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		// Defino que cont�m as informa��es
		panelDesign1 = new JPanel();
		panelDesign1.setBackground(new Color(240, 240, 240));
		panelDesign1.setBounds(137, 102, 342, 47);
		panel.add(panelDesign1);
		panelDesign1.setLayout(null);

		// Defino a textbox para retornar o nome do aluno
		textNomeAluno = new JTextField();
		textNomeAluno.setFont(new Font("Fira Code", Font.PLAIN, 14));
		textNomeAluno.setBounds(10, 11, 322, 31);
		panelDesign1.add(textNomeAluno);
		textNomeAluno.setColumns(10);

		// Defino o panel com a segunda tela de informa��es
		panelDesign2 = new JPanel();
		panelDesign2.setToolTipText("");
		panelDesign2.setBounds(137, 160, 55, 41);
		panel.add(panelDesign2);
		panelDesign2.setLayout(null);

		// Defino o spin de idade do aluno
		spinIdade = new JSpinner();
		spinIdade.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinIdade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinIdade.setFont(new Font("Fira Code", Font.PLAIN, 12));
		spinIdade.setBounds(10, 11, 45, 20);
		panelDesign2.add(spinIdade);

		// Defino o panel com caracte�sticas de design da p�gina
		panelDesign3 = new JPanel();
		panelDesign3.setBounds(137, 212, 91, 47);
		panel.add(panelDesign3);
		panelDesign3.setLayout(null);

		// Defino o spin para puxar a altura do aluno
		spinAltura = new JSpinner();
		spinAltura.setDoubleBuffered(true);
		spinAltura.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		spinAltura.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		spinAltura.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		spinAltura.setModel(new SpinnerNumberModel(0.0, 0.0, 1.0E7, 5.0));
		spinAltura.setBounds(10, 11, 71, 30);
		panelDesign3.add(spinAltura);

		// Defino um quarto panel de design
		panelDesign4 = new JPanel();
		panelDesign4.setLayout(null);
		panelDesign4.setBounds(137, 270, 91, 47);
		panel.add(panelDesign4);

		// Defino o spin para armazenar o peso do aluno
		spinPeso = new JSpinner();
		spinPeso.setModel(new SpinnerNumberModel(0.0, 0.0, 100000.0, 1.0));
		spinPeso.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		spinPeso.setBounds(10, 11, 71, 30);
		panelDesign4.add(spinPeso);

		// Defino a faixa para armaznar os bot�es
		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		// Defino um texto para tela
		lblEditarAluno = new JLabel("Editar aluno");
		faixa.add(lblEditarAluno);
		lblEditarAluno.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblEditarAluno.setHorizontalAlignment(SwingConstants.CENTER);

		// Defino um texto para tela
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(75, 112, 63, 26);
		panel.add(lblNome);

		// Defino um texto para tela
		lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblIdade.setBounds(75, 167, 63, 26);
		panel.add(lblIdade);

		// Defino um texto para tela
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAltura.setBounds(75, 222, 70, 26);
		panel.add(lblAltura);

		// Defino um texto para tela
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblPeso.setBounds(75, 280, 63, 26);
		panel.add(lblPeso);

		// Defino um texto de ajuda ao usu�rio
		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(128, 71, 279, 26);
		panel.add(lblInsiraOsDados);

		// Defino uma faixa de design da tela
		faixa2 = new JPanel();
		faixa2.setBackground(new Color(216, 205, 176));
		faixa2.setBounds(0, 349, 529, 31);
		panel.add(faixa2);
		faixa2.setLayout(null);

		// Defino o bot�o para retornar para o in�cio
		btnInicio = new JButton("Inicio");
		btnInicio.setForeground(Color.BLACK);
		btnInicio.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnInicio.setBounds(98, 0, 117, 31);
		btnInicio.addActionListener(this);
		btnInicio.setBackground(new Color(226, 71, 43));
		faixa2.add(btnInicio);

		// Defino o bot�o para finalizar a edi��o
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(Color.BLACK);
		btnFinalizar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnFinalizar.setBounds(313, 0, 117, 31);
		btnFinalizar.addActionListener(this);
		btnFinalizar.setBackground(new Color(43, 226, 71));
		faixa2.add(btnFinalizar);

		// Defino o icone do nome
		lblIconNome = new JLabel("");
		lblIconNome.setBounds(19, 105, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconNome);

		// Defino o icone da idade
		lblIconIdade = new JLabel("");
		lblIconIdade.setBounds(19, 160, 40, 41);
		lblIconIdade.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/ampulheta.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconIdade);

		// Defino o icone da altura
		lblIconAltura = new JLabel("");
		lblIconAltura.setBounds(19, 215, 40, 41);
		lblIconAltura.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/altura.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconAltura);

		// Defino o icone do peso
		lblIconPeso = new JLabel("");
		lblIconPeso.setBounds(19, 273, 40, 41);
		lblIconPeso.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/balancas.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconPeso);

		// Defino o controlador que realiza a conec��o entre o backend e o frontend
		controladorT = new ControladorTelaEditarAluno(this);
		controladorT.setarInformacoes(aluno);
	}

	/**
	 * M�todo respons�vel por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um bot�o
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorT.acaoPerformada(e.getSource());
	}

	// Getters e Setters
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
