/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.PedidoDAO;
import java.util.List;
import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import java.util.List;



/**
 *
 * @author T-GAMER
 */
public class ClienteFacade {
    ClienteDAO clientedao= new ClienteDAO();
    ProdutoDAO produtodao= new ProdutoDAO();
    PedidoDAO pedidodao= new PedidoDAO();
    
    
   public List <Cliente> listarClientes(){
        return clientedao.listar();
    }
   public Cliente buscarCliente(String CPF){
       return clientedao.buscar(CPF);
   }
   public void adicionarCliente(Cliente cliente){
       clientedao.adicionar(cliente);
   }
   public void atualizarCliente(Cliente cliente){
       clientedao.atualizar(cliente);
   }
   public void removerCliente(String CPF){
       clientedao.remover(CPF);  
   }
   
   public List<Produto> listarProdutos(){
       return produtodao.listar();
   }
   public Produto buscarProduto(int id){
      return produtodao.buscar(id);
   }
   public void adicionarProduto(Produto produto){
       produtodao.adicionar(produto);
   }
   public void atualizarProduto(Produto produto){
       produtodao.atualizar(produto);
   }
   public void removerProduto(int id){
        produtodao.remover(id);
   }
   
   public List<Pedido> listarPedidos(){
       return pedidodao.listar();
   }
   public Pedido buscarPedido(int id){
      return pedidodao.buscar(id);
   }
   public int adicionarPedido(Pedido pedido){
       return pedidodao.adicionar(pedido);
   }
   public void atualizarPedido(Pedido pedido){
       pedidodao.atualizar(pedido);
   }
   public void removerPedido(int id){
       pedidodao.remover(id);
   }
   
}