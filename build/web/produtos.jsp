<%@page import="dao.ProdutoDAO"%>
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
        <%
            String ativo = (String) session.getAttribute("ativo");
            ProdutoDAO dao = new ProdutoDAO();
            request.getSession(true).setAttribute("produtos", dao.listarProduto());
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
                        Produtos
                    </div>

                    <div class=" mt-5">


                        <div class="card">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Nome</th>
                                        <th>Quantidade disponivel</th>
                                        <th>Preço venda</th>
                                        <th>Liberado ?</th>
                                        <th>Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${produtos}" var="produtos">
                                        <tr>
                                            <td><c:out value="${produtos.id}" /></td>
                                            <td><c:out value="${produtos.nome_produto}" /></td>
                                            <td><c:out value="${produtos.quantidade_disponivel}" /></td>                                            
                                            <td><c:out value="${produtos.preco_venda}" /></td>
                                            <td><c:out value="${produtos.liberado_venda}" /></td>

                                            <td><a type="button" href="produto?id=${produtos.id}" class="btn btn-primary mr-1">Alterar liberação</a></td>
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
