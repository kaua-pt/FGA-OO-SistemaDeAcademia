package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controladores.ControladorConsultaTreino;

/**
 * @author Kau„ VinÌcius
 * 
 *         Classe em que √© implementado a tela para consulta de Treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a itera√ß√£o dos bot√µes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes" })
public class PanelConsultaTreino extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblTexto;
	private JPanel panel_1;
	private JButton btnVoltar;
	private JButton btnVer;
	private JButton btnDeletar;
	private JList listTreinos;
	private ControladorConsultaTreino controladorTela;
	private JPanel panelGeral;

	/**
	 * Construitor em que √© gerado a tela de consulta de treino juntamente com seus
	 * componentes. M√©todos atrelados aos bot√µes est√£o no backend
	 * 
	 * @see ControladorConsultaTreino
	 */
	public PanelConsultaTreino() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panelGeral = new JPanel();
		panelGeral.setBounds(0, 11, 529, 374);
		add(panelGeral);
		panelGeral.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 529, 28);
		panelGeral.add(panel);
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);
		panel.setLayout(null);

		lblTexto = new JLabel("Consultar Treinos");
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblTexto.setBounds(167, 8, 184, 14);
		panel.add(lblTexto);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 346, 527, 28);
		panelGeral.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);

		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.setBounds(62, 0, 89, 28);
		btnVoltar.addActionListener(this);
		panel_1.add(btnVoltar);

		btnVer = new JButton("Ver");
		btnVer.setForeground(Color.BLACK);
		btnVer.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVer.setBackground(Color.GREEN);
		btnVer.setBounds(213, 0, 89, 28);
		btnVer.addActionListener(this);
		panel_1.add(btnVer);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnDeletar.setBackground(new Color(162, 51, 52));
		btnDeletar.setBounds(364, 0, 99, 28);
		btnDeletar.addActionListener(this);
		panel_1.add(btnDeletar);

		listTreinos = new JList();
		listTreinos.setBounds(10, 39, 509, 297);
		panelGeral.add(listTreinos);
		listTreinos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		controladorTela = new ControladorConsultaTreino(this);
		controladorTela.inicializar();

	}

	/**
	 * MÈtodo respons·vel por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um bot„o
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

	public JButton getBtnVer() {
		return btnVer;
	}

	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	public JButton getBtnDeletar() {
		return btnDeletar;
	}

	public void setBtnDeletar(JButton btnDeletar) {
		this.btnDeletar = btnDeletar;
	}

	public JList getListTreinos() {
		return listTreinos;
	}

	public void setListTreinos(JList listTreinos) {
		this.listTreinos = listTreinos;
	}

	public JPanel getPanelGeral() {
		return panelGeral;
	}

	public void setPanelGeral(JPanel panelGeral) {
		this.panelGeral = panelGeral;
	}

}
