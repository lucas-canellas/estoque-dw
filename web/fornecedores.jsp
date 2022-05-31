<%@page import="model.Fornecedor"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Fornecedores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">

    </head>
    <body>
        <div class="d-flex">
                        <div class="menu-lateral-trigger">
            <jsp:include page="sidebar.jsp" />
            </div>      
            <div class="w-100">
                <%@include file="navbar.jsp" %>
            <div class="w-100 body-container">
                            <div class="title-bar">
                        Fornecedores
                    </div>
                <div class=" mt-5">
                    

                               
                    <div class="card">
                        <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Razão Social</th>
                                <th>CNPJ</th>
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
                            <c:forEach items="${fornecedores}" var="fornecedores">
                            <tr>
                                <td><c:out value="${fornecedores.id}" /></td>
                                <td><c:out value="${fornecedores.razao_social}" /></td>
                                <td><c:out value="${fornecedores.cnpj}" /></td>
                                <td><c:out value="${fornecedores.endereco}" /></td>
                                <td><c:out value="${fornecedores.bairro}" /></td>
                                <td><c:out value="${fornecedores.cidade}" /></td>
                                <td><c:out value="${fornecedores.uf}" /></td>
                                <td><c:out value="${fornecedores.cep}" /></td>
                                <td><c:out value="${fornecedores.telefone}" /></td>
                                <td><c:out value="${fornecedores.email}" /></td>
                                <td><a type="button" href="fornecedor?id=${fornecedores.id}" class="btn btn-primary mr-1">Editar</a><a href="RemoverFornecedor?id=<c:out value="${fornecedores.id}" />" type="button" class="btn btn-danger">Deletar</a></td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                    </table>
                    </div>
                </div>
</div>
            </div>
        </div>
            <jsp:include page="modal-sidebar.jsp" />   
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
