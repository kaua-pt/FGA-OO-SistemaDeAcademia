package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorTelaEditarExercicio;
import Modelo.Exercicio;
import Modelo.TipoDeGrupamento;

/**
 * @author Kauã Vinícius
 * 
 *         Classe em que Ã© implementado a tela para edição de exercícios.Herda
 *         a classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteraÃ§Ã£o dos botÃµes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class PanelEditarExercicio extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JPanel panelBase;
	private JLabel lblEditarExercicio;
	private JPanel faixa1;
	private JButton btnInicio;
	private JButton btnFinalizar;
	private JLabel lblIconNome;
	private JComboBox comboBoxExercicio;
	private JLabel lblNome;
	private JLabel lbltipo;
	private JLabel lblDescricao;
	private JTextArea textDescricao;
	private ControladorTelaEditarExercicio controladorT;

	/**
	 * Construitor em que Ã© gerado a tela de edição de exercicio juntamente com
	 * seus componentes. MÃ©todos atrelados aos botÃµes estÃ£o no backend
	 * 
	 * @see ControladorTelaEditarExercicio
	 */
	public PanelEditarExercicio(Exercicio exercicio) {
		// Defino as caracteristicas básicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel base da tela
		panelBase = new JPanel();
		panelBase.setBackground(new Color(216, 205, 176));
		panelBase.setBounds(0, 25, 529, 31);
		add(panelBase);

		// Defino a label de ajuda ao usuário
		lblEditarExercicio = new JLabel("Editar Exercicio");
		lblEditarExercicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarExercicio.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		panelBase.add(lblEditarExercicio);

		// Defino faixa onde estão inseridos os botões
		faixa1 = new JPanel();
		faixa1.setLayout(null);
		faixa1.setBackground(new Color(216, 205, 176));
		faixa1.setBounds(0, 346, 529, 31);
		add(faixa1);

		btnInicio = new JButton("Inicio");
		btnInicio.setForeground(Color.BLACK);
		btnInicio.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnInicio.setBackground(new Color(226, 71, 43));
		btnInicio.setBounds(98, 0, 117, 31);
		btnInicio.addActionListener(this);
		faixa1.add(btnInicio);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(Color.BLACK);
		btnFinalizar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnFinalizar.setBackground(new Color(43, 226, 71));
		btnFinalizar.addActionListener(this);
		btnFinalizar.setBounds(313, 0, 117, 31);
		faixa1.add(btnFinalizar);

		lblIconNome = new JLabel("");
		lblIconNome.setBounds(10, 90, 40, 41);
		add(lblIconNome);

		// Defino a label indicando aonde colocar o nome
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblNome.setBounds(59, 100, 63, 26);
		add(lblNome);

		textNome = new JTextField();
		textNome.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
		textNome.setColumns(10);
		textNome.setBounds(168, 101, 290, 25);
		add(textNome);

		// Defino a combobox contendo os tipos de grupamento
		comboBoxExercicio = new JComboBox();
		comboBoxExercicio.setModel(new DefaultComboBoxModel(TipoDeGrupamento.values()));
		comboBoxExercicio.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		comboBoxExercicio.setBounds(168, 161, 310, 31);
		add(comboBoxExercicio);

		// Defino a label indicando aonde colocar o tipo
		lbltipo = new JLabel("Tipo:");
		lbltipo.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lbltipo.setBounds(59, 169, 113, 14);
		add(lbltipo);

		// Defino a label indicando aonde colocar a descrição
		lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setFont(new Font("Fira Code Light", Font.PLAIN, 16));
		lblDescricao.setBounds(59, 225, 100, 20);
		add(lblDescricao);

		textDescricao = new JTextArea();
		textDescricao.setTabSize(4);
		textDescricao.setRows(4);
		textDescricao.setLineWrap(true);
		textDescricao.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		textDescricao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textDescricao.setBounds(168, 231, 324, 78);
		add(textDescricao);

		// Defino o controlador que realiza a conecção entre o backend e o frontend
		controladorT = new ControladorTelaEditarExercicio(this);
		controladorT.iniciarCampos(exercicio);

	}

	/**
	 * Método responsável por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um botão
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controladorT.acaoPerformada(e.getSource());
	}

	// Getters e Setters
	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JComboBox getComboBoxExercicio() {
		return comboBoxExercicio;
	}

	public void setComboBoxExercicio(JComboBox comboBoxExercicio) {
		this.comboBoxExercicio = comboBoxExercicio;
	}

	public JTextArea getTextDescricao() {
		return textDescricao;
	}

	public void setTextDescricao(JTextArea textDescricao) {
		this.textDescricao = textDescricao;
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

	public void setBtnFinalizar(JButton btnFinalizar) {
		this.btnFinalizar = btnFinalizar;
	}

}
