<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Login</h3>
        <form action="LoginServlet" method = "POST">
            <label for="login">Login:</label><br>
            <input type="text" id="login" name="login"><br>
            <label for="password">Senha:</label><br>
            <input type="text" id="password" name="password">
            <input type = "submit" value = "Logar" />
          </form>
    </body>
</html>
