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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Modelo.Aluno;

public class PanelAlunoEncontrado extends JPanel {

	public PanelAlunoEncontrado(Aluno aluno) {
		System.out.println("criado");
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 250);
		setLayout(null);

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setAlignmentY(1.0f);
		panelInfo.setVisible(false);
		panelInfo.setBounds(0, 103, 529, 250);
		add(panelInfo);
		panelInfo.setLayout(null);

		JLabel lblPeso = new JLabel("Peso:\r " + aluno.getPeso());
		lblPeso.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblPeso.setBounds(26, 152, 95, 14);
		panelInfo.add(lblPeso);

		JLabel lblAltura = new JLabel("Altura:\r" + aluno.getAltura());
		lblAltura.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblAltura.setBounds(26, 214, 95, 14);
		panelInfo.add(lblAltura);

		JLabel lblIdade = new JLabel("Idade:\r" + aluno.getIdade());
		lblIdade.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIdade.setBounds(26, 85, 95, 14);
		panelInfo.add(lblIdade);

		JLabel lblIMC = new JLabel("IMC: " + aluno.calcularImc());
		lblIMC.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIMC.setBounds(422, 21, 97, 14);
		panelInfo.add(lblIMC);

		JLabel lblNome = new JLabel("Nome: " + aluno.getPrimeiroNome());
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNome.setBounds(26, 21, 142, 14);
		panelInfo.add(lblNome);

		JLabel lblIMCPessoa = new JLabel("");
		lblIMCPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMCPessoa.setBounds(419, 46, 87, 157);
		lblIMCPessoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PainelMenu.class.getResource("/Imagens/silhueta-de-corpo-humano-em-pe.png"))
				.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		panelInfo.add(lblIMCPessoa);

		JLabel lblTreinos = new JLabel("Treinos");
		lblTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTreinos.setBounds(260, 21, 71, 14);
		panelInfo.add(lblTreinos);

		JLabel Situacao = new JLabel("");
		Situacao.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		Situacao.setBounds(422, 214, 81, 14);
		panelInfo.add(Situacao);

		JList listTreinos = new JList();
		listTreinos.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listTreinos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		listTreinos.setBounds(212, 46, 166, 193);
		panelInfo.add(listTreinos);
	}

}
