package dao;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import classes.Usuario.Tipo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO {
    private Connection connection;
    
    String url= "jdbc:postgresql://localhost:5432/banco";
    String login = "postgres";
    String senha= "postgres";
    
    public PedidoDAO(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println("Driver do PostgreSQL não instalado.");
            e.printStackTrace();
            return;
        }
        try {
            this.connection = DriverManager.getConnection(url, login, senha);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    
    public List<Pedido> listar(){
       String sql= "SELECT * FROM Pedido";
       List<Pedido> retorno = new ArrayList<>();
       
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Pedido pedido = new Pedido();
                int idPedido = resultado.getInt("id");
                
                pedido.setNumPedido(idPedido);
                pedido.setStatus(pedido.getEstadoPedidoDoId(resultado.getInt("id_estadoPedido")));
                pedido.setOrcamento(resultado.getDouble("valor"));
                pedido.setPrazo(resultado.getDate("dataAbertura"));
                
                List<Produto> produtos = new ArrayList<>();
                try{
                    String pedidoProdutoSql= "SELECT * FROM PedidoProduto WHERE FKPedido = " + idPedido;
                    PreparedStatement pedidoProdutoStmt = this.connection.prepareStatement(pedidoProdutoSql);
                    ResultSet resultadoPedidoProduto = pedidoProdutoStmt.executeQuery();
                    while (resultadoPedidoProduto.next()) {
                        int quantidade = resultadoPedidoProduto.getInt("quantidade");
                        int idProduto = resultadoPedidoProduto.getInt("id_produto");
                        try{
                            String produtoSql= "SELECT * FROM Produto WHERE id = " + idProduto;
                            PreparedStatement produtoStmt = this.connection.prepareStatement(produtoSql);
                            ResultSet resultadoProduto = produtoStmt.executeQuery();
                            Produto produto = new Produto();
                            while (resultadoProduto.next()) {
                                produto.setNumProduto(idProduto);
                                produto.setNome(resultadoProduto.getString("descricao"));
                                produto.setValor(resultadoProduto.getDouble("valor"));
                                produto.setPrazo(resultadoProduto.getDate("prazo"));
                            }
                            for (int i = 0; i < quantidade; i++) {
                                produtos.add(produto);
                            }
                        } catch (SQLException e) {
                            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                } catch (SQLException e) {
                    Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
                }
                retorno.add(pedido);
            }
        } catch (SQLException e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return retorno;
    }
    
    public boolean inserir(Pedido pedido) {
        String sql = "INSERT INTO Pedido(cpf_pessoa, id_estadoPedido, dataAbertura, valor) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, pedido.getCPF());
            stmt.setInt(2, pedido.getIdEstadoPedido());
            stmt.setDate(3, new java.sql.Date(pedido.getPrazo().getTime()));
            stmt.setDouble(4, pedido.getOrcamento());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Pedido pedido) {
        String sql = "UPDATE Pedido SET cpf_pessoa, id_estadoPedido, dataAbertura, valor WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pedido.getCPF());            
            stmt.setInt(1, pedido.getIdEstadoPedido());
            stmt.setDate(1, new java.sql.Date(pedido.getPrazo().getTime()));
            stmt.setDouble(1, pedido.getOrcamento());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM Pedido WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
