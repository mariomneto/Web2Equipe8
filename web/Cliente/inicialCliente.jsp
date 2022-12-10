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
    <body>
        
        <div class="container-fluid">
            <h1 class="h3 mb-2 text-gray-800">Página Inicial: Cliente</h1>

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Pedidos em Aberto</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Número Pedido</th>
                                    <th>Orçamento</th>
                                    <th>Prazo</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for(int i = 0; i < pedidosFiltrados.size(); i++){ %>
                                    <% 
                                        int numPedido = pedidosFiltrados.get(i).getNumPedido();
                                        float orcamento = pedidosFiltrados.get(i).getOrcamento();
                                        String prazo = dateFormat.format(pedidosFiltrados.get(i).getPrazo());
                                        String status = util.traduzStatusPedido(pedidosFiltrados.get(i).getStatus()); 
                                    %>
                                    <tr>
                                        <td><%= numPedido %></td>
                                        <td>R$ <%= orcamento %></td>
                                        <td><%= prazo %></td>
                                        <td><%= status %></td>
                                    </tr>
                                <% }%>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Número Pedido</th>
                                    <th>Orçamento</th>
                                    <th>Prazo</th>
                                    <th>Status</th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="../css/jquery/jquery.min.js"></script>
        <script src="../css/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="../css/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="../js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="../css/datatables/jquery.dataTables.min.js"></script>
        <script src="../css/datatables/dataTables.bootstrap4.min.js"></script>
    </body>
</html>
