package classes;


public class Util {
    public Util (){
        
    }
    
    public String traduzStatusPedido (Pedido.Status status) {
        switch (status) {
            case EM_ABERTO:
                return "Em Aberto";
            case REJEITADO:
                return "Rejeitado";
            case CANCELADO:
                return "Cancelado";
            case RECOLHIDO:
                return "Recolhido";
            case AGUARDANDO_PAGAMENTO:
                return "Aguardando Pagamento";
            case PAGO:
                return "Pago";
            case FINALIZADO:
                return "Finalizado";
            default: 
                return "";
        }
    } 
}
