package visao;

import controladores.ControladorMainLabel;

/**
 * @author Kau� Vin�cius
 * @version 1.0
 * 
 *          Classe respons�vel por inicializar o programa chamando o PanelMenu.
 * 
 * @see PanelMenu
 * @see ControladorMainLabel
 *
 */
public class Main {

	/**
	 * M�todo Main que inst�ncia a classe Panel menu e a torna vis�vel;
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PanelMenu frame = new PanelMenu("Dale");
		frame.setVisible(true);

	}

}
