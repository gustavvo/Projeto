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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import locadora.bd.CriaConexao;

import locadora.logica.Produto;

public class ProdutoDao {

	private Connection conexao;
	
	public ProdutoDao() throws SQLException, ClassNotFoundException {
		this.conexao = CriaConexao.getConexao();
	}
	
	/**
	 * Método que adiciona um produto no banco de dados.
	 * @param p1 - produto a ser adicionado no banco
	 * @throws SQLException
	 */
	public void adiciona(Produto p1) throws SQLException {
		String sql = "insert into produtobd (titulo, classificacao, cpfLocador, preco)" + "values (?,?,?,?)";
		
		// Prepara a conexão
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// Seta os valores
		stmt.setString(1, p1.getTitulo());
		stmt.setString(2, p1.getClassificacao());
		stmt.setString(3, p1.getCpfLocador());
		stmt.setDouble(4, p1.getPreco());
		
		// Executa
		stmt.execute();
		stmt.close();
	}
	
	/**
	 * Método que retorna uma lista com os produtos armazenados
	 * @return lista de produtos
	 * @throws SQLException
	 */
	public ArrayList<Produto> getLista() throws SQLException {
		String sql = "select * from produtobd";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		while(rs.next()) {
			Produto p1 = new Produto();
			p1.setTitulo(rs.getString("titulo"));
			p1.setClassificacao(rs.getString("classificacao"));
			p1.setCpfLocador(rs.getString("cpfLocador"));
			p1.setPreco(rs.getDouble("preco"));
			listaProdutos.add(p1);
		}
		
		rs.close();
		stmt.close();
		return listaProdutos;
	}
	
	/**
	 * Método que retorna produtos disponíveis para locação.
	 * @return lista de produtos disponíveis
	 * @throws SQLException
	 */
	public ArrayList<Produto> getListaDisponiveis() throws SQLException {
		String sql = "select * from produtobd prod where prod.cpfLocador='Disponivel'";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		while(rs.next()) {
			Produto p1 = new Produto();
			p1.setTitulo(rs.getString("titulo"));
			p1.setClassificacao(rs.getString("classificacao"));
			p1.setCpfLocador(rs.getString("cpfLocador"));
			p1.setPreco(rs.getDouble("preco"));
			p1.setId(rs.getInt("idProduto"));
			listaProdutos.add(p1);
		}
		
		rs.close();
		stmt.close();
		return listaProdutos;
	}
	
	/**
	 * Método que recupera informações de um produto.
	 * @param IdProduto - id do produto a ser pesquisado
	 * @return informações do produto
	 * @throws SQLException
	 */
	public Produto getProduto(String IdProduto) throws SQLException {
		String id = "null";
		
		if  (! IdProduto.equals("")) {
			id = IdProduto;
		}
		
		String sql = "select * from produtobd prod where prod.idProduto=" + id;
		
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Produto p1 = new Produto();
		while(rs.next()) {
			
			p1.setTitulo(rs.getString("titulo"));
			p1.setClassificacao(rs.getString("classificacao"));
			p1.setCpfLocador(rs.getString("cpfLocador"));
			p1.setPreco(rs.getDouble("preco"));
			p1.setId(rs.getInt("idProduto"));
		}
		
		rs.close();
		stmt.close();
		return p1;
	}
	
	/**
	 * Método que seta um produto como locado.
	 * @param idProduto - produto a ser setado como locado
	 * @param idCliente - cliente que locou o produto
	 * @throws SQLException
	 */
	public void setaProdutoLocado(int idProduto, int idCliente) throws SQLException{
		String sql = "update produtobd set cpfLocador=" +idCliente+ " where idProduto=" +idProduto;
		
		// Prepara a conexão
		PreparedStatement stmt = conexao.prepareStatement(sql);
	
		// Executa
		stmt.execute();
		stmt.close();
		
		
	}
	
	/**
	 * Método que tira um produto da locação
	 * @param idProduto - produto a ser tirado da locacao
	 * @throws SQLException
	 */
	public void tiraProdutoLocado(int idProduto) throws SQLException{
		String sql = "update produtobd set cpfLocador='disponivel' where idProduto=" +idProduto;
		
		// Prepara a conexão
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// Executa
		stmt.execute();
		stmt.close();
		
		
	}
	
	/**
	 * Método que remove um produto do banco de dados.
	 * @param p1 - produto a ser removido do banco
	 * @throws SQLException
	 */
	public void remove(Produto p1) throws SQLException {
		String sql = "delete from produtobd where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, p1.getId());
		stmt.execute();
		stmt.close();
	}
}
