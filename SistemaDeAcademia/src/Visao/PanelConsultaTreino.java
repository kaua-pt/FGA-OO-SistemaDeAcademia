package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelConsultaTreino extends JPanel implements ActionListener {

	public PanelConsultaTreino() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);
		panel.setBounds(0, 11, 527, 28);
		add(panel);
		panel.setLayout(null);

		JLabel lblTexto = new JLabel("Consultar Treinos");
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblTexto.setBounds(167, 8, 184, 14);
		panel.add(lblTexto);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);
		panel_1.setBounds(0, 357, 527, 28);
		add(panel_1);

		JButton btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.setBounds(62, 0, 89, 28);
		panel_1.add(btnVoltar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnEditar.setBackground(Color.GREEN);
		btnEditar.setBounds(213, 0, 89, 28);
		panel_1.add(btnEditar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnDeletar.setBackground(new Color(162, 51, 52));
		btnDeletar.setBounds(364, 0, 99, 28);
		panel_1.add(btnDeletar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
