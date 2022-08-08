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
import Modelo.TipoDeGrupamento;

@SuppressWarnings({"rawtypes","unchecked"})
public class PanelListarExercicios extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
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
	private JPanel panelmain;

	public PanelListarExercicios() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		panelmain = new JPanel();
		panelmain.setBounds(0, 11, 527, 374);
		add(panelmain);
		panelmain.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 527, 28);
		panelmain.add(panel);
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);
		panel.setLayout(null);

		lblTextinho = new JLabel("Listagem de Exercicios");
		lblTextinho.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTextinho.setBounds(165, 4, 214, 25);
		panel.add(lblTextinho);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 346, 527, 28);
		panelmain.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);

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
		listExercicios.setBounds(10, 76, 509, 263);
		panelmain.add(listExercicios);
		listExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		listExercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listExercicios.setBorder(new LineBorder(new Color(0, 0, 0)));

		iconeBusca = new JLabel("");
		iconeBusca.setBounds(10, 21, 68, 58);
		panelmain.add(iconeBusca);
		iconeBusca.setHorizontalAlignment(SwingConstants.CENTER);
		iconeBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		iconeBusca.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/lupa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(435, 39, 89, 23);
		panelmain.add(btnBuscar);
		btnBuscar.setFont(new Font("Fira Code Light", Font.BOLD, 12));

		comboGrupamento = new JComboBox();
		comboGrupamento.setBounds(78, 39, 354, 22);
		panelmain.add(comboGrupamento);
		comboGrupamento.setModel(new DefaultComboBoxModel(TipoDeGrupamento.values()));
		btnBuscar.addActionListener(this);

		controladorTela = new ControladorListarExercicios(this);
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

	public JPanel getPanelmain() {
		return panelmain;
	}

	public void setPanelmain(JPanel panelmain) {
		this.panelmain = panelmain;
	}

}
