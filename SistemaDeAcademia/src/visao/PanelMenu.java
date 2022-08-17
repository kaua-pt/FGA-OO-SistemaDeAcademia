package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controladores.ControladorMainLabel;

/**
 * @author Kaua Vinicius
 * 
 *         Classe em que e implementado a tela para cadastro de Treino. Herda a
 *         classe JPanel pra confeccionar a tela
 * 
 * @see JPanel
 */

public class PanelMenu extends JFrame {

	private static final long serialVersionUID = 1076676034467007044L;
	private JPanel contentPane;
	private JLabel labelTitulo;
	private JPanel panelMenu;
	private JPanel panelMainMenu;
	private ControladorMainLabel controlador;
	private JLabel lblMainIcone;
	private JPanel panelInicio;
	private JLabel lblNomeInicio;
	private JLabel lblInicioIcone;
	private JPanel panelAlunos;
	private JLabel lblAlunos;
	private JLabel lblAlunosIcone;
	private JPanel panelExercicios;
	private JLabel lblExerccios;
	private JLabel lblExerciciosIcone;
	private JPanel panelTreino;
	private JLabel lblTreino;
	private JLabel lblTreinoIcone;
	private JPanel panelSair;
	private JLabel lblSair;
	private JLabel lblSairIcone;

	/**
	 * Construitor em que e gerado a tela base juntamente com seus componentes.
	 * Metodos atrelados aos botoes estao no backend
	 * 
	 * @param titulo String que sera o titulo da pagina
	 * @see ControladorMainLabel
	 */
	public PanelMenu(String titulo) {

		// Defino as caracteristicas da tela
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(37, 66, 82));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		// Defino o titulo da pagina
		labelTitulo = new JLabel(titulo);
		add(labelTitulo);

