package Visao;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelCadastroAluno extends JPanel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PanelCadastroAluno window = new PanelCadastroAluno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelCadastroAluno() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(111, 59, 342, 41);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(111, 126, 49, 41);
		panel.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(211, 126, 91, 41);
		panel.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(344, 126, 62, 41);
		panel.add(panel_4);

	}
}
