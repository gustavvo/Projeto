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
import locadora.dao.EmprestimoDao;
import locadora.logica.Emprestimo;


/**
 * Servlet implementation class ServletListaEmprestimo
 */
public class ServletListaEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListaEmprestimo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Retorna a lista de empréstimos armazenados no banco de dados
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmprestimoDao ed = null;
		List<Emprestimo> emprestimo = null;
		try {
			ed = new EmprestimoDao();
			emprestimo = ed.getLista();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
				
		request.setAttribute("p", emprestimo);		
		RequestDispatcher r = request.getRequestDispatcher("realizaDevolucao.jsp");
		
		r.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmprestimoDao dao = null;
		try {
			dao = new EmprestimoDao();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		List<Emprestimo> emprestimo = null;
		try {
			emprestimo = dao.getLista();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("p", emprestimo);		
		RequestDispatcher r = request.getRequestDispatcher("listaEmprestimos.jsp");
		
		r.forward(request, response);
	}

}
