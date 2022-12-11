<%-- 
    Document   : RelatoriosClientes
    Created on : 11 de dez de 2022, 20:05:09
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
        <link href="resource/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatórios</title>
    </head>
    <%@include  file="navbar.jsp" %>
    <body>
        <div> 
        <H2>Download de Relatórios</h2>
        <br>
  <div class="col-12">
    <button class="btn btn-primary" type="submit">Baixar relatório de todos os Clientes</button>
  </div>
       <br>
     <div class="col-12">
    <button class="btn btn-primary" type="submit">Baixar relatório de Top-5 Clientes</button>
  </div>
       
    </body>
</html>