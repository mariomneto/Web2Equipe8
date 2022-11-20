package classes;

import java.util.Date;

public class Pedido {
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
    private float orcamento;
    private Date prazo;
    private int numPedido;
    
    public Pedido(Status status, float orcamento, Date prazo, int numPedido) {
        this.status = status;
        this.orcamento = orcamento;
        this.prazo = prazo;
        this.numPedido = numPedido;
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

    public float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
}
