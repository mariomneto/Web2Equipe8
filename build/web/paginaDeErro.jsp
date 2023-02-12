<%-- 
    Document   : paginaDeErro
    Created on : 12 de fev. de 2023, 16:28:48
    Author     : T-GAMER
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
    <head>
        <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
        <link href="resource/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
        <%@include  file="navbar.jsp" %>
        <title>Página de Erros</title>
        <div class="card shadow mb-4">
                        <div class="card-header py-3"> 
                        </div>
                        <div class="card-body col-sm-auto">
         <c:if test='${not empty requestScope["msg"]}'>
                             <c:set var="mensagem" value='${requestScope["msg"]}'/>
                             <div class="text-center">
                                <div class="error mx-0" data-text="ERRO!">ERR</div>
                                <p class="text-danger font-weight-bold"><c:out value="${mensagem}" /></p>
                             </div></c:if>
                              <div class="text-center">
                                <div class="error mx-auto" data-text="ERRO!">ERR</div>
                                <p class="text-danger font-weight-bold"><c:out value="Algo deu muito Errado!" /></p>
                             </div>
                        </div>
              </body>
</html>
