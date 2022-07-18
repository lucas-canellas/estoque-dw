<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vendas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">

    </head>
    <body>
        <%
            String ativo = (String) session.getAttribute("ativo");

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
                        Listar vendas
                    </div>
                    <div class=" mt-5">
                        <div class="card ">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Quantidade</th>
                                        <th style="white-space: nowrap">Data venda</th>
                                        <th style="white-space: nowrap">Valor venda</th>
                                        <th>Cliente</th>
                                        <th>Produto</th>
                                        <th>Funcionario</th>

                                        <th>Ações</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${vendas}" var="vendas">
                                        <tr>
                                            <td><c:out value="${vendas.id}" /></td>
                                            <td><c:out value="${vendas.quantidade_venda}" /></td>
                                            <td><c:out value="${vendas.data_venda}" /></td>
                                            <td><c:out value="${vendas.valor_venda}" /></td>
                                            <td><c:out value="${clientes.clientePorId(vendas.id_cliente).getNome()}" /></td>
                                            <td><c:out value="${produtos.produtoPorId(vendas.id_produto).getNome_produto()}" /></td>
                                            <td><c:out value="${funcionarios.funcionarioPorId(vendas.id_funcionario).getNome()}" /></td>

                                            <td><a type="button" href="venda?id=${vendas.id}" class="btn btn-primary mr-1">Editar</a><a href="RemoverVenda?id=<c:out value="${vendas.id}" />" type="button" class="btn btn-danger">Deletar</a></td>
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
