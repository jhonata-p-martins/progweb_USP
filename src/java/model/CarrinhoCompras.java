/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author peixe
 */
public class CarrinhoCompras  implements Serializable{
         private User user; 
         private ArrayList<Product> itens;

         
         public CarrinhoCompras()
         { this.user= null;
           this.itens =  new ArrayList();
         }
         
         
        public CarrinhoCompras(User user )
        { this.user = user;
          this.itens = new ArrayList();
          this.itens.add(new Product("chocolate", "gostosuras",5.99f,1,null,"comprado") ); 
        }        
         
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Product> itens) {
        this.itens = itens;
    }
         
         
         
         
         
}
