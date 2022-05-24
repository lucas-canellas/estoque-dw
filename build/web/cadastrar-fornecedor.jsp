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

        <%@include file="navbar.jsp" %>
        <div class="d-flex">
            <%@include file="sidebar.jsp" %>
            <div class="w-100">
                <div class="header">
                    <img  src="image/header.jpg" alt="Header"/>
                    <h1 class="container texto-header">Estoque</h1>
                </div>
                
                <div class="card container mt-5">  <h1>Cadastrar fornecedor</h1>             <form class="form-group" method="POST" action="CadastrarFornecedor" >
                        <div>
                            <label for="razao_social">Razão Social:</label>
                            <input class="form-control" type="text" name="razao_social" id="razao_social" />
                        </div>
                        <div>
                            <label for="cnpj">CNPJ:</label>
                            <input  class="form-control" type="text" name="cnpj" id="cnpj" />
                        </div>
                        <div>
                            <label for="endereco">Endereço:</label>
                            <input class="form-control" type="text" name="endereco" id="endereco" />
                        </div>
                        <div>
                            <label for="bairro">Bairro:</label>
                            <input class="form-control" type="text" name="bairro" id="bairro" />
                        </div>
                        <div>
                            <label for="cidade">Cidade:</label>
                            <input class="form-control" type="text" name="cidade" id="cidade" />
                        </div>
                        <div>
                            <label for="uf">UF:</label>
                            <input  class="form-control" type="text" name="uf" id="uf" />
                        </div>
                        <div>
                            <label for="cep">CEP:</label>
                            <input class="form-control" type="text" name="cep" id="cep" />
                        </div>
                        <div>
                            <label for="telefone">Telefone:</label>
                            <input class="form-control" type="text" name="telefone" id="telefone" />
                        </div>
                        <div>
                            <label for="email">Email:</label>
                            <input class="form-control" type="text" name="email" id="email" />
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
    </body>
</html>
