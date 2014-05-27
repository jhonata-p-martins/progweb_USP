
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
    <jsp:useBean id="currentProd" type="model.Product" scope="session" />
    <h1>  Detalhes Produto ${currentProd.getNome()} </h1>  
        
    <form action="ServletWeb?acao=add_prod_carrinho&id_prod_add=${index}" method="post" >
    <table border="1">
          <tr>   
               <td>Nome </td>  
               <td>Categoria</td>   
               <td>Valor</td> 
               <td> Qua </td>
               <td> Status</td>
          </tr>
          
          <tr>   
              <td>${currentProd.getNome()}</td>
              <td>${currentProd.getCategoria()}</td>   
              <td>${currentProd.getValor()}</td> 
              <td> 
                  <input type="number" min="0" max="${currentProd.getQuantidade()}" value="0" name="qtd" maxlength="1"/> 
                          
                </td>
              <td> ${currentProd.getStatus()}</td>
          </tr>
            
               
          
    </table>          
          <br> <input type="submit" value="Comprar"/>      
     </form>
     <br>
     <br>
      
     <br>
     <a href="pagina3.jsp">Voltar </td>
          
                
                
          
          
            </center>
    </body>
</html>
