<%-- 
    Document   : index
    Created on : 22/05/2014, 21:46:36
    Author     : Yago
--%>

<%@page import="javax.rmi.CORBA.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<title>index</title>
		<script	type="text/javascript">
			function valida(form)
                        {
				var filtro = /^.+@.+\.((.{3}\..{2})|(.{2,3}))$/
                                if(form.email.value == "") {
                                    alert("Email vazio");
                                    return false;
                                }
				if (form.senha.value.length<5){
					alert("Senha deve ter mais de 5 caracteres");
					form.senha.focus();
					return false;	
				}
                                if(!filtro.test(form.email.value)) {
                                    alert("Email invalido!");
                                    return false;
                                }
				
			}
		</script>
	</head>

	<body>
		<center><h1>Bem Vindo ao Compra Simples</h1></center>                
                <%--<jsp:useBean id="users" scope="session" type="java.util.ArrayList"/>
                <jsp:useBean id="flag" scope="session" type="java.lang.Boolean"/> --%>
                <form onsubmit="return valida(this);" action= "ServletWeb" method="POST">                    
			<table align="center">
				<tr>
					<td>Email do usuário:</td><td><input type="text" name="login"></br></td>
				</tr>
				<tr>
					<td>Senha:</td><td><input type="password" name="senha"></br></td>
				</tr>
				<tr>
					<td><td><input type="submit" value="Enviar"><br> 
</td></td>
				</tr>
                                    	
                        </table>	
                        <br>                              
                       <center>
                       <%--<c:if test="${flag == false}">
                           Email e senha não batem!
                       </c:if>--%>
                        <br><br><br>
                        <a href="pagina2.jsp">Cadastro</a></center>

                    <input type="hidden" name="acao" value="login"/>
		</form>
	</body>
</html>