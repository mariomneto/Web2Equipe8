package dao;

import classes.Funcionario;
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

public class FuncionarioDAO {
    private Connection connection;
    
    String url= "jdbc:postgresql://localhost:5432/banco";
    String login = "postgres";
    String senha= "postgres";
    
    public FuncionarioDAO(){
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
    
    public List<Funcionario> listar(){
       String sql= "SELECT * FROM Pessoa WHERE id_funcao = 2";
       List<Funcionario> retorno = new ArrayList<>();
       
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();
                int idFuncionario = resultado.getInt("id");
                
                funcionario.setId(idFuncionario);
                funcionario.setCPF(resultado.getString("cpf"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setCEP(resultado.getString("cep"));
                funcionario.setNumeroCasa(resultado.getInt("numeroCasa"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setSenha(resultado.getString("senha"));
                funcionario.setTipoUsuario(Tipo.FUNCIONARIO);
                
                List<Pedido> pedidos = new ArrayList<>();
                try{
                    String pedidoSql= "SELECT * FROM Pedido";
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
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
                }
                
                funcionario.setPedidos(pedidos);
                retorno.add(funcionario);
            }
        } catch (SQLException e) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return retorno;
    }
    
    public boolean inserir(Funcionario funcionario) {
        String sql = "INSERT INTO Pessoa(CPF, email, cep, numeroCasa, telefone, nome, id_funcao, senha) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getCPF());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getCEP());
            stmt.setInt(4, funcionario.getNumeroCasa());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getNome());
            stmt.setInt(7, funcionario.getIdFuncao());
            stmt.setString(8, funcionario.getSenha());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Funcionario funcionario) {
        String sql = "UPDATE Pessoa SET CPF, email, cep, numeroCasa, telefone, nome, id_funcao, senha WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getCPF());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getCEP());
            stmt.setInt(4, funcionario.getNumeroCasa());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getNome());
            stmt.setInt(7, funcionario.getIdFuncao());
            stmt.setString(8, funcionario.getSenha());
            stmt.setInt(9, funcionario.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
