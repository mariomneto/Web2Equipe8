<%-- 
    Document   : ManutençãoFuncionarios
    Created on : 27 de nov. de 2022, 15:21:29
    Author     : camis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <h6 class="m-0 font-weight-bold text-primary">Cadastro Geral Funcionarios</h6>
                        </div>
                        <div class="card-body">
                            <form class="user" action="FuncionariosServlet" method = "POST">
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Nome" id="nome" name="nome">
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control form-control-user"
                                    placeholder="E-mail" id="email" name="email">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Data Nascimento" id="datanascimento" name="datanascimento">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Senha" id="senha" name="senha">
                            </div>
                                <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Cadastrar" />
                                <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Editar" />
                                <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Excluir" />
                                <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Listar" />
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

</html>
