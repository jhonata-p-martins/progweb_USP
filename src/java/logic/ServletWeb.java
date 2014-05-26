/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CarrinhoCompras;
import model.Product;
import model.User;

/**
 *
 * @author jhonata
 */
public class ServletWeb extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "";
        String acao;
        
        
        HttpSession session = request.getSession();
        ArrayList<User> listaUsers = (ArrayList<User>)session.getAttribute("usersList");
        acao = (String) request.getParameter("acao");
        
        //acao para verificar login do usuario
        if(acao.equals("login"))
        {
            String login = (String) request.getParameter("login");
            String senha = (String) request.getParameter("senha");
            boolean flag = false;
            for(User u : listaUsers)
            {
                if(u.getLogin().equals(login) && u.getSenha().equals(senha))
                {
                    // cada vez q um user entrar um carinho de compra eh associado a ele
                    url = "pagina3.jsp";
                    CarrinhoCompras car = new CarrinhoCompras(u);
                 
                     
                    car.getItens().add( new Product("chocolate", "gostosuras",5.99f,1,null,"comprado") );
                    car.getItens().add( new Product() );
                    
                    session.setAttribute("userAtual", u);
                    session.setAttribute("carrinho", car.getItens());
                    
                    
                    flag = true;
                    break;
                }
            }
            if(!flag)
            {
                session.setAttribute("flag", flag);
                url = "pagina1.jsp";
            }
            
        }        
        else 
        if(acao.equals("cadastrar")) 
        {   // desnecessario mas nao sei como tratar em acessos concorrentes
            //session.setAttribute("op", 0); 
            User newUser = new User(); 
            session.setAttribute("userAtual", newUser); 
            session.setAttribute("op", 0); 
            url="pagina2.jsp";
        }
        else 
        if(acao.equals("carrinho_compras")) 
        {            
           
            url="pagina4.jsp";
        } else 
        if(acao.equals("atualizar_dados")) 
        {   // desnecessario mas nao sei como tratar em acessos concorrentes
            session.setAttribute("op", 1);            
            url="pagina2.jsp";
        }else 
        if(acao.equals("cadastro_produto")) 
        {   // desnecessario mas nao sei como tratar em acessos concorrentes
                        
            url="pagina6.jsp";
        }else 
        if(acao.equals("estoque")) 
        {   // desnecessario mas nao sei como tratar em acessos concorrentes
            session.setAttribute("op", 1);            
            url="pagina7.jsp";
        }    
        else 
        if(acao.equals("logout")) 
        {   // desnecessario mas nao sei como tratar em acessos concorrentes
           // session.invalidate();
            url="pagina1.jsp";
        }else 
        if(acao.equals("finalizar_compra")) 
        {  // float total=0;
           // User atual;
          //  atual = (User)session.getAttribute("userAtual");
           // for(Product aux : atual.getCarrinhoCompras() )
            // total+= aux.getValor();
            
            
            url="pagina1.jsp";
        } 
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    
        
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
