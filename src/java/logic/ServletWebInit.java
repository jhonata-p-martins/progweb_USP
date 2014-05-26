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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.User;

/**
 *
 * @author peixe
 */
//@WebServlet(name = "ServletWebInit", urlPatterns = {"/ServletWebInit"})
public class ServletWebInit extends HttpServlet {

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

        HttpSession session = request.getSession();
        String url = "pagina1.jsp";
        
        // criando usuários 
        ArrayList<User> users = new ArrayList();        
        users.add(new User("admin", "sanca", "SP", "(16)9929-2999", "admin@usp.br", "admin123", true));
        users.add(new User("peixinhu", "sanca", "SP", "(16)9924-2424", "peixe@gluglu.com", "242424", false));
        
        session.setAttribute("usersList", users);
        session.setAttribute("flag", true);
        
     
        
        
        
        /*Product( String nome, 
             String categoria,
             float  valor,
             int    qtd,
             Object foto,
             String status 
             )*/
    
        // cria lista de produtos
        ArrayList<Product> listProd = new ArrayList();        
        listProd.add(new Product("Shampoo", "Higiene", 12, 10, null, "disponivel"));
        listProd.add(new Product("Sabonete", "Higiene", 2.99f, 2, null, "disponivel"));
        listProd.add(new Product("Absorvente", "Higiene", 4.99f, 0, null, "disponivel"));
        listProd.add(new Product("Arroz", "Alimento", 9.99f, 5, null, "finalizado"));
        session.setAttribute("productList", listProd);
        
        
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
