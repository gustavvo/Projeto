<%@page import="java.util.List"%>
<%@page import="locadora.logica.Produto"%>
<%@page import="locadora.logica.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> Sistema Locadora - Confirmar Empréstimo </title>
</head>





<body>
	<form action="finalizaEmprestimo.do" method="post">
	<h1> Dados da Locação </h1>
	
	<%
		Cliente c = (Cliente) request.getAttribute("c");
		String nomeCliente = c.getNome();
		
		Produto p1 = (Produto) request.getAttribute("p1");
		Produto p2 = (Produto) request.getAttribute("p2");
		Produto p3 = (Produto) request.getAttribute("p3");
		
		
		
		String tituloP1 = p1.getTitulo();
		
		String tituloP2 = p2.getTitulo();
		
		if (tituloP2 == null){
			tituloP2 = "< -- >";
		}
	
		
		String tituloP3 = p3.getTitulo();
		
		if (tituloP3 == null){
			tituloP3 = "< -- >";
		}

		
		Double precoPromocao = (Double) request.getAttribute("promocao");
		
		double total = 0;
		
		if (precoPromocao.doubleValue() != 0){
			if (p1.getPreco() != 0){
				total = total + precoPromocao.doubleValue();;
			}
			if (p2.getPreco() != 0){
				total = total + precoPromocao.doubleValue();
				
			}
			if (p3.getPreco() != 0){
				total = total + precoPromocao.doubleValue();
			}
		}else{
			total = p1.getPreco() + p2.getPreco() + p3.getPreco();
		}
		
		
				
		out.println("<b> Nome do Cliente: </b>");
		out.println("<br>");
		out.println("<input type= \"text\" value= \"" + nomeCliente + "\" name = \"nomeCliente\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" ><br>" );
		out.println("<br>");
		out.println("<br>");
				
		out.println("<b> Filme 1: </b>");
		out.println("<br>");
		out.println("<input type= \"text\" value= \"" + tituloP1 + "\" name = \"filme1\" readonly= \" readonly \" size=50 style=\"font-size:30px;color:blue\"><br>" );
		out.println("<br>");
		out.println("<br>");
		
		out.println("<b> Filme 2: </b>");
		out.println("<br>");
		out.println("<input type= \"text\" value= \"" + tituloP2 + "\" name = \"filme2\" readonly= \" readonly \" size=50 style=\"font-size:30px;color:blue\"><br>" );
		out.println("<br>");
		out.println("<br>");
		
		out.println("<b> Filme 3: </b>");
		out.println("<br>");
		out.println("<input type= \"text\" value= \"" + tituloP3 + "\" name = \"filme3\" readonly= \" readonly \" size=50 style=\"font-size:30px;color:blue\"><br>" );
		out.println("<br>");
		out.println("<br>");
		
		out.println("<b> Total da Locação: </b>");
		out.println("<br>");
		out.println("<input type= \"text\" value= \"" + total + "\" name = \"total\" readonly= \" readonly \" size=50 style=\"font-size:30px;color:blue\"><br>" );
		out.println("<br>");
		
		out.println("<input type= \"hidden\" value= \"" + c.getId() + "\" name = \"codigoCliente\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" ><br>" );
		out.println("<input type= \"hidden\" value= \"" + p1.getId() + "\" name = \"produtoId1\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" ><br>" );
		out.println("<input type= \"hidden\" value= \"" + p3.getId() + "\" name = \"produtoId2\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" ><br>" );
		out.println("<input type= \"hidden\" value= \"" + p2.getId() + "\" name = \"produtoId3\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" ><br>" );
		
		
	%>
	
	
	<input type="submit" value="Confirmar locação">
	<br>
	</form>
	
	<form action="listaProdutos.do" method="post">
		<input type="submit" value="Corrigir informações ">
		<br>
	</form>
	
	
	
</body>
</html>