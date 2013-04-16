package projetolocadora;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import locadora.bd.CriaConexao;
import locadora.dao.ClienteDao;
import locadora.dao.EmprestimoDao;
import locadora.dao.ProdutoDao;
import locadora.logica.Cliente;
import locadora.logica.Emprestimo;
import locadora.logica.Produto;

public class Main {
	
	//@SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
		Date x;
		x = new Date(2, 3, 23); 
		
		Connection conexao = CriaConexao.getConexao();
		
		System.out.println("CONEXAO CRIADA");
		
		//  Cria e adiciona cliente
		ClienteDao clienteDao = new ClienteDao();
		Cliente c1 = new Cliente();
		
		c1.setNome("Marcelo");
		c1.setCpf("123312311");
		c1.setTelefone("2332-2222");
		clienteDao.adiciona(c1);
		
		// Cria e adiciona Produto
		ProdutoDao produtoDao = new ProdutoDao();
		Produto p1 = new Produto();
		
		p1.setTitulo("Esqueceram de mim");
		p1.setClassificacao("infantil");
		p1.setCpfLocador("123321");
		p1.setPreco(3.00);
		produtoDao.adiciona(p1);
				
		// Cria e adiciona empréstimo
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		Emprestimo e1 = new Emprestimo();
		
		e1.setIdCliente(1);
		e1.setData(x);
		e1.setIdProduto1(12);
		e1.setIdProduto2(3);
		e1.setTotal(2.50);
		emprestimoDao.adiciona(e1);
		
		
		
		List<Cliente> listaClientes = clienteDao.getLista();
		
		for (Cliente cliente : listaClientes) {
			System.out.println("Nome: " +cliente.getNome());
			System.out.println("CPF: " +cliente.getCpf());
			System.out.println("Telefone: " +cliente.getTelefone());
			System.out.println("");
		}
		
		List<Produto> listaProdutos = produtoDao.getLista();
		
		for (Produto produto : listaProdutos) {
			System.out.println("Nome: " +produto.getTitulo());
			System.out.println("Classificação: " +produto.getClassificacao());
			System.out.println("");
		}
		
		List<Emprestimo> listaEmprestimos = emprestimoDao.getLista();
		
		for (Emprestimo emprestimo : listaEmprestimos) {
			System.out.println("Empréstimo 1: "+emprestimo.getIdProduto1());
		}
		
		conexao.close();
		System.out.println("Desconectado do banco");
		System.out.println("Funcionou");
		
		
		
	}
}
		
		
		/*ClienteDao dao = new ClienteDao();
		List<Cliente> minhaLista = dao.getLista();
		
		for (Cliente cliente : minhaLista) {
			System.out.println("Nome: " +cliente.getNome());
			System.out.println("CPF: " +cliente.getCpf());
			System.out.println("Telefone: " +cliente.getTelefone());
			System.out.println("");
		}
		*/
		
		
		
	/*	Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setCpf("123321123");
		cliente.setTelefone("3333-3333");
		
		ClienteDao dao = new ClienteDao();
		dao.adiciona(cliente);
		System.out.println("Adicionado ao banco");*/
		
		
//		Connection conexao = CriaConexao.getConexao();
//		conexao.close();
//		System.out.println("Desconectado do banco!");
		
	