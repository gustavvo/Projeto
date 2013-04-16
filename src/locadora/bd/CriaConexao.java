package locadora.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriaConexao {
	
	public static Connection getConexao() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao banco");
			return DriverManager.getConnection("jdbc:mysql://localhost/locadorabd", "root", "123456");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
}
