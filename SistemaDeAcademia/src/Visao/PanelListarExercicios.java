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

/**
 * @author Kauã Vinícius
 * 
 *         Classe em que Ã© implementado a tela para listagem de
 *         Exercicios.Herda a classe JPanel pra confeccionar a tela e implementa
 *         a interface ActionListener para a iteraÃ§Ã£o dos botÃµes
 * 
 * @see JPanel
 * @see ActionListener
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
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
	private JPanel panelDesign;
	private ControladorListarExercicios controladorTela;
	private JPanel panelmain;

	/**
	 * Construitor em que Ã© gerado a tela de listagem de exercicios juntamente com
	 * seus componentes. MÃ©todos atrelados aos botÃµes estÃ£o no backend
	 * 
	 * @see ControladorListarExercicios
	 */
	public PanelListarExercicios() {
		// Defino as caracteristicas básicas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel base da tela
		panelmain = new JPanel();
		panelmain.setBounds(0, 11, 527, 374);
		panelmain.setLayout(null);
		add(panelmain);

		// Defino o panel base das informações
		panel = new JPanel();
		panel.setBounds(0, 0, 527, 28);
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(1.0f);
		panel.setLayout(null);
		panelmain.add(panel);

		// Defino a label de ajuda ao usuário
		lblTextinho = new JLabel("Listagem de Exercicios");
		lblTextinho.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTextinho.setBounds(165, 4, 214, 25);
		panel.add(lblTextinho);

		// Defino o panel para conter os botões
		panelDesign = new JPanel();
		panelDesign.setBounds(0, 346, 527, 28);
		panelDesign.setLayout(null);
		panelDesign.setBackground(new Color(216, 205, 176));
		panelDesign.setAlignmentY(1.0f);
		panelmain.add(panelDesign);

		// Defino o botão para voltar para a tela de início
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.addActionListener(this);
		btnVoltar.setBounds(62, 0, 89, 28);
		panelDesign.add(btnVoltar);

		// Defino botão para editar o treino
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnEditar.setBackground(Color.GREEN);
		btnEditar.addActionListener(this);
		btnEditar.setBounds(213, 0, 89, 28);
		panelDesign.add(btnEditar);

		// Defino o botão para deletar o exercício selecionado
		btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnDeletar.addActionListener(this);
		btnDeletar.setBackground(new Color(162, 51, 52));
		btnDeletar.setBounds(364, 0, 99, 28);
		panelDesign.add(btnDeletar);

		// Defino a lista com todos os exercícios em backend
		listExercicios = new JList();
		listExercicios.setBounds(10, 76, 509, 263);
		listExercicios.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		listExercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listExercicios.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelmain.add(listExercicios);

		// Defino ícone para busca
		iconeBusca = new JLabel("");
		iconeBusca.setBounds(10, 21, 68, 58);
		iconeBusca.setHorizontalAlignment(SwingConstants.CENTER);
		iconeBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		iconeBusca.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/lupa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelmain.add(iconeBusca);

		// Defino o botão de busca
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(435, 39, 89, 23);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		panelmain.add(btnBuscar);

		// Defino a combobox contendo os agrupamentos
		comboGrupamento = new JComboBox();
		comboGrupamento.setBounds(78, 39, 354, 22);
		comboGrupamento.setModel(new DefaultComboBoxModel(TipoDeGrupamento.values()));
		panelmain.add(comboGrupamento);

		// Defino o controlador que realiza a conecção entre o backend e o frontend
		controladorTela = new ControladorListarExercicios(this);
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
