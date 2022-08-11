package visao;

import controladores.ControladorMainLabel;

/**
 * @author Kaua Vinicius
 * @version 1.0
 * 
 *          Classe responsavel por inicializar o programa chamando o PanelMenu.
 * 
 * @see PanelMenu
 * @see ControladorMainLabel
 *
 */
public class Main {

	/**
	 * Metodo Main que instancia a classe Panel menu e a torna visivel;
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PanelMenu frame = new PanelMenu("Dale");
		frame.setVisible(true);

	}

}
