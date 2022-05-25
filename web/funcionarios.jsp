<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Funcionarios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">

    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="d-flex">
            <%@include file="sidebar.jsp" %>
            <div class="w-100">
                <div class="header">
                    <img  src="image/header.jpg" alt="Header"/>
                    <h1 class="container texto-header">Funcionarios</h1>
                </div>

                <div class="container mt-5">


                    <div class="card">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>Papel</th>

                                    <th>A��es</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${funcionarios}" var="funcionarios">
                                    <tr>
                                        <td><c:out value="${funcionarios.id}" /></td>
                                        <td><c:out value="${funcionarios.nome}" /></td>
                                        <td><c:out value="${funcionarios.cpf}" /></td>                      
                                        <td>
                                            <c:out value="${funcionarios.papel == 0 ? 'Administrador' : ''}" />
                                            <c:out value="${funcionarios.papel == 1 ? 'Vendedor' : ''}" />
                                            <c:out value="${funcionarios.papel == 2 ? 'Comprador' : ''}" />
                                        </td>

                                        <td><a type="button" href="funcionario?id=${funcionarios.id}" class="btn btn-primary mr-1">Editar</a><a href="RemoverFuncionario?id=<c:out value="${funcionarios.id}" />" type="button" class="btn btn-danger">Deletar</a></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>