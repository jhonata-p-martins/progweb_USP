<%-- 
    Document   : pagina4
    Created on : 24/05/2014, 23:02:08
    Author     : peixe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho de Compras</title>
    </head>
    
    <body>
    <center>
    
        <h1> ${userAtual.getNome()} Seu Carinho de Compras </h1>
        
        
         
        <table border="1">
            <tr>   <td> Nome </td>  <td>  Quantidade  </td>   <td>valor </td>   <td>  </td>      </tr>
            <jsp:useBean id="carrinho" type="java.util.ArrayList" scope="session" />     
            <c:forEach items="${carrinho}" var="c" varStatus="i">
                 <tr>  <td>${c.getNome()}</td>
                       <td>${c.getQuantidade()}</td>
                       <td>${c.getValor()}</td> 
                       <td> <a href="ServletWeb?acao=remover_item_carrinho&index=${i.index}">Remover Item </td>
                </tr>        
                
           
          </c:forEach>
        </table>
         
       
        <br>
        <h5> Total = ${total_carrinho}  </h5>
        
            <br>
            <br>
        <a href="pagina3.jsp">Continuar Comprando</a> <br>
         <br>
         <br>
        
        
        
        <a href="ServletWeb?acao=finalizar_compra">Finalizar Compra</a> <br>
    
    
    
    </center>
    </body>
</html>
