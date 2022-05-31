<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Compra</title>
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
                        Editar compra
                    </div>
                    <div class="card  mt-5">               
                        <form class="form-group" method="POST" action="EditarCompra" >
                            <input type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>"  />
                            <input type="hidden" id="fornecedor" value="<%out.print(request.getAttribute("id_fornecedor"));%>"  />
                            <input type="hidden" id="funcionario" value="<%out.print(request.getAttribute("id_funcionario"));%>"  />
                            <input type="hidden" id="produto" value="<%out.print(request.getAttribute("id_produto"));%>"  />
                            <div>
                                <label for="quantidade_venda">Quantidade:</label>
                                <input class="form-control" value="<%out.print(request.getAttribute("quantidade_compra"));%>" type="text" name="quantidade_compra" id="quantidade_compra" />
                            </div>
                            <div>
                                <label for="data_venda">Data da compra:</label>
                                <input class="form-control" value="<%out.print(request.getAttribute("data_compra"));%>" type="text" name="data_compra" id="data_compra" />
                            </div>
                            <div>
                                <label for="valor_venda">Valor da compra::</label>
                                <input class="form-control" type="text" value="<%out.print(request.getAttribute("valor_compra"));%>" name="valor_compra"  id="valor_compra" />
                            </div>
                            <div>
                                <label for="id_fornecedor">Fornecedor</label>
                                <select class="form-control" name="id_fornecedor" aria-label="Default select example">
                                                               
                                    <c:forEach var="fornecedor" items="${fornecedores}" varStatus="id">
                                        <option class="forn_value" value="${fornecedor.id}">${fornecedor.razao_social}</option>                                    
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
        <script src="js/selected-editar-compra.js"></script>

    </body>
</html>
