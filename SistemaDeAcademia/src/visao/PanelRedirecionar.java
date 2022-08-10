package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControladorRedirecionar;

/**
 * @author Kau� Vin�cius
 * 
 *         Classe em que é implementado a tela para redirecionamento. Herda
 *         classe JPanel pra confeccionar a tela.
 * 
 * @see JPanel
 */

@SuppressWarnings({ "unused" })
public class PanelRedirecionar extends JPanel {

	private static final long serialVersionUID = -5262748883391237838L;
	private String operacao;
	private String listagem;
	private JPanel panel;
	private ControladorRedirecionar controlador;
	private JLabel lblMsg;
	private JPanel panelCadastro;
	private JLabel lblCadastro;
	private JLabel lblBaseCadastro;
	private JPanel listagem2;
	private JLabel lblList;
	private JLabel lblMsg2;

	/**
	 * Construitor em que é gerado a tela de redirecionamento juntamente com seus
	 * componentes. Métodos atrelados aos botões estão no backend
	 * 
	 * @see ControladorRedirecionar
	 */
	public PanelRedirecionar(String operacao, String listagem) {
		// inst�cio eventos da tela
		this.operacao = operacao;
		this.listagem = listagem;

		// Defino caracter�sticas da tela
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(529, 403);
		setLayout(null);

		// Defino o panel base da tela
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 529, 403);
		add(panel);
		panel.setLayout(null);

		// Defino o controlador redirecionar para ser utilizado em todo o programa
		controlador = new ControladorRedirecionar();
		ControladorRedirecionar.setTela(this);
		ControladorRedirecionar.setPadrao(panel);

		// Defino a mensagem base da tela
		lblMsg = new JLabel("Escolha uma op\u00E7\u00E3o");
		lblMsg.setFont(new Font("Fira Code", Font.BOLD, 20));
		lblMsg.setBounds(153, 56, 213, 61);
		panel.add(lblMsg);

		// Defino o panel de cadastro que � utilizado como bot�o
		panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBackground(new Color(135, 148, 192));
		panelCadastro.setBounds(24, 132, 218, 206);
		panelCadastro.addMouseListener(new AcaoPerformada(panelCadastro, 2, operacao));
		panel.add(panelCadastro);

		// Defino a label de cadastro
		lblCadastro = new JLabel("");
		lblCadastro.setBounds(89, 60, 45, 58);
		lblCadastro.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/cadastro.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		panelCadastro.add(lblCadastro);

		// Defino a label de cadastro
		lblBaseCadastro = new JLabel("Cadastrar " + this.operacao);
		lblBaseCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaseCadastro.setFont(new Font("Fira Code", Font.BOLD, 16));
		lblBaseCadastro.setBounds(0, 108, 218, 76);
		panelCadastro.add(lblBaseCadastro);

		// Defino o panel de listagem
		listagem2 = new JPanel();
		listagem2.setLayout(null);
		listagem2.setBackground(new Color(135, 148, 192));
		listagem2.setBounds(278, 132, 213, 206);
		listagem2.addMouseListener(new AcaoPerformada(listagem2, 5, operacao));
		panel.add(listagem2);

		// Defino a label de lista
		lblList = new JLabel("");
		lblList.setBounds(80, 58, 40, 58);
		lblList.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(PanelMenu.class.getResource("/Imagens/pesquisa-de-dados.png"))
						.getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		listagem2.add(lblList);

		// Defino o texto de listagem
		lblMsg2 = new JLabel(this.listagem + this.operacao);
		lblMsg2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMsg2.setFont(new Font("Fira Code", Font.BOLD, 16));
		lblMsg2.setBounds(0, 119, 213, 58);
		listagem2.add(lblMsg2);

	}

	/**
	 * 
	 * @author Kau� Vin�cius
	 *
	 *         Defino a classe que � utilizada para padronizar os pseudoBot�es da
	 *         tela. Herdo elementos da classe MouseAdapter
	 *
	 * @see MouseAdapter
	 */
	private class AcaoPerformada extends MouseAdapter {

		JPanel panel;
		int id;
		String operacao;

		/**
		 * Constutor da classe para inst�nciar a tela, id e o opera��o
		 * 
		 * @param panel    Jpanel onde est� sendo realizado as opera��es
		 * @param id       Int que cont�m o id do bot�o
		 * @param operacao String contendo a opera��o desejada
		 */
		public AcaoPerformada(JPanel panel, int id, String operacao) {
			this.panel = panel;
			this.id = id;
			this.operacao = operacao;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
			ControladorRedirecionar.receptacao(operacao, id);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(90, 103, 148));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(135, 148, 192));
		}
	}
}
