/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author peixe
 */
public class Product implements Serializable {
    private int id;
    private String nome; 
    private String categoria;
    private float valor;
    private int quantidade;
    private Object foto; 
    private String status;
    
    public Product(){
    Random r = new Random();
    id = r.nextInt(10000);
    nome="";
    categoria= "";
    valor =0;
    quantidade=0;
    foto = null; 
    status="";
    
    }
    public Product( String nome, 
             String categoria,
             float  valor,
             int    qtd,
             Object foto,
             String status 
             )
    {
    Random r = new Random();
    this.id =r.nextInt(10000);
    this.nome=nome;
    this.categoria= categoria;
    this.valor = valor;
    this.quantidade=qtd;
    this.foto =null;
    this.status=status;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getFoto() {
        return foto;
    }

    public void setFoto(Object foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
