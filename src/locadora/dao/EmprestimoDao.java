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
import locadora.logica.Emprestimo;


public class EmprestimoDao {
	
	private Connection conexao;
	
	public EmprestimoDao() throws SQLException, ClassNotFoundException{
		this.conexao = CriaConexao.getConexao();
	}
		
	
	/**
	 * Método que adiciona um cliente no banco de dados.
	 * @param e1 - objeto empréstimo a ser adicionado no banco
	 * @throws SQLException
	 */
	public void adiciona(Emprestimo e1) throws SQLException {
		String sql = "insert into locacaobd (idCliente, data, idProduto1, idProduto2, idProduto3, total)" 
						+ "values (?,?,?,?,?,?)";
		
		// Prepara a conexão
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// Seta os valores
		stmt.setInt(1, e1.getIdCliente());
		stmt.setDate(2, e1.getData());
		stmt.setInt(3, e1.getIdProduto1());
		stmt.setInt(4, e1.getIdProduto2());
		stmt.setInt(5, e1.getIdProduto3());
		stmt.setDouble(6, e1.getTotal());
				
		// Executa
		stmt.execute();
		stmt.close();
	}
	
	/**
	 * Método que remove um cliente do banco de dados.
	 * @param e1 - empréstimo a ser removido
	 * @throws SQLException
	 */
	public void remove(int Id) throws SQLException {
		String sql = "delete from locacaobd where idLocacao=" + Id;
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	/**
	 * Método que retorna uma lista com os empréstimos armazenados no banco de dados.
	 * @return 
	 * @throws SQLException
	 */
	public ArrayList<Emprestimo> getLista() throws SQLException {
		String sql = "select * from locacaobd";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();
		
		while(rs.next()) {
			Emprestimo e1 = new Emprestimo();
			e1.setIdCliente(rs.getInt("idCliente"));
			e1.setData(rs.getDate("data"));
			e1.setIdProduto1(rs.getInt("idProduto1"));
			e1.setIdProduto2(rs.getInt("idProduto2"));
			e1.setIdProduto3(rs.getInt("idProduto3"));
			e1.setIdLocacao(rs.getInt("idLocacao"));
			e1.setTotal(rs.getDouble("total"));
			listaEmprestimos.add(e1);
		}
		
		rs.close();
		stmt.close();
		return listaEmprestimos;
	}
	
	public Emprestimo getEmprestimo(String emprestimoId) throws SQLException {
		String sql = "select * from locacaobd where idLocacao=" + emprestimoId;
		
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Emprestimo e1 = new Emprestimo();
		
		while(rs.next()) {
			
			e1.setIdCliente(rs.getInt("idCliente"));
			e1.setData(rs.getDate("data"));
			e1.setIdProduto1(rs.getInt("idProduto1"));
			e1.setIdProduto2(rs.getInt("idProduto2"));
			e1.setIdProduto3(rs.getInt("idProduto3"));
			e1.setIdLocacao(rs.getInt("idLocacao"));
			e1.setTotal(rs.getDouble("total"));
		}
		
		rs.close();
		stmt.close();
		return e1;
	}
	
}
