<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Funcionario</title>
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
                        Editar funcion�rio
                    </div>

                <div class="card  mt-5">              
                    <form class="form-group" method="POST" action="EditarFuncionario" >
                        <input type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>"  />
                        <div>
                            <label for="nome">Nome:</label>
                            <input class="form-control" value="<%out.print(request.getAttribute("nome"));%>" type="text"  name="nome" id="nome" />
                        </div>
                        <div>
                            <label for="cpf">CPF:</label>
                            <input class="form-control" type="text" value="<%out.print(request.getAttribute("cpf"));%>" name="cpf" id="cpf" />
                        </div>
                        <div>
                            <label for="senha">Senha:</label>
                            <input class="form-control" type="password" value="<%out.print(request.getAttribute("senha"));%>" name="senha" id="senha" />
                        </div>
                        <div>
                            <label for="papel">Papel:</label>
                            <select class="form-control" name="papel" aria-label="Default select example">

                                <%if ("0".equals(request.getAttribute("papel"))) {%>
                                <option value="0" selected >Administrador</option>
                                <%} else {%>
                                <option value="0" >Administrador</option>
                                <% } %>

                                <%if ("1".equals(request.getAttribute("papel"))) {%>
                                <option value="1" selected >Vendedor</option>
                                <%} else {%>
                                <option value="1" >Vendedor</option>
                                <% } %>

                                <%if ("2".equals(request.getAttribute("papel"))) {%>
                                <option value="2" selected >Comprador</option>
                                <%} else {%>
                                <option value="2" >Comprador</option>
                                <% }%>


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
                                <jsp:include page="modal-sidebar.jsp" />   
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/validacao.js"></script>
    </body>
</html>
