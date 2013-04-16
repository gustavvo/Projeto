<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@page import="locadora.logica.Emprestimo"%>
<%@page import="locadora.logica.Cliente"%>
<%@page import="locadora.logica.Produto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Sistema Locadora - Devolução de Produtos </title>
</head>
<body>


<h1> Devolução de produtos efetuado com sucesso</h1>

<%
	Double total = (Double) request.getAttribute("total");
	Double abatimento = (Double) request.getAttribute("abatimento");
	double valorCobrado = total - abatimento;
	
	String nomeP1 = (String) request.getAttribute("nomeP1"); 
	String nomeP2 = (String) request.getAttribute("nomeP2");
	String nomeP3 = (String) request.getAttribute("nomeP3");
	
	
	if (nomeP2.equals(null)){
		nomeP2 = "< -- >";
	}
	if (nomeP3.equals(null)){
		nomeP3 = "< -- >";
	}
	
	out.println("<b>Filmes Devolvidos: </b> <br>"+  nomeP1);
	out.println("<br>");
	out.println(nomeP2);
	out.println("<br>");
	out.println(nomeP3);
	
	out.println("<br>Valor total: " + total);
	out.println("<br>");
	out.println("Abatimentos: " + abatimento);
	out.println("<br>----------------------------------------");	
	out.println("<br>");
	out.println("VALOR COBRADO: " + valorCobrado);
	out.println("<br>");

%>

<input type="button" value="Voltar ao menu principal" onclick="location.href='menu.html'">
<br>
<form action="listaEmprestimo.do" method="get">
	<input type="submit" value="Realizar outra Devolução">
	</form>


</body>
</html>










</body>
</html>