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
        <c:if test='${ not empty requestScope["form"]}' >   
                <c:set var="form" value='${requestScope["form"]}'/>
                </c:if>
                <c:choose>
                   <c:when test="${form eq 'alterar'}">
                    <c:set var="Span" value="Alterar Funcionario"/> 
                    <c:url value="FuncionariosServlet?action=atualizarFuncionario&CPF=${id}" var="Url"/>
                    <c:set var="funcionario" value='${requestScope.funcionario}'/>
                    <c:set var="CPF" value='${funcionario.CPF}'/>
                    <c:set var="nome" value='${funcionario.nome}'/>
                    <c:set var="email" value='${funcionario.email}'/>
                    <c:set var="Data" value='${funcionario.datanascimento}'/>
                    <c:set var="Rua" value='${funcionario.endereco}'/>
                    <c:set var="Senha" value='${funcionario.senha}'/>
                    <c:set var="cep" value='${funcionario.CEP}'/>
                    <c:set var="id" value='${cliente.id}'/>
                   </c:when>
                  <c:otherwise>
                      <c:set var="Span" value="Cadastrar Funcionario"/>
                      <c:url value="FuncionariosServlet?action=inserirFuncionario" var="Url"/>
                      <c:set var="name" value=""/>
                      <c:set var="CPF" value=""/>
                      <c:set var="eMail" value=""/>
                      <c:set var="Data" value=""/>
                      <c:set var="Rua" value=""/>
                      <c:set var="cep" value=""/>
                      <c:set var="Senha" value=""/>
                      <c:set var="id" value=""/>
                    </c:otherwise>
                </c:choose>
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Manutenção de Funcionários</h1>
                    <p class="mb-4"><c:out value="${Span}" />
                    </p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Cadastro Geral Funcionarios</h6>
                        </div>
                        <div class="card-body">
                            <form class="user" action="${Url}" method = "POST">
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Nome" id="nome" name="nome" value="<c:out value="${nome}"/>">
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control form-control-user"
                                    placeholder="E-mail" id="email" name="email" value="<c:out value="${email}"/>">
                            </div>
                            <div class="form-group">
                                <input type="data" class="form-control form-control-user"
                                    placeholder="Data Nascimento" id="datanascimento" name="datanascimento" value="<c:out value="${Data}"/>">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Senha" id="senha" name="senha" value="<c:out value="${senha}"/>">
                            </div>  <div class="form-group">
                                <input type="data" class="form-control form-control-user"
                                    placeholder="CPF" id="CPF" name="CPF" value="<c:out value="${CPF}"/>">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="numero rua" id="endereco" name="endereco" value="<c:out value="${Rua}"/>">
                            </div>
                             <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="cep" id="cep" name="cep" value="<c:out value="${cep}"/>">
                            </div>   </div>
                             <div class="form-group">
                                 <input type="hidden" id="id" name="id" value="${id}">
                            </div>
                                    <c:choose>
                                        <c:when test="${form eq 'alterar'}">
                                            <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Cadastrar" />
                                        </c:when>
                                        <c:otherwise>
                                            <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Editar" />  
                                        </c:otherwise>
                                    </c:choose>
                        </form>
                        </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

       
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
