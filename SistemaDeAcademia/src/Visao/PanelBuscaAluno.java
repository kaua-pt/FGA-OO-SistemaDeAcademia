package Visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import Controladores.ControladorAluno;
import Controladores.ControladorRedirecionar;
import Modelo.Aluno;

public class PanelBuscaAluno extends JPanel {

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
	private JLabel lblNewLabel_1_1_1;
	private JPanel panelDeletar;
	private JLabel lblNewLabel_1_1;
	private JPanel panelEditar;
	private JLabel lblNewLabel_1;
	private JPanel panelVoltar;
	private JPanel panel_1;
	private JLabel labelBusca;
	private JLabel lblnaoEncont;
	private JPanel panelInfo;
	private JPanel panel;
	private JLabel iconeBusca;
	private JLabel lblNewLabel;
	private ControladorAluno controladorA;
	private JPanel panelNaoEncontrado;

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
		textField.setBounds(65, 72, 376, 20);
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
		lblIMCPessoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(PainelMenu.class.getResource("/Imagens/silhueta-de-corpo-humano-em-pe.png"))
				.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
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

		panelVoltar = new JPanel();
		panelVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelVoltar.setBackground(new Color(169, 46, 23));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelVoltar.setBackground(new Color(226, 71, 43));
			}
		});
		panelVoltar.setBackground(new Color(226, 71, 43));
		panelVoltar.setToolTipText("Voltar");
		panelVoltar.setBounds(61, 0, 94, 28);
		panel_1.add(panelVoltar);
		panelVoltar.setLayout(null);

		lblNewLabel_1 = new JLabel("Voltar");
		lblNewLabel_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(18, 9, 60, 14);
		panelVoltar.add(lblNewLabel_1);

		panelEditar = new JPanel();
		panelEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.caminho(1);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelEditar.setBackground(new Color(21, 113, 35));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelEditar.setBackground(new Color(43, 226, 71));
			}
		});
		panelEditar.setToolTipText("Voltar");
		panelEditar.setBackground(Color.GREEN);
		panelEditar.setBounds(216, 0, 94, 28);
		panel_1.add(panelEditar);
		panelEditar.setLayout(null);

		lblNewLabel_1_1 = new JLabel("Editar");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(18, 9, 60, 14);
		panelEditar.add(lblNewLabel_1_1);

		panelDeletar = new JPanel();
		panelDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (aluno != null) {
					controladorA.removerAluno(aluno.getNome());
					controlador.caminho(1);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				panelDeletar.setBackground(new Color(113, 35, 36));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelDeletar.setBackground(new Color(162, 51, 52));
			}
		});
		panelDeletar.setToolTipText("Voltar");
		panelDeletar.setBackground(new Color(162, 51, 52));
		panelDeletar.setBounds(371, 0, 94, 28);
		panel_1.add(panelDeletar);
		panelDeletar.setLayout(null);

		lblNewLabel_1_1_1 = new JLabel("Deletar");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 9, 74, 14);
		panelDeletar.add(lblNewLabel_1_1_1);

		labelBusca = new JLabel("Buscar");
		labelBusca.setFont(new Font("Fira Code Light", Font.BOLD, 14));
		labelBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				aluno = Controladores.ControladorAluno.getUmAluno(textField.getText());
				if (aluno == null) {
					panelNaoEncontrado.setVisible(true);
					panelInfo.setVisible(false);
				} else {
					panelNaoEncontrado.setVisible(false);
					alterarInformacoes();
					panelInfo.setVisible(true);
				}
			}
		});

		labelBusca.setHorizontalAlignment(SwingConstants.CENTER);
		labelBusca.setBounds(451, 60, 68, 45);
		add(labelBusca);
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

	public void alterarInformacoes() {
		this.getLblTreinos().setText("Treinos");
		this.getLblNome().setText("Nome:" + aluno.getPrimeiroNome());
		this.getLblAltura().setText("Altura:\r" + aluno.getAltura());
		this.getLblIMC().setText(String.format("IMC:%.2f", aluno.calcularImc()));
		this.getLblPeso().setText("Peso:\r" + aluno.getPeso());
		this.getLblTreinos();
		this.getLblIdade().setText("Idade:\r" + aluno.getIdade());
		this.getSituacao().setText(aluno.calcularParametro());
		lblIMCPessoa.setVisible(true);
		listTreinos.setVisible(true);
	}

}
