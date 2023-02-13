package dao;

import classes.Cliente;
import classes.Pedido;
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

public class ClienteDAO {
    private Connection connection;
    
    String url= "jdbc:postgresql://localhost:5432/banco";
    String login = "postgres";
    String senha= "postgres";
    
    public ClienteDAO(){
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
    
    public List<Cliente> listar(){
       String sql= "SELECT * FROM Pessoa WHERE id_funcao = 1";
       List<Cliente> retorno = new ArrayList<>();
       
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                int idCliente = resultado.getInt("id");
                
                cliente.setId(idCliente);
                cliente.setCPF(resultado.getString("cpf"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setCEP(resultado.getString("cep"));
                cliente.setNumeroCasa(resultado.getInt("numeroCasa"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setSenha(resultado.getString("senha"));
                cliente.setTipoUsuario(Tipo.CLIENTE);
                
                List<Pedido> pedidos = new ArrayList<>();
                try{
                    String pedidoSql= "SELECT * FROM Pedido WHERE id_pessoa = " + idCliente;
                    PreparedStatement peditoStmt = this.connection.prepareStatement(pedidoSql);
                    ResultSet resultadoPedidos = peditoStmt.executeQuery();
                    while (resultadoPedidos.next()) {
                        Pedido pedido = new Pedido();
                        pedido.setNumPedido(resultadoPedidos.getInt("id"));
                        pedido.setStatus(pedido.getEstadoPedidoDoId(resultadoPedidos.getInt("id_estadoPedido")));
                        pedido.setPrazo(resultadoPedidos.getDate("dataAbertura"));
                        pedido.setOrcamento(resultadoPedidos.getDouble("valor"));
                        pedidos.add(pedido);
                    }
                } catch (SQLException e) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
                }
                
                cliente.setPedidos(pedidos);
                retorno.add(cliente);
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return retorno;
    }
    
    public boolean inserir(Cliente cliente) {
        String sql = "INSERT INTO Pessoa(CPF, email, cep, numeroCasa, telefone, nome, id_funcao, senha) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, cliente.getCPF());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCEP());
            stmt.setInt(4, cliente.getNumeroCasa());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getNome());
            stmt.setInt(7, cliente.getIdFuncao());
            stmt.setString(8, cliente.getSenha());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Cliente cliente) {
        String sql = "UPDATE Pessoa SET CPF, email, cep, numeroCasa, telefone, nome, id_funcao, senha WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getCPF());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCEP());
            stmt.setInt(4, cliente.getNumeroCasa());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getNome());
            stmt.setInt(7, cliente.getIdFuncao());
            stmt.setString(8, cliente.getSenha());
            stmt.setInt(9, cliente.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM Pessoa WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
