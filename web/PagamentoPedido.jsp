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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<fmt:setLocale value="pt-BR" />
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
          <c:choose>
           <c:when test="${not empty sessionScope.login}">
               <a class=navbar-brand href=#><c:out value="${sessionScope.login}" /></a>
                </c:when>
           <c:otherwise>
               <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o Sistema"/>
                </jsp:forward>
                </c:otherwise>
       </c:choose>
    </head>
     <%@include  file="navbar.jsp" %>
     <c:choose>
      <c:when test='${not empty requestScope ["pedido"]}'>
       <c:set var="pedido" value='${requestScope ["pedido"]}'/>  
        <title>Pagamento Pedido</title>
            <div class="container-md">
             <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="row m-0">
                 <div class="col-lg-6 pb-5 pe-lg-5">
                    <div class="row m-0">
                        <div class="d-flex align-items-lg-start mt-0 mb-auto">
                            <p class="h2 m-0"><span class="font-weight-bolder">Detalhes do pedido</span></P>
                        </div>
                    </div>
                    <div class="col-12 p-md-5">
                        
                    <div class="row m-4 bg-light">
                        <div class="col-md-4 col-5 ps-30 pe-0 my-4">
                            <p class="font-weight-bold">Produtos</p>
                            <p class="font-weight-normal h5 text-dark"><c:forEach items="${pedido.pedidoProduto}" var="pedidos" >
                                                                            <c:out value="${pedidos.produto.nome}" /><br>
                                                                       </c:forEach>
                                <span class="ps-1"></span></p>
                        </div>
                        <div class="col-md-4 col-6  ps-30 my-4">
                            <p class="font-weight-bold">Quantidade</p>
                            <p class="font-weight-normal h5 m-0 text-info"><c:forEach items="${pedido.pedidoProduto}" var="pedido1" >
                                                                            <c:out value="${pedido1.produto.valor}" /><br>
                                                                           </c:forEach></p>
                        </div>
                        <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="font-weight-bold"></p>
                            <p class="font-weight-normal h5 m-0"></p>
                        </div>
                         <div class="col-md-4 col-6 ps-30 my-4">
                            <p class="font-weight-bold">Data de entrega</p>
                            <p class="font-weight-normal h5 m-0 text-dark"><c:out value="${pedido.prazoFormatado}"/></p>
                        </div>
                        <div class="col-md-8 col-6 ps-30 my-4">
                            <p class="font-weight-bold">Status</p>
                            <p class="font-weight-normal h5 m-1 text-dark"><c:out value="${pedido.status}"/></p>
                        </div>
                    </div>
                    </div>
                </div>
            <div class="col-lg-5 p-0 ps-lg-4">
                <div class="row m-1">
                    <div class="col-12 px-4">
                  
                        <div class="d-flex justify-content-between mb-2">
                            <p class="font-weight-bold"> Número do pedido : <c:out value="${pedido.numPedido}" /></p>
                        </div>
                        <div class="d-flex justify-content-between mb-3">
                            <p class="font-weight-bolder h2">Total:</p>
                            <div class="d-flex align-text-bottom ">
                               
                          <span class="font-weight-normal text-danger h3"><fmt:formatNumber value="${pedido.orcamento}" minFractionDigits="2" type="currency" /></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 px-0">
                        <c:url value="/ClienteServlet?action=pagarPedido&id=${pedido.numPedido}" var="url" />
                        <form action="${url}" method="post">
                        <div class="row bg-light m-0">
                            <div class="col-12 px-4 my-4">
                                <p class="font-weight-bold">Detalhes do pagamento</p>
                            </div>
                            
                            <div class="col-12 px-4">
                                <div class="d-flex  mb-4">
                                    <span class="">
                                        <p class="font-weight-bold">Número do cartão</p>
                                        <input class="form-control" type="number" name="numcard" required
                                            placeholder="1234 5678 9012 3456">
                                    </span>
                                    <div class=" w-100 d-flex flex-column align-items-end">
                                        <p class="font-weight-bold">Validade</p>
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
                                        <p class="font-weight-bold">Titular</p>
                                        <input class="form-control" type="text" name="titular"
                                            placeholder="Nome">
                                    </span>
                                    <div class="w-100 d-flex flex-column align-items-end">
                                        <p class="font-weight-bold">CVC</p>
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
 </div>
         </c:when>
         <c:otherwise>
               <jsp:forward page="index.html">
                <jsp:param name="msg" value="Erro ao verificar Pedido!"/>
                </jsp:forward>
                </c:otherwise>
         </c:choose>
       
         
        
    </body>
</html>

