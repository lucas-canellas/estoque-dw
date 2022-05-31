<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Fornecedor</title>
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
                        Cadastrar compra
                    </div>

                    <div class="card  mt-5">            
                        <form class="form-group" method="POST" action="cadastro-compra" >
                            <div>
                                <label for="quantidade_venda">Quantidade:</label>
                                <input class="form-control" type="text" name="quantidade_compra" id="quantidade_compra" />
                            </div>
                            <div>
                                <label for="data_compra">Data da compra:</label>
                                <input class="form-control" type="text" name="data_compra" id="data_compra" />
                            </div>
                            <div>
                                <label for="valor_compra">Valor da compra::</label>
                                <input class="form-control" type="text" name="valor_compra"  id="valor_compra" />
                            </div>
                            <div>
                                <label for="id_fornecedor">Fornecedor:</label>
                                <select class="form-control" name="id_fornecedor" aria-label="Default select example">
                                    <option selected>Selecione a fornecedor</option>                                
                                    <c:forEach var="fornecedor" items="${fornecedores}" varStatus="id">
                                        <option value="${fornecedor.id}">${fornecedor.razao_social}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <div>
                                <label for="id_produto">Produto:</label>
                                <select class="form-control" name="id_produto" aria-label="Default select example">
                                    <option selected>Selecione o produto</option>                                
                                    <c:forEach var="produto" items="${produtos}" varStatus="id">
                                        <option value="${produto.id}">${produto.nome_produto}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <div>
                                <label for="id_funcionario">Funcionário:</label>
                                <select class="form-control" name="id_funcionario" aria-label="Default select example">
                                    <option selected>Selecione o funcionário</option>                                
                                    <c:forEach var="funcionario" items="${funcionarios}" varStatus="id">
                                        <option value="${funcionario.id}">${funcionario.nome}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <div class=" mt-3">
                                <div>
                                    <button type="submit" class="button-entrar-login">Enviar</button>
                                </div>
                            </div>
                        </form></div></div>

            </div>
        </div>
        <jsp:include page="modal-sidebar.jsp" />   
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/validacao.js"></script>
    </body>
</html>
