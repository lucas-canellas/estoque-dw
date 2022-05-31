<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Compras</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">

    </head>
    <body>
        <%@include file="./modal/mensagem-status.jsp" %> 
        <div class="d-flex">
                        <div class="menu-lateral-trigger">
            <jsp:include page="sidebar.jsp" />
            </div>       
            <div class="w-100">
                <%@include file="navbar.jsp" %>
            <div class="w-100 body-container">
                            <div class="title-bar">
                        Compras
                    </div>
                <div class=" mt-5">
                    <div class="card ">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Quantidade</th>
                                    <th style="white-space: nowrap">Data compra</th>
                                    <th style="white-space: nowrap">Valor compra</th>
                                    <th>Forneceodr</th>
                                    <th>Produto</th>
                                    <th>Funcionario</th>

                                    <th>Ações</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${compras}" var="compras">
                                    <tr>
                                        <td><c:out value="${compras.id}" /></td>
                                        <td><c:out value="${compras.quantidade_compra}" /></td>
                                        <td><c:out value="${compras.data_compra}" /></td>
                                        <td><c:out value="${compras.valor_compra}" /></td>
                                        <td><c:out value="${fornecedores.fornecedorPorId(compras.id_fornecedor).getRazao_social()}" /></td>
                                        <td><c:out value="${produtos.produtoPorId(compras.id_produto).getNome_produto()}" /></td>
                                        <td><c:out value="${funcionarios.funcionarioPorId(compras.id_funcionario).getNome()}" /></td>
                                        
                                        <td><a type="button" href="compra?id=${compras.id}" class="btn btn-primary mr-1">Editar</a><a href="RemoverCompra?id=<c:out value="${compras.id}" />" type="button" class="btn btn-danger">Deletar</a></td>
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
