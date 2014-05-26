<%-- 
    Document   : pagina4
    Created on : 24/05/2014, 23:02:08
    Author     : peixe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho de Compras</title>
    </head>
    
    <body>
    <center>
    
        <h1> ${userAtual.getNome()} Seu Carinho de Compras </h1>
        <jsp:useBean id="carrinho" type="java.util.ArrayList" scope="session" />  
        
         
        <table border="1">
            <tr><td>  ID  </td><td>  Categoria  </td><td>nome da bagaça </td><td>Valor da Bagaça </td><td> detalhes dessa bagaça</td></tr>
               <c:forEach items="${carrinho}" var="b" varStatus="i">
             
                 <c:if test="${b.getQuantidade() > 0}"> 
                    
                 <tr>  <td>${b.getId()}</td>
                       <td>${b.getCategoria()}</td>
                       <td>${b.getNome()}</td> 
                       <td>${b.getValor()}</td>
                       <td> <a href="ServletWeb?acao=detalhes_produto&id_prod=${b.getId()}">Detalhes </td>
             
                  </tr>        
                
            </c:if> 
          </c:forEach>
        </table>
         
       
        
        
        
        
        <a href="pagina3.jsp">Continuar Comprando</a> <br>
        
        
        
        
        <a href="ServletWeb?acao=finalizar_compra">Finalizar Compra</a> <br>
    
    
    
    </center>
    </body>
</html>
