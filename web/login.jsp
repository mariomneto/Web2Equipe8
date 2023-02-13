<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
    </head>
    <body class="bg-gradient-primary">
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Login</h1>
                            <form class="user" action="LoginServlet" method = "POST">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user"
                                        placeholder="E-mail" id="login" name="login">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control form-control-user"
                                        placeholder="Senha" id="senha" name="senha">
                                </div>
                                <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Logar" action="LoginServlet" />
                            </form>
                    </div>
                    <div class="text-center">
                        <a class="small" href="Cadastro.jsp">Cadastrar uma conta.</a>
                    </div>
                </div>    
            </div>
        </div>
    </body>
</html>
