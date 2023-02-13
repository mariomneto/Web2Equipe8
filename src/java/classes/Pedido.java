package classes;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Pedido implements Serializable{

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
    private String CPF;

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

    public Pedido(Status status, double orcamento, Date prazo, int numPedido) {
        this.status = status;
        this.orcamento = orcamento;
        this.prazo = prazo;
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

    public Date getPrazo(){
         return prazo;
     }
    public String getPrazoFormatado() {
            Locale brasil = new Locale("pt", "BR");
            DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, brasil);
            return f.format(prazo);
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
    
    public int getIdEstadoPedido() {
        switch (this.status) {
            case EM_ABERTO:
                return 1;
            case REJEITADO:
                return 2;
            case CANCELADO:
                return 3;
            case RECOLHIDO:
                return 4;
            case AGUARDANDO_PAGAMENTO:
                return 5;
            case PAGO:
                return 6;
            case FINALIZADO:
                return 7;
        }
        
        return 0;
    }
    
    public Status getEstadoPedidoDoId(int id) {
        switch (id) {
            case 1:
                return Status.EM_ABERTO;
            case 2:
                return Status.REJEITADO;
            case 3:
                return Status.CANCELADO;
            case 4:
                return Status.RECOLHIDO;
            case 5:
                return Status.AGUARDANDO_PAGAMENTO;
            case 6:
                return Status.PAGO;
            case 7:
                return Status.FINALIZADO;
            default: 
                return Status.EM_ABERTO; 
        }
         
    }
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
   
}
