<%-- 
    Document   : ConsultaPedido
    Created on : 10 de dez. de 2022, 20:36:54
    Author     : T-GAMER
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.String"%>
<%@ page import="classes.Pedido"%>
<%@ page import=" static classes.Pedido.Status.AGUARDANDO_PAGAMENTO"%>
<%@ page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<c:url value="$" var="base"/>

<!DOCTYPE html>

<html>
    <head>
        <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
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
        <title>Consulta Pedido</title>
        <div>
          <form action= "ClienteServlet?action=consultarPedido" method="post"  class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 text-dark">
              <h2 class="font-weight-bold"> Consultar Pedido </h2>
              <div class="input-group">
                            <input type="number" name="pesquisapedido" class="form-control-lg bg-light border-0 small" placeholder="Insira o número do pedido"
                                aria-label="Search" aria-describedby="basic-addon2" required >
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit" value="Consultar">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
              </div>
          </form></div>
       <c:if test='${ not empty requestScope["consultaPedido"]}' >   
               <c:set var="pedido" value='${requestScope["consultaPedido"]}'/>  
        <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-dark">Pedido</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Número Pedido</th>
                                            <th>Produtos</th>
                                            <th>Valor Unitário</th>
                                            <th>Quantidade</th>
                                            <th>Data de Entrega</th>
                                            <th>Status</th>
                                            <th>Valor Total</th>
                                        </tr>
                                    </thead>
                         <tbody>
                                        <tr> <tr>
                                        <tr> 
                                            <td><c:out value="${pedido.numPedido}" /></td>
                                            <td><c:forEach items="${pedido.pedidoProduto}" var="pedidos" >
                                                    <c:out value="${pedidos.produto.nome}" /><br>
                                                      </c:forEach>
                                          </td>
                                            <td><c:forEach items="${pedido.pedidoProduto}" var="pedido1" >
                                                    <c:out value="${pedido1.produto.valor}" /><br>
                                            </c:forEach>
                                               </td>
                                            <td><c:forEach items="${pedido.pedidoProduto}" var="pedido2" >
                                                <c:out value="${pedido2.quantidade}" /><br>
                                            </c:forEach>
                                                  </td>
                                            <td><c:out value="${pedido.prazoFormatado}"/></td>
                                            <td><c:out value="${pedido.status}"/></td>
                                            <fmt:setLocale value="pt-BR" />
                                            <td><fmt:formatNumber value="${pedido.orcamento}" minFractionDigits="2" type="currency" /></td>
                                                 <c:if test="${pedido.status eq 'AGUARDANDO_PAGAMENTO'}" >
                                                     <c:url value="/ClienteServlet?action=pagarForm&id=${pedido.numPedido}" var="url"/>
                                                 <td><a class="btn btn-success" href="${url}"/>
                                                 <i class="icon-shopping-cart icon-large"></i> Efetuar Pagamento </a></td>
                                                 </tr>
                                                    </c:if>
                                                  </c:if>
                <c:if test='${not empty requestScope["msg"]}'>
                             <c:set var="mensagem" value='${requestScope["msg"]}'/>
                             <div class="text-center">
                                <div class="error mx-auto" data-text="ERRO!">ERRO!</div>
                                <p class="text-danger font-weight-bold"><c:out value="${mensagem}" /></p>
                             </div></c:if>
                <c:if test='${not empty requestScope["pagamento"]}'>  
                 <c:set var="mensagem1" value='${requestScope["msgPagS"]}'/>
                    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
                     <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
                         <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                     </symbol>
                        <div class="alert alert-success d-flex align-items-center" role="alert">
                             <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
                                <div>
                                 <c:out value="${mensagem1}"/>
                                </div>
                        </div></c:if>

    </body>
   

</html>
