<%@page import="java.util.List"%>
<%@page import="locadora.logica.Emprestimo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Sistema Locadora - Lista de Locações </title>
</head>
<body>

<h1> Lista de Locações </h1>
<ul>
<%


	List<Emprestimo> emprestimos = (List<Emprestimo>) request.getAttribute("p");

	
	
	for (Emprestimo emprestimo : emprestimos) {
		out.println("<li><b> Código do CLiente: </b>" +emprestimo.getIdCliente());
		out.println("<b>| Código da Locação: </b>" +emprestimo.getIdLocacao());
		out.println("<b>| Código Filme 1: </b>" +emprestimo.getIdProduto1());
		out.println("<b>| Código Filme 2: </b>" +emprestimo.getIdProduto2());
		out.println("<b>| Código Filme 3: </b>" +emprestimo.getIdProduto3());
		out.println("<b>| Data: </b>" +emprestimo.getData());
		out.println("<b>| Total: </b>" +emprestimo.getTotal());
		out.println("</li>");
	}

%>
</ul>
<br>
<input type="button" value="Voltar ao menu principal" onclick="location.href='menu.html'">


</body>
</html>