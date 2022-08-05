/**
 * 
 */
package Visao;

import Controladores.ControladorMainLabel;

/**
 * @author Kauã Vinícius
 * @version 1.0
 * 
 *          Classe responsável por inicializar o programa chamando o PanelMenu.
 * 
 * @see PanelMenu
 * @see ControladorMainLabel
 *
 */
public class Main {

	/**
	 * Método Main que instância a classe Panel menu e a torna visível;
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PanelMenu frame = new PanelMenu("Dale");
		frame.setVisible(true);

	}

}
