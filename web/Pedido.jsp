<%-- 
    Document   : Pedido
    Created on : 11 de dez de 2022, 18:24:47
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="resource/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">
        <link href="resource/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <%@include  file="navbar.jsp" %>
    <body>
        <h2>Novo Pedido</h2>
       <div class="input-group mb-3">
  <label class="input-group-text" for="inputGroupSelect01">Quantidade de Peças </label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div>

        <h4>Selecione a quantidade de cada tipo de roupa:</h4>
        
<div class="input-group mb-3">
 <label class="input-group-text" for="inputGroupSelect01"> Camisetas </label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div>
      
<div class="input-group mb-3">
 <label class="input-group-text" for="inputGroupSelect01"> Calças </label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div>

<div class="input-group mb-3">
 <label class="input-group-text" for="inputGroupSelect01"> Camisas </label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div>        
      
<div class="input-group mb-3">
 <label class="input-group-text" for="inputGroupSelect01"> Saias </label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div> 
        
<div class="input-group mb-3">
 <label class="input-group-text" for="inputGroupSelect01"> Cobertor</label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div>  
        
<div class="input-group mb-3">
 <label class="input-group-text" for="inputGroupSelect01"> Lençol </label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div>  
<div class="input-group mb-3">
 <label class="input-group-text" for="inputGroupSelect01"> Casaco </label>
  <select class="form-select" id="inputGroupSelect01">
    <option selected>Quantidade</option>
    <option value="1">Um</option>
    <option value="2">Dois</option>
    <option value="3">Três</option>
    <option value="4">Quatro</option>
    <option value="5">Cinco</option>
    <option value="6">Seis</option>
    <option value="7">Sete</option>
    <option value="8">Oito</option>
    <option value="9">Nove</option>
  </select>
</div>  
        
<div class="col-12">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
      <label class="form-check-label" for="invalidCheck2">
        Confirmo que as Quantidade acima estão corretas!
      </label>
    </div>
</div><div> <br>
        
    <div>     
<form class="row g-3">
  <div class="col-md-4">
    <label for="validationDefault01" class="form-label">Nome</label>
    <input type="text" class="form-control" id="validationDefault01" value="" required>
  </div>
  <div class="col-md-4">
    <label for="validationDefault02" class="form-label">Sobrenome</label>
    <input type="text" class="form-control" id="validationDefault02" value="" required>
  </div>
  <div class="col-md-6">
    <label for="validationDefault03" class="form-label">Rua</label>
    <input type="text" class="form-control" id="validationDefault03" required>
  </div>
  <div class="col-md-6">
    <label for="validationDefault03" class="form-label">Cidade</label>
    <input type="text" class="form-control" id="validationDefault03" required>
  </div>
    <div class="col-md-6">
    <label for="validationDefault03" class="form-label">Bairo</label>
    <input type="text" class="form-control" id="validationDefault03" required>
  </div>
  <div class="col-md-3">
    <label for="validationDefault05" class="form-label">CEP</label>
    <input type="text" class="form-control" id="validationDefault05" required>
  </div>
  <div class="col-12">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
      <label class="form-check-label" for="invalidCheck2">
        Confirmo que as informações acima estão corretas!
      </label>
    </div>
  </div>
    <br> <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
  <div class="col-12">
    <button class="btn btn-primary" type="submit">Confirmar Pedido</button>
  </div>
       <br> <br>
     <div class="col-12">
    <button class="btn btn-primary" type="submit">Recusar Pedido</button>
  </div>
</form>
    <br>
    <br>
    
    </div>
    </body>
</html>
