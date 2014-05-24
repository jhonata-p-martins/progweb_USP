/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.io.Serializable;
import java.util.Random;

public class User implements Serializable
{
    private int id;
    private String nome;
    private String cidade;
    private String estado;
    private String telefone;
    private String login;
    private String senha;
    private boolean isAdmin;

    
    
    public User()
    {
        Random r = new Random();
        this.id = r.nextInt(10000);
        this.nome = "";
        this.cidade = "";
        this.estado = "";
        this.telefone = "";
        this.login = "";
        this.senha = "";
        this.isAdmin = false;
    }
    
    public User(String nome, String cidade, String estado, String telefone, 
            String login, String senha, boolean is)
    {
        Random r = new Random();
        this.id = r.nextInt(10000);
        this.nome = nome.toUpperCase();
        this.cidade = cidade.toUpperCase();
        this.estado = estado.toUpperCase();
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.isAdmin = false;
    }
    
    public int getId() 
    {
        return id;
    }

//    public void setId(int id) 
//    {
//        this.id = id;
//    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getCidade() 
    {
        return cidade;
    }

    public void setCidade(String cidade) 
    {
        this.cidade = cidade;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public String getTelefone() 
    {
        return telefone;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }

    public String getLogin() 
    {
        return login;
    }

    public void setLogin(String login) 
    {
        this.login = login;
    }

    public String getSenha() 
    {
        return senha;
    }

    public void setSenha(String senha) 
    {
        this.senha = senha;
    }

    public boolean isIsAdmin() 
    {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) 
    {
        this.isAdmin = isAdmin;
    }
            
}

