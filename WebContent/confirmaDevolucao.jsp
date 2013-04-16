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
	<title> Confirmação de Devolução </title>
	
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


<script language="JavaScript">
function carrega()
{
  document.formulario.login.value="0.00";
}

function zera_login()
{
  document.formulario.login.value="";
}
</script>

</head>
<body>
	<h1>Confirmação de Devolução</h1>
<form action="finalizaDevolucao.do" method="post">	
<%


	Emprestimo e = (Emprestimo) request.getAttribute("e");
	Cliente c = (Cliente) request.getAttribute("c");
	Produto p1 = (Produto) request.getAttribute("p1");
	Produto p2 = (Produto) request.getAttribute("p2");
	Produto p3 = (Produto) request.getAttribute("p3");
	
	
	String tituloP2 = p2.getTitulo();
	
	String tituloP3 = p3.getTitulo();
	
	if (tituloP2 == null){
		tituloP2 = "< -- >";
	}
	
	if (tituloP3 == null){
		tituloP3 = "< -- >";
	}
	
	out.println("<b> Nome do Cliente: </b>");
	out.println("<br>");
	out.println("<input type= \"text\" value= \"" + c.getNome() + "\" name = \"nomeCliente\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:blue \" ><br>" );
	out.println("<br>");
	out.println("<br>");
	
	out.println("<b> Nome Do Primeiro Filme: </b>");
	out.println("<br>");
	out.println("<input type= \"text\" value= \"" + p1.getTitulo() + "\" name = \"nomeFilme1\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:blue \" ><br>" );
	out.println("<br>");
	out.println("<br>");
	
	out.println("<b> Nome do Segundo Filme: </b>");
	out.println("<br>");
	out.println("<input type= \"text\" value= \"" + tituloP2 + "\" name = \"nomeFilme2\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:blue \" ><br>" );
	out.println("<br>");
	out.println("<br>");
	
	out.println("<b> Nome do Terceiro Filme: </b>");
	out.println("<br>");
	out.println("<input type= \"text\" value= \"" + tituloP3 + "\" name = \"nomeFilme3\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:blue \" ><br>" );
	out.println("<br>");
	out.println("<br>");
	
	
	out.println("<b> Total da Locação: </b>");
	out.println("<br>");
	out.println("<input type= \"text\" value= \"" + (e.getTotal()) + "\" name = \"total\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:blue \" ><br>" );
	out.println("<br>");
	out.println("<hr>");
	
	
	out.println("<input type= \"hidden\" value= \"" + e.getIdLocacao() + "\" name = \"codigoEmprestimo\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" >" );
	out.println("<input type= \"hidden\" value= \"" + e.getIdCliente() + "\" name = \"codigoCliente\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" >" );
	out.println("<input type= \"hidden\" value= \"" + e.getIdProduto1() + "\" name = \"IdProduto1\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" >" );
	out.println("<input type= \"hidden\" value= \"" + e.getIdProduto2() + "\" name = \"IdProduto2\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" >" );
	out.println("<input type= \"hidden\" value= \"" + e.getIdProduto3() + "\" name = \"IdProduto3\" readonly= \" readonly \"  size=50 style=\"font-size:30px;color:blue \" >" );
	
	Date agora = new Date(System.currentTimeMillis());
	int tempo = e.dataDiff(e.getData(), agora);
	
	
	out.println("<b> Dias Com o Filme Locado: </b>");
	out.println("<br>");
	out.println("<input type= \"text\" value= \"" + tempo + "\" name = \"tempo\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:blue \" ><br>" );
	out.println("<br>");
	out.println("<br>");
	
	if (tempo > 10){
		out.println("<b> Multa Severa: </b>");
		out.println("<br>");
		out.println("<input type= \"text\" value= \"" + 10 + "\" name = \"multa\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:red \" ><br>" );
		out.println("<br>");
		out.println("<b> Total A ser pago: </b>");
		out.println("<br>");
		out.println("<input type= \"text\" value= \"" + (e.getTotal()+10) + "\" name = \"totalgeral\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:red \" ><br>" );
		out.println("<br>");
		out.println("<br>");
	}else{
		if (tempo > 2 && tempo <= 10){
			out.println("<b> Multa Branda: </b>");
			out.println("<br>");
			out.println("<input type= \"text\" value= \"" + 5 + "\" name = \"multa\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:red \" ><br>" );
			out.println("<br>");
			out.println("<b> Total A ser pago: </b>");
			out.println("<br>");
			out.println("<input type= \"text\" value= \"" + (e.getTotal()+5) + "\" name = \"totalgeral\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:red \" ><br>" );
			out.println("<br>");
			out.println("<br>");
		}else{
			out.println("<b> Total A ser pago: </b>");
			out.println("<br>");
			out.println("<input type= \"text\" value= \"" + (e.getTotal()) + "\" name = \"totalgeral\" readonly= \" readonly \"  size=50 style=\"font-size:20px;color:blue \" ><br>" );
			out.println("<br>");
			out.println("<br>");
		}
	}
	
	
%>
	Conceder abatimento (R$): <br>
	<input type="text" name="abatimento" onkeypress='return SomenteNumero(event)' value="0.00" onclick="this.value=''" onblur="if(this.value=='') this.value='0.00'"> <br>
	<input type="submit" value="Confirmar devolução">
	</form>
	<br>
	<form action="listaEmprestimo.do" method="get">
		<input type="submit" value="Escolher outra Devolução">
	</form>
	<br>
	<input type="button" value="Retornar ao menu Inicial" onclick="location.href='menu.html'">
	<br>
	<br>
	

</body>
</html>