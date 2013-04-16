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

import locadora.dao.ClienteDao;
import locadora.logica.Cliente;

/**
 * Servlet implementation class ServletListaClientes
 */
public class ServletListaClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Lista os clientes armazenados no banco de dados
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDao dao = null;
		try {
			dao = new ClienteDao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Cliente> clientes = dao.getLista();
		
		request.setAttribute("c", clientes);
		
		RequestDispatcher r = request.getRequestDispatcher("listaClientes.jsp");
		
		r.forward(request, response);
		
	}

}
