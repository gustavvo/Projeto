package projetolocadora;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

import locadora.bd.CriaConexao;
import locadora.dao.ClienteDao;
import locadora.logica.Cliente;

public class Main {
	
	public static void main(String[] args) throws SQLException {
	
		
		Connection conexao = CriaConexao.getConexao();
		
		ClienteDao dao = new ClienteDao();
		
		
		
		
		
		Cliente c1 = new Cliente();
		c1.setNome("Marcelo");
		c1.setCpf("123312311");
		c1.setTelefone("2332-2222");
		dao.adiciona(c1);
		
		
		List<Cliente> minhaLista = dao.getLista();
		
		for (Cliente cliente : minhaLista) {
			System.out.println("Nome: " +cliente.getNome());
			System.out.println("CPF: " +cliente.getCpf());
			System.out.println("Telefone: " +cliente.getTelefone());
			System.out.println("");
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
		
	