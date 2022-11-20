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
    
    int num_pedido;
    Status status;
    float orcamento;
    Date prazo;
}
