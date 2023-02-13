<%-- 
    Document   : ManutençãoFuncionarios
    Created on : 27 de nov. de 2022, 15:21:29
    Author     : camis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LOL - Manutenção Peças de Roupas</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

     <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
     <link href="resource/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <c:choose>
           <c:when test="${not empty sessionScope.login}">
</head>
 <%@include  file="navbar.jsp" %>

    <!-- Page Wrapper -->
    <div id="wrapper">
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Manutenção de Funcionários</h1>
                    <p class="mb-4">(CRUD - Inserção, Remoção, Atualização e Listagem) O funcionário pode manter novos funcionários para acesso ao sistema, 
                        com os seguintes dados: e-mail único para login, nome, data de nascimento, e senha.
                    </p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Funcionários Registrados</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Email</th>
                                            <th>Data Nascimento</th>
                                            <th style="text-align:center">Visualizar</th><th style="text-align:center">Editar</th><th style="text-align:center">Deletar</th><tr>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Email</th>
                                            <th>Data Nascimento</th>
                                            <th style="text-align:center">Visualizar</th><th style="text-align:center">Editar</th><th style="text-align:center">Deletar</th><tr>
                                        </tr>
                                    </tfoot>
                                    <tbody>  
                                    <c:forEach items="${requestScope.listaFuncionarios}" var="funcionario" >    
                                        <tr><td>${funcionario.CPF}</td>
                                            <td>${funcionario.nome}</td>
                                            <td>${funcionario.email}</td>
                                            <td align="center">
                                                <a class="btn btn-success btn-circle btn-sm" href="FuncionarioServlet?action=atualizarFuncionarioForms&CPF=${cliente.CPF}" role="button">
                                                    <i class="fas fa-search"></i></a>                    
                                            </td>
                                            <td align="center">   
                                                <a class="btn btn-warning btn-circle btn-sm" href="FuncionarioServlet?action=atualizarFuncionarioForms&CPF=${cliente.CPF}" role="button">
                                                    <i class="fas fa-pencil-alt"></i></a>
                                            </td>
                                            <td align="center">
                                                <a class="btn btn-danger btn-circle btn-sm" href="FuncionarioServlet?action=removerFuncionario&CPF=${cliente.CPF}" role="button">
                                                    <i class="fas fa-trash"></i></a>
                                            </td>
                                        </tr>   
                                    </c:forEach>
                                </table>
                                <div>
                                    <a class="btn btn-success btn-sm" href="FuncionarioServlet?action=formNew" role="button">
                                        <i class="fas fa-plus"></i> Novo Funcionario</a></div>
                            </div>
                                   
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
                    </div>
                </div>
   </div>
       
    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>
        </c:when>
           <c:otherwise>
               <jsp:forward page="index.html">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o Sistema"/>
                </jsp:forward>
                </c:otherwise>
       </c:choose>

</html>
