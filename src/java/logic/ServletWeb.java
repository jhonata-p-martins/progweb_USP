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




public class ServletWeb extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "";
        String acao;
        
        
        HttpSession session = request.getSession();
        ArrayList<User> listaUsers = (ArrayList<User>)session.getAttribute("usersList");
        
        
        // se nao existir nenhum carrinho associa o mesmo ao usuário atual 
         ArrayList<Product> carrinho = (ArrayList)session.getAttribute("carrinho");
                   if( carrinho == null)
                   { carrinho= new ArrayList();
                     session.setAttribute("carrinho", carrinho);
                   }  
        
        
        // cria lista de produtos
        ArrayList<Product> listProd =  (ArrayList)session.getAttribute("productList");
                   
        
        
        
        
        
        
                   
        acao = (String) request.getParameter("acao");
        
        //acao para verificar login do usuario
         if (acao.equals("login")) {
            String login = (String) request.getParameter("login");
            String senha = (String) request.getParameter("senha");
            boolean flag = false;
            for (User u : listaUsers) {
                if (u.getLogin().equals(login) && u.getSenha().equals(senha)) 
                {
                    // cada vez q um user entrar um carinho de compra eh associado a ele
                    url = "pagina3.jsp";
                    
                    session.setAttribute("userAtual", u);
                    
                    
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                session.setAttribute("flag", flag);
                url = "pagina1.jsp";
            }
            session.setAttribute("usersList", listaUsers);
        
        
        } else 
        if (acao.equals("cadastro")) {   // desnecessario mas nao sei como tratar em acessos concorrentes
            //session.setAttribute("op", 0); 
            User newUser = new User();
            session.setAttribute("userAtual", newUser);
            session.setAttribute("flag", false);
            session.setAttribute("op", 0);
            url = "pagina2.jsp";
        
        
        }
        else
        if (acao.equals("cadastrar")) {
            String login = (String) request.getParameter("login");
            boolean flag = false;
            for (User u : listaUsers) {
                if (u.getLogin().equals(login)) {
                    flag = true;
                    break;
                }
            }

            String nome = (String) request.getParameter("nome");
            String cidade = (String) request.getParameter("cidade");
            String estado = (String) request.getParameter("estado");
            String telefone = (String) request.getParameter("telefone");
            String senha = (String) request.getParameter("senha");
            User u = new User(nome, cidade, estado, telefone, login, senha, false);

            if (!flag) {
                listaUsers.add(u);
                session.setAttribute("usersList", listaUsers);
//                session.setAttribute("userAtual", u);
                url = "pagina1.jsp";
            } else {
                session.setAttribute("flag", true);
                session.setAttribute("userAtual", u);
                url = "pagina2.jsp";
            }
        
        
        
        }
        // pagina 3 
        else 
        if(acao.equals("carrinho_compras")) 
        {   
            session.setAttribute("total_carrinho", CalcTotalCarrinho(carrinho));
            url="pagina4.jsp";
        
        
        }
        else 
        if(acao.equals("atualizar_dados")) 
        {   // desnecessario mas nao sei como tratar em acessos concorrentes
            session.setAttribute("op", 1);            
            url="pagina2.jsp";
        
        
        }
         else 
         if (acao.equals("atualizar")) {
            String login = (String) request.getParameter("login");
            String nome = (String) request.getParameter("nome");
            String cidade = (String) request.getParameter("cidade");
            String estado = (String) request.getParameter("estado");
            String telefone = (String) request.getParameter("telefone");
            String senha = (String) request.getParameter("senha");
            for (int i = 0; i < listaUsers.size(); i++) {
                if (listaUsers.get(i).getLogin().equals(login)) {
                    User u = new User(nome, cidade, estado, telefone, login, senha, listaUsers.get(i).getIsAdmin());
                    session.setAttribute("userAtual", u);
                    listaUsers.set(i, u);
                    break;
                }
            }
            session.setAttribute("usersList", listaUsers);
            url = "pagina3.jsp";
        
         
         }
        else
        if(acao.equals("detalhes_produto"))
        {  int index = Integer.parseInt(request.getParameter("id_prod"));
             
           session.setAttribute("currentProd",   listProd.get(index) );
           session.setAttribute("index",   index );
           url="pagina5.jsp";
        
        
        }    
         // pagina 3 opcional para administrador
        else 
        if(acao.equals("cadastro_produto")) 
        {                       
            url="pagina6.jsp";
        }else 
        if(acao.equals("estoque")) 
        {  session.setAttribute("op", 1);            
            url="pagina7.jsp";
        }    
        else 
        if(acao.equals("logout")) 
        {  session.setAttribute("flag", true);
            url="pagina1.jsp";
        }
        // pagina 4  CARRINHO DE COMPRAS 
        else 
        if(acao.equals("finalizar_compra")) 
        {   
            
            url="pagina1.jsp";
        }else if (acao.equals("voltar")) {
            String page = request.getParameter("page");
            url = "pagina" + page + ".jsp";
        }else 
        if(acao.equals("remover_item_carrinho")) 
        {
            int index = Integer.parseInt(request.getParameter("index"));
            
            
            boolean flag=false;
            for(int i=0; i< listProd.size(); i++)
            {   
                if (listProd.get(i).getNome().equals(carrinho.get(index).getNome()  )  )
                { listProd.get(i).setQuantidade(  ( listProd.get(i).getQuantidade() + carrinho.get(index).getQuantidade())      );
                  flag = true;
                }
            }    
            if( !flag)
            listProd.add(  carrinho.get(index) ) ;
            
            
            
            
            carrinho.remove(index);
            session.setAttribute("total_carrinho", CalcTotalCarrinho(carrinho));           
            url="pagina4.jsp";
        } 
        else 
        if(acao.equals("add_prod_carrinho")) 
        {
            boolean flag=false;
            int id_prod = Integer.parseInt(request.getParameter("id_prod_add"));
            int qtd = Integer.parseInt(request.getParameter("qtd"));
            Product aux =  listProd.get(id_prod).vendaProduto(qtd); 
            Product aux1;
            // verificamos se produto jah existe no carrinho para apenas somar Qtd
            for(int i=0; i< carrinho.size(); i++)
            {   aux1= carrinho.get(i);
                if (aux1.getNome().equals(aux.getNome()) )
                { carrinho.get(i).setQuantidade(  (carrinho.get(i).getQuantidade()+qtd)      );
                  flag = true;
                }
            }    
            if( !flag)
            carrinho.add(  aux   ) ;
                    
            url="pagina3.jsp";
        } 
        
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    
       private float CalcTotalCarrinho( ArrayList<Product> c)
        {   float total=0;
            for(Product aux : c)
               total+= aux.getValor()* aux.getQuantidade(); 
            return total;
        
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
