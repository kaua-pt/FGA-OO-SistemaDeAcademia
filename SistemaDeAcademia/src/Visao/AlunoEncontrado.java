package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import Modelo.Aluno;

public class AlunoEncontrado extends JPanel {

	private static final long serialVersionUID = 1L;

	public AlunoEncontrado(Aluno aluno) {

		setBackground(Color.WHITE);
		setSize(527, 250);
		setLayout(null);

		JLabel lblPeso = new JLabel("Peso:\r" + aluno.getPeso());
		lblPeso.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblPeso.setBounds(26, 152, 115, 14);
		add(lblPeso);

		JLabel lblAltura = new JLabel("Altura:\r" + aluno.getAltura());
		lblAltura.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblAltura.setBounds(26, 214, 113, 14);
		add(lblAltura);

		JLabel lblIdade = new JLabel("Idade:\r" + aluno.getIdade());
		lblIdade.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIdade.setBounds(26, 85, 95, 14);
		add(lblIdade);

		JLabel lblIMC = new JLabel(String.format("IMC:%.2f", aluno.calcularImc()));
		lblIMC.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMC.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIMC.setBounds(405, 21, 115, 14);
		add(lblIMC);

		JLabel lblNome = new JLabel("Nome:" + aluno.getPrimeiroNome());
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNome.setBounds(26, 21, 142, 14);
		add(lblNome);

		JLabel lblIMCPessoa = new JLabel("");
		lblIMCPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMCPessoa.setBounds(419, 46, 87, 157);
		lblIMCPessoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PainelMenu.class.getResource("/Imagens/silhueta-de-corpo-humano-em-pe.png"))
				.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		add(lblIMCPessoa);

		JLabel lblTreinos = new JLabel("Treinos");
		lblTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTreinos.setBounds(234, 21, 71, 14);
		add(lblTreinos);

		JLabel Situacao = new JLabel(aluno.calcularParametro());
		Situacao.setHorizontalAlignment(SwingConstants.CENTER);
		Situacao.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		Situacao.setBounds(408, 214, 109, 36);
		add(Situacao);

		JList<Object> listTreinos = new JList<Object>();
		listTreinos.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listTreinos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		listTreinos.setBounds(186, 46, 166, 193);
		add(listTreinos);

	}

}
