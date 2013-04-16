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
import locadora.dao.EmprestimoDao;
import locadora.dao.ProdutoDao;
import locadora.logica.Cliente;
import locadora.logica.Emprestimo;
import locadora.logica.Produto;

/**
 * Servlet implementation class ServletConfirmaDevolucao
 */
public class ServletConfirmaDevolucao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfirmaDevolucao() {
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
	 * Recebe os dados da locação e confirma a devoulção.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idDevolucao  = request.getParameter("id");
		
		try {
			if (devolucaoDisponivel(idDevolucao)){
				EmprestimoDao ed = new EmprestimoDao();
				Emprestimo emprestimo = ed.getEmprestimo(idDevolucao);
				
				ClienteDao cd = new ClienteDao();
				
				int x = emprestimo.getIdCliente();
				String id = String.valueOf(x);
				
				//String id = Integer.toString(emprestimo.getIdCliente());
				Cliente cli = cd.getCliente(id);
				
				ProdutoDao pd = new ProdutoDao();
				Produto p1 = pd.getProduto(Integer.toString(emprestimo.getIdProduto1()));
				Produto p2 = pd.getProduto(Integer.toString(emprestimo.getIdProduto2()));
				Produto p3 = pd.getProduto(Integer.toString(emprestimo.getIdProduto3()));
				
				request.setAttribute("e", emprestimo);
				request.setAttribute("c", cli);
				request.setAttribute("p1", p1);
				request.setAttribute("p2", p2);
				request.setAttribute("p3", p3);
				
				RequestDispatcher r = request.getRequestDispatcher("confirmaDevolucao.jsp");
				r.forward(request, response);
			
			}else{
				RequestDispatcher r = request.getRequestDispatcher("erroDevolucao.html");
				r.forward(request, response);
			}
			
					
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifica se a devolução é possível
	 * @param idDevolucao
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean devolucaoDisponivel(String idDevolucao) throws ClassNotFoundException, SQLException{
		EmprestimoDao ed = new EmprestimoDao();
		int id = Integer.parseInt(idDevolucao);
		
		ArrayList<Emprestimo> emprestimos = ed.getLista();
		
		for (Emprestimo emprestimo : emprestimos){
			if (emprestimo.getIdLocacao() == id){
				return true;
			}
		}
		
		return false;
	}

}
