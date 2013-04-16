<%@page import="java.util.List"%>
<%@page import="locadora.logica.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> Sistema Locadora - Realizando empréstimo </title>
	
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
    	if ((tecla == 8) || (tecla == 13) || (tecla == 9) || (tecla == 46)) return true;
		else  return false;
    }
}
</script> 
	
</head>

<body>
	<form action="confirma.do" method="post" onsubmit="return form_simples(this)">
	<h1> Lista de produtos disponíveis para locação:</h1>
		
		<ul>
			<% 
				List<Produto> produtos = (List<Produto>) request.getAttribute("p");

				for (Produto produto : produtos) {
					out.println("<li><b> ID:</b>" + produto.getId());
					out.println("<b>| Classificação:</b> " +produto.getClassificacao());
					out.println("<b>| Título: </b>" +produto.getTitulo());
					out.println("<b>| Preço: </b>" +produto.getPreco());
					out.println("</li>");
				}
			%>
		</ul>
	<hr>
	<h2> Dados da Locação </h2>
	
	Código do Cliente: <input type="text" name="idCliente" alt="yes" onkeypress='return SomenteNumero(event)'>
	<br>
	
	Código Filme 1: <input type="text" name="primeiroFilme" alt="yes" onkeypress='return SomenteNumero(event)'>
	<br>
	
	Código Filme 2: <input type="text" name="segundoFilme" onkeypress='return SomenteNumero(event)'>
	<br>
	
	Código Filme 3: <input type="text" name="terceiroFilme" onkeypress='return SomenteNumero(event)'>
	<br>
	
	<input type="radio" name="semanaPromocao" value="1" checked="checked"> Utilizar preço padrão
	<br>
	
	<input type="radio" name="semanaPromocao" value="0"> Semana Promocional, insira o valor de cada filme:
	<br>
	<input type="text" name="precoPromocao" onkeypress='return SomenteNumero(event)'>
	<br>
	
	<input type="submit" value="OK">
	<br>
	</form>
	<input type="button" value="Voltar ao menu principal" onclick="location.href='menu.html'">

</body>
</html>