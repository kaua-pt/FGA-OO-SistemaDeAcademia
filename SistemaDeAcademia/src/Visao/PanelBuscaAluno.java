package Visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Controladores.ControladorRedirecionar;
import Controladores.ControladorTelaBuscaAluno;
import Modelo.Aluno;

public class PanelBuscaAluno extends JPanel implements ActionListener {

	Aluno aluno;
	private static final long serialVersionUID = 7399066554867365317L;
	private JTextField textField;
	private JList<Object> listTreinos;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblIdade;
	private JLabel lblIMC;
	private JLabel lblNome;
	private JLabel lblIMCPessoa;
	private JLabel lblTreinos;
	private JLabel Situacao;
	private JPanel panel_1;
	private JLabel lblnaoEncont;
	private JPanel panelInfo;
	private JPanel panel;
	private JLabel iconeBusca;
	private JLabel lblNewLabel;
	private JPanel panelNaoEncontrado;
	private JButton btnBuscar;
	private JButton btnVoltar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private ControladorTelaBuscaAluno controladorTela;

	public PanelBuscaAluno(ControladorRedirecionar controlador) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		lblNewLabel = new JLabel("Buscar Aluno");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Fira Code Light", Font.BOLD, 20));
		lblNewLabel.setBounds(184, 11, 151, 45);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setToolTipText("Digite o nome do aluno");
		textField.setBounds(65, 72, 366, 20);
		add(textField);
		textField.setColumns(10);

		iconeBusca = new JLabel("");
		iconeBusca.setHorizontalAlignment(SwingConstants.CENTER);
		iconeBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		iconeBusca.setBounds(0, 52, 68, 58);
		iconeBusca.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PainelMenu.class.getResource("/Imagens/lupa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		add(iconeBusca);

		panel = new JPanel();
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setBounds(1, 18, 527, 28);
		add(panel);

		panelInfo = new JPanel();
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setAlignmentY(1.0f);
		panelInfo.setVisible(false);
		panelInfo.setBounds(1, 103, 527, 250);
		panelInfo.setVisible(false);
		add(panelInfo);
		panelInfo.setLayout(null);

		lblPeso = new JLabel();
		lblPeso.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblPeso.setBounds(26, 152, 115, 14);
		panelInfo.add(lblPeso);

		lblAltura = new JLabel();
		lblAltura.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblAltura.setBounds(26, 214, 113, 14);
		panelInfo.add(lblAltura);

		lblIdade = new JLabel();
		lblIdade.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIdade.setBounds(26, 85, 95, 14);
		panelInfo.add(lblIdade);

		lblIMC = new JLabel();
		lblIMC.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMC.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIMC.setBounds(405, 21, 115, 14);
		panelInfo.add(lblIMC);

		lblNome = new JLabel();
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNome.setBounds(26, 21, 142, 14);
		panelInfo.add(lblNome);

		lblIMCPessoa = new JLabel("");
		lblIMCPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMCPessoa.setBounds(419, 46, 87, 157);
		lblIMCPessoa.setVisible(false);
		panelInfo.add(lblIMCPessoa);

		lblTreinos = new JLabel();
		lblTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTreinos.setBounds(234, 21, 71, 14);
		panelInfo.add(lblTreinos);

		Situacao = new JLabel();
		Situacao.setHorizontalAlignment(SwingConstants.CENTER);
		Situacao.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		Situacao.setBounds(408, 214, 109, 36);
		panelInfo.add(Situacao);

		listTreinos = new JList<Object>();
		listTreinos.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listTreinos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		listTreinos.setBounds(186, 46, 166, 193);
		listTreinos.setVisible(false);
		panelInfo.add(listTreinos);

		panelNaoEncontrado = new JPanel();
		panelNaoEncontrado.setBounds(1, 103, 527, 250);
		panelNaoEncontrado.setVisible(false);
		add(panelNaoEncontrado);
		panelNaoEncontrado.setLayout(null);

		lblnaoEncont = new JLabel("Aluno N\u00E3o Encontrado!");
		lblnaoEncont.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblnaoEncont.setBounds(153, 111, 220, 14);
		panelNaoEncontrado.add(lblnaoEncont);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 205, 176));
		panel_1.setAlignmentY(1.0f);
		panel_1.setBounds(1, 364, 527, 28);
		add(panel_1);
		panel_1.setLayout(null);

		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.addActionListener(this);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(62, 0, 89, 28);
		panel_1.add(btnVoltar);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.addActionListener(this);
		btnEditar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnEditar.setBounds(213, 0, 89, 28);
		btnEditar.setBackground(Color.GREEN);
		panel_1.add(btnEditar);

		btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.addActionListener(this);
		btnDeletar.setBackground(new Color(162, 51, 52));
		btnDeletar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnDeletar.setBounds(364, 0, 99, 28);
		panel_1.add(btnDeletar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnBuscar.setBounds(435, 71, 89, 23);
		add(btnBuscar);

		controladorTela = new ControladorTelaBuscaAluno(this, controlador);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JList<Object> getListTreinos() {
		return listTreinos;
	}

	public void setListTreinos(JList<Object> listTreinos) {
		this.listTreinos = listTreinos;
	}

	public JLabel getLblPeso() {
		return lblPeso;
	}

	public void setLblPeso(JLabel lblPeso) {
		this.lblPeso = lblPeso;
	}

	public JLabel getLblAltura() {
		return lblAltura;
	}

	public void setLblAltura(JLabel lblAltura) {
		this.lblAltura = lblAltura;
	}

	public JLabel getLblIdade() {
		return lblIdade;
	}

	public void setLblIdade(JLabel lblIdade) {
		this.lblIdade = lblIdade;
	}

	public JLabel getLblIMC() {
		return lblIMC;
	}

	public void setLblIMC(JLabel lblIMC) {
		this.lblIMC = lblIMC;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JLabel getLblIMCPessoa() {
		return lblIMCPessoa;
	}

	public void setLblIMCPessoa(JLabel lblIMCPessoa) {
		this.lblIMCPessoa = lblIMCPessoa;
	}

	public JLabel getLblTreinos() {
		return lblTreinos;
	}

	public void setLblTreinos(JLabel lblTreinos) {
		this.lblTreinos = lblTreinos;
	}

	public JLabel getSituacao() {
		return Situacao;
	}

	public void setSituacao(JLabel situacao) {
		Situacao = situacao;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
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

	public JPanel getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(JPanel panelInfo) {
		this.panelInfo = panelInfo;
	}

	public JPanel getPanelNaoEncontrado() {
		return panelNaoEncontrado;
	}

	public void setPanelNaoEncontrado(JPanel panelNaoEncontrado) {
		this.panelNaoEncontrado = panelNaoEncontrado;
	}

}
