package classes;

import java.util.List;

public class Funcionario extends Usuario {
    private List<Pedido> pedidos;
    
    public Funcionario (String CPF, String nome, String email, String endereco, String telefone, String senha, List<Pedido> pedidos) {
        super(CPF, nome, email, endereco, telefone, senha, Tipo.FUNCIONARIO);
        this.pedidos = pedidos;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}