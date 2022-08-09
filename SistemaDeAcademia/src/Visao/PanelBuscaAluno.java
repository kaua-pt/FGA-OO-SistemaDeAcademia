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

import Controladores.ControladorTelaBuscaAluno;
import Modelo.Aluno;

/**
 * @author Kauã Vinícius
 *
 *         Classe em que é implementada a tela de busca de aluno
 * 
 *         Herda a classe JPanel pra confeccionar a tela e implementa a
 *         interface ActionListener para a iteração dos botões
 *
 * @see JPanel
 * @see ActionListener
 */

public class PanelBuscaAluno extends JPanel implements ActionListener {

	Aluno aluno;
	private static final long serialVersionUID = 7399066554867365317L;
	private JTextField textFieldNome;
	private JList<Object> listTreinos;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblIdade;
	private JLabel lblIMC;
	private JLabel lblNome;
	private JLabel lblIMCPessoa;
	private JLabel lblTreinos;
	private JLabel Situacao;
	private JPanel panelEstilo;
	private JLabel lblnaoEncont;
	private JPanel panelInfo;
	private JPanel panel;
	private JLabel iconeBusca;
	private JLabel lblTexto;
	private JPanel panelNaoEncontrado;
	private JButton btnBuscar;
	private JButton btnVoltar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private ControladorTelaBuscaAluno controladorTela;
	private JPanel panelbase;

	/**
	 * Construitor em que é gerado a tela de busca de aluno juntamente com seus
	 * componentes. Métodos atrelados aos botões estão no backend
	 * 
	 * @see ControladorTelaBuscaAluno
	 */
	public PanelBuscaAluno() {
		// Defino a borda, a cor de fundo, tamanho da tela e seu layout;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel utilizado como base da tela
		panelbase = new JPanel();
		panelbase.setBounds(0, 11, 528, 381);
		add(panelbase);
		panelbase.setLayout(null);

		// Defino o texto base no topo da tela
		lblTexto = new JLabel("Buscar Aluno");
		lblTexto.setBounds(184, 0, 151, 45);
		panelbase.add(lblTexto);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setFont(new Font("Fira Code Light", Font.BOLD, 20));

		// Defino o campo para digitar o nome do Aluno
		textFieldNome = new JTextField();
		textFieldNome.setBounds(65, 61, 366, 20);
		panelbase.add(textFieldNome);
		textFieldNome.setToolTipText("Digite o nome do aluno");
		textFieldNome.setColumns(10);

		// Defino aqui o icone de busca
		iconeBusca = new JLabel("");
		iconeBusca.setBounds(0, 41, 68, 58);
		panelbase.add(iconeBusca);
		iconeBusca.setHorizontalAlignment(SwingConstants.CENTER);
		iconeBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		iconeBusca.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/lupa.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

		// Defino um panel para estilizar a tela
		panel = new JPanel();
		panel.setBounds(1, 7, 527, 28);
		panelbase.add(panel);
		panel.setBackground(new Color(216, 205, 176));
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);

		// Defino o panel em que é anexado as informações
		panelInfo = new JPanel();
		panelInfo.setBounds(1, 92, 527, 250);
		panelbase.add(panelInfo);
		panelInfo.setBackground(Color.WHITE);
		panelInfo.setAlignmentY(1.0f);
		panelInfo.setVisible(false);
		panelInfo.setVisible(false);
		panelInfo.setLayout(null);

		// Defino o campo de peso
		lblPeso = new JLabel();
		lblPeso.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblPeso.setBounds(26, 152, 115, 14);
		panelInfo.add(lblPeso);

		// Defino o campo de altura
		lblAltura = new JLabel();
		lblAltura.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblAltura.setBounds(26, 214, 113, 14);
		panelInfo.add(lblAltura);

		// Defino o campo de idade
		lblIdade = new JLabel();
		lblIdade.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIdade.setBounds(26, 85, 95, 14);
		panelInfo.add(lblIdade);

		// Defino o campo de IMC
		lblIMC = new JLabel();
		lblIMC.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMC.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblIMC.setBounds(405, 21, 115, 14);
		panelInfo.add(lblIMC);

