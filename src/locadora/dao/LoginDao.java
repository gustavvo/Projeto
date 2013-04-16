package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import locadora.bd.CriaConexao;
import locadora.logica.Usuario;

public class LoginDao {
	
	private Connection conexao;

	public LoginDao() throws ClassNotFoundException, SQLException {
		this.conexao = CriaConexao.getConexao();
	}
	
	public ArrayList<Usuario> getUsuarios()  {
		String sql = "select * from usuariobd";
		
		try {
			PreparedStatement stmt;
			stmt = this.conexao.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		while(rs.next()) {
			Usuario u1 = new Usuario();
			u1.setNome(rs.getString("nome"));
			u1.setSenha(rs.getString("senha"));
			listaUsuarios.add(u1);
		}
		
		rs.close();
		stmt.close();
		return listaUsuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

}
