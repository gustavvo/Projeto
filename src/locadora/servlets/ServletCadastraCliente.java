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

import locadora.dao.ClienteDao;
import locadora.logica.Cliente;

/**
 * Servlet implementation class ServletCadastraCliente
 */
public class ServletCadastraCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCadastraCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Recebe da página HTML os campos nome, telefone e cpf para armazenar no banco de dados
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String a = request.getParameter("nome");
		String b = request.getParameter("telefone");
		String c = request.getParameter("cpf");
		
		ClienteDao dao = null;
		try {
			dao = new ClienteDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cliente c1 = new Cliente();
		c1.setNome(a);
		c1.setTelefone(b);
		c1.setCpf(c);
		try {
			dao.adiciona(c1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher r = request.getRequestDispatcher("cadastroClienteOk.html");
		r.forward(request, response);
		
	}

}
