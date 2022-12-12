<%-- 
    Document   : ManutençãoPeçasdeRoupas
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
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
     <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
     <link href="resource/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

</head>
 <%@include  file="navbar.jsp" %>

                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Manutenção de Peças de Roupas</h1>
                    <p class="mb-4">CRUD - Inserção, Remoção, Atualização e Listagem) Um funcionário pode manter peças de roupas a serem lavadas. 
                        Por exemplo: calça jeans, camisa social, bermuda, etc. 
                        Deve ser armazenado também o preço individual e o prazo (em dias) para lavagem desta peça roupa;</p>

                            
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Peças de Roupas Registradas</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Prazo de Lavagem</th>
                                            <th>Valor Unidade</th>
                                            <th>Peso</th>
                                            <th style="text-align:center">Salvar - Alterar - Excluir</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Nome</th>
                                            <th>Prazo de Lavagem</th>
                                            <th>Valor Unidade</th>
                                            <th>Peso</th>
                                            <th style="text-align:center">Salvar - Alterar - Excluir</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td>Camiseta</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Calça Jeans</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Saia</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Vestido</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Bermuda</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Macação</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                 <button class="btn btn-success btn-circle btn-sm" type="button">
                                                     <i class="fas fa-check"></i>
                                                 </button>
                                                 <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                     <i class="fas fa-exclamation-triangle"></i>
                                                 </button>
                                                 <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                         <i class="fas fa-trash"></i>
                                                 </button>
                                             </td>
                                        </tr>
                                        <tr>
                                            <td>Edredom</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Cobertor</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Travesseiro</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>61</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Jaqueta</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>23</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Moleton</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>30</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Toalha</td>
                                            <td>2 - 3 Dias</td>
                                            <td>10</td>
                                            <td>22</td>
                                            <td align="center">
                                                <button class="btn btn-success btn-circle btn-sm" type="button">
                                                    <i class="fas fa-check"></i>
                                                </button>
                                                <button class="btn btn-warning btn-circle btn-sm" type="button">
                                                    <i class="fas fa-exclamation-triangle"></i>
                                                </button>
                                                <button class="btn btn-danger btn-circle btn-sm" type="button">
                                                        <i class="fas fa-trash"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

          
    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>
