package Visao;

import java.awt.EventQueue;

public class PainelInicio extends PainelMenu {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PainelInicio window = new PainelInicio();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PainelInicio() {
		super("Inicio");
	}

}
