package Visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controladores.ControladorListarExercicios;
import Controladores.ControladorRedirecionar;
import Modelo.TipoDeGrupamento;

public class PanelListarExercicios extends JPanel implements ActionListener {

	private JPanel panel;
	private JLabel lblTextinho;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JList listExercicios;
	private JLabel iconeBusca;
	private JButton btnBuscar;
	private JComboBox comboGrupamento;
	private JButton btnVoltar;
	private JPanel panel_1;
	private ControladorListarExercicios controladorTela;

	public PanelListarExercicios(ControladorRedirecionar controlador) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);
		panel.setBounds(0, 11, 527, 28);
		add(panel);
		panel.setLayout(null);

		lblTextinho = new JLabel("Listagem de Exercicios");
		lblTextinho.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTextinho.setBounds(165, 4, 214, 25);
		panel.add(lblTextinho);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);
		panel_1.setBounds(0, 357, 527, 28);
		add(panel_1);

		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(62, 0, 89, 28);
		panel_1.add(btnVoltar);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnEditar.setBackground(Color.GREEN);
		btnEditar.addActionListener(this);
		btnEditar.setBounds(213, 0, 89, 28);
		panel_1.add(btnEditar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnDeletar.addActionListener(this);
		btnDeletar.setBackground(new Color(162, 51, 52));
		btnDeletar.setBounds(364, 0, 99, 28);
		panel_1.add(btnDeletar);

		listExercicios = new JList();
		listExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		listExercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listExercicios.setBorder(new LineBorder(new Color(0, 0, 0)));
		listExercicios.setBounds(10, 87, 509, 263);
		add(listExercicios);

		iconeBusca = new JLabel("");
		iconeBusca.setHorizontalAlignment(SwingConstants.CENTER);
		iconeBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		iconeBusca.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/lupa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		iconeBusca.setBounds(10, 32, 68, 58);
		add(iconeBusca);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(435, 50, 89, 23);
		add(btnBuscar);

		comboGrupamento = new JComboBox();
		comboGrupamento.setModel(new DefaultComboBoxModel(TipoDeGrupamento.values()));
		comboGrupamento.setBounds(78, 50, 354, 22);
		add(comboGrupamento);

		controladorTela = new ControladorListarExercicios(this, controlador);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("vrau");
		this.controladorTela.acaoPerformada(e.getSource());
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnDeletar() {
		return btnDeletar;
	}

	public void setBtnDeletar(JButton btnDeletar) {
		this.btnDeletar = btnDeletar;
	}

	public JList getListExercicios() {
		return listExercicios;
	}

	public void setListExercicios(JList listExercicios) {
		this.listExercicios = listExercicios;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JComboBox getComboGrupamento() {
		return comboGrupamento;
	}

	public void setComboGrupamento(JComboBox comboGrupamento) {
		this.comboGrupamento = comboGrupamento;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

}
