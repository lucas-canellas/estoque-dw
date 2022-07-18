<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Venda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">

    </head>
    <body>
                        <%
            String ativo = (String) session.getAttribute("ativo");
            String papel = (String) session.getAttribute("papel");
            if (ativo == null) {
                response.sendRedirect("index.jsp");
            }
        %>

        <div class="d-flex">
                        <div class="menu-lateral-trigger">
            <jsp:include page="sidebar.jsp" />
            </div>      
            <div class="w-100">
                <%@include file="navbar.jsp" %>
                <div class="w-100 body-container">
                                <div class="title-bar">
                        Editar venda
                    </div>
                    <div class="card  mt-5">               
                        <form class="form-group" method="POST" action="EditarVenda" >
                            <input type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>"  />
                            <input type="hidden" id="funcionario" value="<%out.print(request.getAttribute("id_funcionario"));%>"  />
                            <input type="hidden" id="cliente" value="<%out.print(request.getAttribute("id_cliente"));%>"  />
                            <input type="hidden" id="produto" value="<%out.print(request.getAttribute("id_produto"));%>"  />
                            <div>
                                <label for="quantidade_venda">Quantidade:</label>
                                <input class="form-control" value="<%out.print(request.getAttribute("quantidade_venda"));%>" type="text" name="quantidade_venda" id="quantidade_venda" />
                            </div>
                            <div>
                                <label for="data_venda">Data da compra:</label>
                                <input class="form-control" value="<%out.print(request.getAttribute("data_venda"));%>" type="text" name="data_venda" id="data_venda" />
                            </div>
                            <div>
                                <label for="valor_venda">Valor da compra::</label>
                                <input class="form-control" type="text" value="<%out.print(request.getAttribute("valor_venda"));%>" name="valor_venda"  id="valor_venda" />
                            </div>
                            <div>
                                <label for="id_cliente">Cliente:</label>
                                <select class="form-control" name="id_cliente" aria-label="Default select example">
                                                                   
                                    <c:forEach var="cliente" items="${clientes}" varStatus="id">
                                        <option class="clie_value" value="${cliente.id}">${cliente.nome}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <div>
                                <label for="id_produto">Produto:</label>
                                <select class="form-control" name="id_produto" aria-label="Default select example">
                                                                  
                                    <c:forEach var="produto" items="${produtos}" varStatus="id">
                                        <option class="prod_value" value="${produto.id}">${produto.nome_produto}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <div>
                                <label for="id_funcionario">Funcionário:</label>
                                <select class="form-control" name="id_funcionario" aria-label="Default select example">                                                                  
                                    <c:forEach var="funcionario" items="${funcionarios}" varStatus="id">
                                        <option class="func_value"  value="${funcionario.id}">${funcionario.nome}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <div class=" mt-3">
                                <div>
                                    <button type="submit" class="button-entrar-login">Enviar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
                            <jsp:include page="modal-sidebar.jsp" />   
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/validacao.js"></script>
        <script src="js/scripts.js"></script>

    </body>
</html>
