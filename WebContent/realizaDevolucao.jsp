<%@page import="java.util.List"%>
<%@page import="locadora.logica.Emprestimo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Sistema Locadora - Realiza devolução </title>

<script>
function form_simples(ele){
        numero = ele.elements.length
        erro = "";
        for(i=0; i<numero; i++){
                if(ele.elements[i].alt == "yes"){
                        if(ele.elements[i].name == "email" || ele.elements[i].name == "e-mail" || ele.elements[i].name == "mail"){
                                if(ele.elements[i].value.indexOf('@')==-1 || ele.elements[i].value.indexOf('.')==-1){
                                erro = erro + "Preencha o campo '"+ ele.elements[i].name.toUpperCase() +"' corretamente. \n"
                                }
                        }else{
                                if(ele.elements[i].value==""){
                                erro = erro + "Preencha o campo '"+ ele.elements[i].name.toUpperCase() +"'. \n"
                                }
                        }
                }
                if(ele.elements[i].title == "yes"){
                        if(ele.elements[i].value==""){
                        erro = erro + "Preencha o campo '"+ ele.elements[i].name.toUpperCase() +"'. \n"
                        }
                }
        }

        if(erro != ""){
                alert("Erros:\n"+erro);
                return false
        }else{
                return true
        }
}
</script>

<script language='JavaScript'>
function SomenteNumero(e){
    var tecla=(window.event)?event.keyCode:e.which;   
    if((tecla>47 && tecla<58)) return true;
    else{
    	if ((tecla == 8) || (tecla == 0)) return true;
		else  return false;
    }
}
</script> 



</head>
<body>

<h1> Lista de Locações </h1>
<ul>
<%

	List<Emprestimo> emprestimos = (List<Emprestimo>) request.getAttribute("p");

	
	
	for (Emprestimo emprestimo : emprestimos) {
		out.println("<li><b> Código do CLiente: </b>" +emprestimo.getIdCliente());
		out.println("<b>| Código da Locação: </b>" +emprestimo.getIdLocacao());
		out.println("<b>| Filme 1: </b>" +emprestimo.getIdProduto1());
		out.println("<b>| Filme 2: </b>" +emprestimo.getIdProduto2());
		out.println("<b>| Filme 3: </b>" +emprestimo.getIdProduto3());
		out.println("<b>| Data: </b>" +emprestimo.getData());
		out.println("<b>| Total: </b>" +emprestimo.getTotal());
		out.println("</li>");
	}
%>
</ul>
<br>
<hr>
	Digite o ID da Locação a ser Devolvida: 
	<br>
	
	
	<form action="confirmaDevolucao.do" method="post" onsubmit="return form_simples(this)" >
	
	<input type="text" name="id" alt="yes" onkeypress='return SomenteNumero(event)'>
	<br>
	
	<input type="submit" value="Realizar devolução">
	
	</form>
	
	
	<br>
	<input type="button" value="Retorna ao menu Inicial" onclick="location.href='menu.html'">
	












</body>
</html>