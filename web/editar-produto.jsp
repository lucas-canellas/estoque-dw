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


                    <div class="card container mt-5">  <p>Liberar <strong>${nome_produto}</strong> para venda ?</p>             
                        <form class="form-group" method="POST" action="EditarProduto" >
                            <input type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>"  />
          
                            <select class="form-control" name="liberado_venda" aria-label="Default select example">
                                <%if ("S".equals(request.getAttribute("liberado_venda"))) {%>
                                <option value="S" selected >Liberar</option>
                                <%} else {%>
                                <option value="S" >Liberar</option>
                                <% } %>

                                <%if ("N".equals(request.getAttribute("liberado_venda"))) {%>
                                <option value="N" selected >Não liberar</option>
                                <%} else {%>
                                <option value="N" >Não liberar</option>
                                <% } %>

                            </select>
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
