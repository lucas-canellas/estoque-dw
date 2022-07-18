<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="menu-lateral d-flex flex-column flex-shrink-0 bg-light" >
    <ul class="nav nav-pills flex-column mb-auto">

        <div class="d-flex align-items-center ml-3"> 
            <img src="image/do-utilizador.png" alt="avatar" style="width: 30px"/>
            <div>
                <p class="ml-2" style="margin: 0">${nome}</p>
                <p class="ml-2" style="margin: 0; font-size: 12px">${papel}</p>
            </div>
        </div>
        <div class="dropdown-divider ml-2 "></div> 
        <div class="dashboard-wrapper">            
            <a href="painel.jsp" aria-current="page">
                <h1 class="dashboard">Dashboard </h1>                
            </a>
        </div>
        <div class="dropdown-divider mb-3"></div> 
        <c:if test="${papel == 'Administrador'}"> 
            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#funcionarios"
                    class=" collapsed nav-link link-dark mt-3"
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Funcionários</b> </span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="funcionarios" style="">
                    <li><a class="nav-link link-dark" href="funcionarios">Gerenciar funcionários</a></li> 
                    <li><a class="nav-link link-dark" href="cadastro-funcionario.jsp">Cadastrar funcionários</a></li>
                </ul>
            </li> 
        </c:if>

        <c:if test="${papel == 'Vendedor'}"> 
            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#clientes"
                    class=" collapsed nav-link link-dark mt-3"
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Clientes</b> </span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="clientes" style="">
                    <li><a class="nav-link link-dark" href="clientes.jsp">Gerenciar clientes</a></li> 
                    <li><a class="nav-link link-dark" href="cadastrar-cliente.jsp">Cadastrar clientes</a></li>
                </ul>
            </li>

            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#venda"
                    class=" collapsed nav-link link-dark mt-3"
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Venda</b> </span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="venda" style="">
                    <li><a class="nav-link link-dark" href="pagina-cadastrar-venda">Cadastrar venda</a></li>
                    <li><a class="nav-link link-dark" href="vendas">Gerenciar vendas</a></li> 
                </ul>
            </li>
        </c:if>

        <c:if test="${papel == 'Comprador'}"> 
            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#fornecedores"
                    class=" collapsed nav-link link-dark "
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Fornecedores</b></span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="fornecedores" >
                    <li><a class="nav-link link-dark" href="fornecedores.jsp">Gerenciar fornecedores</a></li> 
                    <li><a class="nav-link link-dark" href="cadastrar-fornecedor.jsp">Cadastrar fornecedor</a></li>
                </ul>
            </li>

            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#compra"
                    class=" collapsed nav-link link-dark mt-3"
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Compra</b> </span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="compra" style="">
                    <li><a class="nav-link link-dark" href="cadastrar-compra-produto.jsp">Cadastrar compra</a></li>
                    <li><a class="nav-link link-dark" href="compras.jsp">Gerenciar compras</a></li> 
                </ul>
            </li>

            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#categorias"
                    class=" collapsed nav-link link-dark mt-3"
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Categoria</b> </span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="categorias" style="">
                    <li><a class="nav-link link-dark" href="categorias.jsp">Gerenciar categorias</a></li> 
                    <li><a class="nav-link link-dark" href="cadastrar-categoria.jsp">Cadastrar categoria</a></li>                               
                </ul>
            </li>

            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#controle-produtos"
                    class=" collapsed nav-link link-dark mt-3"
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Controle liberação de produtos</b> </span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="controle-produtos" style="">
                    <li><a class="nav-link link-dark" href="ListarProdutos">Alterar liberação do produto</a></li>
                    <li><a class="nav-link link-dark" href="PageCadastarProduto">Cadastrar produto</a></li> 
                </ul>
            </li>
        </c:if>
                    <c:if test="${papel == 'Cliente'}"> 
            <li>
                <a
                    href="#"
                    data-toggle="collapse"
                    data-target="#produtos"
                    class=" collapsed nav-link link-dark mt-3"
                    aria-expanded="false"
                    >

                    <div class="d-flex justify-content-between">
                        <span class="nav-label"> <b>Produtos</b> </span>
                        <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                    </div>
                </a>
                <ul class="sub-menu collapse" id="produtos" style="">
                    <li><a class="nav-link link-dark" href="area-cliente.jsp">Produtos disponiveis</a></li> 

                </ul>
            </li> 
        </c:if>








        <hr>

        </div>