		// Defino o campo de nome
		lblNome = new JLabel();
		lblNome.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNome.setBounds(26, 21, 142, 14);
		panelInfo.add(lblNome);

		// Defino o campo para o icone no IMC
		lblIMCPessoa = new JLabel("");
		lblIMCPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMCPessoa.setBounds(419, 46, 87, 157);
		lblIMCPessoa.setVisible(false);
		panelInfo.add(lblIMCPessoa);

		// Defino o campo de Treinos do aluno
		lblTreinos = new JLabel();
		lblTreinos.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblTreinos.setBounds(234, 21, 71, 14);
		panelInfo.add(lblTreinos);

		// Defino o campo de situação do aluno relativo ao IMC
		Situacao = new JLabel();
		Situacao.setHorizontalAlignment(SwingConstants.CENTER);
		Situacao.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		Situacao.setBounds(408, 214, 109, 36);
		panelInfo.add(Situacao);

		// Defino a lista que será mostrado os treinos
		listTreinos = new JList<Object>();
		listTreinos.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
		listTreinos.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		listTreinos.setBounds(186, 46, 166, 193);
		listTreinos.setVisible(false);
		panelInfo.add(listTreinos);

		// Defino a tela base caso o aluno não seja encontrado
		panelNaoEncontrado = new JPanel();
		panelNaoEncontrado.setBounds(1, 92, 527, 250);
		panelbase.add(panelNaoEncontrado);
		panelNaoEncontrado.setVisible(false);
		panelNaoEncontrado.setLayout(null);

		// Defino a escrita caso o aluno não seja encontrado
		lblnaoEncont = new JLabel("Aluno N\u00E3o Encontrado!");
		lblnaoEncont.setFont(new Font("Fira Code Light", Font.BOLD, 16));
		lblnaoEncont.setBounds(153, 111, 220, 14);
		panelNaoEncontrado.add(lblnaoEncont);

		// Defino um panel para estilização
		panelEstilo = new JPanel();
		panelEstilo.setBounds(1, 353, 527, 28);
		panelbase.add(panelEstilo);
		panelEstilo.setBackground(new Color(216, 205, 176));
		panelEstilo.setAlignmentY(1.0f);
		panelEstilo.setLayout(null);

		// Defino o botão para voltar para o inicio
		btnVoltar = new JButton("Inicio");
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(new Color(226, 71, 43));
		btnVoltar.addActionListener(this);
		btnVoltar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnVoltar.setBounds(62, 0, 89, 28);
		panelEstilo.add(btnVoltar);

		// Defino o botão para editar o aluno
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.addActionListener(this);
		btnEditar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnEditar.setBounds(213, 0, 89, 28);
		btnEditar.setBackground(Color.GREEN);
		panelEstilo.add(btnEditar);

		// Defino o botão de deletar o aluno
		btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.addActionListener(this);
		btnDeletar.setBackground(new Color(162, 51, 52));
		btnDeletar.setFont(new Font("Fira Code Light", Font.BOLD, 12));
		btnDeletar.setBounds(364, 0, 99, 28);
		panelEstilo.add(btnDeletar);

		// Defino o botão para buscar o aluno
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(435, 60, 89, 23);
		panelbase.add(btnBuscar);
		btnBuscar.addActionListener(this);
		btnBuscar.setFont(new Font("Fira Code Light", Font.BOLD, 12));

		// controlador que liga o Frontend Com o Backend
		controladorTela = new ControladorTelaBuscaAluno(this);
	}

	/**
	 * M�todo respons�vel por conectar o backend e o frontend
	 * 
	 * @param event Evento no qual representa o clique de um bot�o
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		this.controladorTela.acaoPerformada(event.getSource());
	}

	// Getters e Setters
	public JTextField getTextField() {
		return textFieldNome;
	}

	public void setTextField(JTextField textField) {
		this.textFieldNome = textField;
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

	public JPanel getPanelbase() {
		return panelbase;
	}

	public void setPanelbase(JPanel panelbase) {
		this.panelbase = panelbase;
	}

}
