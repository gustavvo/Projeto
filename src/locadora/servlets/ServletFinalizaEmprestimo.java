package locadora.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import locadora.dao.EmprestimoDao;
import locadora.dao.ProdutoDao;
import locadora.logica.Emprestimo;

/**
 * Servlet implementation class ServletFinalizaEmprestimo
 */
public class ServletFinalizaEmprestimo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFinalizaEmprestimo() {
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
	 * Captura do HTML o id do cliente, id dos protudos locados e o valor total das locações. Todos
	 * as informações são armazenadas no banco de dados de empréstimos.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clienteId = Integer.parseInt(request.getParameter("codigoCliente"));
		int produtoId1 = Integer.parseInt(request.getParameter("produtoId1"));
		int produtoId2 = Integer.parseInt(request.getParameter("produtoId2"));
		int produtoId3 = Integer.parseInt(request.getParameter("produtoId3"));
		double total = Double.parseDouble(request.getParameter("total"));
		
		Date data = new Date(System.currentTimeMillis()); 
		
		try {
			EmprestimoDao ed = new EmprestimoDao();
			Emprestimo e1 = new Emprestimo();
			
			e1.setIdCliente(clienteId);
			e1.setIdProduto1(produtoId1);
			e1.setIdProduto2(produtoId2);
			e1.setIdProduto3(produtoId3);
			e1.setTotal(total);
			e1.setData(data);			
			ed.adiciona(e1);
			
			ProdutoDao pd = new ProdutoDao();
			pd.setaProdutoLocado(produtoId1, clienteId);
			pd.setaProdutoLocado(produtoId2, clienteId);
			pd.setaProdutoLocado(produtoId3, clienteId);
			
			RequestDispatcher r = request.getRequestDispatcher("emprestimoOk.html");
			r.forward(request, response);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
