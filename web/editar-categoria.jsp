<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Fornecedor</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">

    </head>
    <body>
        <div class="d-flex">
            <%@include file="sidebar.jsp" %>        
            <div class="w-100">
                <%@include file="navbar.jsp" %>
            <div class="w-100">


                <div class="card container mt-5">  <h1>Editar Categoria</h1>             
                    <form class="form-group" method="POST" action="EditarCategoria" >
                        <input type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>"  />
                        <div>
                            <label for="nome_categoria">Categoria:</label>
                            <input class="form-control" type="text" value="<%out.print(request.getAttribute("nome_categoria"));%>" name="nome_categoria" id="nome_categoria" />
                        </div>                        
                        <div class=" mt-3">
                            <div>
                                <button type="submit" class="button-entrar-login">Enviar</button>
                            </div>
                        </div>
                    </form></div>
</div>
            </div>
        </div>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/validacao.js"></script>
    </body>
</html>
