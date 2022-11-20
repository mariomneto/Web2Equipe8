<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Login</h3>
        <form action="CadastroServlet" method = "POST">
            <label for="CPF">CPF:</label><br>
            <input type="text" id="CPF" name="CPF"><br>
            <label for="nome">Nome:</label><br>
            <input type="text" id="nome" name="nome"><br>
            <label for="email">E-mail:</label><br>
            <input type="email" id="email" name="email"><br>
            <label for="endereco1">Endereço:</label><br>
            <input type="text" id="endereco1" name="endereco1"><br>
            <label for="endereco2">Complemento:</label><br>
            <input type="text" id="endereco2" name="endereco2"><br>
            <label for="telefone">Telefone:</label><br>
            <input type="text" id="telefone" name="telefone"><br>
            <input type = "submit" value = "Cadastrar" />
          </form>
    </body>
</html>
