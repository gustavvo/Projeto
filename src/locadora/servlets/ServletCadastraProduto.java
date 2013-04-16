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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import locadora.dao.ProdutoDao;
import locadora.logica.Produto;

/**
 * Servlet implementation class ServletCadastraProduto
 */
public class ServletCadastraProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastraProduto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Recebe o título e a classificação de determinado produto para 
	 * armazenamento no banco de dados.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a = request.getParameter("titulo");
		String b = request.getParameter("classificacao");
		//String c = request.getParameter("cpfLocador");
		
		ProdutoDao dao = null;
		try {
			dao = new ProdutoDao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Produto p1 = new Produto();
		p1.setTitulo(a);
		p1.setClassificacao(b);
		p1.setCpfLocador("Disponivel");
		
		switch (b) {
			case "Filme": p1.setPreco(5);			
				    	  break;
			case "Show": p1.setPreco(3);
						 break;
			case "Infantil" : p1.setPreco(2);
				break;
		default:
			p1.setPreco(0);
			break;
		}
		
		
		
		try {
			dao.adiciona(p1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher r = request.getRequestDispatcher("cadastroProdutoOk.html");
		r.forward(request, response);
		
		
		
		
		
	}

}
