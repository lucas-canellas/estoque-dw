<%@ page language="java" contentType="text/html" %>
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
            String usuario = (String) session.getAttribute("user_id");
            if (usuario == null) {
                response.sendRedirect("index.jsp");
            }            
        %>
        <%@include file="navbar.jsp" %>
        <div class="d-flex">
            <%@include file="sidebar.jsp" %>
            <div class="w-100">
                <div class="header">
                    <img  src="image/header.jpg" alt="Header"/>
                    <h1 class="container texto-header">Estoque</h1>
                </div>

                <div class="card container container-tabelas mt-5 mb-5">            
                    <!-- Nav tabs -->
                    <ul class="nav nav-pills">
                        <li class='nav-item'>
                            <a class='nav-link active' data-toggle='tab' href='#s1'>CADASTRO VENDA</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link ' data-toggle='tab' href='#s2'>CADASTRO CATEGORIA</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link ' data-toggle='tab' href='#s3'>CADASTRO CLIENTE</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link ' data-toggle='tab' href='#s4'>CADASTRO COMPRA</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link ' data-toggle='tab' href='#s5'>CADASTRO FORNECEDORES</a>
                        </li>
                        <li class='nav-item'>
                            <a class='nav-link ' data-toggle='tab' href='#s6'>CADASTRO FUNCIONARIO</a>
                        </li>    
                        <li class='nav-item'>
                            <a class='nav-link ' data-toggle='tab' href='#s7'>CADASTRO PRODUTO</a>
                        </li>  
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content mt-4">
                        <div class='tab-pane  fade in show active' id='s1'><form class="form-group" >
                                <div>
                                    <label for="quantidade_venda">Quantidade:</label>
                                    <input class="form-control" type="text" id="quantidade_venda" />
                                </div>
                                <div>
                                    <label for="data_venda">Data da venda:</label>
                                    <input class="form-control" type="text" id="data_venda" />
                                </div>
                                <div>
                                    <label for="valor_venda">Valor da venda:</label>
                                    <input class="form-control" type="text" id="valor_venda" />
                                </div>
                                <div>
                                    <label for="id_cliente">Cliente:</label>
                                    <input  class="form-control" type="text" id="id_cliente" />
                                </div>
                                <div>
                                    <label for="id_produto">Produto:</label>
                                    <input class="form-control" type="text" id="id_produto" />
                                </div>
                                <div>
                                    <label for="id_funcionario">Funcion�rio:</label>
                                    <input class="form-control" type="text" id="id_funcionario" />
                                </div>
                                <div class=" mt-3">
                                    <div>
                                        <button type="submit" class="button-entrar-login">Enviar</button>
                                    </div>
                                </div>
                            </form></div>
                        <div class='tab-pane  fade' id='s2'><form class="form-group" >
                                <div>
                                    <label for="nome_categoria">Nome:</label>
                                    <input class="form-control" type="text" id="nome_categoria" />
                                </div>
                                <div class=" mt-3">
                                    <div>
                                        <button type="submit" class="button-entrar-login">Enviar</button>
                                    </div>
                                </div>
                            </form></div>
                        <div class='tab-pane  fade' id='s3'><form method="POST" action="CadastrarCliente" class="form-group" >
                                <div>
                                    <label for="nome">Nome:</label>
                                    <input class="form-control" name="nome" type="text" id="nome" />
                                </div>
                                <div>
                                    <label for="cpf">CPF:</label>
                                    <input  class="form-control" name="cpf" type="text" id="cpf" />
                                </div>
                                <div>
                                    <label for="endereco">Endere�o:</label>
                                    <input class="form-control" name="endereco" type="text" id="endereco" />
                                </div>
                                <div>
                                    <label for="bairro">Bairro:</label>
                                    <input class="form-control" name="bairro" type="text" id="bairro" />
                                </div>
                                <div>
                                    <label for="cidade">Cidade:</label>
                                    <input class="form-control" name="cidade" type="text" id="cidade" />
                                </div>
                                <div>
                                    <label for="uf">UF:</label>
                                    <input class="form-control" name="uf" type="text" id="uf" />
                                </div>
                                <div>
                                    <label for="cep">CEP:</label>
                                    <input class="form-control" name="cep" type="text" id="cep" />
                                </div>
                                <div>
                                    <label for="telefone">Telefone:</label>
                                    <input class="form-control" name="telefone" type="text" id="telefone" />
                                </div>
                                <div>
                                    <label for="email">Email:</label>
                                    <input class="form-control" name="email" type="text" id="email" />
                                </div>
                                <div class=" mt-3">
                                    <div>
                                        <button type="submit" class="button-entrar-login">Enviar</button>
                                    </div>
                                </div>
                            </form></div>
                        <div class='tab-pane  fade' id='s4'> <form class="form-group" >
                                <div>
                                    <label for="quantidade_venda">Quantidade:</label>
                                    <input class="form-control" type="text" id="quantidade_venda" />
                                </div>
                                <div>
                                    <label for="data_compra">Data da compra:</label>
                                    <input class="form-control" type="text" id="data_compra" />
                                </div>
                                <div>
                                    <label for="valor_compra">Valor da compra::</label>
                                    <input class="form-control" type="text" id="valor_compra" />
                                </div>
                                <div>
                                    <label for="id_fornecedor">Fornecedor:</label>
                                    <input class="form-control" type="text" id="id_fornecedor" />
                                </div>
                                <div>
                                    <label for="id_produto">Produto:</label>
                                    <input class="form-control" type="text" id="id_produto" />
                                </div>
                                <div>
                                    <label for="id_funcionario">Funcion�rio:</label>
                                    <input class="form-control" type="text" id="id_funcionario" />
                                </div>
                                <div class=" mt-3">
                                    <div>
                                        <button type="submit" class="button-entrar-login">Enviar</button>
                                    </div>
                                </div>
                            </form></div>
                        <div class='tab-pane  fade' id='s5'><form class="form-group" method="POST" action="CadastrarFornecedor" >
                                <div>
                                    <label for="razao_social">Raz�o Social:</label>
                                    <input class="form-control" type="text" name="razao_social" id="razao_social" />
                                </div>
                                <div>
                                    <label for="cnpj">CNPJ:</label>
                                    <input  class="form-control" type="text" name="cnpj" id="cnpj" />
                                </div>
                                <div>
                                    <label for="endereco">Endere�o:</label>
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
                        <div class='tab-pane  fade' id='s6'><form class="form-group" >
                                <div>
                                    <label for="nome">Nome:</label>
                                    <input class="form-control" type="text" id="nome" />
                                </div>
                                <div>
                                    <label for="cpf">CPF:</label>
                                    <input class="form-control" type="text" id="cpf" />
                                </div>
                                <div>
                                    <label for="senha">Senha:</label>
                                    <input class="form-control" type="password" id="senha" />
                                </div>
                                <div>
                                    <label for="papel">Papel:</label>
                                    <input class="form-control" type="text" id="papel" />
                                </div>
                                <div class=" mt-3">
                                    <div>
                                        <button type="submit" class="button-entrar-login">Enviar</button>
                                    </div>
                                </div>
                            </form></div>   
                        <div class='tab-pane  fade' id='s7'><form class="form-group" >
                                <div>
                                    <label for="nome_produto">Nome:</label>
                                    <input class="form-control" type="text" id="nome_produto" />
                                </div>
                                <div>
                                    <label for="descricao">Descri��o:</label>
                                    <input class="form-control" type="text" id="descricao" />
                                </div>
                                <div>
                                    <label for="preco_compra">Pre�o compra:</label>
                                    <input class="form-control" type="text" id="preco_compra" />
                                </div>
                                <div>
                                    <label for="preco_venda">Pre�o venda:</label>
                                    <input class="form-control" type="text" id="preco_venda" />
                                </div>
                                <div>
                                    <label for="quantidade_disponivel">Quantidade dispon�vel:</label>
                                    <input class="form-control" type="text" id="quantidade_disponivel" />
                                </div>
                                <div>
                                    <label for="liberado_venda">Liberado para venda:</label>
                                    <input class="form-control" type="text" id="liberado_venda" />
                                </div>
                                <div>
                                    <label for="id_categoria">Categoria:</label>
                                    <input class="form-control" type="text" id="id_categoria" />
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
        </div>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
