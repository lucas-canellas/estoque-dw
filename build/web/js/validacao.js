
$(document).ready(function(){    
    $('#cpf').mask('000.000.000-00', {reverse: true});
    $('#telefone').mask('(00) 00000-0000');
    $('#data_compra').mask('00/00/0000');
    $('#data_venda').mask('00/00/0000');
    
});


function TestaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    if (strCPF == "00000000000")
        return false;

    for (i = 1; i <= 9; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))
        Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10)))
        return false;

    Soma = 0;
    for (i = 1; i <= 10; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11))
        Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11)))
        return false;
    return true;
}