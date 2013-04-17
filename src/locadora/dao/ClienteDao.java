/*
 * Instituto Federal de Educação, Ciência e Tecnologia da Paraíba
 * Campus Campina Grande
 * Componente Curricular: Desenvolvimento Web
 * 
 * Sistema de Locadora WEB
 * 
 * @author Hallyson Gustavo, Vinicius Fernandes
 *  
 */

package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import locadora.bd.CriaConexao;
import locadora.logica.Cliente;

/*
 * 
 */

public class ClienteDao {

	private Connection conexao;
	
	public ClienteDao() throws SQLException, ClassNotFoundException{
		this.conexao = CriaConexao.getConexao();
	}
	
	/**
	 * Método que adiciona um objeto Cliente no banco de dados
	 * 
	 * @param c1 - cliente a ser adicionado
	 * @throws SQLException
	 */
	public void adiciona(Cliente c1) throws SQLException {
		
		// Prepara a conexão
		String sql = "insert into clientebd (nome, cpf, telefone)" +
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

	
	
	/**
	 * Método que retorna um arraylist com a lista de todos os clientes armazenados no banco de dados
	 * @return 
	 */
	public ArrayList<Cliente> getLista()  {
		String sql = "select * from clientebd";
		
		try {
			PreparedStatement stmt;
			stmt = this.conexao.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		while(rs.next()) {
			Cliente c1 = new Cliente();
			c1.setNome(rs.getString("nome"));
			c1.setCpf(rs.getString("cpf"));
			c1.setTelefone(rs.getString("telefone"));
			c1.setId(rs.getString("idCliente"));
			listaClientes.add(c1);
		}
		
		rs.close();
		stmt.close();
		return listaClientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Método que recebe o número de identificação do cliente e retorna todas as informações do mesmo.
	 * @param idCliente - código de identificação do cliente
	 * @return
	 */
	public Cliente getCliente(String idCliente){
		String sql = "select * from clientebd where idCliente="+idCliente;
		
		try {
			PreparedStatement stmt;
			stmt = this.conexao.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		Cliente c1 = new Cliente();	
		while(rs.next()) {
			
			c1.setNome(rs.getString("nome"));
			c1.setCpf(rs.getString("cpf"));
			c1.setTelefone(rs.getString("telefone"));
			c1.setId(rs.getString("idCLiente"));
		}
		
		rs.close();
		stmt.close();
		return c1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * Método que altera as informações de um cliente armazenada no banco de dados.
	 * @param c1 - um objeto cliente.
	 */
	public void altera(Cliente c1)  {
		String sql = "update clientebd set nome=?, cpf=?, telefone=? where id=?" ;
	
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(sql);
		
		
		// Seta os valores
		stmt.setString(1, c1.getNome());
		stmt.setString(2, c1.getCpf());
		stmt.setString(3, c1.getTelefone());
		stmt.setString(4, c1.getId());
		
		// Executa o código SQL
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
						
	}
	
	
	/**
	 * Método que remove um cliente do banco de dados
	 * @param c1 - cliente a ser removido
	 */
	public void remove(int idCliente)  {
		String sql = "delete from clientebd where idCliente=" + idCliente;
		
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(sql);
		
		stmt.execute();
		stmt.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public ArrayList<Cliente> getListaCLienteDisponiveis()  {
		String sql = "select * from clientebd where idCliente not  in (select idcliente from locacaobd)";
		
		try {
			PreparedStatement stmt;
			stmt = this.conexao.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		while(rs.next()) {
			Cliente c1 = new Cliente();
			c1.setId(rs.getString("idCliente"));
			c1.setNome(rs.getString("nome"));
			c1.setCpf(rs.getString("cpf"));
			c1.setTelefone(rs.getString("telefone"));
			listaClientes.add(c1);
		}
		
		rs.close();
		stmt.close();
		return listaClientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
		
		
		
		
		
		
		
		
		



















