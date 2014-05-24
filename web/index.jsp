<%-- 
    Document   : index
    Created on : 22/05/2014, 21:46:36
    Author     : Yago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>index</title>
		<script	type="text/javascript">
			function valida(form){
				var filtro = /^.+@.+\..{3}\..{2}$/
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
		<form onsubmit="return valida(this);" action= "principal.html">
			<table align="center">
				<tr>
					<td>Email do usuário:</td><td><input type="text" name="email"></br></td>
				</tr>
				<tr>
					<td>Senha:</td><td><input type="password" name="senha"></br></td>
				</tr>
				<tr>
					<td><td><input type="submit" value="Enviar"><br> 
</td></td>
				</tr>
                                <tr>
					<td><td><a href="pagina2.jsp">Cadastro</a><br> 
</td></td>
				</tr>
			</table>
			
		</form>
	</body>
</html>