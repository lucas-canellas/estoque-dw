<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">    
        <link rel="stylesheet" href="css/painel.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">

    </head>
    <body>

        <%@include file="navbar.jsp" %>
        <div class="d-flex">
            <%@include file="sidebar.jsp" %>
            <div class="w-100">
                <div class="header">
                    <img  src="image/header.jpg" alt="Header"/>
                    <h1 class="container texto-header">Cadastrar clientes</h1>
                </div>

                <div class="card container mt-5">              
                    <form name="form-cadastro-cliente" method="POST" onsubmit="return validateForm()"  action="CadastrarCliente" class="form-group" >
                        <div>
                            <label for="nome">Nome:</label>
                            <input class="form-control" name="nome" required maxlength="50" type="text" id="nome" />
                        </div>
                        <div>
                            <label for="cpf">CPF:</label>
                            <input  class="form-control cpf" name="cpf" required type="text" id="cpf" />
                        </div>
                        <div>
                            <label for="endereco">Endereço:</label>
                            <input class="form-control" name="endereco" maxlength="50" required type="text" id="endereco" />
                        </div>
                        <div>
                            <label for="bairro">Bairro:</label>
                            <input class="form-control" name="bairro" maxlength="50" required type="text" id="bairro" />
                        </div>
                        <div>
                            <label for="cidade">Cidade:</label>
                            <input class="form-control" name="cidade" maxlength="50" required type="text" id="cidade" />
                        </div>
                        <div>
                            <label for="uf">UF:</label>
                            <input class="form-control" name="uf" maxlength="2" required type="text" id="uf" />
                        </div>
                        <div>
                            <label for="cep">CEP:</label>
                            <input class="form-control" name="cep" required type="text" id="cep" />
                        </div>
                        <div>
                            <label for="telefone">Telefone:</label>
                            <input class="form-control" name="telefone" required type="text" id="telefone" />
                        </div>
                        <div>
                            <label for="email">Email:</label>
                            <input class="form-control" name="email" maxlength="50" required type="email" id="email" />
                        </div>
                        <div class=" mt-3">
                            <div>
                                <button type="submit" class="button-entrar-login">Enviar</button>
                            </div>
                        </div>
                    </form></div>

            </div>
        </div>
        
        
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.mask.js"></script>
        <script src="js/validacao.js"></script>
    </body>
</html>
