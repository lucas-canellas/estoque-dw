<%@page import="dao.CategoriaDAO"%>
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
        <%
            CategoriaDAO dao = new CategoriaDAO();
            request.getSession(true).setAttribute("categorias", dao.listarCategoria());
        %>
        <%@include file="./modal/mensagem-status.jsp" %> 
        <div class="d-flex">
            <div class="menu-lateral-trigger">
                <jsp:include page="sidebar.jsp" />
            </div>       
            <div class="w-100">
                <%@include file="navbar.jsp" %>
                <div class="w-100 body-container">
                    <div class="title-bar">
                        Categorias
                    </div>
                    <div class=" mt-5">
                        <div class="card">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${categorias}" var="categorias">
                                        <tr>
                                            <td><c:out value="${categorias.id}" /></td>
                                            <td><c:out value="${categorias.nome_categoria}" /></td>

                                            <td><a type="button" href="categoria?id=${categorias.id}" class="btn btn-primary mr-1">Editar</a><a href="RemoverCategoria?id=<c:out value="${categorias.id}" />" type="button" class="btn btn-danger">Deletar</a></td>
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
        <c:if test="${chamou_cadastro eq true}">
            <script>
                $(document).ready(function () {
                    $('#mensagemStatusModal').modal('show');
                });
            </script>
        </c:if>
    </body>
</html>
