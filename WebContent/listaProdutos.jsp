<%@page import="java.util.List"%>
<%@page import="locadora.logica.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Sistema Locadora - Lista de Produtos</title>
</head>
<body>

<h1> Lista de Produtos </h1>
<ul>
<%


	List<Produto> produtos = (List<Produto>) request.getAttribute("p");

	
	
	for (Produto produto : produtos) {
		out.println("<li><b> Título: </b>" +produto.getTitulo());
		out.println("<b>| Classificação: </b>" +produto.getClassificacao());
		out.println("<b>| CPF do Locador: </b>" +produto.getCpfLocador());
		out.println("<b>| Preço: </b>" +produto.getPreco());
		out.println("</li>");
	}

%>
</ul>
<br>
<input type="button" value="Voltar ao menu principal" onclick="location.href='menu.html'">
	
</body>
</html>