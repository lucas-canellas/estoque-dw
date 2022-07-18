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
            String ativo = (String) session.getAttribute("ativo");

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
                        Cadastrar produto
                    </div>

                    <div class="card  mt-5">              
                        <form class="form-group" method="POST" action="CadastrarProduto2" >
                            <div>
                                <label for="nome_produto">Nome:</label>
                                <input class="form-control" type="text" required maxlength="100" name="nome_produto"   id="nome_produto" />
                            </div>
                            <div>
                                <label for="descricao">Descrição:</label>
                                <input class="form-control" required maxlength="255" type="text" name="descricao" id="descricao" />
                            </div>
                            <div>
                                <label for="preco_compra">Preço compra:</label>
                                <input class="form-control" required maxlength="8"  type="text" name="preco_compra" id="preco_compra" />
                            </div>
                            <div>
                                <label for="preco_venda">Preço venda:</label>
                                <input class="form-control" required maxlength="8" type="text" name="preco_venda" id="preco_venda" />
                            </div>
                            <div>
                                <label for="quantidade_disponivel">Quantidade disponível:</label>
                                <input class="form-control" required maxlength="8" type="text" name="quantidade_disponivel" id="quantidade_disponivel" />
                            </div>
                            <div>
                                <label for="liberado_venda">Liberado para venda:</label>                                
                                 <select class="form-control" required name="liberado_venda" aria-label="Default select example">
                                     <option value="" disabled selected>Selecione se esta liberado</option> 
                                     <option value="S">Liberado</option> 
                                     <option value="N">Não liberado</option> 
                                 </select>
                            </div>
                            <div>
                                <label for="id_categoria">Categoria:</label>
                                <select class="form-control" name="id_categoria" aria-label="Default select example">
                                    <option disabled selected>Selecione a categoria</option>                                
                                    <c:forEach var="categoria" items="${categorias}" varStatus="id">
                                        <option value="${categoria.id}">${categoria.nome_categoria}</option>                                    
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
    </body>
</html>
