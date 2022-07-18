<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">        
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" type="image/x-icon" href="image/icons8-produto-16.png">


    </head>
    <body class="d-flex justify-content-center align-items-center ">

        <div class="container-card-login " >
            <div class="card-login">                
                <h3 id="titulo-login">LOGIN CLIENTE</h3>
                <p id="subtitulo-login">Entre abaixo com seus dados:</p>
                <div class="card-body">
                    <form id="login_form"  action="logincliente" method="POST"> 

                        <div class="input-group mb-2 mr-sm-2">
                            <input type="text" class="form-control texto-input" required name="cpf" id="cpf" placeholder="CPF CLIENTE">
                        </div>                      
                        <div class="mt-3">
                            <div>
                                <button type="submit" value="login" class="button-entrar-login">Entrar</button>
                            </div>
                        </div>
                    </form>
                    <p class="mb-1 mt-3">
                        <a href="index.jsp" class="text-secondary ">Voltar para o login de funcionários</a>
                    </p>
                </div>

            </div>


        </div>

        <script src="jquery-3.4.1.min.js"></script>
        <script src="popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

</body>
</html>

