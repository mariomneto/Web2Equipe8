<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
    </head>
    <body class="bg-gradient-primary">
        <div class="container">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Cadastro</h1>
                        </div>
                        <form class="user" action="CadastroServlet" method = "POST">
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="CPF" id="CPF" name="CPF">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Nome Completo" id="nome" name="nome">
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control form-control-user"
                                    placeholder="E-mail" id="email" name="email">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Endereço" id="endereco1" name="endereco1">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Complemento (opcional)" id="endereco2" name="endereco2">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user"
                                    placeholder="Telefone" id="telefone" name="telefone">
                            </div>
                            <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Cadastrar" />
                          </form>
                    </div>
                </div>
            </div>
        <div class="container">
    </body>
</html>
