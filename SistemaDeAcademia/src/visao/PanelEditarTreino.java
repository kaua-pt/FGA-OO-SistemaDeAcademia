package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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

import controladores.ControladorTelaEditarTreino;
import modelo.Treino;

/**
 * @author Kaua Vinicius
 * 
 *         Classe em que e implementado a tela para edicao de Treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteracao dos botoes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes", "unchecked", "removal" })
public class PanelEditarTreino extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTextField textNome;
	private JComboBox comboGrupo;
	private JList<String> listExerciciosTreino;
	private JPanel panel;
	private JPanel panelMain2;
	private JLabel lblTexto;
	private JPanel panelMain1;
	private JLabel lblTitulo;
	private JPanel faixa;
	private JPanel faixaBaixo;
	private JLabel lblNome;
	private JPanel panelAux;
	private JLabel lblInsiraOsDados;
	private JLabel lblTipo;
	private JButton btnInicio;
	private JButton btnFinalizar;
	private JButton btnVoltar;
	private JButton btnExercicios;
	private JLabel lblSeries;
	private JLabel lblRep;
	private JSpinner spinnerSerie;
	private JSpinner spinnerRepeticao;
	private ControladorTelaEditarTreino controladorTela;

	/**
	 * Construitor em que e gerado a tela de editar treino juntamente com seus
	 * componentes. Metodos atrelados aos botoes estao no backend
	 * 
	 * @see ControladorTelaEditarTreino
	 */
	public PanelEditarTreino(Treino treino) {
		// Defino as caracteristicas basicas da tela
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

		// Defino o primeiro panel base das informacoes
		panelMain1 = new JPanel();
		panelMain1.setVisible(true);

		// Defino o segundo panel base das informacoes
		panelMain2 = new JPanel();
		panelMain2.setBounds(0, 61, 529, 277);
		panel.add(panelMain2);
		panelMain2.setVisible(false);
		panelMain2.setLayout(null);

		// Defino um texto de ajuda ao usuario
		lblTexto = new JLabel("Selecione Novamente os exercicios desejados");
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTexto.setBounds(71, 11, 412, 30);
		panelMain2.add(lblTexto);

		// Defino uma lista contendo os exercicios compativeis com o treino
		listExerciciosTreino = new JList();
		listExerciciosTreino.setBorder(new LineBorder(new Color(0, 0, 0)));
		listExerciciosTreino.setVisibleRowCount(80);
		listExerciciosTreino.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listExerciciosTreino.setBounds(81, 44, 378, 189);
		panelMain2.add(listExerciciosTreino);

		// Defino o botao para retornar
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(204, 244, 117, 31);
		btnVoltar.addActionListener(this);
		btnVoltar.setBackground(new Color(255, 163, 100));
		btnVoltar.setForeground(Color.BLACK);
		panelMain2.add(btnVoltar);
		panelMain1.setBounds(0, 70, 529, 266);
		panel.add(panelMain1);
		panelMain1.setLayout(null);

		// Defino uma label com um texto de ajuda ao usuario
		lblTitulo = new JLabel("Editar Treino");
		lblTitulo.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(128, 33, 279, 26);
		panel.add(lblTitulo);

		// Defino a faixa superior para design
		faixa = new JPanel();
		faixa.setBackground(new Color(216, 205, 176));
		faixa.setBounds(0, 28, 529, 31);
		panel.add(faixa);

		// Defino a faixa inferior para design
		faixaBaixo = new JPanel();
		faixaBaixo.setBackground(new Color(216, 205, 176));
		faixaBaixo.setBounds(0, 349, 529, 31);
		panel.add(faixaBaixo);
		faixaBaixo.setLayout(null);

		// Defino o botao para retornar ao inicio
		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnInicio.setBounds(96, 0, 117, 31);
		btnInicio.addActionListener(this);
		btnInicio.setBackground(new Color(226, 71, 43));
		faixaBaixo.add(btnInicio);

		// Defino o botao para finalizar a edicao
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnFinalizar.setBounds(311, 0, 117, 31);
		btnFinalizar.setBackground(new Color(43, 226, 71));
		btnFinalizar.addActionListener(this);
		faixaBaixo.add(btnFinalizar);

		// Defino a label indicando aonde colocar o nome
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(64, 52, 63, 26);
		panelMain1.add(lblNome);

		// Defino um panel auxiliar
		panelAux = new JPanel();
		panelAux.setLayout(null);
		panelAux.setBackground(SystemColor.menu);
		panelAux.setBounds(126, 37, 342, 47);
		panelMain1.add(panelAux);

		// Defino o local onde sera inserido o nome do treino
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(0, 16, 332, 25);
		panelAux.add(textNome);

		// Defino a label indicando aonde colocar o tipo de grupamento
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblTipo.setBounds(64, 119, 63, 26);
		panelMain1.add(lblTipo);

		// Defino o combo contendo os grupamentos musculares
		comboGrupo = new JComboBox();
		comboGrupo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboGrupo.setBounds(126, 117, 343, 31);
		comboGrupo.setModel(new DefaultComboBoxModel(new String[] { "A- Peito, Tr\u00EDceps e Ombro",
				"B- Costa e B\u00EDceps", "C- Perna", "D- Aer\u00F3bico" }));
		panelMain1.add(comboGrupo);

		// Defino o botao para entrar na tela de exerc�cios
		btnExercicios = new JButton("Exercicios");
		btnExercicios.setBounds(204, 235, 117, 31);
		panelMain1.add(btnExercicios);
		btnExercicios.addActionListener(this);
		btnExercicios.setBackground(new Color(255, 163, 100));
		btnExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 12));

		// Defino a label de ajuda a usuario
		lblInsiraOsDados = new JLabel("Insira os dados:");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblInsiraOsDados.setBounds(126, 0, 279, 26);
		panelMain1.add(lblInsiraOsDados);

		// Defino a label indicando aonde colocar as series
		lblSeries = new JLabel("S\u00E9ries:");
		lblSeries.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblSeries.setBounds(64, 176, 76, 26);
		panelMain1.add(lblSeries);

		// Defino a label indicando aonde colocar as repeticoes
		lblRep = new JLabel("Repeti\u00E7\u00F5es:");
		lblRep.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblRep.setBounds(312, 176, 117, 26);
		panelMain1.add(lblRep);

		// Defino o spin para inserir as series
		spinnerSerie = new JSpinner();
		spinnerSerie.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerSerie.setBounds(147, 179, 56, 20);
		panelMain1.add(spinnerSerie);

		// Defino o spin para inserir as repeticoes
		spinnerRepeticao = new JSpinner();
		spinnerRepeticao.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerRepeticao.setBounds(429, 179, 56, 20);
		panelMain1.add(spinnerRepeticao);

		// Defino o controlador que realiza a coneccao entre o backend e o frontend
		controladorTela = new ControladorTelaEditarTreino(this);
		controladorTela.iniciarTela(treino);
	}

	/**
	 * Metodo responsavel por conectar o backend e o frontend
	 * 
	 * @param e Evento no qual representa o clique de um botao
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorTela.acaoPerformada(e.getSource());
	}

	// Getters e Setters
	public JComboBox getComboGrupo() {
		return comboGrupo;
	}

	public void setComboGrupo(JComboBox comboGrupo) {
		this.comboGrupo = comboGrupo;
	}

	public JList<String> getListExerciciosTreino() {
		return listExerciciosTreino;
	}

	public void setListExerciciosTreino(JList<String> listExerciciosTreino) {
		this.listExerciciosTreino = listExerciciosTreino;
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public void setBtnInicio(JButton btnInicio) {
		this.btnInicio = btnInicio;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public void setBtnFinalizar(JButton btnCadastrar) {
		this.btnFinalizar = btnCadastrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnExercicios() {
		return btnExercicios;
	}

	public void setBtnExercicios(JButton btnExercicios) {
		this.btnExercicios = btnExercicios;
	}

	public JSpinner getSpinnerSerie() {
		return spinnerSerie;
	}

	public void setSpinnerSerie(JSpinner spinnerSerie) {
		this.spinnerSerie = spinnerSerie;
	}

	public JSpinner getSpinnerRepeticao() {
		return spinnerRepeticao;
	}

	public void setSpinnerRepeticao(JSpinner spinnerRepeticao) {
		this.spinnerRepeticao = spinnerRepeticao;
	}

	public JPanel getPanelMain2() {
		return panelMain2;
	}

	public void setPanelMain2(JPanel panelMain2) {
		this.panelMain2 = panelMain2;
	}

	public JPanel getPanelMain1() {
		return panelMain1;
	}

	public void setPanelMain1(JPanel panelMain1) {
		this.panelMain1 = panelMain1;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textField) {
		this.textNome = textField;
	}

}
