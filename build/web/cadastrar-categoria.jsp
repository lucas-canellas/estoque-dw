<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Categoria</title>
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
            <div class="w-100 ">
                <%@include file="navbar.jsp" %>
                <div class="w-100 body-container"> 
                    <div class="title-bar">
                        Cadastrar categorias
                    </div>
                    <div class="card  mt-5">              
                        <form class="form-group" method="POST" action="CadastrarCategoria" >
                            <div>
                                <label for="nome_categoria">Raz?o Social:</label>
                                <input class="form-control" type="text" required maxlength="50" name="nome_categoria" id="nome_categoria" />
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
