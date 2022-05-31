//FUNÇÃO PARA ADICIONAR O ATRIBUTO SELECTED NA TAG OPTION DOS SELECT 

function selectDefaultVale(valor, classe) {

    var select = document.querySelectorAll(classe);
    var option;

    for (var i = 0; i < select.length; i++) {
        option = select[i].value;
        if (option == valor) {
            select[i].selected = true;
            return;
        }
    }
}



const val_fornecedor = document.querySelector('#fornecedor').value;
const val_funcionario = document.querySelector('#funcionario').value;
const val_produto = document.querySelector('#produto').value;



selectDefaultVale(val_fornecedor, '.forn_value');
selectDefaultVale(val_produto, '.prod_value');
selectDefaultVale(val_funcionario, '.func_value');
