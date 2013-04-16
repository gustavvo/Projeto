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
import locadora.dao.LoginDao;
import locadora.logica.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Cria a sessão e realiza o login do usuário.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		//HttpSession sessao = request.getSession();
		//sessao.setMaxInactiveInterval(-1);
		
		
		//if (sessao.isNew()){
			if (verificaLOgin(nome, senha)){
				RequestDispatcher r = request.getRequestDispatcher("menu.html");
				r.forward(request, response);
			}else{
				RequestDispatcher r = request.getRequestDispatcher("WEB-INF/erroLogin.html");
				r.forward(request, response);
			}
		//}else{
		//	RequestDispatcher r = request.getRequestDispatcher("menu.html");
		//	r.forward(request, response);
		//}
		
		
	}
	
	protected boolean verificaLOgin(String usuario, String senha){
		try {
			LoginDao ld = new LoginDao();
			
			ArrayList<Usuario> usuarios = ld.getUsuarios();
			
			
			for (Usuario u : usuarios) {
				if (u.getNome().equals(usuario) && u.getSenha().equals(senha)){
					return true;
				}
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		boolean create = true;
		HttpSession sessao = request.getSession(create);
			
			if (verificaLogin(nome, senha)) {
				sessao.setAttribute("nome", nome);
				//response.sendRedirect("menuJ.jsp");
				RequestDispatcher r = request.getRequestDispatcher("/WEB-INF/menuJ.jsp");
				r.forward(request, response);
			} else {
				RequestDispatcher r = request.getRequestDispatcher("index.html");
				r.forward(request, response);
			}
	}
	*/
}
