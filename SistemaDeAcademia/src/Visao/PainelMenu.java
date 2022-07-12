package Visao;

import java.awt.Color;
import java.awt.EventQueue;
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

public class PainelMenu extends JFrame {
	
	
	private JPanel contentPane;
	protected PainelInicio inicio = new PainelInicio();
	protected PainelRedirecionar redirecionarAluno = new PainelRedirecionar("Aluno");
	protected PainelRedirecionar redirecionarExercicio = new PainelRedirecionar("Exercicio");
	protected PainelRedirecionar redirecionarTreino = new PainelRedirecionar("Treino");
	
	public static void main(String[] args) {
		PainelMenu frame = new PainelMenu("Dale");
		frame.setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public PainelMenu(String titulo) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(37, 66, 82));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel labelTitulo = new JLabel(titulo);
		add(labelTitulo);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(23, 28, 45));
		panelMenu.setBounds(0, 0, 185, 464);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblMainIcone = new JLabel("");
		lblMainIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainIcone.setBounds(10, 11, 165, 98);
		lblMainIcone.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/academia.png"))
						.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		panelMenu.add(lblMainIcone);

		JPanel panelInicio = new JPanel();
		panelInicio.setBounds(0, 119, 185, 48);
		panelInicio.setBackground(new Color(231, 233, 238));
		panelInicio.addMouseListener(new PanelAdaptador(panelInicio));
		panelInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(inicio);
			}
		});
		panelMenu.add(panelInicio);
		panelInicio.setLayout(null);

		JLabel lblNewLabel = new JLabel("In\u00EDcio");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(84, 11, 38, 26);
		panelInicio.add(lblNewLabel);

		JLabel lblInicioIcone = new JLabel("");
		lblInicioIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioIcone.setBackground(Color.WHITE);
		lblInicioIcone.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/casa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblInicioIcone.setBounds(10, 0, 53, 48);
		panelInicio.add(lblInicioIcone);

		JPanel panelAlunos = new JPanel();
		panelAlunos.setBounds(0, 178, 185, 48);
		panelAlunos.setBackground(new Color(231, 233, 238));
		panelAlunos.addMouseListener(new PanelAdaptador(panelAlunos));
		panelMenu.add(panelAlunos);
		panelAlunos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(redirecionarAluno);
			}
		});
		panelAlunos.setLayout(null);

		JLabel lblAlunos = new JLabel("Alunos");
		lblAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunos.setForeground(Color.BLACK);
		lblAlunos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAlunos.setBounds(84, 11, 48, 26);
		panelAlunos.add(lblAlunos);

		JLabel lblAlunosIcone = new JLabel("");
		lblAlunosIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunosIcone.setBackground(Color.WHITE);
		lblAlunosIcone.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/do-utilizador.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblAlunosIcone.setBounds(10, 0, 53, 48);
		panelAlunos.add(lblAlunosIcone);

		JPanel panelExercicios = new JPanel();
		panelExercicios.setBounds(0, 237, 185, 48);
		panelExercicios.setBackground(new Color(231, 233, 238));
		panelExercicios.addMouseListener(new PanelAdaptador(panelExercicios));
		panelExercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(redirecionarExercicio);
			}
		});
		panelMenu.add(panelExercicios);
		panelExercicios.setLayout(null);

		JLabel lblExerccios = new JLabel("Exerc\u00EDcios");
		lblExerccios.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerccios.setForeground(Color.BLACK);
		lblExerccios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExerccios.setBounds(84, 11, 75, 26);
		panelExercicios.add(lblExerccios);

		JLabel lblExerciciosIcone = new JLabel("");
		lblExerciciosIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblExerciciosIcone.setBackground(Color.WHITE);
		lblExerciciosIcone.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/exercicio.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblExerciciosIcone.setBounds(10, 0, 53, 48);
		panelExercicios.add(lblExerciciosIcone);

		JPanel panelTreino = new JPanel();
		panelTreino.setBounds(0, 296, 185, 48);
		panelTreino.setBackground(new Color(231, 233, 238));
		panelTreino.addMouseListener(new PanelAdaptador(panelTreino));
		panelTreino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(redirecionarTreino);
			}
		});
		panelMenu.add(panelTreino);
		panelTreino.setLayout(null);

		JLabel lblTreino = new JLabel("Treino");
		lblTreino.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreino.setForeground(Color.BLACK);
		lblTreino.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTreino.setBounds(84, 11, 45, 26);
		panelTreino.add(lblTreino);

		JLabel lblTreinoIcone = new JLabel("");
		lblTreinoIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreinoIcone.setBackground(Color.WHITE);
		lblTreinoIcone.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PainelMenu.class.getResource("/Imagens/exercicios-de-alongamento.png"))
				.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblTreinoIcone.setBounds(10, 0, 53, 48);
		panelTreino.add(lblTreinoIcone);

		JPanel panelSair = new JPanel();
		panelSair.setBounds(0, 355, 185, 48);
		panelSair.setBackground(new Color(231, 233, 238));
		panelSair.addMouseListener(new PanelAdaptador(panelSair));
		panelMenu.add(panelSair);
		panelSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PainelMenu.this.dispose();
			}
		});
		panelSair.setLayout(null);

		JLabel lblSair = new JLabel("Sair");
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setForeground(Color.BLACK);
		lblSair.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSair.setBounds(84, 11, 27, 26);
		panelSair.add(lblSair);

		JLabel lblSairIcone = new JLabel("");
		lblSairIcone.setHorizontalAlignment(SwingConstants.CENTER);
		lblSairIcone.setBackground(Color.WHITE);
		lblSairIcone.setBounds(10, 0, 53, 48);
		lblSairIcone.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/sair.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelSair.add(lblSairIcone);

		JPanel panelMainMenu = new JPanel();
		panelMainMenu.setBackground(new Color(231, 233, 238));
		panelMainMenu.setBounds(195, 11, 529, 403);
		contentPane.add(panelMainMenu);
		panelMainMenu.setLayout(null);
		
		panelMainMenu.add(inicio);
		panelMainMenu.add(redirecionarAluno);
		panelMainMenu.add(redirecionarExercicio);
		panelMainMenu.add(redirecionarTreino);
		menuClicked(inicio);
	}
	
	public void menuClicked(JPanel panel) {
		inicio.setVisible(false);
		redirecionarAluno.setVisible(false); 
		redirecionarExercicio.setVisible(false); 
		redirecionarTreino.setVisible(false);  
		
		panel.setVisible(true);

	}
	
	protected class PanelAdaptador extends MouseAdapter {

		JPanel panel;

		public PanelAdaptador(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(231, 233, 238));
		}
	}
}