		// Defino o panel basico de menu
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(23, 28, 45));
		panelMenu.setBounds(0, 0, 185, 464);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		// Defino o local onde as informacoes aparecerao
		panelMainMenu = new JPanel();
		panelMainMenu.setBackground(new Color(231, 233, 238));
		panelMainMenu.setBounds(195, 11, 529, 403);
		contentPane.add(panelMainMenu);
		panelMainMenu.setLayout(null);

		// Defino a label onde estara o icone principal do programa
		lblMainIcone = new JLabel("");
		lblMainIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainIcone.setBounds(10, 11, 165, 98);
		lblMainIcone.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/academia.png"))
						.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		panelMenu.add(lblMainIcone);

		// Defino o panel Inicio que serve como botao
		panelInicio = new JPanel();
		panelInicio.setBounds(0, 119, 185, 48);
		panelInicio.setBackground(new Color(231, 233, 238));
		panelInicio.addMouseListener(new AcaoPerformada(panelInicio, 1));
		panelMenu.add(panelInicio);
		panelInicio.setLayout(null);

		// Defino a label com o nome inicio
		lblNomeInicio = new JLabel("In\u00EDcio");
		lblNomeInicio.setForeground(new Color(0, 0, 0));
		lblNomeInicio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNomeInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeInicio.setBounds(84, 11, 38, 26);
		panelInicio.add(lblNomeInicio);

		// Defino a label com o icone de inicio
		lblInicioIcone = new JLabel("");
		lblInicioIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioIcone.setBackground(Color.WHITE);
		lblInicioIcone.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/casa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblInicioIcone.setBounds(10, 0, 53, 48);
		panelInicio.add(lblInicioIcone);

		// Defino o panel alunos que serve como botao
		panelAlunos = new JPanel();
		panelAlunos.setBounds(0, 178, 185, 48);
		panelAlunos.setBackground(new Color(231, 233, 238));
		panelAlunos.addMouseListener(new AcaoPerformada(panelAlunos, 2));
		panelMenu.add(panelAlunos);
		panelAlunos.setLayout(null);

		// Defino a label com o nome alunos
		lblAlunos = new JLabel("Alunos");
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunos.setForeground(Color.BLACK);
		lblAlunos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAlunos.setBounds(84, 11, 48, 26);
		panelAlunos.add(lblAlunos);

		// Defino a label com o icone de alunos
		lblAlunosIcone = new JLabel("");
		lblAlunosIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunosIcone.setBackground(Color.WHITE);
		lblAlunosIcone.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/do-utilizador.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblAlunosIcone.setBounds(10, 0, 53, 48);
		panelAlunos.add(lblAlunosIcone);

		// Defino o panel Exercicios que serve como botao
		panelExercicios = new JPanel();
		panelExercicios.setBounds(0, 237, 185, 48);
		panelExercicios.setBackground(new Color(231, 233, 238));
		panelExercicios.addMouseListener(new AcaoPerformada(panelExercicios, 3));
		panelMenu.add(panelExercicios);
		panelExercicios.setLayout(null);

		// Defino a label com o nome de exercicios
		lblExerccios = new JLabel("Exerc\u00EDcios");
		lblExerccios.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerccios.setForeground(Color.BLACK);
		lblExerccios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExerccios.setBounds(84, 11, 75, 26);
		panelExercicios.add(lblExerccios);

		// Defino a label onde estara o icone de exercicios
		lblExerciciosIcone = new JLabel("");
		lblExerciciosIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosIcone.setBackground(Color.WHITE);
		lblExerciciosIcone.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/exercicio.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblExerciciosIcone.setBounds(10, 0, 53, 48);
		panelExercicios.add(lblExerciciosIcone);

		// Defino o panel treino que serve como botao
		panelTreino = new JPanel();
		panelTreino.setBounds(0, 296, 185, 48);
		panelTreino.setBackground(new Color(231, 233, 238));
		panelTreino.addMouseListener(new AcaoPerformada(panelTreino, 4));
		panelMenu.add(panelTreino);
		panelTreino.setLayout(null);

		// Defino a label onde estara o nome treino
		lblTreino = new JLabel("Treino");
		lblTreino.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreino.setForeground(Color.BLACK);
		lblTreino.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTreino.setBounds(84, 11, 45, 26);
		panelTreino.add(lblTreino);

		// Defino a label onde estara o icone de teino
		lblTreinoIcone = new JLabel("");
		lblTreinoIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreinoIcone.setBackground(Color.WHITE);
		lblTreinoIcone.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PanelMenu.class.getResource("/Imagens/exercicios-de-alongamento.png"))
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblTreinoIcone.setBounds(10, 0, 53, 48);
		panelTreino.add(lblTreinoIcone);

		// Defino o panel sair que serve como botao
		panelSair = new JPanel();
		panelSair.setBounds(0, 355, 185, 48);
		panelSair.setBackground(new Color(231, 233, 238));
		panelSair.addMouseListener(new AcaoPerformada(panelSair, 5));
		panelMenu.add(panelSair);
		panelSair.setLayout(null);

		// Defino a label onde estara escrito sair
		lblSair = new JLabel("Sair");
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setForeground(Color.BLACK);
		lblSair.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSair.setBounds(84, 11, 27, 26);
		panelSair.add(lblSair);

		// Defino a label onde estara o icone de saida
		lblSairIcone = new JLabel("");
		lblSairIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblSairIcone.setBackground(Color.WHITE);
		lblSairIcone.setBounds(10, 0, 53, 48);
		lblSairIcone.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/sair.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelSair.add(lblSairIcone);

		// Defino o controlador que realiza a coneccao entre backend e frontend
		controlador = new ControladorMainLabel(this);
		controlador.caminho(1);
		controlador.iniciarValores();

	}

	/**
	 * 
	 * @author Kaua Vinicius
	 *
	 *         Defino a classe que e utilizada para padronizar os pseudoBotoes da
	 *         tela. Herdo elementos da classe MouseAdapter
	 *
	 * @see MouseAdapter
	 */
	private class AcaoPerformada extends MouseAdapter {

		JPanel panel;
		int id;

		/**
		 * Constutor da classe para instanciar a tela, id e o operacao
		 * 
		 * @param panel Jpanel onde esta sendo realizado as operacoes
		 * @param id    Int que contem o id do botao
		 */
		public AcaoPerformada(JPanel panel, int id) {
			this.panel = panel;
			this.id = id;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
			controlador.caminho(id);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(231, 233, 238));
		}
	}

	// Getters e Setters
	public JPanel getPanelInicio() {
		return panelInicio;
	}

	public JLabel getLblAlunos() {
		return lblAlunos;
	}

	public JLabel getLblExerccios() {
		return lblExerccios;
	}

	public JLabel getLblTreino() {
		return lblTreino;
	}

	public JLabel getLblSair() {
		return lblSair;
	}

	public JPanel getPanelMainMenu() {
		return panelMainMenu;
	}

	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}

}
