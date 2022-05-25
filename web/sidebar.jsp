<div class="menu-lateral d-flex flex-column flex-shrink-0 p-3 bg-light" >

    <ul class="nav nav-pills flex-column mb-auto">
        <li class="active nav-item">
            <a href="painel.jsp" class="active nav-link" aria-current="page">
                Home
            </a>
        </li>
        <li>
            <a
                href="#"
                data-toggle="collapse"
                data-target="#fornecedores"
                class=" collapsed nav-link link-dark mt-3"
                aria-expanded="false"
                >

                <div class="d-flex justify-content-between">
                    <span class="nav-label"> <b>Fornecedores</b> </span>
                    <span><img class="arrow-icone" src="image/down-chevron.png" alt="arrow"/></span>
                </div>
            </a>
            <ul class="sub-menu collapse" id="fornecedores" style="">
                <li><a class="nav-link link-dark" href="fornecedores">Listar fornecedores</a></li> 
                <li><a class="nav-link link-dark" href="cadastrar-fornecedor.jsp">Cadastrar fornecedor</a></li>
            </ul>
        </li>
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
                <li><a class="nav-link link-dark" href="funcionarios">Listar funcionários</a></li> 
                <li><a class="nav-link link-dark" href="cadastro-funcionario.jsp">Cadastrar funcionários</a></li>
            </ul>
        </li>
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
                <li><a class="nav-link link-dark" href="clientes">Listar clientes</a></li> 
                <li><a class="nav-link link-dark" href="cadastrar-cliente.jsp">Cadastrar clientes</a></li>
            </ul>
        </li>
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
                <li><a class="nav-link link-dark" href="categorias">Listar categorias</a></li> 
                <li><a class="nav-link link-dark" href="cadastrar-categoria.jsp">Cadastrar categoria</a></li>
                <li><a class="nav-link link-dark" href="cadastrar-compra-produto.jsp">Cadastrar compra</a></li>
            </ul>
        </li>


    </ul>
    <hr>

</div>