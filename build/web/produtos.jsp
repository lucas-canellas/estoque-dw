<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Produtos</title>
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


                <div class="container mt-5">
                    
                               
                    <div class="card">
                        <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>Liberado ?</th>
                                <th>Op��es</th>
                                

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${produtos}" var="produtos">
                            <tr>
                                <td><c:out value="${produtos.id}" /></td>
                                <td><c:out value="${produtos.nome_produto}" /></td>
                                <td><c:out value="${produtos.liberado_venda}" /></td>
                                
                                <td><a type="button" href="produto?id=${produtos.id}" class="btn btn-primary mr-1">Alterar libera��o</a></td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    </div>
                </div>
</div>
            </div>
        </div>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>