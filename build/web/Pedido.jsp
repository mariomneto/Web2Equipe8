<%-- 
    Document   : Pedido
    Created on : 11 de dez de 2022, 18:24:47
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <style>
		.confirmacao {
			background-color: #e6e6e6;
			padding: 10px;
			font-weight: bold;
		}
	</style>
        
        <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
        <link href="resource/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <%@include  file="navbar.jsp" %>
    <body>
        <h1 style="text-align: center; color: black; font-weight: bold;">Novo pedido</h1>
        <br>
        <h4 style="text-align: center;">Selecione as peças e suas quantidades:</h4>
        <br>
        
        <label for="quantidade">Camiseta</label>
<input type="number" id="quantidade" name="camiseta" min="0" max="9">
        
        <label for="quantidade">Calça</label>
<input type="number" id="quantidade" name="calca" min="0" max="9">
        
        <label for="quantidade">Camisa</label>
<input type="number" id="quantidade" name="camisa" min="0" max="9">
        
        <label for="quantidade">Saia</label>
<input type="number" id="quantidade" name="saia" min="0" max="9">

        <label for="quantidade">Peça intima</label>
<input type="number" id="quantidade" name="intima" min="0" max="9">

        <label for="quantidade">Meia</label>
<input type="number" id="quantidade" name="meia" min="0" max="9">

        <label for="quantidade">Casaco</label>
<input type="number" id="quantidade" name="casaco" min="0" max="9">

<br> <br> 

        <label for="quantidade">Cobertor</label>
<input type="number" id="quantidade" name="cobertor" min="0" max="9">

        <label for="quantidade">Lençol</label>
<input type="number" id="quantidade" name="lencol" min="0" max="9">

<br><br> 

<div class="col-12">
		<div class="form-check">
			<input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
			<label class="form-check-label confirmacao" for="invalidCheck2">
				Confirmo que as quantidades acima estão corretas!
			</label>
		</div>
	</div>
<br>

<div style="text-align: center;">
  <form method="post" action="servlet_name">
    <button type="submit" name="pedido" value="aceitar" style="background-color: green; color: white; border-radius: 5px; width: 350px; padding: 10px; border: none;">Aceitar Pedido</button>
    <button type="submit" name="pedido" value="rejeitar" style="background-color: red; color: white; border-radius: 5px; width: 350px; padding: 10px; border: none;">Rejeitar Pedido</button>
  </form>
</div>



</html>
