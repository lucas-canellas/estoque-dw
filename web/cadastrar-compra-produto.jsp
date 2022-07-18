<%@page import="dao.FuncionarioDAO"%>
<%@page import="dao.ProdutoDAO"%>
<%@page import="dao.FornecedorDAO"%>
<%@page import="dao.CompraDAO"%>
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
        <%
            FornecedorDAO fornecedor_dao = new FornecedorDAO();
            request.getSession(true).setAttribute("fornecedores", fornecedor_dao.listarFornecedor());

            ProdutoDAO produto_dao = new ProdutoDAO();
            request.getSession(true).setAttribute("produtos", produto_dao.listarProduto());
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
                        Cadastrar compra
                    </div>
                    <div class="card  mt-5">            
                        <form class="form-group" method="POST" action="cadastro-compra" >
                            <div>
                                <label for="quantidade_venda">Quantidade:</label>
                                <input class="form-control" type="text"  maxlength="9" name="quantidade_compra" id="quantidade_compra" required />
                            </div>
                            <div>
                                <label for="data_compra">Data da compra:</label>
                                <input class="form-control" type="text" pattern="\d{1,2}/\d{1,2}/\d{4}"  name="data_compra" id="data_compra" required/>
                            </div>
                            <div>
                                <label for="valor_compra">Valor da compra:</label>
                                <input class="form-control" type="text"  maxlength="8"  name="valor_compra"  id="valor_compra" required/>
                            </div>
                            <div>
                                <label for="id_fornecedor">Fornecedor:</label>
                                <select class="form-control" name="id_fornecedor"  aria-label="Default select example" required>
                                    <option value="" selected>Selecione a fornecedor</option>                                
                                    <c:forEach var="fornecedor" items="${fornecedores}" varStatus="id">
                                        <option value="${fornecedor.id}">${fornecedor.razao_social}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <div>
                                <label for="id_produto">Produto:</label>
                                <select class="form-control" name="id_produto"  aria-label="Default select example" required>
                                    <option value="" selected>Selecione o produto</option>                                
                                    <c:forEach var="produto" items="${produtos}" varStatus="id">
                                        <option value="${produto.id}">${produto.nome_produto}</option>                                    
                                    </c:forEach>  
                                </select>
                            </div>
                            <!--ID COMPRADOR-->
                            <input type="hidden" name="id_funcionario" value="${user_id}"/> 
                            <div>
                                <label>Comprador:</label>
                                <div class="form-control bg-light">
                                    ${nome}
                                </div>
                                <p class="text-muted fw-lighter" style="font-size: 12px">Comprador preenchido automaticamente (Funcionário que realiza a compra)</p>
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
        <c:if test="${chamou_cadastro eq true}">
            <script>
                $(document).ready(function () {
                    $('#mensagemStatusModal').modal('show');
                });
            </script>
        </c:if>
    </body>
</html>
