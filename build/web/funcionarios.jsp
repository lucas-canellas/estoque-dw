<%@page import="dao.FuncionarioDAO"%>
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
        <%
            String ativo = (String) session.getAttribute("ativo");
            FuncionarioDAO dao = new FuncionarioDAO();
            request.getSession(true).setAttribute("funcionarios", dao.listarFuncionarios());
                        if (ativo == null) {
                response.sendRedirect("index.jsp");
            }
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
                        Funcion?rios
                    </div>
                <div class=" mt-5">
                    <div class="card">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nome</th>
                                    <th>CPF</th>
                                    <th>Papel</th>

                                    <th>A??es</th>

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
                </div></div>

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
