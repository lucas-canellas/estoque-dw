<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Venda</title>
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
                        Cadastrar venda
                    </div>

                    <div class="card  mt-5">             
                        <form class="form-group" method="POST" action="cadastro-venda" >
                            <div>
                                <label for="quantidade_venda">Quantidade:</label>
                                <input class="form-control" type="text" name="quantidade_venda" id="quantidade_venda" />
                            </div>
                            <div>
                                <label for="data_venda">Data da compra:</label>
                                <input class="form-control" type="text" name="data_venda" id="data_venda" />
                            </div>
                            <div>
                                <label for="valor_venda">Valor da compra::</label>
                                <input class="form-control" type="text" name="valor_venda"  id="valor_venda" />
                            </div>
                            <div>
                                <label for="id_cliente">Cliente:</label>
                                <select class="form-control" name="id_cliente" aria-label="Default select example">
                                    <option selected>Selecione a fornecedor</option>                                
                                    <c:forEach var="cliente" items="${clientes}" varStatus="id">
                                        <option value="${cliente.id}">${cliente.nome}</option>                                    
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
                        </form></div>
                </div>
            </div>
        </div>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/validacao.js"></script>

        <jsp:include page="modal-sidebar.jsp" />   
        <c:if test="${chamou_cadastro eq true}">
            <script>
                $(document).ready(function () {
                    $('#mensagemStatusModal').modal('show');
                });
            </script>
        </c:if>
    </body>
</html>
