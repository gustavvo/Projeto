<%@page import="java.util.List"%>
<%@page import="locadora.logica.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="locadora.dao.ClienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Sistema Locadora - Lista de Clientes </title>
</head>
<body>


<h1> Lista de Clientes </h1>
<ul>
<%

	List<Cliente> clientes = (List<Cliente>) request.getAttribute("c");

	
	
	for (Cliente cliente : clientes) {
		out.println("<li><b> Nome: </b>" +cliente.getNome());
		//out.println("<br>");
		out.println("<b>| CPF: </b>" +cliente.getCpf());
		//out.println("<br>");
		out.println("<b>| Telefone: </b>" +cliente.getTelefone());
		out.println("</li>");
		//out.println("<br>");
		//out.println("<br>");
	}
	

%>
</ul>
<br>
<input type="button" value="Voltar ao menu principal" onclick="location.href='menu.html'">
</body>
</html>