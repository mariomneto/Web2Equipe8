<%-- 
    Document   : inicialCliente
    Created on : Nov 27, 2022, 2:40:56 PM
    Author     : mario
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="classes.Pedido"%>
<%@page import="classes.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <link href="../css/sb-admin-2.min.css" rel="stylesheet">
            <link href="../css/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
            
            
            <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">

            <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/jq-3.6.0/dt-1.13.1/b-2.3.3/r-2.4.0/datatables.min.css"/>
            <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/jq-3.6.0/dt-1.13.1/b-2.3.3/r-2.4.0/datatables.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

            <script type="text/javascript" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
    </head>
    <%
        Util util = new Util();
        Locale loc = new Locale("pt", "BR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        List <Pedido> pedidos = new ArrayList();
        Pedido pedido = new Pedido(Pedido.Status.EM_ABERTO, 2f, new Date(), 1);
        Pedido pedidoFinalizado = new Pedido(Pedido.Status.FINALIZADO, 2f, new Date(), 1);
        pedidos.add(pedido);
        pedidos.add(pedidoFinalizado);
        pedidos.add(pedido);
        pedidos.add(pedido);
        pedidos.add(pedidoFinalizado);
        pedidos.add(pedido);
        
        List <Pedido> pedidosFiltrados = new ArrayList();
        for (Pedido p: pedidos) {
            if (p.getStatus() == Pedido.Status.EM_ABERTO) {
                pedidosFiltrados.add(p);
            }
        }
    %>
      <%@include  file="navbar.jsp" %>
    <body class="bg-gradient-primary">
        <div class="container-fluid">
            <h1 class="h3 mb-2 text-white">Cliente</h1>

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Pedidos em Aberto</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered" id="tabela" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Número Pedido</th>
                                    <th>Valor</th>
                                    <th>Prazo</th>
                                    <th>Estado do Pedido</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for(int i = 0; i < pedidosFiltrados.size(); i++){ %>
                                    <% 
                                        int numPedido = pedidosFiltrados.get(i).getNumPedido();
                                        double orcamento = pedidosFiltrados.get(i).getOrcamento();
                                        String prazo = dateFormat.format(pedidosFiltrados.get(i).getPrazo());
                                        String status = util.traduzStatusPedido(pedidosFiltrados.get(i).getStatus()); 
                                    %>
                                    <tr>
                                        <td>#<%= numPedido %></td>
                                        <td>R$ <%= orcamento %></td>
                                        <td><%= prazo %></td>
                                        <td><%= status %></td>
                                    </tr>
                                <% }%>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Número Pedido</th>
                                    <th>Valor</th>
                                    <th>Prazo</th>
                                    <th>Status</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript" language="javascript">
            $(document).ready(function () {
                    $('#tabela').DataTable();
            });
        </script>
    </body>
</html>
