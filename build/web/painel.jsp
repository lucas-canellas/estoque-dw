<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Painel</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">
        <link href="fontawesome-free-6.1.1-web/css/all.css" rel="stylesheet">

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
                        <div class="menu-lateral-trigger">
            <jsp:include page="sidebar.jsp" />
            </div>
            </div>
            <div class="w-100">
                
                    <%@include file="navbar.jsp" %>

                
                <div class="w-100 body-container">
                    <h1>Bem vindo ao Sistema</h1>
                    <h5>Dashboard em contrução ...</h5>
                </div>
            </div>
        </div>
        <jsp:include page="modal-sidebar.jsp" />           


        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>


    </body>
</html>
