/*
 * Instituto Federal de Educação, Ciência e Tecnologia da Paraíba
 * Campus Campina Grande
 * Componente Curricular: Desenvolvimento Web
 * 
 * Sistema de Locadora WEB
 * 
 * @author Hallyson Gustavo, Vinicius Fernandes
 * 
 * 
 */

// Classe para criar a conexão com o banco de dados MySql

package locadora.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {

	
/*
 * Método estático para criação da conexão
 */
	public static Connection getConexao() throws SQLException, ClassNotFoundException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao banco");
			return DriverManager.getConnection("jdbc:mysql://localhost/locadorabd", "root", "123456");
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
}

