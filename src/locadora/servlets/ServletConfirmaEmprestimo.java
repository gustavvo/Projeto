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

package locadora.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import locadora.dao.ClienteDao;
import locadora.dao.ProdutoDao;
import locadora.logica.Cliente;
import locadora.logica.Produto;

/**
 * Servlet implementation class ServletConfirmaEmprestimo
 */
public class ServletConfirmaEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfirmaEmprestimo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * Recebe do HTML o id do cliente e o filmes por ele locados, mostrando todas as informações e pedindo ao funcionário 
	 * a confirmação da locação.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCLiente = request.getParameter("idCliente");
		String primeiroFilme = request.getParameter("primeiroFilme");
		String segundoFilme = request.getParameter("segundoFilme");
		String terceiroFilme = request.getParameter("terceiroFilme");
		double precoPromocao = 0;
		
		if (request.getParameter("semanaPromocao").equals("0")){
			precoPromocao = Double.parseDouble(request.getParameter("precoPromocao"));
		}
		
		try {
			if (verificaClienteDisponivel(idCLiente)){
				
				if (!disponibilidade(primeiroFilme, segundoFilme, terceiroFilme)) {
					RequestDispatcher r  = request.getRequestDispatcher("filmeNaoDisponivel.html");
					r.forward(request, response);
				} else {

					ClienteDao cd = new ClienteDao();
					
					Cliente c1 = cd.getCliente(idCLiente);
					
					ProdutoDao pd = new ProdutoDao();
					
					Produto produto1 = pd.getProduto(primeiroFilme);
					Produto produto2 = pd.getProduto(segundoFilme);
					Produto produto3 = pd.getProduto(terceiroFilme);
					
					request.setAttribute("c", c1);
					request.setAttribute("p1", produto1);
					request.setAttribute("p2", produto2);
					request.setAttribute("p3", produto3);
					request.setAttribute("promocao", precoPromocao);	
					
					RequestDispatcher r  = request.getRequestDispatcher("confirmaEmprestimo.jsp");
					r.forward(request, response);					
				}
						
			} else {
				RequestDispatcher r  = request.getRequestDispatcher("clienteNaoDisponivel.html");
				r.forward(request, response);
			}		
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}		
	}
	
	/**
	 * Verifica se determinado cliente está disponível para realizar uma locação.
	 * @param idCliente
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean verificaClienteDisponivel(String idCliente) throws ClassNotFoundException, SQLException{
		ClienteDao cd = new ClienteDao();
		
		ArrayList<Cliente> clientes = cd.getListaCLienteDisponiveis();
		
		for (Cliente cliente : clientes) {
			
			if (cliente.getId().equals(idCliente)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Verifica se determinado filme está disponível para locação.
	 * @param idFilme
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean verificaFilmeDisponivel(String idFilme) throws ClassNotFoundException, SQLException{
		
		int x = 0;
		
		if (!idFilme.equals("")){
			x = Integer.parseInt(idFilme);
		}
		
		ProdutoDao pd = new ProdutoDao();
		
		ArrayList<Produto> produtos = pd.getListaDisponiveis();
		
		for (Produto produto : produtos){			
			if (produto.getId() == x){
				return true;
			}
		}		
		return false;
	}
	
	/**
	 * Verifica uma entrada vazia em um campo do formulário de locação.
	 * @param filme
	 * @return
	 */
	protected boolean verificaVazio(String filme) {
		if (filme.equals("")) return true ;
		else  return false;
	}
	
	/**
	 * Retorna um boolean verificando a disponibilidade da locação.
	 * @param filme1
	 * @param filme2
	 * @param filme3
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean disponibilidade(String filme1, String filme2, String filme3) throws ClassNotFoundException, SQLException {
		
		if (verificaFilmeDisponivel(filme1)) {
			
			if (!verificaVazio(filme2)) {
				
				if (verificaFilmeDisponivel(filme2)) {
					
					if (!verificaVazio(filme3)) {
						
						if (verificaFilmeDisponivel(filme3)) {
							return true;
						} else return false;
				
					} else return true;
			
				} else return false; 
			}
				if (!verificaVazio(filme3)) {
					if (verificaFilmeDisponivel(filme3)) {
						return true;
					} else return false;
				
				} else return true;
			}
		return false;
	}

}
