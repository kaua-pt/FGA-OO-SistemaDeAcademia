/**
 *
 */
package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author PC
 *
 */
public class BaseDeDados {

	private Connection coneccao = null;
	private Statement estado = null;
	private ResultSet resultado = null;


	public void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.coneccao = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabalhoOO","root","tocarviolao3");
			this.estado = this.coneccao.createStatement();
			System.out.print("deu bom");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean estaConectado() {
		if (coneccao != null) {
			return true;
		}
		return false;
	}

	public void inserirElemento() {
		try {
			String query = "INSERT INTO aluno(nome,id,altura,idade,peso)";
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
