<%-- 
    Document   : PagamentoPedido
    Created on : 10 de dez. de 2022, 20:37:42
    Author     : T-GAMER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.lang.String"%>
<%@ page import="classes.Pedido"%>
<%@ page import=" static classes.Pedido.Status"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <html>
    <head>
        <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
        <link href="resource/bootstrap/css/estilopay.css" rel="stylesheet">
        <link href="resource/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
        <%@include  file="navbar.jsp" %>
      <% HttpSession sess = request.getSession(false);
     ArrayList<Pedido> list = (ArrayList<Pedido>) sess.getAttribute("list");
        for(Pedido pedido : list){ %> 
        <title>Pagamento Pedido</title>
        <div class="container">
        <div class="row m-0">
            <div class="col-lg-7 pb-5 pe-lg-5">
                <div class="row">
                    <div class="col-12 p-5">
                    </div>
                    <div class="row m-5 bg-light">
                        <div class="col-md-4 col-6 ps-30 pe-0 my-4">
                            <p class="text-muted">Produtos</p>
                            <p class="h5"><%    for(int i = 0 ; i < pedido.getPedidoProduto().size(); i++){
                                                out.println(pedido.getPedidoProduto().get(i).getProduto().getNome() + "<br>");
                                             } %>
                                <span class="ps-1"></span></p>
                        </div>
                        <div class="col-md-4 col-6  ps-30 my-4">
                            <p class="text-muted">Quantidade</p>
                            <p class="h5 m-0"><% for(int i = 0 ; i < pedido.getPedidoProduto().size(); i++){
                                                    out.println (pedido.getPedidoProduto().get(i).getQuantidade() +" <br>");  }
                                             %></p>
                        </div>
                        <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="text-muted">Data de entrega</p>
                            <p class="h5 m-0"><%out.println(pedido.getPrazoFormatado()); %></p>
                        </div>
                        <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="text-muted">Status</p>
                            <p class="h5 m-0"><% out.println(pedido.getStatus()); %></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-5 p-0 ps-lg-4">
                <div class="row m-0">
                    <div class="col-12 px-4">
                        <div class="d-flex align-items-end mt-4 mb-2">
                            <p class="h4 m-0"><span class="pe-1">Pedido</span>
                        </div>
                        <div class="d-flex justify-content-between mb-2">
                            <p class="textmuted"> Número do pedido : <%  out.println(pedido.getNumPedido()); %></p>
                        </div>
                        <div class="d-flex justify-content-between mb-3">
                            <p class="textmuted fw-bold">Total</p>
                            <div class="d-flex align-text-top ">
                          <span class="h4"><% out.println(pedido.getOrcamento() + "R$"); %></span>
                            </div>
                        </div>
                    </div><% } %>
                    <div class="col-12 px-0">
                        <form action= "PagamentoPedidoServlet" method="post">
                        <div class="row bg-light m-0">
                            <div class="col-12 px-4 my-4">
                                <p class="fw-bold">Detalhes do pagamento</p>
                            </div>
                            
                            <div class="col-12 px-4">
                                <div class="d-flex  mb-4">
                                    <span class="">
                                        <p class="text-muted">Número do cartão</p>
                                        <input class="form-control" type="number" name="numcard" required
                                            placeholder="1234 5678 9012 3456">
                                    </span>
                                    <div class=" w-100 d-flex flex-column align-items-end">
                                        <p class="text-muted">Validade</p>
     <select name="mes" id=""  class="custom-select" required>
        <option value="">Mês</option> 
        <option value="01">01</option>
        <option value="02">02</option>
        <option value="03">03</option>
        <option value="04">04</option>
        <option value="05">05</option>
        <option value="06">06</option>
        <option value="07">07</option>
        <option value="08">08</option>
        <option value="09">09</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
    </select>
     <select name="ano" id="" class="custom-select" required>
        <option value="">Ano</option>
        <option value="2022">2022</option>
        <option value="2023">2023</option>
        <option value="2024">2024</option>
        <option value="2025">2025</option>
        <option value="2026">2026</option>
        <option value="2027">2027</option>
        <option value="2028">2028</option>
        <option value="2029">2029</option>
        <option value="2030">2030</option>
     </select>
                                    </div>
                                </div>
                                <div class="d-flex mb-5">
                                    <span class="me-5">
                                        <p class="text-muted">Titular</p>
                                        <input class="form-control" type="text" name="titular"
                                            placeholder="Nome">
                                    </span>
                                    <div class="w-100 d-flex flex-column align-items-end">
                                        <p class="text-muted">CVC</p>
                                        <input class="form-control" type="text" maxlength="3" name="cvc" placeholder="3 digitos finais" pattern="[0-9]{3}" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row m-0">
                            <div class="col-12  mb-4 p-0">
                                <button class="btn btn-primary" type="submit">Pagar<span class="fas fa-arrow-right ps-2"></span></button>  
                            </div>
                       </div>
                   </form></div>
               </div>
            </div>
        </div>
    </div>

         
        
    </body>
</html>
