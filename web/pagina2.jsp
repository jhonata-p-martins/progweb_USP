<%-- 
    Document   : pagina2
    Created on : 22/05/2014, 22:43:58
    Author     : Yago
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pagina2</title>
        <script	type="text/javascript">
			function valida(form){
				var filtro = /^.+@.+\..{3}\..{2}$/
                                if(form.email.value == "" ||form.nome.value == "" ||form.cidade.value == "" 
                                ||form.senha.value == "" ||form.confirma.value == "") {
                                    alert("Todos os campos devem ser preenchidos");
                                    return false;
                                }
                                
				if (form.senha.value.length<5 || form.senha.value.lenght>8){
					alert("Senha deve ter entre 5 e 8 caracteres");
					form.senha.focus();
					return false;	
				}
                                if(!filtro.test(form.email.value)) {
                                    alert("Login (email) invalido!");
                                    return false;
                                }
                                if (form.senha.value!=form.confirma.value){
					alert("ConfirmaÃ§Ã£o de senha deve ser igual a senha");
					form.senha.focus();
					return false;	
				}
				
			}
                        /*
                        function formatar(mascara, documento){
                          var i = documento.value.length;
                          var saida = mascara.substring(0,1);
                          var texto = mascara.substring(i)

                          if (texto.substring(0,1) != saida){
                                    documento.value += texto.substring(0,1);
                          }

                        }
                        */
                       function mascara(o,f){
                            v_obj=o
                            v_fun=f
                            setTimeout("execmascara()",1)
                        }
                        function execmascara(){
                            v_obj.value=v_fun(v_obj.value)
                        }
                        function mtel(v){
                            v=v.replace(/D/g,"");             //Remove tudo o que nÃ£o Ã© dÃ­gito
                            v=v.replace(/^(d{2})(d)/g,"($1) $2"); //Coloca parÃªnteses em volta dos dois primeiros dÃ­gitos
                            v=v.replace(/(d)(d{4})$/,"$1-$2");    //Coloca hÃ­fen entre o quarto e o quinto dÃ­gitos
                            return v;
                        }
                        function id( el ){
                                return document.getElementById( el );
                        }
                        window.onload = function(){
                                id('telefone').onkeypress = function(){
                                        mascara( this, mtel );
                                }
                        }
		</script>
    </head>
    <body>
        <center><h1>Cadastro</h1></center>
		<form onsubmit="return valida(this);" action= "ServletWeb">
			<table align="center">
				<tr>
					<td>Nome:</td><td><input type="text" name="nome" value="${userAtual.getNome()}"   ></br></td>
                                      
                                        
				</tr>
				<tr>
					<td>Cidade:</td><td><input type="text" name="cidade"   value="${userAtual.getCidade()}" ></br></td>
				</tr>
				<tr>
					<td>Estado:</td>
                                        <td>
                                            <select name="estado">
                                                <option value="AD" checked>AC</option>
                                                <option value="AL">AL</option>
                                                <option value="AP">AP</option>
                                                <option value="AM">AM</option>
                                                <option value="BA">BA</option>
                                                <option value="CE">CE</option>
                                                <option value="DF">DF</option>
                                                <option value="ES">ES</option>
                                                <option value="GO">GO</option>
                                                <option value="MA">MA</option>
                                                <option value="MT">MT</option>
                                                <option value="MS">MS</option>
                                                <option value="MG">MG</option>
                                                <option value="PA">PA</option>
                                                <option value="PB">PB</option>
                                                <option value="PR">PR</option>
                                                <option value="PE">PE</option>
                                                <option value="PI">PI</option>
                                                <option value="RJ">RJ</option>
                                                <option value="RN">RN</option>
                                                <option value="RS">RS</option>
                                                <option value="RO">RO</option>
                                                <option value="RR">RR</option>
                                                <option value="SC">SC</option>
                                                <option value="SP">SP</option>
                                                <option value="SE">SE</option>
                                                <option value="TO">TO</option>
                                            </select>
                                        </td>
				</tr>
                                <tr>
			        <td>Telefone:</td><td><input type="text" name="telefone" id="telefone" maxlength="14" value="${userAtual.getTelefone()}" /></td>
				</tr>
                                <tr>
				                                    
                                       <c:if test="${op == 0}">  
                                          <td>Login:</td><td><input type="text" name="login"></br></td>                                       
                                       </c:if> 
                                       <c:if test="${op == 1}">  
                                            <td>Login:</td><td><input type="text" name="login2"  value="${userAtual.getLogin()}" disabled="true" ></br></td>
                                            <input type="hidden" name="login" value="${userAtual.getLogin()}"/>
                                       </c:if> 
                                    
				</tr>
                                <tr>
                                    <td></td><td><c:if test="${op == 0 && flag == true}">Login ja existente</c:if></td>
                                </tr>
                                
                                
                                
                                <tr>
					<td>Senha:</td><td><input type="password" name="senha" value="${userAtual.getSenha()}"  ></br></td>
				</tr>
                                <tr>
					<td>Confirmar senha:</td><td><input type="password" name="confirma" value="${userAtual.getSenha()}" ></br></td>
				</tr>
				<tr>
                                    <c:if test="${op == 0}">  
					<td><td><input type="submit" value="Enviar"><br> 
                                        <input type="hidden" name="acao" value="cadastrar"/>
                                    </c:if>
                                    <c:if test="${op == 1}">  
					<td><td><input type="submit" value="Atualizar"><br> 
                                        <input type="hidden" name="acao" value="atualizar"/>
                                    </c:if>
</td></td>
				</tr>
                                <tr>
					<c:if test="${op == 0}">  
                                            <td><td><a href="ServletWeb?acao=voltar&page=1">Voltar</a><br> 
                                        </c:if>
                                        <c:if test="${op == 1}">  
                                            <td><td><a href="ServletWeb?acao=voltar&page=3">Voltar</a><br> 
                                        </c:if>
</td></td>
				</tr>
			</table>
			
		</form>
    </body>
</html>
