/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author T-GAMER
 */
public class PedidoProduto implements Serializable {
    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public PedidoProduto(){
        
    }
    public PedidoProduto(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public int adicionaQuantidade(){
        return quantidade = quantidade + 1;
    }
    
    public int reduzQuantidade(){
        return quantidade = quantidade - 1;
    }
      public double calculaValorLinha(){
        double valor = 0.0;
        valor  = getProduto().getValor() * getQuantidade();
        return valor;
    }
}
