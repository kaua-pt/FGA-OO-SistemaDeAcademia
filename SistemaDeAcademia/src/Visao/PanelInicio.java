package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * @author Kau� Vin�cius
 * 
 *         Classe que implementa a tela incial com informações básicas do
 *         programa. Herda JPanel para criar a interface gráfica
 * 
 * @see JPanel
 **/

public class PanelInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtAlunos;
	private JTextField txtTreinos;
	private JTextField txtExerccios;
	private JTextField txtInicio;
	private JLabel lblBoasVindas;
	private JPanel panel;
	private JLabel lblAlunoinc;
	private JTextPane txtpBase;
	private JPanel panelBase;
	private JLabel iconTreino;
	private JTextPane txtpnCliqueEmTreino;
	private JPanel panelBase1;
	private JLabel lblIconeExercicio;
	private JTextPane txtInfoExercicio;

	/**
	 * Construtor que cria a tela e suas características
	 */
	public PanelInicio() {
		// Defino a borda, a cor de fundo, tamanho da tela e seu layout;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Mensagem de boas Vindas
		lblBoasVindas = new JLabel("Bem Vindo ao Sistema We Go Gym");
		lblBoasVindas.setFont(new Font("Fira Code Light", Font.BOLD, 17));
		lblBoasVindas.setBounds(102, 31, 330, 52);
		add(lblBoasVindas);

		// Defino o JPanel que serve como base para os demais componentes da classe
		panel = new JPanel();
		panel.setBackground(new Color(135, 148, 192));
		panel.setBounds(10, 94, 162, 276);
		add(panel);
		panel.setLayout(null);

		// Defino o ícone das informações dos alunos
		lblAlunoinc = new JLabel("");
		lblAlunoinc.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/do-utilizador.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblAlunoinc.setBounds(61, 23, 40, 46);
		panel.add(lblAlunoinc);

		// Defino o texto contendo o título para alunos
		txtAlunos = new JTextField();
		txtAlunos.setEditable(false);
		txtAlunos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlunos.setText("Alunos");
		txtAlunos.setBounds(32, 69, 98, 27);
		panel.add(txtAlunos);
		txtAlunos.setColumns(10);

		// Defino o texto para as operações com alunos
		txtpBase = new JTextPane();
		txtpBase.setEditable(false);
		txtpBase.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtpBase.setText(
				"Clique em alunos para ser redirecionado ao campo de cadastro listagem, exclus\u00E3o e edi\u00E7\u00E3o dos dados dos alunos");
		txtpBase.setBounds(10, 125, 142, 127);
		panel.add(txtpBase);

		// Primeiro Panel usado como base gráfica
		panelBase = new JPanel();
		panelBase.setBackground(new Color(135, 148, 192));
		panelBase.setBounds(182, 94, 162, 276);
		add(panelBase);
		panelBase.setLayout(null);

		// Defino aqui o icone de Treino
		iconTreino = new JLabel("");
		iconTreino.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PanelMenu.class.getResource("/Imagens/exercicios-de-alongamento.png"))
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		iconTreino.setBounds(61, 23, 40, 46);
		panelBase.add(iconTreino);

		// Defino o texto contendo o título para treinos
		txtTreinos = new JTextField();
		txtTreinos.setEditable(false);
		txtTreinos.setText("Treinos");
		txtTreinos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtTreinos.setColumns(10);
		txtTreinos.setBounds(32, 69, 98, 27);
		panelBase.add(txtTreinos);

		// Defino o texto para as operações com Treino
		txtpnCliqueEmTreino = new JTextPane();
		txtpnCliqueEmTreino.setEditable(false);
		txtpnCliqueEmTreino.setText(
				"Clique em treino para ser redirecionado ao campo de cadastro listagem, exclus\u00E3o e edi\u00E7\u00E3o dos treinos");
		txtpnCliqueEmTreino.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtpnCliqueEmTreino.setBounds(10, 125, 142, 127);
		panelBase.add(txtpnCliqueEmTreino);

		// Defino aqui os segundo panel utilizado como base
		panelBase1 = new JPanel();
		panelBase1.setBackground(new Color(135, 148, 192));
		panelBase1.setBounds(354, 94, 162, 276);
		add(panelBase1);
		panelBase1.setLayout(null);

		// Defino o icone do Exercicio
		lblIconeExercicio = new JLabel("");
		lblIconeExercicio.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/exercicio.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblIconeExercicio.setBounds(61, 22, 40, 46);
		panelBase1.add(lblIconeExercicio);

		// Defino o texto contendo o título para exercícios
		txtExerccios = new JTextField();
		txtExerccios.setEditable(false);
		txtExerccios.setText("Exerc\u00EDcios");
		txtExerccios.setHorizontalAlignment(SwingConstants.CENTER);
		txtExerccios.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtExerccios.setColumns(10);
		txtExerccios.setBounds(29, 69, 104, 27);
		panelBase1.add(txtExerccios);

		// Defino o texto para as operações com Exercicios
		txtInfoExercicio = new JTextPane();
		txtInfoExercicio.setEditable(false);
		txtInfoExercicio.setText(
				"Clique em Exerc\u00EDcios para ser redirecionado ao campo de cadastro listagem, exclus\u00E3o e edi\u00E7\u00E3o dos exerc\u00EDcios");
		txtInfoExercicio.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtInfoExercicio.setBounds(10, 125, 142, 127);
		panelBase1.add(txtInfoExercicio);

		// Defino aqui o texto de inicio
		txtInicio = new JTextField();
		txtInicio.setEditable(false);
		txtInicio.setText("Inicio");
		txtInicio.setHorizontalAlignment(SwingConstants.CENTER);
		txtInicio.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtInicio.setColumns(10);
		txtInicio.setBounds(218, 11, 98, 27);
		add(txtInicio);
	}
}
