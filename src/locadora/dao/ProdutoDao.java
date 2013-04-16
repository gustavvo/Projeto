package locadora.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import locadora.bd.CriaConexao;
import locadora.logica.Cliente;
import locadora.logica.Produto;

public class ProdutoDao {

	private Connection conexao;
	
	public ProdutoDao() throws SQLException {
		this.conexao = CriaConexao.getConexao();
	}
	
	public void adiciona(Produto p1) throws SQLException {
		String sql = "insert into produto (titulo, classificacao, cpfLocado, preco, )" + "values (?,?,?)";
		
		// Prepara a conexão
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		// Seta os valores
		stmt.setString(1, p1.getTitulo());
		stmt.setString(2, p1.getClassificacao());
		stmt.setString(3, p1.getCpfLocado());
		stmt.setDouble(4, p1.getPreco());
		
		// Executa
		stmt.execute();
		stmt.close();
	}
	
	// Retorna lista de produtos
	public ArrayList<Produto> getListaProdutos() throws SQLException {
		String sql = "select * from produto";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		while(rs.next()) {
			Produto p1 = new Produto();
			p1.setTitulo(rs.getString("titulo"));
			p1.setClassificacao(rs.getString("classificacao"));
			p1.setCpfLocado(rs.getString("cpfLocado"));
			p1.setPreco(rs.getDouble("preco"));
		}
		
		rs.close();
		stmt.close();
		return listaProdutos;
	}
	
	public void remove(Produto p1) throws SQLException {
		String sql = "delete from produto where id=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, p1.getId());
		stmt.execute();
		stmt.close();
	}
}
