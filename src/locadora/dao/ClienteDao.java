package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import locadora.bd.CriaConexao;
import locadora.logica.Cliente;

public class ClienteDao {

	private Connection conexao;
	
	public ClienteDao() throws SQLException {
		this.conexao = CriaConexao.getConexao();
	}
	
	public void adiciona(Cliente c1) throws SQLException{
		
		// Prepara a conexão
		String sql = "insert into cliente (nome, cpf, telefone)" +
						"values (?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// Seta os valores
		stmt.setString(1, c1.getNome());
		stmt.setString(2, c1.getCpf());
		stmt.setString(3, c1.getTelefone());
		
		// Executa o código SQL
		stmt.execute();
		stmt.close();
	}
	
	// Retorna lista de contatos
	public ArrayList<Cliente> getLista() throws SQLException {
		String sql = "select * from cliente";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Cliente> minhaLista = new ArrayList<Cliente>();
		
		while(rs.next()) {
			Cliente c1 = new Cliente();
			c1.setNome(rs.getString("nome"));
			c1.setCpf(rs.getString("cpf"));
			c1.setTelefone(rs.getString("telefone"));
			minhaLista.add(c1);
		}
		
		rs.close();
		stmt.close();
		return minhaLista;
	}
	
	public void altera(Cliente c1) throws SQLException {
		String sql = "update cliente set nome=?, cpf=?, telefone=? where id=?" ;
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// Seta os valores
		stmt.setString(1, c1.getNome());
		stmt.setString(2, c1.getCpf());
		stmt.setString(3, c1.getTelefone());
		stmt.setLong(4, c1.getId());
		
		// Executa o código SQL
		stmt.execute();
		stmt.close();
						
	}
	
	public void remove(Cliente c1) throws SQLException {
		String sql = "delete from cliente where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setLong(1, c1.getId());
		stmt.execute();
		stmt.close();		
	}
	
	
	
}
		
		
		
		
		
		
		
		
		



















