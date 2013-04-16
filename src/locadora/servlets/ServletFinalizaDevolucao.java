package locadora.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import locadora.dao.EmprestimoDao;
import locadora.dao.ProdutoDao;

/**
 * Servlet implementation class ServletFinalizaDevolucao
 */
public class ServletFinalizaDevolucao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFinalizaDevolucao() {
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
	 * Exibe os dados da locação, calcula os valores a serem pagos pelo cliente e efetua a transação.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idEmprestimo = Integer.parseInt(request.getParameter("codigoEmprestimo"));
		int idProduto1 = Integer.parseInt(request.getParameter("IdProduto1"));
		int idProduto2 = Integer.parseInt(request.getParameter("IdProduto2"));
		int idProduto3 = Integer.parseInt(request.getParameter("IdProduto3"));
		
		double abatimento = Double.parseDouble(request.getParameter("abatimento"));
		double total = Double.parseDouble(request.getParameter("totalgeral"));
		String nomeP1 = request.getParameter("nomeFilme1");
		String nomeP2 = request.getParameter("nomeFilme2");
		String nomeP3 = request.getParameter("nomeFilme3");
		
		try {
			EmprestimoDao ed = new EmprestimoDao();
			ed.remove(idEmprestimo);
			
			ProdutoDao pd = new ProdutoDao();
			pd.tiraProdutoLocado(idProduto1);
			pd.tiraProdutoLocado(idProduto2);
			pd.tiraProdutoLocado(idProduto3);
			
			request.setAttribute("total", total);
			request.setAttribute("abatimento", abatimento);
			request.setAttribute("nomeP1", nomeP1);
			request.setAttribute("nomeP2", nomeP2);
			request.setAttribute("nomeP3", nomeP3);
			
			
			RequestDispatcher r = request.getRequestDispatcher("devolucaoOk.jsp");
			r.forward(request, response);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
