<%@page import="model.Cliente"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Clientes</title>
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
                                <th>CPF</th>
                                <th>Endereço</th>
                                <th>Bairro</th>
                                <th>Cidade</th>
                                <th>UF</th>
                                <th>CEP</th>
                                <th>Telefone</th>
                                <th>Email</th>
                                <th>Ações</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${clientes}" var="clientes">
                            <tr>
                                <td><c:out value="${clientes.id}" /></td>
                                <td><c:out value="${clientes.nome}" /></td>
                                <td><c:out value="${clientes.cpf}" /></td>
                                <td><c:out value="${clientes.endereco}" /></td>
                                <td><c:out value="${clientes.bairro}" /></td>
                                <td><c:out value="${clientes.cidade}" /></td>
                                <td><c:out value="${clientes.uf}" /></td>
                                <td><c:out value="${clientes.cep}" /></td>
                                <td><c:out value="${clientes.telefone}" /></td>
                                <td><c:out value="${clientes.email}" /></td>
                                <td><a type="button" href="cliente?id=${clientes.id}" class="btn btn-primary mr-1">Editar</a><a href="RemoverCliente?id=<c:out value="${clientes.id}" />" type="button" class="btn btn-danger">Deletar</a></td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    </div>
                </div></div>

            </div>
        </div>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
