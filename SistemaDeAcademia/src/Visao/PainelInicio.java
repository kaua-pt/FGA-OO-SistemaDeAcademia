package Visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.TextField;
import javax.swing.JTextPane;

public class PainelInicio extends JPanel{

	private JTextField txtAlunos;
	private JTextField txtTreinos;
	private JTextField txtExerccios;
	private JTextField txtInicio;

	public PainelInicio() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo ao Sistema We Go Gym");
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 17));
		lblNewLabel.setBounds(102, 31, 330, 52);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135,148,192));
		panel.setBounds(10, 94, 162, 276);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblAlunoinc = new JLabel("");
		lblAlunoinc.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/do-utilizador.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblAlunoinc.setBounds(61, 23, 40, 46);
		panel.add(lblAlunoinc);
		
		txtAlunos = new JTextField();
		txtAlunos.setEditable(false);
		txtAlunos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtAlunos.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlunos.setText("Alunos");
		txtAlunos.setBounds(32, 69, 98, 27);
		panel.add(txtAlunos);
		txtAlunos.setColumns(10);
		
		JTextPane txtpBase = new JTextPane();
		txtpBase.setEditable(false);
		txtpBase.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtpBase.setText("Clique em alunos para ser redirecionado ao campo de cadastro listagem, exclus\u00E3o e edi\u00E7\u00E3o dos dados dos alunos");
		txtpBase.setBounds(10, 125, 142, 127);
		panel.add(txtpBase);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135,148,192));
		panel_1.setBounds(182, 94, 162, 276);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/exercicios-de-alongamento.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(61, 23, 40, 46);
		panel_1.add(lblNewLabel_1);
		
		txtTreinos = new JTextField();
		txtTreinos.setEditable(false);
		txtTreinos.setText("Treinos");
		txtTreinos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtTreinos.setColumns(10);
		txtTreinos.setBounds(32, 69, 98, 27);
		panel_1.add(txtTreinos);
		
		JTextPane txtpnCliqueEmTreino = new JTextPane();
		txtpnCliqueEmTreino.setEditable(false);
		txtpnCliqueEmTreino.setText("Clique em treino para ser redirecionado ao campo de cadastro listagem, exclus\u00E3o e edi\u00E7\u00E3o dos treinos");
		txtpnCliqueEmTreino.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtpnCliqueEmTreino.setBounds(10, 125, 142, 127);
		panel_1.add(txtpnCliqueEmTreino);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(135,148,192));
		panel_1_1.setBounds(354, 94, 162, 276);
		add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/exercicio.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		lblNewLabel_1_1.setBounds(61, 22, 40, 46);
		panel_1_1.add(lblNewLabel_1_1);
		
		txtExerccios = new JTextField();
		txtExerccios.setEditable(false);
		txtExerccios.setText("Exerc\u00EDcios");
		txtExerccios.setHorizontalAlignment(SwingConstants.CENTER);
		txtExerccios.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		txtExerccios.setColumns(10);
		txtExerccios.setBounds(29, 69, 104, 27);
		panel_1_1.add(txtExerccios);
		
		JTextPane txtpcaixa2 = new JTextPane();
		txtpcaixa2.setEditable(false);
		txtpcaixa2.setText("Clique em Exerc\u00EDcios para ser redirecionado ao campo de cadastro listagem, exclus\u00E3o e edi\u00E7\u00E3o dos exerc\u00EDcios");
		txtpcaixa2.setFont(new Font("Fira Code", Font.PLAIN, 12));
		txtpcaixa2.setBounds(10, 125, 142, 127);
		panel_1_1.add(txtpcaixa2);
		
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
