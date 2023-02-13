package classes;

import java.io.Serializable;
import java.util.List;

public class Funcionario extends Usuario implements Serializable{
    private List<Pedido> pedidos;
    
    public Funcionario(){
        
    }
    public Funcionario (String CPF, String nome, String email, String CEP, int numeroCasa, String telefone, String senha, List<Pedido> pedidos) {
        super(CPF, nome, email, CEP, numeroCasa, telefone, senha, Tipo.FUNCIONARIO);
        this.pedidos = pedidos;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}