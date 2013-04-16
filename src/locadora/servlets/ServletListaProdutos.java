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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadora.dao.ProdutoDao;
import locadora.logica.Produto;

/**
 * Servlet implementation class ServletListaProdutos
 */
public class ServletListaProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Retorna a lista de produtos cadastrados no banco de dados
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProdutoDao dao = null;
		try {
			dao = new ProdutoDao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Produto> produtos = null;
		try {
			produtos = dao.getLista();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("p", produtos);
		
		RequestDispatcher r = request.getRequestDispatcher("listaProdutos.jsp");
		
		r.forward(request, response);	
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoDao dao = null;
		try {
			dao = new ProdutoDao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Produto> produtos = null;
		try {
			produtos = dao.getListaDisponiveis();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("p", produtos);
		
		RequestDispatcher r = request.getRequestDispatcher("realizaEmprestimo.jsp");
		
		r.forward(request, response);
		
	}
	
}
