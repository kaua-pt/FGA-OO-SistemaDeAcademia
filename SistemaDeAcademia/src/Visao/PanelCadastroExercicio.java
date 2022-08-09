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

/**
 * @author KauÃ£ VinÃ­cius
 * 
 *         Classe em que Ã© implementado a tela para cadastro de exercício.Herda
 *         a classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteraÃ§Ã£o dos botÃµes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class PanelCadastroExercicio extends JPanel implements ActionListener {

	private static final long serialVersionUID = -910184885933068706L;
	private JTextField nomeExercicio;
	private JPanel panel;
	private JPanel panel1;
	private JLabel mainMessagem;
	private JPanel faixa;
	private JLabel lblNome;
	private JLabel lblInsiraOsDados;
	private JPanel faixa2;
	private JLabel lblIconNome;
	private JComboBox comboBoxExercicio;
	private JLabel lbltipo;
	private JLabel lblNewLabel;
	private JPanel panelDescricao;
	private JTextArea textArea;
	private JButton btnVoltar;
	private JButton btnCadastrar;
	private JLabel lblIconTipo;
	private JLabel lblIconDescricao;
	private ControladorTelaCadastroExercicio controladorTela;

	/**
	 * Construtor que cria a tela
	 * 
	 * @see ControladorTelaCadastroExercicio
	 */
	public PanelCadastroExercicio() {
		// Defino as características da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino uma panel base da tela
		panel = new JPanel();
		panel.setBorder(new CompoundBorder());
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		// Defino o panel base para inserir os dados
		panel1 = new JPanel();
		panel1.setBackground(new Color(240, 240, 240));
		panel1.setBounds(168, 102, 310, 47);
		panel.add(panel1);
		panel1.setLayout(null);

		// Defino textfield onde será inserido o nome do exercício
		nomeExercicio = new JTextField();
		nomeExercicio.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		nomeExercicio.setBounds(0, 11, 290, 25);
		panel1.add(nomeExercicio);
		nomeExercicio.setColumns(10);

		// Defino a label onde é inserido a mensagem principal de exerício
		mainMessagem = new JLabel("Cadastro de Exerc\u00EDcio");
		mainMessagem.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		mainMessagem.setHorizontalAlignment(SwingConstants.CENTER);
		mainMessagem.setBounds(128, 33, 279, 26);
		panel.add(mainMessagem);

		// Defino a faixa utilizada para design da página
		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		// Defino a label de ajuda para o usuário
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(59, 112, 63, 26);
		panel.add(lblNome);

		// Defino uma label contendo a mensagem principal
		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(128, 71, 279, 26);
		panel.add(lblInsiraOsDados);

		// Defino a segunda faixa para design
		faixa2 = new JPanel();
		faixa2.setBackground(new Color(216, 205, 176));
		faixa2.setBounds(0, 349, 529, 31);
		panel.add(faixa2);
		faixa2.setLayout(null);

		// Defino o botão para voltar para o início
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(98, 0, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(226, 71, 43));
		faixa2.add(btnVoltar);

		// Defino o botão para realizar o cadastro
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnCadastrar.setBounds(313, 0, 117, 31);
		btnCadastrar.addActionListener(this);
		btnCadastrar.setBackground(new Color(43, 226, 71));
		faixa2.add(btnCadastrar);

		// Defino a label onde fica o ícone do nome
		lblIconNome = new JLabel("");
		lblIconNome.setBounds(10, 102, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconNome);

		// Defino a combobox onde é inserido o grupamento muscular do exercício
		comboBoxExercicio = new JComboBox();
		comboBoxExercicio.setModel(new DefaultComboBoxModel(TipoDeGrupamento.values()));
		comboBoxExercicio.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboBoxExercicio.setBounds(168, 173, 310, 31);
		panel.add(comboBoxExercicio);

		// Defino a label de ajuda para o usuário
		lbltipo = new JLabel("Tipo:");
		lbltipo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lbltipo.setBounds(59, 181, 113, 14);
		panel.add(lbltipo);

		// Defino a label de ajuda para o usuário
		lblNewLabel = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(59, 237, 100, 20);
		panel.add(lblNewLabel);

		// Defino o panel para armazenar a textArea de descrição
		panelDescricao = new JPanel();
		panelDescricao.setLayout(null);
		panelDescricao.setBackground(new Color(255, 255, 255));
		panelDescricao.setBounds(168, 243, 324, 78);
		panel.add(panelDescricao);

		// Defino a textArea para ser inserido as descrições dos exercícios
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setTabSize(4);
		textArea.setRows(4);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		textArea.setBounds(0, 0, 324, 78);
		panelDescricao.add(textArea);

		// Defino o local onde é inserido o icone de tipo
		lblIconTipo = new JLabel("");
		lblIconTipo.setBounds(10, 163, 40, 41);
		lblIconTipo.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/tipo-2.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconTipo);

		// Defino o local onde é inserido o icone de exercícios
		lblIconDescricao = new JLabel("");
		lblIconDescricao.setBounds(10, 229, 40, 41);
		lblIconDescricao.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/escrita.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panel.add(lblIconDescricao);

		// Defino o controlador que realiza a conecção entre o backend e o frontend

		controladorTela = new ControladorTelaCadastroExercicio(this);
	}

	/**
	 * Método responsável por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um botão
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	// Getters e setters
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
