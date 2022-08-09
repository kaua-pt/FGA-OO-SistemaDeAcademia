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
 * @author Kauã Vinícius
 * 
 *         Classe em que Ã© implementado a tela para consulta de Treino.Herda a
 *         classe JPanel pra confeccionar a tela e implementa a interface
 *         ActionListener para a iteraÃ§Ã£o dos botÃµes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes" })
public class PanelConsultaTreino extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblTexto;
	private JPanel panelDesign;
	private JButton btnVoltar;
	private JButton btnVer;
	private JButton btnDeletar;
	private JList listTreinos;
	private ControladorConsultaTreino controladorTela;
	private JPanel panelGeral;

	/**
	 * Construitor em que Ã© gerado a tela de consulta de treino juntamente com seus
	 * componentes. MÃ©todos atrelados aos botÃµes estÃ£o no backend
	 * 
	 * @see ControladorConsultaTreino
	 */
	public PanelConsultaTreino() {
		// Defino as caracteristicas básicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel base da tela
		panelGeral = new JPanel();
		panelGeral.setBounds(0, 11, 529, 374);
		add(panelGeral);
		panelGeral.setLayout(null);

		// Defino o panel base das informações
		panel = new JPanel();
		panel.setBounds(0, 0, 529, 28);
		panelGeral.add(panel);
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);
		panel.setLayout(null);

		// Defino a label de ajuda ao usuário
		lblTexto = new JLabel("Consultar Treinos");
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblTexto.setBounds(167, 8, 184, 14);
		panel.add(lblTexto);

		// Defino o panel de design inferior
		panelDesign = new JPanel();
		panelDesign.setBounds(0, 346, 527, 28);
		panelGeral.add(panelDesign);
		panelDesign.setLayout(null);
		panelDesign.setBackground(new Color(216, 205, 176));
		panelDesign.setAlignmentY(1.0f);

		// Defino o botão para retornar para o início
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.setBounds(62, 0, 89, 28);
		btnVoltar.addActionListener(this);
		panelDesign.add(btnVoltar);

		// Defino o botão para visualizar informações do treino
		btnVer = new JButton("Ver");
		btnVer.setForeground(Color.BLACK);
		btnVer.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVer.setBackground(Color.GREEN);
		btnVer.setBounds(213, 0, 89, 28);
		btnVer.addActionListener(this);
		panelDesign.add(btnVer);

		// Defino o botão para deletar o treino
		btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnDeletar.setBackground(new Color(162, 51, 52));
		btnDeletar.setBounds(364, 0, 99, 28);
		btnDeletar.addActionListener(this);
		panelDesign.add(btnDeletar);

		// Defino a lista com os treinos no banco de dados
		listTreinos = new JList();
		listTreinos.setBounds(10, 39, 509, 297);
		panelGeral.add(listTreinos);
		listTreinos.setBorder(new LineBorder(new Color(0, 0, 0)));
		listTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));

		// Defino o controlador que realiza a conecção entre o backend e o frontend
		controladorTela = new ControladorConsultaTreino(this);
		controladorTela.inicializar();

	}

	/**
	 * Método responsável por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um botão
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
