<%-- 
    Document   : listagemPedidoTabela
    Created on : 2 de dez. de 2022, 15:19:15
    Author     : edu__
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/sb-admin-2.min.css">
        <link rel="stylesheet" href="../css/listagemPedido.css">
        <script src="listagemPedido.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/jq-3.6.0/dt-1.13.1/b-2.3.3/r-2.4.0/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/jq-3.6.0/dt-1.13.1/b-2.3.3/r-2.4.0/datatables.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

        <script type="text/javascript" src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
    </head>
    <body class="bg-gradient-primary">
        <div class="container-fluid">
            <h1 class="h3 mb-2 text-white">Cliente</h1>
            
            <div class="card shadow mb-4">
                <div class="card-body p-0 my-auto text-truncate">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Histórico de Pedidos</h6>
                    </div>
                    <div class="card-body">
                        <div class="card-body">
                            <p>Filtrar pedidos: 
                                <button class="btn btn-warning " id="ab">Em Aberto</button>
                                <button class="btn btn-danger" id="can">Cancelados</button>
                                <button class="btn btn-dark " id="rec">Recolhido</button>
                                <button class="btn btn-info "id="apag">Aguardando Pagamento</button>
                                <button class="btn btnPago" id="pag">Pago</button>

                                <button class="btn btn-success ">Finalizado</button>


                            </p>


                            <table id="tabela" class="table table-striped table-bordered" style="width:100%">

                                        <thead>
                                                <tr>
                                                        
                                        <th>Numero do Pedido</th>
                                                        <th>Itens</th>
                                                        <th>Estado do Pedido</th>
                                                        <th>Valor</th>
                                        <th>Prazo</th>
                                                        <th>Cancelar (caso Em Aberto)</th>
                                                    </tr>
                                            </thead>
                                        <tbody>
                                                <tr>
                                                        <td>#1</td>
                                                        <td>Calça</td>
                                                        <td>Em Aberto</td>
                                                        <td>7,00</td>
                                                        <td>2011-04-25</td>
                                                        <td><button type="button" class="btn btn-danger" id="botao" data-bs-toggle="modal" data-bs-target="#modalCancelar">Cancelar</button></td>
                                                    </tr>
                                                <tr>
                                                        <td>#3</td>
                                                        <td>Camiseta</td>
                                                        <td>Finalizado</td>
                                                        <td>5,00</td>
                                                        <td>2011-07-25</td>
                                                        <td></td>
                                                    </tr>
                                                <tr>
                                                        <td>#6</td>
                                                        <td>Cueca</td>
                                                        <td>Cancelado</td>
                                                        <td>100,00</td>
                                                        <td>2009-01-12</td>
                                                        <td></td>
                                                    </tr>
                                                <tr>
                                                        <td>#7</td>
                                                        <td>Calça, Meia</td>
                                                        <td>Rejeitado</td>
                                                        <td>15,00</td>
                                                        <td>2012-03-29</td>
                                                        <td></td>
                                                    </tr>
                                                <tr>
                                                        <td>#9</td>
                                                        <td>Meia</td>
                                                        <td>Recolhido</td>
                                                        <td>3,00</td>
                                                        <td>2008-11-28</td>
                                                        <td></td>
                                                    </tr>
                                                
                                            </tbody>
                                        <tfoot>
                                                <tr>
                                                          <th>Numero do Pedido</th>
                                                        <th>Itens</th>
                                                        <th>Estado do Pedido</th>
                                                        <th>Valor</th>
                                        <th>Prazo</th>
                                                        <th>Cancelar (caso Em Aberto)</th>
                                                    </tr>
                                            </tfoot>
                                    </table>
                            </tr></tbody>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Button trigger modal -->

        <!-- Modal -->
        <div class="modal fade" id="modalCancelar" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLongTitle">Cancelar Pedido</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Deseja Cancelar o pedido selecionado em aberto?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Retornar</button>
                        <button type="button" class="btn btn-danger">Cancelar Pedido</button>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" language="javascript">
            $(document).ready(function () {
                    $('#tabela').DataTable();
            });
        </script>

        <script type="text/javascript" language="javascript">
            $('#modalCancelar').on('shown.bs.modal', function () {
                $('#botao').trigger('focus');
            });
        </script>
    </body>
</html>
