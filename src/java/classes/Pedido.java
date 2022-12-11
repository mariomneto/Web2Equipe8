package classes;

import static classes.Pedido.Status.AGUARDANDO_PAGAMENTO;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Pedido {

    public Pedido() {
    }
    public enum Status {
        EM_ABERTO,
        REJEITADO,
        CANCELADO,
        RECOLHIDO,
        AGUARDANDO_PAGAMENTO,
        PAGO,
        FINALIZADO
    }
    
    private Status status;
    private double orcamento;
    private Date prazo;
    private int numPedido;
    private List<PedidoProduto> PedidoProduto;
    private PagamentoCartao pagamento;

    public PagamentoCartao getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoCartao pagamento) {
        this.pagamento = pagamento;
    }
    
     
    public List<PedidoProduto> getPedidoProduto() {
        return PedidoProduto;
    }

 
    public void setPedidoProduto(List<PedidoProduto> PedidoProduto) {
        this.PedidoProduto = PedidoProduto;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

  
    
    public Pedido(Status status, double orcamento, Date prazo, int numPedido, List<PedidoProduto> PedidoProduto, PagamentoCartao pagamento) {
        this.status = status;
        this.orcamento = orcamento;
        this.prazo = prazo;
        this.numPedido = numPedido;
        this.PedidoProduto = PedidoProduto;
        this.pagamento = pagamento;
    }
    
    public int getNum_pedido() {
        return numPedido;
    }

    public void setNum_pedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getOrcamento(){
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }
    
    public double calculaOrcamento(){
        double orc = 0.0;
        for(int i = 0 ; i < getPedidoProduto().size(); i++){
         orc = orc + getPedidoProduto().get(i).calculaValorLinha();
    }
        return orc;}

    public String getPrazo() {
            Locale brasil = new Locale("pt", "BR");
            DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, brasil);
            return f.format(prazo);
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
  
    
   
}
