<%-- 
    Document   : pagina3
    Created on : 24/05/2014, 21:52:30
    Author     : peixe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    
    <body>
    <center>
        <h1>BEM VINDO ${userAtual.getNome()} !</h1>
        <br>
        <jsp:useBean id="userAtual" type="model.User" scope="session"/>        
        <a href="ServletWeb?acao=carrinho_compras">CARRILHO DE COMPRAS (LEPO LEPO)</a> <br>
        <a href="ServletWeb?acao=atualizar_dados">EDITAR DADOS</a> <br>
         <c:if test="${userAtual.getIsAdmin() == true}">
             <a href="ServletWeb?acao=cadastro_produto">CADASTRO DE PRODUTO</a> <br>
              <a href="ServletWeb?acao=estoque">ESTOQUE</a>  <br>
         </c:if> 
        <a href="ServletWeb?acao=logout">LOGOUT</a>  <br> 
        
        
        
        <jsp:useBean id="productList" type="java.util.ArrayList" scope="session"/>
        <table border="1">
          <tr><td>  Quantidade  </td><td>  Categoria  </td><td>Nome   </td><td>Valor  </td><td> Detalhes </td></tr>
            <c:forEach items="${productList}" var="b" varStatus="i">
             
                 <c:if test="${b.getQuantidade() > 0}"> 
                   <c:if test="${b.getStatus() eq 'disponivel'}">   
                 <tr>  <td>${b.getQuantidade()}</td>
                       <td>${b.getCategoria()}</td>
                       <td>${b.getNome()}</td> 
                       <td>${b.getValor()}</td>
                       <td> <a href="ServletWeb?acao=detalhes_produto&id_prod=${i.index}">Detalhes </td>
                       
                  </tr>        
                </c:if>   
              </c:if> 
          </c:forEach>
        </table>
         
        
        
        
        
    </center>
    </body>
</html>
