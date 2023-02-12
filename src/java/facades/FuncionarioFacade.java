/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facades;

import classes.Funcionario;
import classes.Pedido;
import classes.Produto;
import java.util.List;
import dao.ProdutoDAO;
import dao.PedidoDAO;

/**
 *
 * @author T-GAMER
 */
public class FuncionarioFacade {
    ProdutoDAO produtodao = new ProdutoDAO();
    FuncionarioDAO funcionariodao = new FuncionarioDAO();
    PedidoDAO pedidodao = new PedidoDAO();
    
   public List<Funcionario> listarFuncionarios(){
        return funcionariodao.listar();
   }
   public Funcionario buscarFuncionario(int id){
        return funcionariodao.buscar(id);
   }
   public void adicionaFuncionario(Funcionario funcionario){
       funcionariodao.adicionar(funcionario);
   }
   public void atualizarFuncionario(Funcionario funcionario){
       funcionariodao.atualizar(funcionario);
   }
   public void removerFuncionario(int id){
       funcionariodao.remover(id);
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
   public List<Pedido> listarPedidoStatus(String status){
      return pedidodao.buscar(status);
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
