/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Produto implements Serializable{
    private int numProduto;
    private String nome;
    private double valor;
    private Date prazo; 
    
    public Produto (){
    }

    public int getNumProduto() {
        return numProduto;
    }

    public void setNumProduto(int numProduto) {
        this.numProduto = numProduto;
    }

    public Produto(int numProduto, String nome, double valor, Date prazo) {
        this.numProduto= numProduto;
        this.nome = nome;
        this.valor = valor;
        this.prazo = prazo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPrazo() {
            Locale brasil = new Locale("pt", "BR"); 
            DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, brasil);
            return f.format(prazo);
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }


}
