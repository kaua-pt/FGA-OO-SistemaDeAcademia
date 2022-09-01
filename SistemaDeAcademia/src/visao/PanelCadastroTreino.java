package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControladorTelaCadastroTreino;
import modelo.Aluno;

/**
 * @author Kaua Vinicius
 * 
 *         Classe em que e implementado a tela para cadastro de Treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteracao dos botoes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes", "unchecked", "removal" })
public class PanelCadastroTreino extends JPanel implements ActionListener {
	private static final long serialVersionUID = 6408302848948208845L;

	private ControladorTelaCadastroTreino controladorTela;
	private JTextField textField;
	private JComboBox comboAluno;
	private JComboBox comboGrupo;
	private JList<String> listExerciciosTreino;
	private JSpinner spinSerie;
	private JSpinner spinRep;
	private JPanel panel;
	private JPanel panelMain2;
	private JLabel lblTexto;
	private JLabel lblSeries;
	private JLabel lblRepeticoes;
	private JPanel panelMain1;
	private JLabel lblMsgMain;
	private JPanel faixa;
	private JPanel faixa2;
	private JLabel lblAjudaNome;
	private JPanel panel2;
	private JLabel lblInsiraOsDados;
	private JLabel lblAjudaTipo;
	private JLabel lblAjudaAluno;
	private JButton btnInicio;
	private JButton btnCadastrar;
	private JButton btnVoltar;
	private JButton btnExercicios;
	private JLabel lblIconNome;
	private JLabel lblIconAluno;
	private JLabel lblIconTipo;

	/**
	 * Construtor que realiza a inicializacao da tela
	 * 
	 * @see ControladorTelaCadastroTreino
	 */
	public PanelCadastroTreino() {
		// Defino as caracteristicas base da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel utilizado como base da tela
		panel = new JPanel();
		panel.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		// Defino primeiro panel que aparecera para o usuario
		panelMain1 = new JPanel();
		panelMain1.setVisible(true);
		panelMain1.setBounds(0, 70, 529, 266);
		panel.add(panelMain1);
		panelMain1.setLayout(null);

		// Defino a mensagem principal da tela
		lblMsgMain = new JLabel("Cadastro de Treino");
		lblMsgMain.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblMsgMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsgMain.setBounds(128, 33, 279, 26);
		panel.add(lblMsgMain);

		// Defino a faixa utilizada como design
		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		// Defino a segunda faixa utilizada para design
		faixa2 = new JPanel();
		faixa2.setBackground(new Color(216, 205, 176));
		faixa2.setBounds(0, 349, 529, 31);
		panel.add(faixa2);
		faixa2.setLayout(null);

		// Defino o botao para retornar para o inicio
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnInicio.setBounds(96, 0, 117, 31);
		btnInicio.addActionListener(this);
		btnInicio.setBackground(new Color(226, 71, 43));
		faixa2.add(btnInicio);

		// Defino o botao para retornar para o cadastrar
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnCadastrar.setBounds(311, 0, 117, 31);
		btnCadastrar.setBackground(new Color(43, 226, 71));
		btnCadastrar.addActionListener(this);
		faixa2.add(btnCadastrar);

		// Defino a label para direcionar o usuario em relacao ao nome
		lblAjudaNome = new JLabel("Nome:");
		lblAjudaNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAjudaNome.setBounds(64, 52, 63, 26);
		panelMain1.add(lblAjudaNome);

		// Defino o terceiro panel de design
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(SystemColor.menu);
		panel2.setBounds(126, 37, 342, 47);
		panelMain1.add(panel2);

		// Defino textfield para inserir dados
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 11, 332, 25);
		panel2.add(textField);

		// Defino combo para selecionar o aluno em que deve ser anexado o treino
		comboAluno = new JComboBox();
		comboAluno.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboAluno.setBounds(126, 116, 343, 31);
		comboAluno.setModel(new DefaultComboBoxModel<String>(Aluno.getTodosAlunos()));
		panelMain1.add(comboAluno);

		// Defino o label para direcionar usuario em relacao ao aluno
		lblAjudaAluno = new JLabel("Aluno:");
		lblAjudaAluno.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAjudaAluno.setBounds(64, 124, 75, 14);
		panelMain1.add(lblAjudaAluno);

		// Defino o label para direcionar o usuario em relacao ao tipo
		lblAjudaTipo = new JLabel("Tipo:");
		lblAjudaTipo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblAjudaTipo.setBounds(64, 195, 63, 26);
		panelMain1.add(lblAjudaTipo);

		// Defino o combobox para selecionar o grupamento muscular
		comboGrupo = new JComboBox();
		comboGrupo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboGrupo.setBounds(125, 193, 343, 31);
		comboGrupo.setModel(new DefaultComboBoxModel(new String[] { "A- Peito, Tr\u00EDceps e Ombro",
				"B- Costa e B\u00EDceps", "C- Perna", "D- Aer\u00F3bico" }));
		panelMain1.add(comboGrupo);

		// Defino o botao para mostrar a tela de exercicios
		btnExercicios = new JButton("Exercicios");
		btnExercicios.setBounds(204, 235, 117, 31);
		panelMain1.add(btnExercicios);
		btnExercicios.addActionListener(this);
		btnExercicios.setBackground(new Color(255, 163, 100));
		btnExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 12));

		// Defino a label de ajuda
		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(126, 0, 279, 26);
		panelMain1.add(lblInsiraOsDados);

		// Defino a label onde havera o icone de nome
		lblIconNome = new JLabel("");
		lblIconNome.setBounds(14, 37, 40, 41);
		lblIconNome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/sinal-de-arroba.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelMain1.add(lblIconNome);

		// Defino a label onde havera o icone de aluno
		lblIconAluno = new JLabel("");
		lblIconAluno.setBounds(14, 114, 40, 41);
		lblIconAluno.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/usuario-de-perfil.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelMain1.add(lblIconAluno);

		// Defino a label onde havera o icone de tipo
		lblIconTipo = new JLabel("");
		lblIconTipo.setBounds(14, 180, 40, 41);
		lblIconTipo.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/tipo-2.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelMain1.add(lblIconTipo);

		// Defino o panel onde ficara a segunda parte de informacoes principais
		panelMain2 = new JPanel();
		panelMain2.setBounds(0, 61, 529, 277);
		panel.add(panelMain2);
		panelMain2.setVisible(false);
		panelMain2.setLayout(null);

		// Defino a label de ajuda na tela 2
		lblTexto = new JLabel("Selecione os exerc\u00EDcios desejados");
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblTexto.setBounds(100, 11, 361, 30);
		panelMain2.add(lblTexto);

		// Defino a label de ajuda para as series
		lblSeries = new JLabel("S\u00E9ries:");
		lblSeries.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblSeries.setBounds(375, 68, 91, 20);
		panelMain2.add(lblSeries);

		// Defino o spin para inserir as series
		spinSerie = new JSpinner();
		spinSerie.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinSerie.setBounds(375, 99, 65, 20);
		panelMain2.add(spinSerie);

		// Defino a label de repeticoes
		lblRepeticoes = new JLabel("Repeti\u00E7\u00F5es:");
		lblRepeticoes.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblRepeticoes.setBounds(375, 139, 121, 29);
		panelMain2.add(lblRepeticoes);

		// Defino o spin para inserir as repeticoes
		spinRep = new JSpinner();
		spinRep.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinRep.setBounds(375, 179, 65, 20);
		panelMain2.add(spinRep);

		// Defino a lista onde estara os exercicios que devem ser selecionados
		listExerciciosTreino = new JList();
		listExerciciosTreino.setBorder(new LineBorder(new Color(0, 0, 0)));
		listExerciciosTreino.setVisibleRowCount(80);
		listExerciciosTreino.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listExerciciosTreino.setBounds(27, 44, 338, 189);
		panelMain2.add(listExerciciosTreino);

		// Defino o botao para voltar
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(204, 244, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(255, 163, 100));
		btnVoltar.setForeground(Color.BLACK);
		panelMain2.add(btnVoltar);

		// Controlador que realiza a coneccao entre o front e o backend
		controladorTela = new ControladorTelaCadastroTreino(this);

	}

	/**
	 * Metodo responsavel por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um botao
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	// Getters e Setters
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JList<String> getListExerciciosTreino() {
		return listExerciciosTreino;
	}

	public void setListExerciciosTreino(JList<String> listExerciciosTreino) {
		this.listExerciciosTreino = listExerciciosTreino;
	}

	public JComboBox getComboAluno() {
		return comboAluno;
	}

	public JComboBox getComboGrupo() {
		return comboGrupo;
	}

	public JSpinner getSpinSerie() {
		return spinSerie;
	}

	public JSpinner getSpinRep() {
		return spinRep;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnExercicios() {
		return btnExercicios;
	}

	public JPanel getPanelMain2() {
		return panelMain2;
	}

	public JPanel getPanelMain1() {
		return panelMain1;
	}

}
