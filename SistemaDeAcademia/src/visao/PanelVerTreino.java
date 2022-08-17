package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControladorVerTreino;
import modelo.Treino;

/**
 * @author Kaua Vinicius
 * 
 *         Classe em que e implementado a tela para visualizar um treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteracao dos botoes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes" })
public class PanelVerTreino extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panelBase;
	private JButton btnVoltar;
	private JButton btnEditar;
	private JLabel lblNome;
	private JLabel lblAluno;
	private JLabel lblSeries;
	private JLabel lblRepeticoes;
	private JList listExerciciosTreino;
	private JLabel lblExercicios;
	private JTextArea textTipo;
	private ControladorVerTreino controladorTela;
	private JPanel panelBaseGeral;

	/**
	 * Construitor em que e gerado a tela de visualizacao de treino juntamente com
	 * seus componentes. Metodos atrelados aos botoes estao no backend
	 * 
	 * @see ControladorVerTreino
	 */
	public PanelVerTreino(Treino treino) {
		// Defino caracteristicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel que e utilizado como base para todos os elementos
		panelBaseGeral = new JPanel();
		panelBaseGeral.setBounds(0, 11, 529, 374);
		add(panelBaseGeral);
		panelBaseGeral.setLayout(null);

		// Defino o panel que e utilizado como base para os botoes
		panelBase = new JPanel();
		panelBase.setBounds(0, 346, 527, 28);
		panelBaseGeral.add(panelBase);
		panelBase.setLayout(null);
		panelBase.setBackground(new Color(216, 205, 176));
		panelBase.setAlignmentY(1.0f);

		// Defino o botao para voltar para o inicio
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.setBounds(116, 0, 89, 28);
		btnVoltar.addActionListener(this);
		panelBase.add(btnVoltar);

		// Defino o botao para editar o treino
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnEditar.setBackground(Color.GREEN);
		btnEditar.setBounds(321, 0, 89, 28);
		btnEditar.addActionListener(this);
		panelBase.add(btnEditar);

		// Defino o panel que e utilizado como base
		panel = new JPanel();
		panel.setBounds(0, 0, 529, 28);
		panelBaseGeral.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);

		// Defino o label onde sera inserido o nome
		lblNome = new JLabel();
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(122, 0, 290, 26);
		panel.add(lblNome);
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 16));

		// Defino o label onde sera inserido o aluno
		lblAluno = new JLabel();
		lblAluno.setBounds(10, 59, 254, 14);
		panelBaseGeral.add(lblAluno);
		lblAluno.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino o label onde sera inserido o numero de series
		lblSeries = new JLabel();
		lblSeries.setBounds(10, 188, 254, 20);
		panelBaseGeral.add(lblSeries);
		lblSeries.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino o label onde sera inserido o numero de repeticoes
		lblRepeticoes = new JLabel();
		lblRepeticoes.setBounds(10, 247, 254, 29);
		panelBaseGeral.add(lblRepeticoes);
		lblRepeticoes.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino o label onde sera inserido os exercicios
		listExerciciosTreino = new JList();
		listExerciciosTreino.setBounds(274, 86, 245, 235);
		panelBaseGeral.add(listExerciciosTreino);
		listExerciciosTreino.setVisibleRowCount(80);
		listExerciciosTreino.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listExerciciosTreino.setBorder(new LineBorder(new Color(0, 0, 0)));

		// Defino a label indicando os exercicios
		lblExercicios = new JLabel("Exercicios:");
		lblExercicios.setBounds(274, 52, 110, 26);
		panelBaseGeral.add(lblExercicios);
		lblExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino o label para receber o tipo do treino
		textTipo = new JTextArea();
		textTipo.setBounds(10, 110, 254, 43);
		panelBaseGeral.add(textTipo);
		textTipo.setLineWrap(true);
		textTipo.setBackground(panelBaseGeral.getBackground());
		textTipo.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		textTipo.setEditable(false);

		// Defino o controlador que realizara a coneccao entre o backend e o
		// frontend
		controladorTela = new ControladorVerTreino(this, treino);
		controladorTela.inicializar();

	}

	/**
	 * Metodo responsavel por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um botao
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorTela.acaoPerformada(e.getSource());
	}

	// Getters e Setters
	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblAluno() {
		return lblAluno;
	}

	public void setLblAluno(JLabel lblAluno) {
		this.lblAluno = lblAluno;
	}

	public JTextArea getTextTipo() {
		return textTipo;
	}

	public void setTextTipo(JTextArea textTipo) {
		this.textTipo = textTipo;
	}

	public JLabel getLblSeries() {
		return lblSeries;
	}

	public void setLblSeries(JLabel lblSeries) {
		this.lblSeries = lblSeries;
	}

	public JLabel getLblRepeticoes() {
		return lblRepeticoes;
	}

	public void setLblRepeticoes(JLabel lblRepeticoes) {
		this.lblRepeticoes = lblRepeticoes;
	}

	public JList getListExerciciosTreino() {
		return listExerciciosTreino;
	}

	public void setListExerciciosTreino(JList listExerciciosTreino) {
		this.listExerciciosTreino = listExerciciosTreino;
	}

	public JPanel getPanelBaseGeral() {
		return panelBaseGeral;
	}

	public void setPanelBaseGeral(JPanel panelBaseGeral) {
		this.panelBaseGeral = panelBaseGeral;
	}

}
